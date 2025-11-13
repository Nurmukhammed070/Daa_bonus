KMP (Knuth–Morris–Pratt) String Search Algorithm — Report
Abdikarim Nurmukhammed, SE-2430

1. Introduction
The purpose of this assignment is to implement the KMP string searching algorithm in Java, test it on three different input sizes, and analyze its performance.

KMP efficiently finds occurrences of a pattern inside a text using preprocessing of the pattern.

2. Algorithm Overview

2.1 LPS Array (Longest Prefix Suffix)
KMP first computes the LPS array where:
- lps[i] = longest proper prefix of pattern[0..i] which is also a suffix.

This allows the algorithm to “jump” inside the pattern on mismatches instead of re-checking characters.

2.2 KMP Search
The search runs through the text using:
- i → index for text
- j → index for pattern

Cases:
- Match → move both i and j
- Mismatch → move j using lps[j−1]
- If j reaches pattern length → match found

3. Test Results

3.1 Short Test
- Text: `ababcabcabababd`
- Pattern: `ababd`
- Output: match at index **10**

3.2 Medium Test
- Text: `"THIS IS A TEST TEXT. THIS TEST IS SIMPLE. TEST TEST TEST."`
- Pattern: `TEST`
- Output: multiple matches, including positions: 10, 23, 34, 39, 44

3.3 Long Test
- 2000 repetitions of `lorem ipsum...`
- Inserted `"PATTERNXYZ"` every 200 sequences
- Output: ~10–11 matches depending on generation

The KMP algorithm handles long strings efficiently and maintains linear performance.

4. Complexity Analysis

Time Complexity:
- LPS computation: O(m)
- Search: O(n)
- Total: O(n + m)

Space Complexity:
- LPS array: O(m)
- Output list: O(k), where k = number of matches
- Total: O(m + k)

---

5. Conclusion
KMP significantly improves searching performance compared to naive algorithms.  
It avoids unnecessary comparisons by using the LPS array, making it efficient even on long texts.

The implementation is correct, efficient, and suitable for practical use.
