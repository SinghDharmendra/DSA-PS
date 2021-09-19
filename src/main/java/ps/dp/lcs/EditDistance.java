package ps.dp.lcs;
/*
Given two strings word1 and word2, return the minimum number of operations required to convert word1 to word2.

You have the following three operations permitted on a word:

Insert a character
Delete a character
Replace a character

LC : 72

 */

import java.util.Arrays;

public class EditDistance {
    int m, n;
    int mem[][];

    public int minDistanceDP(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int t[][] = new int[m + 1][n + 1];

        for (int i = 1; i < m + 1; i++) {
            t[i][0] = i;
        }
        for (int j = 0; j < n + 1; j++) {
            t[0][j] = j;
        }

        for (int i = 1; i < m + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    t[i][j] = t[i - 1][j - 1];
                } else {
                    t[i][j] = 1 + Math.min(
                            t[i - 1][j - 1],
                            Math.min(
                                    t[i - 1][j],
                                    t[i][j - 1]
                            )

                    );
                }
            }
        }
        return t[m][n];

    }

    //recursion + memorization

    public int minDistance(String word1, String word2) {
        m = word1.length();
        n = word2.length();
        mem = new int[m + 1][n + 1];
        for (int[] me : mem) {
            Arrays.fill(me, -1);
        }
        return getMinOperation(word1, word2, 0, 0);

    }

    int getMinOperation(String word1, String word2, int i, int j) {

        if (i >= m && j >= n) {
            return mem[i][j] = 0;
        } else if (i >= m) {
            return mem[i][j] = n - j;
        } else if (j >= n) {
            return mem[i][j] = m - i;
        }

        char c1 = word1.charAt(i);
        char c2 = word2.charAt(j);
        if (mem[i][j] != -1) {
            return mem[i][j];
        }
        if (c1 == c2) {
            return mem[i][j] = getMinOperation(word1, word2, i + 1, j + 1);
        } else {
            return mem[i][j] = 1 +
                    Math.min(
                            getMinOperation(word1, word2, i + 1, j + 1),
                            Math.min(
                                    getMinOperation(word1, word2, i, j + 1),
                                    getMinOperation(word1, word2, i + 1, j)

                            )

                    );
        }

    }
}
