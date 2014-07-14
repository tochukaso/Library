package main.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Graph {

    /**
     * 辺を表す2次元配列を引数に取り、
     * 隣接行列を返却する。
     * 条件として、各edgeのfrom,toの組み合わせは重複しないこと。
     * 重複する場合、戻り値は後書きされた値が返却される。
     * 
     * @param edge 辺の要素 頂点from, 頂点to, コストを格納した2次元配列
     *         {1, 2, 4}, {2, 3, 5}, {3, 1, 2}の様なデータ形式とする。
     * @param V 頂点の数
     * @param isDirection 有向グラフの可否。有効グラフの場合、引数edgeの逆辺は設定しない。
     */
    public static int[][] makeAdjacencyMatrix(int[][] edge, int V, boolean isDirection) {

        int[][] res = new int[V][V];
        for (int i = 0; i < V; i++) {
            Arrays.fill(res[i], Integer.MAX_VALUE / 100);
            res[i][i] = 0;
        }
        // 各辺のコストをedgeに当てはめる。
        for (int[] is : edge) {
            res[is[0]][is[1]] = is[2];
            if(!isDirection) {
                res[is[1]][is[0]] = is[2];
            }
        }
        return res;
    }

    /**
     * 辺を表す2次元配列を引数に取り、
     * 隣接行列を返却する。
     * 条件として、各edgeのfrom,toの組み合わせは重複しないこと。
     * 重複する場合、戻り値は後書きされた値が返却される。
     * 
     * @param edge 辺の要素 頂点from, 頂点to, コストを格納した2次元配列
     *         {1, 2, 4}, {2, 3, 5}, {3, 1, 2}の様なデータ形式とする。
     * @param V 頂点の数
     * @param isDirection 有向グラフの可否。有効グラフの場合、引数edgeの逆辺は設定しない。
     */
    public static Map<Integer,Integer>[] makeAdjacencyList(int[][] edge, int V, boolean isDirection) {

        Map<Integer, Integer>[] res = new Map[V];
        for (int i = 0; i < V; i++) {
            res[i] = new HashMap<Integer, Integer>();
        }
        // 各辺のコストをedgeに当てはめる。
        for (int[] is : edge) {
            {
                Map<Integer, Integer> map = res[is[0]];
                map.put(is[1], is[2]);
            }

            if(!isDirection) {
                Map<Integer, Integer> map = res[is[1]];
                map.put(is[0], is[2]);
            }
        }
        return res;
    }
}

