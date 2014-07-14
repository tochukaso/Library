package main.algorithm;

/**
 * 動的計画法の典型例を格納する辞書的クラス
 *
 */
public class DP {
    
    
    /**
     * スタート地点からゴール地点への最短経路が何パターンあるかを捜査する。 
     * 
     */
    static char[][] field = new char[12][12];
    static {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                field[i][j]  = Math.random() >= 0.1 ? '.' : '-' ;
            }
        }
        field[1][1] = 'S';
        field[10][10] = '.';
    }

   
    /**
     * ある点までの進む通りの数をメモ化することで
     * 再計算を省くことが出来る。
     * 
     * また、ある点(x,y)に到達する組み合わせは、
     * (x-1,y),(x,y-1)の組み合わせ数を足すことで求めることが出来る。
     * 
     */
    public static void main(String[] args)  {
        
        int[][]dp = new int[11][11];
        dp[1][1] = 1;
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(field[i][j]);
                if(i == 1 && j == 1 || field[i][j] == '-') continue;
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
            System.out.println();
        }
        System.out.println("最短経路のパターンは" + dp[10][10] + "通り");

        for (int i = 1; i <= 10; i++) {
           for (int j = 1; j <= 10; j++) {
               System.out.printf("%1$ 6d", dp[i][j]);
           }
           System.out.println();
        }
    }
}
