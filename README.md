KMP String Search Algorithm in Java

This repository contains a full implementation of the Knuth–Morris–Pratt (KMP) string searching algorithm in Java.

Contents
- `src/KMPExample.java` — full implementation + test cases
- `samples/` — 3 input examples (short, medium, long)
- `report.md` — short 1–2 page explanation of algorithm, tests, and complexity

## How to Run
Compile:
    javac src/KMPExample.java

Run:
    java -cp src KMPExample

Tests
The program tests:
1. Short string
2. Medium string
3. Long generated string

Complexity
Time complexity: O(n + m)  
Space complexity: O(m)
