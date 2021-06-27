package ps.dp.mcm;

import javax.print.StreamPrintServiceFactory;

public class EvaluateExpressionToTrueParenthesization {
    public static void main(String[] args) {
        String exp = "T|T&F^T";

        int res = solve(exp, 0, exp.length() - 1, true);
        System.out.println("total number of ways : "+res);

    }

    private static int solve(String s, int i, int j, boolean isTrue) {

        if (i > j)
            return 0;
        if (i == j) {
            if (isTrue == true) {
                return s.charAt(i) == 'T' ? 1 : 0;
            } else {
                return s.charAt(i) == 'F' ? 1 : 0;
            }
        }
        int ans = 0;
        for (int k = i + 1; k < j; k = k + 2) {
            int lt = solve(s, i, k - 1, true);
            int lf = solve(s, i, k - 1, false);
            int rt = solve(s, k + 1, j, true);
            int rf = solve(s, k + 1, j, false);
            char c = s.charAt(k);
            switch (c) {
                case '&': {
                    if (isTrue == true) {
                        ans = ans + lt * rt;

                    } else {
                        ans = ans + lt * rf +
                                lf * rt + lf * rf;
                    }
                    break;


                }

                case '|': {
                    if (isTrue == true) {
                        ans = ans + lt * rt + lt * rf + lf * rt;

                    } else {
                        ans = ans + lf * rf;
                    }
                    break;


                }

                case '^': {
                    if (isTrue == true) {
                        ans = ans + lt * rf + lf * rt;

                    } else {
                        ans = ans + lf * rf + lt * rt;
                    }
                    break;


                }


            }
        }
        return ans;
    }
}
