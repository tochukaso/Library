package main.algorithm;

/**
 * しゃく取り法
 *
 */
public class Shakutori {

    /**
     * 0~4までの数字をランダムに持った数列が与えられる。
     * 0~4までの要素を持った数列の最小の範囲を求める。
     */

    /**
     * 数字の種類
     */
    static int T = 5;

    /**
     * 数列の長さ
     */
    static int N = 20;
    static int[] subsequence = new int[N];

    static {
        for (int i = 0; i < N; i++) {
            subsequence[i] = (int) (Math.random() * T);
            System.out.print(subsequence[i] + " ");
        }
        System.out.println();
    }

    /**
     * subsequenceに含まれている全ての要素を満たす最短の範囲を特定する。
     * 例 全ての要素(0~4)を全て含む最短の範囲は10~15
     * 3 4 0 4 2 0 1 2 2 4 0 2 3 4 3 1 2 3 2 2
     * max 6 from 10 to 15
     * 
     * @param T
     * @param N
     * @param subsequence
     */
    void shakutori(int T, int N, int[] subsequence) {

        int[] dp = new int[T];

        int max = Integer.MAX_VALUE;
        int mFrom = -1;
        int mTo = -1;

        int from = 0;
        int to = 0;


        for (; to < N; to++) {

            dp[subsequence[to]]++;

            boolean isAllElements = true;
            while(isAllElements) {
                for (int sum : dp) {
                    if(sum == 0) {
                        isAllElements = false;
                        break;
                    }
                }

                if (isAllElements) {
                    int length = to - from + 1;
                    if(max > length) {
                        max = length;
                        mFrom = from;
                        mTo = to;
                    }
                    dp[subsequence[from]]--;
                    from++;
                }
            }

        }
        System.out.println("max " + max + " from " + mFrom + " to " + mTo);

    }

    public static void main(String[] args) {
        new Shakutori().shakutori(T, N, subsequence);
    }


}
