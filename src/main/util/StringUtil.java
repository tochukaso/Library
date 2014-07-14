package main.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringUtil {

    /**
     * 2つの文字列の最長部分一致部分の長さを返却する。
     * 計算量O(NM)で最長部分を取得する。
     * 
     * @param base 比較対象の文字列1
     * @param word 比較対象の文字列2
     * @return  最長部分一致の長さ
     */
    public static int getLongestCommonSubsequence(String base, String word) {
        int[][] dp = new int[base.length() + 1][word.length() + 1];
        
        for (int i = 0; i < base.length(); i++) {
            for (int j = 0; j < word.length(); j++) {
                if(base.charAt(i) == word.charAt(j)) {
                    dp[i+1][j+1] = dp[i][j] + 1;
                } else {
                    dp[i+1][j+1] = Math.max(dp[i+1][j], dp[i][j+1]);
                }
            }
        }
        return dp[base.length()][word.length()];
    }
    
    /**
     * 最長部分増加列を求める。
     * 例.
     *   1 3 5 1 2 3 4 という配列の場合、
     *   1 2 3 4 が最長部分増加列となる。
     *   最長部分増加列の条件は、int[i] < int[i + 1]を満たす配列の最長となる。
     * 
     * @param sequence
     * @return
     */
    public static int[] getLongestIncreasingSubsequence(int[] sequence) {
        
        int[] dp = new int[sequence.length + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 0; i < sequence.length; i++) {
            int num = sequence[i];
            for (int j = 0; j < sequence.length; j++) {
                if(dp[j] < num) {
                    dp[j + 1] = Math.min(dp[j + 1], num);
                }
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i < dp.length; i++) {
            if(dp[i] == Integer.MAX_VALUE) {
                break;
            }
            list.add(dp[i]);
        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
        
    }
    public static void main(String[] args) {
        
        StringBuilder base = new StringBuilder();
        for (int i = 0; i < 30; i++) {
            base.append((char) (Math.random()*10 + 97));
        }
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            word.append((char) (Math.random()*10 + 97));
        }
        
        System.out.println(base);
        System.out.println(word);

        System.out.println(getLongestCommonSubsequence(base.toString(), word.toString()));
        
        int[] test = new int[100];
        for (int i = 0; i < 100; i++) {
            test[i] = (int) (Math.random() * 100) + i;
            System.out.print(test[i] + " ");
        }
        System.out.println();
        
        int[] ans = getLongestIncreasingSubsequence(test);
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i] + " ");
        }
        
    }
}
