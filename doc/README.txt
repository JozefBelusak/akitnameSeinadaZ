StackLang projekt – dokumentácia
================================

Obsah
-----
1. Prehľad jazyka StackLang a jeho požiadaviek.
2. Spôsob spúšťania interpretera cez skript `bin/SLANG` (Linux/macOS) a `languages/StackLang.cmd` (Windows CMD).
3. Krátky návod ako zrekonštruovať generované zdrojové kódy pomocou nástroja SLANG.
4. Stručné testy pre úspešné aj chybové scenáre.

1. Prehľad jazyka
-----------------
StackLang je deterministický zásobníkový jazyk nad prirodzenými číslami.
Podporované príkazy: `load n`, `add`, `sub`, `mul`, `dup`. Odčítanie je
povolené len ak výsledok zostane nezáporný. Sémantika je formálne zapísaná
v SLANG špecifikácii `languages/StackLang.txt`, ktorá definuje domény,
printer, parser, typový systém a denotačnú sémantiku.

2. Spúšťanie interpretera
-------------------------
Linux/macOS/WSL:
```
./bin/SLANG
(load 3 load 4 add dup mul CTRL+D)
```
Voliteľne je možné program zadať ako argumenty:
```
./bin/SLANG load 5 dup add dup mul
```

Windows CMD:
```
cd languages
StackLang.cmd
```
Skript v priečinku `languages` spustí SLANG + ANTLR build (ak sú nainštalované)
a následne kompiluje `StackLangMain.java`. Na konci ostane interaktívny
prompt, ktorý číta príkazy zo štandardného vstupu (Ctrl+Z + Enter ukončí zadávanie).

3. Obnovenie generovaných zdrojov
---------------------------------
Ak máte lokálne nástroje `slang` a `antlr4`, stačí spustiť `StackLang.cmd`
alebo upravenú verziu pre Linux. Skript vytvorí adresár `languages/lang/stacklang`
s parserom, AST a sémantickými triedami, ktoré potom spúšťa `StackLangMain`.

4. Testy
--------
Úspešné scenáre:
* `load 3 load 4 add dup mul` → `[49]`
* `load 5 dup add dup mul` → `[100]`
* `load 6 load 6 sub` → `[0]`

Chybové scenáre:
* `add` → nedostatok operandov
* `load 1 load 2 sub` → striktná podmienka na nezáporný výsledok
* `load -1` → literály musia byť prirodzené čísla
* `foo` → neznámy príkaz
