StackLang – Part II submission
==============================

Files
-----
* `StackLang.v` – Rocq/Coq development featuring syntax, denotational
  semantics, structural operational semantics, determinism proofs and the proof
  that both semantics coincide on the sample program `load 3 load 4 add dup mul`.

Compilation
-----------
```
opam switch vsrocq
opam install rocq            # once per switch
opam exec -- coqc StackLang.v
```

You can also load the file in VsRocq/VS Code by pointing the extension to the
`vsrocq` switch (`~/.opam/vsrocq/bin/vsrocqtop`).

Proof structure
---------------
1. Section *Syntax* defines `cmd`, `stack` and `program`.
2. Section *Denotational semantics* implements partial functions
   `cmd_denote` and `program_denote`, together with determinism lemmas.
3. Section *Structural operational semantics* introduces `exec_cmd` and `exec`
   and proves determinism for both relations.
4. Section *Relating both semantics* contains soundness/completeness lemmas and
   theorem `semantics_equivalent`.
5. Section *Sample program proof* instantiates the generic results for the
   assignment's program and shows that both semantics yield `[49]`.
