(**
  StackLang.v
  -----------
  Coq formalisation of the StackLang DSL.  The development covers:
  * syntax of commands, stacks and programs,
  * denotational semantics as partial functions on stacks,
  * structural operational semantics as inductive relations,
  * determinism proofs for both semantic views, and
  * a proof that both approaches agree on the sample program
    `load 3 load 4 add dup mul`, whose result is `[49]`.
*)

From Coq Require Import List Arith.
Import ListNotations.

(** * Syntax *)

Inductive cmd : Type :=
| Load (n : nat)
| Add
| Sub
| Mul
| Dup.

Definition stack := list nat.
Definition program := list cmd.

(** * Denotational semantics *)

Definition cmd_denote (c : cmd) (σ : stack) : option stack :=
  match c with
  | Load n => Some (n :: σ)
  | Add =>
      match σ with
      | x :: y :: σ' => Some (x + y :: σ')
      | _ => None
      end
  | Sub =>
      match σ with
      | x :: y :: σ' =>
          if Nat.leb x y then Some (y - x :: σ') else None
      | _ => None
      end
  | Mul =>
      match σ with
      | x :: y :: σ' => Some (x * y :: σ')
      | _ => None
      end
  | Dup =>
      match σ with
      | x :: σ' => Some (x :: x :: σ')
      | _ => None
      end
  end.

Fixpoint program_denote (p : program) (σ : stack) : option stack :=
  match p with
  | [] => Some σ
  | c :: p' =>
      match cmd_denote c σ with
      | Some σ' => program_denote p' σ'
      | None => None
      end
  end.

Lemma cmd_denote_deterministic :
  forall c σ σ1 σ2,
    cmd_denote c σ = Some σ1 ->
    cmd_denote c σ = Some σ2 ->
    σ1 = σ2.
Proof.
  intros c σ σ1 σ2 H1 H2.
  now rewrite H1 in H2; inversion H2.
Qed.

Lemma program_denote_deterministic :
  forall p σ σ1 σ2,
    program_denote p σ = Some σ1 ->
    program_denote p σ = Some σ2 ->
    σ1 = σ2.
Proof.
  induction p as [|c p IH]; intros σ σ1 σ2 H1 H2; cbn in *.
  - inversion H1; subst.
    inversion H2; subst; reflexivity.
  - destruct (cmd_denote c σ) as [σ'|] eqn:Hcmd; try discriminate.
    specialize (IH _ _ _ H1 H2). exact IH.
Qed.

(** * Structural operational semantics *)

Inductive exec_cmd : cmd -> stack -> stack -> Prop :=
| exec_load :
    forall n σ,
      exec_cmd (Load n) σ (n :: σ)
| exec_add :
    forall x y σ,
      exec_cmd Add (x :: y :: σ) (x + y :: σ)
| exec_sub :
    forall x y σ,
      x <= y ->
      exec_cmd Sub (x :: y :: σ) (y - x :: σ)
| exec_mul :
    forall x y σ,
      exec_cmd Mul (x :: y :: σ) (x * y :: σ)
| exec_dup :
    forall x σ,
      exec_cmd Dup (x :: σ) (x :: x :: σ).

Inductive exec : program -> stack -> stack -> Prop :=
| exec_nil :
    forall σ,
      exec [] σ σ
| exec_cons :
    forall c p σ σ' σ'',
      exec_cmd c σ σ' ->
      exec p σ' σ'' ->
      exec (c :: p) σ σ''.

Lemma exec_cmd_deterministic :
  forall c σ σ1 σ2,
    exec_cmd c σ σ1 ->
    exec_cmd c σ σ2 ->
    σ1 = σ2.
Proof.
  intros c σ σ1 σ2 H1 H2.
  inversion H1; subst; inversion H2; subst; auto.
Qed.

Lemma exec_deterministic :
  forall p σ σ1 σ2,
    exec p σ σ1 ->
    exec p σ σ2 ->
    σ1 = σ2.
Proof.
  intros p σ σ1 σ2 Hexec1.
  revert σ2.
  induction Hexec1 as [|c p σ σ' σ'' Hcmd Hexec IH]; intros σ2 Hexec2; inversion Hexec2; subst; auto.
  specialize (exec_cmd_deterministic _ _ _ _ Hcmd H1) as ->.
  eapply IH; eauto.
Qed.

(** * Relating both semantics *)

Lemma exec_cmd_sound :
  forall c σ σ',
    exec_cmd c σ σ' ->
    cmd_denote c σ = Some σ'.
Proof.
  intros c σ σ' H.
  destruct H; cbn; try reflexivity.
  apply (proj2 (Nat.leb_le _ _)) in H.
  now rewrite H.
Qed.

Lemma exec_cmd_complete :
  forall c σ σ',
    cmd_denote c σ = Some σ' ->
    exec_cmd c σ σ'.
Proof.
  intros c σ σ' H.
  destruct c; cbn in H.
  - inversion H; constructor.
  - destruct σ as [|x σ]; try discriminate.
    destruct σ as [|y σ'']; try discriminate.
    inversion H; constructor.
  - destruct σ as [|x σ]; try discriminate.
    destruct σ as [|y σ'']; try discriminate.
    destruct (Nat.leb x y) eqn:Hab; try discriminate.
    inversion H; subst.
    apply Nat.leb_le in Hab.
    constructor; assumption.
  - destruct σ as [|x σ]; try discriminate.
    destruct σ as [|y σ'']; try discriminate.
    inversion H; constructor.
  - destruct σ as [|x σ]; try discriminate.
    inversion H; constructor.
Qed.

Lemma exec_sound :
  forall p σ σ',
    exec p σ σ' ->
    program_denote p σ = Some σ'.
Proof.
  intros p σ σ' H.
  induction H; cbn; auto.
  rewrite (exec_cmd_sound _ _ _ H).
  exact IHexec.
Qed.

Lemma exec_complete :
  forall p σ σ',
    program_denote p σ = Some σ' ->
    exec p σ σ'.
Proof.
  induction p as [|c p IHp]; intros σ σ' H; cbn in H.
  - inversion H; constructor.
  - destruct (cmd_denote c σ) as [σ1|] eqn:Hcmd; try discriminate.
    apply exec_cons with (σ' := σ1).
    + apply exec_cmd_complete, Hcmd.
    + apply IHp, H.
Qed.

Theorem semantics_equivalent :
  forall p σ σ',
    program_denote p σ = Some σ' <-> exec p σ σ'.
Proof.
  split; [apply exec_complete | apply exec_sound].
Qed.

Corollary exec_total :
  forall p σ σ',
    exec p σ σ' ->
    exists σ'',
      program_denote p σ = Some σ'' /\ σ'' = σ'.
Proof.
  intros p σ σ' H.
  exists σ'.
  split; auto using exec_sound.
Qed.

(** * Sample program proof *)

Definition example_program : program :=
  [Load 3; Load 4; Add; Dup; Mul].

Lemma example_denotation :
  program_denote example_program [] = Some [49].
Proof.
  unfold example_program; cbn; reflexivity.
Qed.

Lemma example_exec :
  exec example_program [] [49].
Proof.
  apply exec_complete.
  apply example_denotation.
Qed.

Theorem example_semantics_agree :
  exec example_program [] [49] /\
  program_denote example_program [] = Some [49].
Proof.
  split; [apply example_exec | apply example_denotation].
Qed.

Corollary example_operational_equals_denotational :
  forall σ,
    exec example_program [] σ ->
    σ = [49].
Proof.
  intros σ Hex.
  pose proof exec_sound _ _ _ Hex as Hden.
  rewrite example_denotation in Hden.
  now inversion Hden.
Qed.
