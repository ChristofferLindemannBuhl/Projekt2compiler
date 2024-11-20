# Variables
GRAMMAR := hw.g4
PROJECT_FILES_DIR := hdl0_compiler
INPUT_FILES_DIR := input_files
OUTPUT_DIR := out
ANTLR_SRC_DIR := $(PROJECT_FILES_DIR)/antlr_generated_sources
ANTLR_OUT_DIR := $(OUTPUT_DIR)/hdl0_compiler/antlr_generated_sources
PROJECT_OUT_DIR := $(OUTPUT_DIR)/hdl0_compiler
HTML_OUT_DIR := $(OUTPUT_DIR)/html_output
ANTLR_JAR := antlr-4.13.2-complete.jar

# Handle classpath separator for Windows
PATH_SEPARATOR := :
ifeq ($(OS),Windows_NT)
    PATH_SEPARATOR := ;
endif

# ANTLR tools
ANTLR4 := java -cp $(ANTLR_JAR) org.antlr.v4.Tool
TEST_RIG := java -cp $(ANTLR_JAR) org.antlr.v4.gui.TestRig

# Ensure output directories exist
$(shell mkdir -p $(ANTLR_SRC_DIR) $(PROJECT_OUT_DIR) $(HTML_OUT_DIR))

# Generated ANTLR Java files
ANTLR_JAVA_FILES := $(ANTLR_SRC_DIR)/*.java

# Class files generated from Java sources
ANTLR_CLASS_FILES := $(ANTLR_OUT_DIR)/*.class

# Project Java files
PROJECT_FILES := $(PROJECT_FILES_DIR)/*.java

# Class files for the main project
MAIN_CLASS_FILES := $(PROJECT_FILES:$(PROJECT_FILES_DIR)/%.java=$(PROJECT_OUT_DIR)/%.class)

.PHONY: all clean run grun

# Default target: Build everything
all: $(ANTLR_CLASS_FILES) $(MAIN_CLASS_FILES)
	@echo "\nFinishing building project. You can run the project with 'make run' or test it with 'make grun'.\n"

# Rule to clean generated files
clean:
	@echo "Cleaning up generated files..."
	@rm -rf $(OUTPUT_DIR)
	@rm -rf $(ANTLR_SRC_DIR)

# Rule to generate ANTLR parser files
$(ANTLR_JAVA_FILES): $(GRAMMAR)
	@echo "Generating ANTLR files from grammar $(GRAMMAR)..."
	@$(ANTLR4) -package hdl0_compiler.antlr_generated_sources -visitor -o $(ANTLR_SRC_DIR) $(GRAMMAR)

# Rule to compile ANTLR-generated Java files
$(ANTLR_CLASS_FILES): $(ANTLR_JAVA_FILES)
	@echo "Compiling ANTLR-generated Java files..."
	@javac -cp $(ANTLR_JAR) $(ANTLR_SRC_DIR)/*.java -d $(OUTPUT_DIR)

# Rule to compile project Java files and avoid recompilation if not needed
$(MAIN_CLASS_FILES): $(PROJECT_FILES)
	@echo "Compiling main project files..."
	@javac -cp $(ANTLR_JAR)$(PATH_SEPARATOR)$(PROJECT_OUT_DIR)$(PATH_SEPARATOR). $(PROJECT_FILES) -d $(OUTPUT_DIR)

# Run the Main class with input files
run: $(ANTLR_CLASS_FILES) $(MAIN_CLASS_FILES)
	@echo "Running the main program for .hw files in $(INPUT_FILES_DIR)..."
	@for file in $(INPUT_FILES_DIR)/*.hw; do \
		baseFile=$$(basename $$file .hw); \
		prefix=$$(echo $$baseFile | sed -E 's/^([^\\-]+).*/\1/'); \
		echo "Processing $$baseFile -> $(HTML_OUT_DIR)/$$prefix.html"; \
		java -cp $(OUTPUT_DIR)$(PATH_SEPARATOR)$(ANTLR_JAR)$(PATH_SEPARATOR). hdl0_compiler.Main $$file > $(HTML_OUT_DIR)/$$prefix.html || echo "Error processing $$file"; \
	done
	@echo "\nSaved .html files to $(HTML_OUT_DIR)\n"

# Run TestRig with input files
grun: $(ANTLR_CLASS_FILES)
	@echo "Running ANTLR TestRig for .hw files in $(INPUT_FILES_DIR)..."
	@for file in $(INPUT_FILES_DIR)/*.hw; do \
		echo "Testing $$file with TestRig..."; \
		java -cp $(OUTPUT_DIR)$(PATH_SEPARATOR)$(ANTLR_JAR)$(PATH_SEPARATOR). \
			org.antlr.v4.gui.TestRig hdl0_compiler.antlr_generated_sources.hw start -gui -tokens $$file || echo "Error testing $$file"; \
	done
	@echo "\nFinished testing with TestRig\n"
