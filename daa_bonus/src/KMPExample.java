import java.util.ArrayList;
import java.util.List;

public class KMPExample {

    // Function to compute the LPS array
    public static int[] computeLPS(String pattern) {
        int m = pattern.length();
        int[] lps = new int[m];
        int len = 0;

        int i = 1;
        while (i < m) {
            if (pattern.charAt(i) == pattern.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    // KMP search function
    public static List<Integer> kmpSearch(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int n = text.length();
        int m = pattern.length();

        int[] lps = computeLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < n) {
            if (text.charAt(i) == pattern.charAt(j)) {
                i++;
                j++;

                if (j == m) {
                    positions.add(i - j);
                    j = lps[j - 1];
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        return positions;
    }

    // Test examples
    public static void main(String[] args) {

        // Short test
        String text1 = "ababcabcabababd";
        String pattern1 = "ababd";
        System.out.println("Short test: " + kmpSearch(text1, pattern1));

        // Medium test
        String text2 = "THIS IS A TEST TEXT. THIS TEST IS SIMPLE. TEST TEST TEST.";
        String pattern2 = "TEST";
        System.out.println("Medium test: " + kmpSearch(text2, pattern2));

        // Long test
        StringBuilder sb = new StringBuilder();
        String base = "lorem ipsum dolor sit amet ";
        for (int i = 0; i < 2000; i++) {
            sb.append(base);
            if (i % 200 == 0) sb.append("PATTERNXYZ ");
        }
        String text3 = sb.toString();
        String pattern3 = "PATTERNXYZ";
        System.out.println("Long test: " + kmpSearch(text3, pattern3));
    }
}