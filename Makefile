# Variables
GRAMMAR := hw.g4
PROJECT_FILES_DIR := hdl0_compiler
INPUT_FILES_DIR := input_files

ANTLR_SRC_DIR := $(PROJECT_FILES_DIR)/antlr_generated_sources
PROJECT_OUT_DIR := out/hdl0_compiler
ANTLR_OUT_DIR := $(PROJECT_OUT_DIR)/antlr_generated_sources
HTML_OUT_DIR := out/html_output

# ANTLR JAR file and classpath configuration
ANTLR_JAR := antlr-4.13.2-complete.jar

# Set PATH_SEPARATOR based on the environment
PATH_SEPARATOR := :
ifeq ($(OS),Windows_NT)
    PATH_SEPARATOR_OPTION := ;
endif

# ANTLR tool and grun setup
ANTLR4 := java -cp $(ANTLR_JAR) org.antlr.v4.Tool
TEST_RIG := java -cp $(ANTLR_JAR) org.antlr.v4.gui.TestRig

# Ensure output directories exist
$(shell mkdir -p $(ANTLR_SRC_DIR))
$(shell mkdir -p $(PROJECT_OUT_DIR))
$(shell mkdir -p $(HTML_OUT_DIR))

# List of ANTLR Java files to be generated
ANTLR_JAVA_FILES := $(ANTLR_SRC_DIR)/hwBaseListener.java \
                    $(ANTLR_SRC_DIR)/hwBaseVisitor.java \
                    $(ANTLR_SRC_DIR)/hwLexer.java \
                    $(ANTLR_SRC_DIR)/hwListener.java \
                    $(ANTLR_SRC_DIR)/hwParser.java \
                    $(ANTLR_SRC_DIR)/hwVisitor.java

.PHONY: clean all

# Clean and build

all: clean generate_parser compile_antlr_generated compile_project
	@echo "\nFinishing building project\n"

# Clean target to remove generated files without deleting the directories
clean:
	@echo "Cleaning up generated files"
	@rm -rf $(PROJECT_OUT_DIR)/*.class   					# Remove project class files
	@rm -rf $(PROJECT_OUT_DIR)/antlr_generated_sources/* 	# Remove ANTLR class files
	@rm -rf $(HTML_OUT_DIR)/* 								# Remove html output
	@rm -rf $(ANTLR_SRC_DIR)/* 								# Remove generated ANTLR java files

# Rule to generate parser files from grammar
generate_parser:
	@echo "Generating parser files from $(GRAMMAR) in $(ANTLR_SRC_DIR)"
	@$(ANTLR4) -package hdl0_compiler.antlr_generated_sources -visitor -o $(ANTLR_SRC_DIR) $(GRAMMAR)

# Target to compile ANTLR-generated Java files
compile_antlr_generated:
	@echo "Compiling ANTLR-generated Java files to class files in $(ANTLR_OUT_DIR)"
	@javac -cp $(ANTLR_JAR) $(ANTLR_SRC_DIR)/*.java -d out

# Rule to compile Main project Java files into class files
compile_project: compile_antlr_generated
	@echo "Compiling main project Java files with dependencies: '$(ANTLR_JAR)$(PATH_SEPARATOR)$(ANTLR_OUT_DIR)$(PATH_SEPARATOR).'"
	@javac -cp $(ANTLR_JAR)$(PATH_SEPARATOR)$(ANTLR_OUT_DIR)$(PATH_SEPARATOR). $(wildcard $(PROJECT_FILES_DIR)/*.java) -d out

# Rule to run Main class with input files
run: $(PROJECT_OUT_DIR)/Main.class
	@echo "Starting processing of .hw files in $(INPUT_FILES_DIR)"
	@for file in $(INPUT_FILES_DIR)/*.hw; do \
        baseFile=$$(basename $$file .hw); \
        prefix=$$(echo $$baseFile | sed -E 's/^([^\\-]+).*/\1/'); \
        echo "Processing $$baseFile"; \
        if ! java -cp out$(PATH_SEPARATOR)$(ANTLR_JAR)$(PATH_SEPARATOR). hdl0_compiler.Main $$file > $(HTML_OUT_DIR)/$$prefix.html; then \
            echo "Error processing $$file"; \
        fi; \
    done
	@echo "\nSaved .html files to $(HTML_OUT_DIR)\n"

# Rule to run the ANTLR TestRig with input files
grun: $(ANTLR_OUT_DIR)/hwParser.class
	@echo "Starting TestRig processing for .hw files in $(INPUT_FILES_DIR)"
	@for file in $(INPUT_FILES_DIR)/*.hw; do \
        echo "\nProcessing $$file with TestRig"; \
        if ! java -cp out$(PATH_SEPARATOR)$(ANTLR_JAR)$(PATH_SEPARATOR). org.antlr.v4.gui.TestRig hdl0_compiler.antlr_generated_sources.hw start -gui -tokens $$file; then \
            echo "Error processing $$file"; \
        fi; \
    done
	@echo "\nFinished testing input files\n"
