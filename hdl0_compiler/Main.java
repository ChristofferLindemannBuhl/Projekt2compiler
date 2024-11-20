package hdl0_compiler;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.antlr.v4.runtime.CharStreams;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.ArrayList;
import java.io.IOException;

import hdl0_compiler.antlr_generated_sources.*;

public class Main {
	public static void main(String[] args) throws IOException {
		// We expect at least one argument, where each argument is the name of the input file
		if (args.length != 1) {
			System.err.println("Please give exactly one filename as input argument.\n");
			System.exit(-1);
		}

		String fileName = args[0];

		System.out.println("\n");
		System.out.println("== == == == == == == == == == == == == == ==");
		System.out.println("||--------|| Hardware Simulator ||--------||");
		System.out.println();
		System.out.println("\t * Processing file: '" + fileName + "'");
		System.out.println();

		// open the input file
		CharStream input = CharStreams.fromFileName(fileName);
		//new ANTLRFileStream (filename); // Deprecated

		// create a lexer/scanner
		hwLexer lex = new hwLexer(input);

		// get the stream of tokens from the scanner
		CommonTokenStream tokens = new CommonTokenStream(lex);

		// create a parser
		hwParser parser = new hwParser(tokens);

		// and parse anything from the grammar for "start"
		ParseTree parseTree = parser.start();

		// The JaxMaker is a visitor that produces html/jax output as a string
		String result = new JaxMaker().visit(parseTree);

		/* The AstMaker generates the abstract syntax to be used for
		the second assignment, where for the start symbol of the
	   	ANTLR grammar, it generates an object of class Circuit (see
	   	AST.java). */
		Circuit p = (Circuit) new AstMaker().visit(parseTree);

		/* For the second assignment you need to extend the classes of
	    AST.java with some methods that correspond to running a
	    simulation of the given hardware for given simulation
	    inputs. The method for starting the simulation should be
	    called here for the Circuit p. */

		// Initialize the environment with the circuit's function definitions
		Environment env = new Environment(p.definitions);

		// Run the simulator (this will print the state at each cycle)
		p.runSimulator(env);

		// Create a directory for the output HTML files if it doesn't exist
		String outputDir = "html_output";
		Files.createDirectories(Paths.get(outputDir));

		// Generate HTML fileName based on the input fileName
		String htmlFilename = outputDir + "/" + Paths.get(fileName).getFileName().toString().replace(".hw", ".html");

		// Write result to html file
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(htmlFilename))) {
			writer.write(result);
			System.out.println();
			System.out.println("\t * Saved Generated HTML at: \"" + htmlFilename + "\"");
		} catch (IOException e) {
			System.err.println("\t * Error writing HTML file: " + e.getMessage());
		}

		System.out.println();
		System.out.println("\t * Hardware simulator finished");
		System.out.println("== == == == == == == == == == == == == == ==");
		System.out.println();
	}
}

// The visitor for producing html/jax -- solution for assignment 1, task 3:

class JaxMaker extends AbstractParseTreeVisitor<String> implements hwVisitor<String> {

	public String visitStart(hwParser.StartContext ctx) {
		StringBuilder result = new StringBuilder("<!DOCTYPE html>\n" +
				"<html><head><title> " + ctx.name.getText() + "</title>\n" +
				"<script src = \"https://polyfill.io/v3/polyfill.min.js?features = es6\"></script>\n" +
				"<script type = \"text/javascript\" id = \"MathJax-script\" async src = \"https://cdn.jsdelivr.net/npm/mathjax@3/es5/tex-chtml.js\">\n" +
				"</script></head><body>\n");
		result.append("<h1>").append(ctx.name.getText()).append("</h1>\n").append("<h2> Inputs </h2>\n");

		for (Token t:ctx.ins) {
			result.append(t.getText()).append(" ");
		}

		result.append("\n <h2> Outputs </h2>\n ");
		for (Token t:ctx.outs) {
			result.append(t.getText()).append(" ");
		}

		result.append("\n <h2> Latches </h2>\n");
		for (Token t:ctx.ls) {
			result.append(t.getText()).append(" ");
		}

		result.append("\n <h2> Definitions </h2>\n");
		for (hwParser.DefdeclContext t:ctx.defs) {
			result.append(visit(t));
		}

		result.append("\n <h2> Updates </h2>\n");

		for (hwParser.UpdatedeclContext t:ctx.up) {
			result.append(visit(t));
		}

		result.append("\n <h2> Simulation inputs </h2>\n");
		for (hwParser.SimInpContext t:ctx.simin)
			result.append(visit(t));

		result.append("\n</body></html>\n");
		return result.toString();
	};

	public String visitSimInp(hwParser.SimInpContext ctx) {
		return "<b>"+ctx.in.getText()+"</b>: "+ctx.str.getText()+"<br>\n";
	}

	public String visitUpdatedecl(hwParser.UpdatedeclContext ctx) {
		return ctx.write.getText()+"&larr;\\("+ visit(ctx.e)+"\\)<br>\n";
	}

	public String visitDefdecl(hwParser.DefdeclContext ctx) {
		StringBuilder args = new StringBuilder();
		boolean first = true;
		for (Token t:ctx.xs) {
			if(first) first = false; else args.append(",");
			args.append(t.getText());
		}
		return "\\(\\mathit{"+ctx.f.getText()+"}("+args+") = "+visit(ctx.e)+"\\)<br>\n";
	}

	public String visitUseDef(hwParser.UseDefContext ctx) {
		StringBuilder args = new StringBuilder();
		boolean first = true;
		for (hwParser.ExprContext e:ctx.es) {
			if(first) first = false; else args.append(",");
			args.append(visit(e));
		}
		return "\\mathit{"+ctx.f.getText()+"}("+args+")";
	}

	public String visitSignal(hwParser.SignalContext ctx) {
		return "\\mathrm{"+ctx.x.getText()+"}";
	};

	public String visitConjunction(hwParser.ConjunctionContext ctx) {
		return "("+visit(ctx.e1)+"\\wedge"+visit(ctx.e2)+")";
	};

	public String visitDisjunction(hwParser.DisjunctionContext ctx) {
		return "("+visit(ctx.e1)+"\\vee"+visit(ctx.e2)+")";
	};

	public String visitNegation(hwParser.NegationContext ctx) {
		return "\\neg("+visit(ctx.e)+")";
	};

	public String visitParenthesis(hwParser.ParenthesisContext ctx) {
		return visit(ctx.e);
	}

}

// The visitor for producing the Abstract Syntax (see AST.java).

class AstMaker extends AbstractParseTreeVisitor<AST> implements hwVisitor<AST> {
	public AST visitStart(hwParser.StartContext ctx) {
		List<String> ins = new ArrayList<>();
		for (Token t:ctx.ins) {
			ins.add(t.getText());
		}
		List<String> outs = new ArrayList<>();
		for (Token t:ctx.outs) {
			outs.add(t.getText());
		}
		List<String> latches = new ArrayList<>();
		for (Token t:ctx.ls) {
			latches.add(t.getText());
		}
		List<Def> defs = new ArrayList<>();
		for (hwParser.DefdeclContext t:ctx.defs) {
			defs.add((Def)visit(t));
		}
		List<Update> updates = new ArrayList<>();
		for (hwParser.UpdatedeclContext t:ctx.up) {
			updates.add((Update)visit(t));
		}
		List<Trace> simInput = new ArrayList<>();
		for (hwParser.SimInpContext t:ctx.simin) {
			simInput.add((Trace)visit(t));
		}
		return new Circuit(ctx.name.getText(),ins,outs,latches,defs,updates,simInput);
	};

	public AST visitSimInp(hwParser.SimInpContext ctx) {
		String s = ctx.str.getText();
		// s is a string consisting of characters '0' and '1' (not numbers!)
		Boolean[] tr = new Boolean[s.length()];
		// for the simulation it is more convenient to work with
		// Booleans, so converting the string s to an array of
		// Booleans here:
		for (int i = 0; i < s.length(); i++) {
			tr[i] = (s.charAt(i) == '1');
		}
		return new Trace(ctx.in.getText(),tr);
	}

	public AST visitDefdecl(hwParser.DefdeclContext ctx) {
		List<String> args = new ArrayList<>();
		for (Token t:ctx.xs) {
			args.add(t.getText());
		}
		return new Def(ctx.f.getText(), args, (Expr)visit(ctx.e));
	}

	public AST visitUpdatedecl(hwParser.UpdatedeclContext ctx) {
		return new Update(
				ctx.write.getText(),
				(Expr) visit(ctx.e)
		);
	}


	public AST visitSignal(hwParser.SignalContext ctx) {
		return new Signal(ctx.x.getText());
	};

	public AST visitConjunction(hwParser.ConjunctionContext ctx) {
		return new Conjunction(
				(Expr)visit(ctx.e1),
				(Expr)visit(ctx.e2)
		);
	};

	public AST visitDisjunction(hwParser.DisjunctionContext ctx) {
		return new Disjunction(
				(Expr) visit(ctx.e1),
				(Expr)visit(ctx.e2)
		);
	};

	public AST visitNegation(hwParser.NegationContext ctx) {
		return new Negation((Expr) visit(ctx.e));
	};

	public AST visitParenthesis(hwParser.ParenthesisContext ctx) {
		return visit(ctx.e);
	}

	public AST visitUseDef(hwParser.UseDefContext ctx) {
		List<Expr> args = new ArrayList<>();
		for (hwParser.ExprContext e:ctx.es) {
			args.add((Expr) visit(e));
		}
		return new UseDef(ctx.f.getText(),args);
	}
}


