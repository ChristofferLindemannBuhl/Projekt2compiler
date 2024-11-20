#!/bin/bash

PACKAGE_NAME="package hdl0_compiler.antlr_generated_sources;"

GENERATED_JAVA_DIR="hdl0_compiler/antlr_generated_sources"

if [[ ! -d "$GENERATED_JAVA_DIR" ]]; then
    echo "Directory $GENERATED_JAVA_DIR does not exist."
    exit 1
fi

for file in "$GENERATED_JAVA_DIR"/*.java; do
    if [[ -f "$file" ]]; then
        echo "$PACKAGE_NAME" | cat - "$file" > temp_file && mv temp_file "$file"
        echo "Added package name to $file"
    else
        echo "No .java files found in $GENERATED_JAVA_DIR"
    fi
done
