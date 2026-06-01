# Assembler Processor Emulator

A small Java-based emulator for running a simplified assembly-like language. The project models the main parts of a basic processor, including a control unit, arithmetic logic unit, memory management unit, registers, labels, jumps, and console I/O.

## Features

- CPU execution loop with a program counter
- Four general-purpose registers: `A`, `B`, `C`, and `D`
- Arithmetic instructions: `ADD`, `SUB`, `MUL`, `DIV`
- Bitwise logic instructions: `AND`, `OR`, `NOT`, `XOR`
- Data movement with registers, constants, memory addresses, and labels
- Conditional and unconditional jumps
- Basic comparison flags for equality and signed ordering
- Console input and output through `IN` and `OUT`
- Paged memory model backed by 4096-byte frames
- JUnit tests for ALU and MMU behavior

## Requirements

- Java 21
- Maven

## Project Structure

```text
AssemblerProcessorEmulator/
|-- Codes/                         # Example assembly programs
|-- src/main/com/inputpoint/        # Emulator entry point
|-- src/main/com/processor/         # CPU, CU, ALU, MMU, and IO classes
|-- src/main/com/memoryunits/       # Page and frame memory classes
|-- src/test/com/processor/         # Unit tests
`-- pom.xml                         # Maven build configuration
```

## Supported Instructions

| Instruction | Description | Example |
| --- | --- | --- |
| `MOV` | Move a value into a register or memory address | `MOV A 10` |
| `MOV BYTE` | Move one byte into a register or memory address | `MOV BYTE A 5` |
| `ADD` | Add a value to a register | `ADD A, B` |
| `SUB` | Subtract a value from a register | `SUB A, 2` |
| `MUL` | Multiply a register by a value | `MUL A, B` |
| `DIV` | Divide a register by a value | `DIV A, 2` |
| `AND` | Bitwise AND | `AND A, B` |
| `OR` | Bitwise OR | `OR A, B` |
| `NOT` | Bitwise NOT | `NOT A` |
| `XOR` | Bitwise XOR | `XOR A, B` |
| `CMP` | Compare two values and update flags | `CMP A, B` |
| `JMP` | Jump to a label or register-held address | `JMP LOOP` |
| `JE` | Jump if equal | `JE DONE` |
| `JNE` | Jump if not equal | `JNE LOOP` |
| `JGE` | Jump if greater than or equal | `JGE DONE` |
| `JL` | Jump if less than | `JL LOOP` |
| `IN` | Read console input into a register | `IN A` |
| `OUT` | Print a register value | `OUT A` |
| `HALT` | Stop program execution | `HALT` |

## Example Program

```asm
MOV A 10
MOV B 20
ADD A, B
OUT A
HALT
```

This program stores `10` in register `A`, stores `20` in register `B`, adds `B` to `A`, and prints `30`.

## Build

From the project directory:

```bash
mvn compile
```

## Run

Compile the project, then run the emulator with one of the example assembly files:

```bash
java -cp target/classes com.inputpoint.Emulator Codes/test2.asm
```

Programs that use the `IN` instruction wait for a value from standard input.

## Test

```bash
mvn test
```

## Notes

- Assembly source files are read as UTF-8 text and split line by line.
- Labels are written with a trailing colon, for example `LOOP:`.
- Memory addresses use hexadecimal notation, for example `0x1234567891234567`.
- Long values are stored in memory using 8 bytes.
