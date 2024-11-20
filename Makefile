# Variables
GRAMMAR := hw.g4

PROJECT_FILES_DIR := hdl0_compiler
INPUT_FILES_DIR := input_files

ANTLR_JAR := antlr-4.13.2-complete.jar
PROJECT_OUT_DIR := out/hdl0_compiler
ANTLR_OUT_DIR := $(PROJECT_FILES_DIR)/antlr_generated_sources

# Ensure the ANTLR output directory exists
$(shell mkdir -p $(ANTLR_OUT_DIR))
$(shell mkdir -p $(PROJECT_OUT_DIR)/antlr_generated_sources)

# List of ANTLR Java files to be generated
ANTLR_JAVA_FILES := $(ANTLR_OUT_DIR)/ccBaseListener.java \
                    $(ANTLR_OUT_DIR)/ccBaseVisitor.java \
                    $(ANTLR_OUT_DIR)/ccLexer.java \
                    $(ANTLR_OUT_DIR)/ccListener.java \
                    $(ANTLR_OUT_DIR)/ccParser.java \
                    $(ANTLR_OUT_DIR)/ccVisitor.java

# Command to run ANTLR
ANTLR4 := java -cp $(ANTLR_JAR) org.antlr.v4.Tool

# Classpath variables
ANTLR_CLASSPATH = $(ANTLR_OUT_DIR):.
PROJECT_CLASSPATH = $(PROJECT_OUT_DIR):.

.PHONY: clean all

# Clean and build

all: clean generate_parser add_package compile_antlr_generated compile_project run

# Clean target to remove generated files without deleting the directories
clean:
	@echo "Cleaning up generated files..."
	@rm -rf out/*  									# Remove output files in directory 'out'
	@rm -rf hdl0_compiler/antlr_generated_sources/*	# Remove generated antlr java files in directory 'hdl0_compiler/antlr_generated_sources'
	@rm -rf html_output/* 							# Remove html output in directory 'html_output'

# Rule to generate parser files from grammar
generate_parser:
	@echo "Generating parser files from $(GRAMMAR) in $(ANTLR_OUT_DIR)..."
	$(ANTLR4) -visitor -o $(ANTLR_OUT_DIR) $(GRAMMAR)

# Add package name to generated ANTLR .java files
add_package:
	@echo "Adding package name to ANTLR .java files..."
	@./add_package.sh

# Target to compile ANTLR-generated Java files
compile_antlr_generated:
	@echo "Compiling ANTLR-generated Java files to class files in $(PROJECT_OUT_DIR)/antlr_generated_sources..."
	@javac -cp "$(ANTLR_JAR):$(ANTLR_CLASSPATH)" $(ANTLR_OUT_DIR)/*.java -d out

# Rule to compile Main project Java files into class files
compile_project: compile_antlr_generated
	@echo "Compiling main project Java files..."
	@javac -cp "$(ANTLR_JAR):$(ANTLR_CLASSPATH):$(PROJECT_OUT_DIR)/antlr_generated_sources" $(PROJECT_FILES_DIR)/*.java -d out

# Rule to run Main class with input files
run:
	@echo "Starting processing of .hw files in $(INPUT_FILES_DIR)..."
	@for file in $(INPUT_FILES_DIR)/*.hw; do \
        echo "Processing input file: $$file"; \
        if ! java -cp "$(ANTLR_JAR):out" hdl0_compiler.Main $$file; then \
            echo "Error processing $$file"; \
        fi; \
    done
