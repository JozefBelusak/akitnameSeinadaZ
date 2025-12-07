StackLang Assignment – Submission Map
====================================

This repository now mirrors the structure from `zadanie.zip`.  Part I (SLANG +
Java) lives under `bin/`, `doc/` and `languages/`; Part II (Rocq) stays in
`Rocq/`.

Repository layout
-----------------
| Path | Purpose |
| ---- | ------- |
| `bin/SLANG` | POSIX helper that compiles `languages/StackLangMain.java` and runs the interpreter interactively (type program, finish with Ctrl+D). |
| `doc/README.txt` | Short end-user documentation in Slovak (overview, run instructions, manual tests). |
| `languages/StackLang.txt` | Actual SLANG language definition (domains, printer, parser, type system, denotational semantics). |
| `languages/StackLang.cmd` | Windows helper inspired by zadanie.zip – re-generates sources via SLANG/ANTLR and runs the interpreter. |
| `languages/StackLangMain.java` | Reference interpreter that also works standalone (used by `bin/SLANG`). |
| `languages/lang/stacklang/` | Output directory for generated sources (empty until `StackLang.cmd` is executed). |
| `Rocq/StackLang.v` | Coq development for Part II (syntax, two semantics, determinism proofs, equivalence, sample program). |
| `Rocq/README.txt` | Build instructions and proof roadmap for Part II. |
| `2025_26__SPJ_Zadanie.pdf` | Original assignment statement. |

How to package
--------------
```
zip -r StackLang_submission.zip bin doc languages Rocq 2025_26__SPJ_Zadanie.pdf
```
This matches the structure demonstrated in `zadanie.zip` while keeping Part II.

Part I – SLANG artefacts
------------------------
* `StackLang.txt` follows the official SLANG template: domains, printer, parser
  (`antlr4`), simple type judgments, and denotational semantics implemented in
  Java snippets.  The semantics enforce natural-number literals and non-negative
  subtraction results.
* `StackLangMain.java` is a small interpreter that reads either command-line
  tokens or all whitespace-separated tokens from stdin.  It checks the same
  guards as the SLANG specification and reports stack underflow with explicit
  error messages.
* `bin/SLANG` (Linux/macOS/WSL) and `languages/StackLang.cmd` (Windows CMD)
  automate compilation.  The Windows script also shows how to re-run the SLANG
  + ANTLR toolchain if desired.
* Test cases are listed in `doc/README.txt` – both successful programs and
  failing ones (underflow, guard violation, invalid literal, unknown token).

Part II – Rocq artefacts
------------------------
`Rocq/StackLang.v` keeps the previous proof structure: inductive syntax,
denotational semantics, big-step SOS, determinism lemmas for both, proofs of
soundness/completeness, and instantiation on the sample program (`[49]`).  Build
instructions remain the same (`opam switch vsrocq`, `opam install rocq`, then
`cd Rocq && coqc StackLang.v`).

Notes & limitations
-------------------
* The Windows build script assumes environment variable `SLANG_HOME` (defaults to
  `C:\slang`).  Update it if your installation differs.
* `bin/SLANG` does not regenerate the ANTLR parser; it simply compiles and runs
  the standalone interpreter.
* `languages/lang/stacklang` is kept empty on purpose; run `StackLang.cmd` to
  populate it with generated sources if the grader requires them.
