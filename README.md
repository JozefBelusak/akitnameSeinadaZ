StackLang Assignment – Detailed Guide
=====================================

This document is my “defence pack” for both parts of the assignment described in `2025_26__SPJ_Zadanie.pdf`.  
It maps requirements to artefacts, explains the implementation decisions, lists tests, and outlines how to demonstrate everything live.

Repository layout
-----------------
| File | Purpose |
| ---- | ------- |
| `stacklang.txt` | SLANG specification: syntax domains, denotational rules, executable semantics, worked evaluation of the sample program. |
| `Main.java` | Reference interpreter that accepts command-line tokens and executes StackLang programs on a stack of natural numbers. |
| `StackLang.v` | Rocq/Coq development: syntax types, denotational semantics, structural operational semantics (SOS), determinism proofs, semantic equivalence, proof of the sample program result. |
| `2025_26__SPJ_Zadanie.pdf` | Statement of the assignment (kept for reference). |

Part I – SLANG specification and Java interpreter
-------------------------------------------------

### SLANG file (`stacklang.txt`)
Sections mirror the grading rubric:
1. **Overview** – StackLang is deterministic and works over natural-number stacks.
2. **Syntax** – Syntactic domains + BNF productions. Leftmost element of the stack is the top.
3. **Denotational semantics** – Defines semantic domains (`Stack`, `CmdDen`, `ProgDen`) and equations for every primitive. `sub` inserts `second - first`.
4. **SLANG executable snippet** – DSL `meaning` rules that mirror the denotational equations, with `error` signalling invalid states.
5. **Example evaluation** – Step trace for `load 3 load 4 add dup mul` (result `[49]`).
6. **Input conditions** – States operand requirements and error handling approach.

### `Main.java` architecture
* `ProgramParser` builds a list of instructions from CLI tokens. It ensures `load` has an argument and that all literals are naturals.
* Instruction classes:
  - `LoadInstruction` pushes a constant.
  - `BinaryInstruction` abstracts `add`, `sub`, `mul` with a guard predicate (e.g., `sub` requires `second >= first`).
  - `DupInstruction` duplicates the top element.
* `StackMachine` extends the SLANG semantics with explicit underflow detection (throws exceptions when operands are missing).
* `main` executes either the default program or user-provided tokens and prints the resulting stack or error.
* Bonus ideas (not implemented yet): additional primitives such as `swap`, `drop`, `over`, `rot`. They would require new command constructors in both Java and Coq/SLANG specs if we aim for the extra point.

### Running & testing Part I
Compile (WSL, OpenJDK 17+):
```
javac Main.java
```

Successful scenarios:
```
java Main                         # default → [49]
java Main load 0 load 42 load 7   # [7,42,0]
java Main load 5 dup add dup mul  # (5+5)^2 = 100
java Main load 6 load 6 sub       # [0]
java Main load 1 dup dup mul mul  # [1]
```

Failure cases (expected to throw):
```
java Main add                     # underflow
java Main load 5 add              # underflow
java Main load 2 load 3 sub       # guard violation (second < first)
java Main load -1                 # invalid literal
java Main load                    # missing literal
java Main foo                     # unknown command
```

Part II – Rocq / Coq development (`StackLang.v`)
-----------------------------------------------

### Content overview
1. **Syntax** – `cmd`, `stack`, `program`.
2. **Denotational semantics** – `cmd_denote`, `program_denote`.
3. **Determinism lemmas** – `cmd_denote_deterministic`, `program_denote_deterministic`.
4. **Structural operational semantics** – `exec_cmd`, `exec` plus their determinism properties.
5. **Semantic correspondence** – `exec_cmd_sound/complete`, `exec_sound/complete`, Theorem `semantics_equivalent`.
6. **Sample program proof** – `example_program`, `example_denotation`, `example_exec`, `example_semantics_agree`.

### Checking the Coq development
1. Enable the opam switch:  
   `opam switch vsrocq`  
   `eval "$(opam env --switch=vsrocq)"`.
2. Install Rocq compiler binaries (required for `coqc`):  
   `opam install rocq`.
3. Compile:  
   `opam exec --switch=vsrocq -- coqc StackLang.v`
4. Interactive option: VsRocq extension in VS Code with `Vsrocq: Path = ~/.opam/vsrocq/bin/vsrocqtop`.

### Reading hints
* Proofs use simple tactics (`inversion`, `constructor`, inductive hypotheses). Comments split the file into sections matching the bullet list above.
* Guards (`Nat.leb`) are rewritten using `Nat.leb_le`.
* The final corollary shows that running the sample program under SOS yields `[49]`, matching the denotational evaluation.

Defence checklist
-----------------
1. Walk through `stacklang.txt` sections to show syntax + semantics.
2. Demonstrate `Main.java` on both successful and failing inputs, noting the guard behaviour.
3. Explain how Java guards correspond to denotational equations (especially `sub` and underflow checks).
4. In `StackLang.v`, highlight:
   * Syntax definitions
   * Denotational vs. SOS semantics
   * Determinism lemmas
   * `semantics_equivalent`
   * Example proof for `[49]`
5. Mention potential bonus commands (swap/drop/over) and how they would be added if bonus points are needed.

Known limitations / future work
-------------------------------
* Bonus primitives (`swap`, `drop`, `over`) are not yet implemented; adding them would require updating all three artefacts (SLANG, Java, Coq).
* Java interpreter uses `long` without overflow checks, which is acceptable under the assignment’s natural-number domain assumption.
* `coqc` must be installed via `opam install rocq` before compiling `StackLang.v` outside VsRocq.
