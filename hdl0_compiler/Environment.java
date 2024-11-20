package hdl0_compiler;

import java.util.HashMap;
import java.util.Map.Entry;
import java.util.List;

class Environment {
    // Map for the signals: each signal has a current value as a Boolean
    private final HashMap<String, Boolean> variableValues = new HashMap<>();

    // Map for defined functions like "xor": for a string like "xor",
    // you can look up its definition
    private final HashMap<String, Def> definitions;

    // Standard constructor that does not care about definitions
    // You cannot use getDef() below when using this constructor.
    public Environment() {
        this.definitions = new HashMap<>();
    }

    // Constructor that compute the map of function definitions, given
    // a set of definitions as available in Circuit. You can then use
    // getDef() below.
    public Environment(List<Def> definitionList) {
        definitions = new HashMap<>();
        for (Def d : definitionList) {
            definitions.put(d.f,d);
        }
    }

    // This constructor can be used during eval to create a new
    // environment with the same definitions contained in an existing
    // one:
    public Environment(Environment env) {
        this.definitions = env.definitions;
    }

    // Lookup a definition, e.g., "xor"
    public Def getDef(String name) {
        Def d = definitions.get(name);
        if (d == null) {
            System.err.println("Function not defined: " + name); System.exit(-1);
        }
        return d;
    }

    // return the set of all definitions; this is helpful when
    // creating a new environment during eval: just get the defs from
    // the current environment and using it as an argument to the
    // constructor for the new environment
    public HashMap<String, Def> getDefinitions() {
        return definitions;
    }

    public void setVariable(String name, Boolean value) {
        variableValues.put(name, value);
    }

    public Boolean getVariable(String name) {
        Boolean value = variableValues.get(name);
        if (value == null) {
            System.err.println("Variable not defined: " + name); System.exit(-1);
        }
        return value;
    }

    public Boolean hasVariable(String name) {
        Boolean v = variableValues.get(name);
        return (v != null);
    }

    public String toString() {
        StringBuilder table = new StringBuilder();
        for (Entry<String,Boolean> entry : variableValues.entrySet()) {
            table.append(entry.getKey()).append("\t-> ").append(entry.getValue()).append("\n");
        }
        return table.toString();
    }
}
