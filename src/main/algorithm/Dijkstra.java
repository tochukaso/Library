package main.algorithm;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * ダイクストラ法
 * 単一始点からの最短経路を判別する
 * 
 * 計算量はO(N^2)
 * ただし、優先度付きのQue(PriorityQue)を使えば計算量はO(N logN) と出来る。
 * 
 *
 */
public class Dijkstra {

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
     * ダイクストラ法による単一始点最短経路を求める。
     * int dp[]にそれぞれの各頂点への最小のコストが格納される。
     * 
     * @param E 辺の要素 頂点from, 頂点to, コストを格納した2次元配列
     * @param startV 経路を求める始点
     */
    static void dikstra(int[][] E, int startV) {
        
        
        int[][] edge = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(edge[i], Integer.MAX_VALUE / 100);
            edge[i][i] = 0;
        }
        // 各辺のコストをedgeに当てはめる。
        for (int[] is : E) {
            edge[is[0]][is[1]] = is[2];
            edge[is[1]][is[0]] = is[2];
        }
        
        int[] dp = new int[V];
        Arrays.fill(dp, Integer.MAX_VALUE / 100);
        dp[startV] = 0;
        
        boolean[] used = new boolean[V];
        
        for (int i = 0; i < V; i++) {
            int minV = -1;
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < V; j++) {
                if(! used[j] && min > dp[j]) {
                    min = dp[j];
                    minV = j;
                }
            }
            
            used[minV] = true;
            
            for (int j = 0; j < V; j++) {
                if (minV == j) continue;
                dp[j] = Math.min(dp[j], dp[minV] + edge[minV][j]);
            }
        }
        
        for (int i = 0; i < V; i++) {
           System.out.print(dp[i] + " ");
        }
        
    }
    
    public static void main(String[] args) {
        dikstra(E, 0);
    }
}
