# mini-expression-compiler
# Mini Expression Compiler: From Expression to Evaluation

## Project Summary

This project implements a simple mini expression compiler in Java. It simulates key phases of a compiler by taking an arithmetic expression as input and processing it through:

* **Lexical Analysis (Tokenization)** – Converts the input string into tokens such as numbers, operators, and parentheses
* **Parsing (Recursive Descent Parser)** – Validates the expression using grammar rules
* **Abstract Syntax Tree (AST) Generation** – Builds a tree structure representing the expression
* **Evaluation** – Traverses the AST to compute the final result

The program provides clear output for each phase, including tokens, parse results, expression tree, and evaluation result.

---

## Features

* Supports operators: `+`, `-`, `*`, `/`
* Supports parentheses for grouping
* Supports unary operators (e.g., `-3`)
* Displays token stream
* Displays parse success or failure
* Prints expression tree in readable format
* Evaluates expressions correctly
* Handles invalid expressions with error messages

---

## Setup Instructions

1. Make sure Java JDK is installed on your system
2. Download or clone this repository
3. Open a terminal or command prompt in the project folder

---

## How to Compile

Run the following command:

```
javac -d bin src/compiler/*.java
```

This compiles all Java files and places the output in the `bin` folder.

---

## How to Run

Run the program using:

```
java -cp bin compiler.MiniExpressionCompiler
```

Then enter an arithmetic expression when prompted.

---

## Example Inputs and Outputs

### Valid Input

```
Input: (3 + 2) * 5 - 1
Tokens: [(, 3, +, 2, ), *, 5, -, 1]
Parse: SUCCESS
Tree:
└── -
    ├── *
    │   ├── +
    │   │   ├── 3
    │   │   └── 2
    │   └── 5
    └── 1
Evaluation Result: 24
```

---

### Another Valid Input

```
Input: 3 + 4 * 2
Parse: SUCCESS
Evaluation Result: 11
```

---

### Invalid Input

```
Input: 3 + * 5
Parse: FAILED
Error: Unexpected token: *
```

---

### Invalid Input

```
Input: 3 + (4 - )
Parse: FAILED
Error: Invalid syntax at token: )
```

---

## Test Cases

Use the following test inputs:

* `3 + 4 * 2`
* `(1 + 2) * (3 + 4)`
* `(3 + 2) * 5 - 1`
* `-3 + 4 * 2`
* `((3))`
* `3 + * 5`
* `()`
* `3 + (4 - )`

---

## Project Structure

```
mini-expression-compiler
├── src
│   └── compiler
│       ├── Token.java
│       ├── Tokenizer.java
│       ├── Node.java
│       ├── NumberNode.java
│       ├── BinaryOpNode.java
│       ├── UnaryOpNode.java
│       ├── Parser.java
│       ├── Evaluator.java
│       └── MiniExpressionCompiler.java
├── bin
└── README.md
```

---

## Design Overview

* **Tokenizer** scans input and produces tokens
* **Parser** uses recursive descent to validate expressions
* **AST Nodes** represent numbers, binary operations, and unary operations
* **Evaluator** recursively computes values from the AST

The code is modular and follows object-oriented design principles.

---

## Author

[Your Name]
