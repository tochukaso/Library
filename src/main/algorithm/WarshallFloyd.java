package main.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ワーシャルフロイド法の実装例を記載する。
 * グラフ問題で、それぞれの頂点から頂点への最短距離を測定する。
 * 一般的に「全点対最短経路」を解くアルゴリズムとして知られている。
 * 計算量は、O(N^3)
 * 
 *
 */
public class WarshallFloyd {
    
    /**
     * 頂点の数
     */
    static int V = 8;
    
    /**
     * 各頂点を結ぶ辺の移動コストを表す。
     */
    static int[][] E = new int[V*2][3];

    static {
        
        /**
         * 辺の初期化
         */
        int eCnt = 0;
        Set<String> used = new HashSet<String>();
        while(eCnt < V * 2) {
            int from = (int) (Math.random() * V );
            int to = (int) (Math.random() * V);
            String key = String.valueOf(from) + to;
            
            if (from <= to || !used.add(key)) continue;
            int cost = (int) (Math.random() * 9 + 1);
            E[eCnt][0] = from;
            E[eCnt][1] = to;
            E[eCnt][2] = cost;
            eCnt++;
        }
        
        for (int[] ar : E) {
            for (int k = 0; k < 3; k++) {
                System.out.print(ar[k] + " ");
            }
            System.out.println();
        }
    }
    
    /**
     * ワーシャルフロイドによる全点対最短経路を求める。
     * int[][] dpにそれぞれの各頂点間の最小のコストが格納される。
     * 
     * @param E 辺の要素 頂点from, 頂点to, コストを格納した2次元配列
     */
    static void warshallFloyd(int[][] E) {
        
        int[][] dp = new int[V][V];
        
        for (int i = 0; i < V; i++) {
            // 適度に大きい値を設定する。オーバーフローにを付ける必要がある。
            Arrays.fill(dp[i], Integer.MAX_VALUE / 100);
            dp[i][i] = 0;
        } 
        
        // 各辺のコストをDPに当てはめる。
        for (int[] is : E) {
            dp[is[0]][is[1]] = is[2];
            dp[is[1]][is[0]] = is[2];
        }

        for (int k = 0; k < V; k++) {
            for (int i = 0; i < V; i++) {
                for (int j = 0; j < V; j++) {
                    dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
                }
            }
        }
        
        System.out.println();
        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        
    }

    public static void main(String[] args) {
        warshallFloyd(E);
    }
}
