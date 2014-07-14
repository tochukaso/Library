package main.algorithm;

import java.util.HashSet;
import java.util.Set;

/**
 * クラスカル法のアルゴリズムについて
 * 最小全域木を求める。
 * 全域木は、あるグラフの頂点間を接弦するのに最小の辺の数となるようにする。
 * 最小なので、かつ、総コストが最小となるようなグラフを求める。
 *
 */
public class Kruskal {

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
    
    static void Kruskal(int[][] E) {
        
        
    }
}
