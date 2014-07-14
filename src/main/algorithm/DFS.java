package main.algorithm;

/**
 * 
 * 深さ優先探索を使用した捜査方法を辞書的に格納したクラス
 *
 */
public class DFS {


    /**
     * 深さ優先探索のテンプレート
     * フィボナッチ関数
     * @param index
     * @return
     */
    static int dfs(int index) {
        if(index <= 1) {
            return 1;
        }
        return dfs(index - 2) + dfs(index -1);
    }
    
    static int[] dp = new int[100];
   
    /**
     * メモ化を使用した深さ優先探索のテンプレート
     * フィボナッチ関数の場合 
     * @param index
     * @return
     */
    static int dfsWithDP(int index) {
        if(index <= 1) {
            return 1;
        }

        if (dp[index] != 0) return dp[index];
        
        
        return dp[index] = dfsWithDP(index - 2) + dfsWithDP(index - 1);
    }
    

    /**
     * 深さ優先探索を使用したフィールドの捜査
     * 2次元配列のマップを捜査する。
     * 
     */
    static char[][] field = new char[12][12];
    static {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                field[i][j]  = Math.random() >= 0.2 ? '.' : '-' ;
            }
        }
        field[1][1] = 'S';
        field[10][10] = '.';
    }
    
    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    static boolean[][] used = new boolean[12][12];

    /*
     * 深さ優先探索を使用してフィールドを捜査する。
     * 最短経路であることは保証されていない。
     * 最短経路を保証したい場合は、used変数をint型に変換し、
     * 初期値をINF(適当な最大値）にし、スタート地点を0にする。
     * 以前に通った経路よりコストが小さい場合は捜査対象に含めるようにすればよい。
     * （以前に通ったコストの最小は、次回訪れる箇所の4方より求める。）
     * 
     * フィールドを探索毎に持たなくてよいので、幅優先探索よりもメモリを使わずに済む。
     * ただし、スタート地点にごく近い位置にゴールがあることが自明な場合は
     * 幅優先探索の方がよい。
     * 
     */
    static void dfsSearch(int y, int x) {
        if ( y == 10 && x == 10) {
            for (int i = 1; i <= 10; i++) {
                for (int j = 1; j <= 10; j++) {
                    System.out.print(field[i][j]);
                }
                System.out.println();
            }
            return;
        }

        for (int i = 0; i < 4; i++) {
            int my = y + dy[i];
            int mx = x + dx[i];

            if(field[my][mx] == '.' && !used[my][mx]) {  
                used[my][mx] = true;
                field[my][mx] = 'R';
                dfsSearch(my, mx);
                field[my][mx] = '.';
            } 
        }

    }

    public static void main(String[] args) {
        dfsSearch(1,1);
//        { 
//            long start = System.currentTimeMillis();
//            for (int i = 0; i < 50; i++) {
//                System.out.println(dfs(i));
//            }
//            System.out.println("時間 " + (System.currentTimeMillis() - start));
//        } 
//        { 
//            long start = System.currentTimeMillis();
//            for (int i = 0; i < 50; i++) {
//                System.out.println(dfsWithDP(i));
//            }
//            System.out.println("時間 " + (System.currentTimeMillis() - start));
//        }
    }
}
