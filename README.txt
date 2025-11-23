StackLang assignment
====================

Project layout
--------------
* `stacklang.txt` – complete SLANG specification of StackLang syntax, semantic domains and executable rules.
* `Main.java` – standalone interpreter used to exercise the SLANG specification on concrete inputs.
* `StackLang.v` – Rocq/Coq formalisation with denotational semantics, structural operational semantics and proofs.

Running the Java interpreter
----------------------------
1. Compile and run:
   ```
   javac Main.java
   java Main            # runs the default sample program
   java Main load 8 dup mul load 2 add
   ```
2. Expected output for the default program (`load 3 load 4 add dup mul`):
   ```
   No arguments supplied, running default program: load 3 load 4 add dup mul
   Executed 5 commands.
   Final stack (top -> bottom): [49]
   ```
   Pass a custom program as command-line tokens to interpret a different sequence.

Coq development
---------------
1. The file `StackLang.v` depends only on the Coq standard library (`List`, `Arith`).
2. Compile the development with:
   ```
   coqc StackLang.v
   ```
3. The script defines the syntax (`cmd`, `program`, `stack`), denotational semantics (functions returning `option stack`) and structural operational semantics (inductive relations `exec_cmd` and `exec`).
4. Proved lemmas cover:
   * determinism of the denotational interpreter,
   * determinism of the structural operational semantics,
   * equivalence between both semantics for any program,
   * an explicit proof that the sample program from the assignment terminates with `[49]`.

Notes
-----
* Both semantics operate on natural numbers and detect underflow/guard violations via `None` (denotational) or absence of derivations (SOS).
* The Java interpreter mirrors the SLANG rule set; exceptions signal the same error cases as `None` in the specification.
