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
    
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

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
     * また、再帰の回数が深くなる場合、stackOverFlowを起こす可能性がある。
     * 
     */
    static void dfsSearch(int y, int x) {
        if ( y == 10 && x == 10) {
            printMap();
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

    private static void printMap() {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(field[i][j]);
            }
            System.out.println();
        }
    }

    static int robotMoves = 16;
    static boolean[][] robotMap; 
    /**
     * 最強最速のアルゴリズマー養成講座から
     * Topcoderのロボットの移動が成功する確率を判定する問題
     * 既に通った場所を再度通ることは出来ない。引数でそれぞれの方向に移動する確率が渡される。
     * robotMovesの回数分移動して、最終位置が正しいかどうか。
     * @param double[] {n,s,e,w} それぞれの方向に移動する確率
     * @return
     */
    public static void searchRobot(double[] porab) {
       robotMap = new boolean[robotMoves * 2 + 4][robotMoves * 2 + 4];
       System.out.printf("%f12", dfsRobot(0, robotMoves, robotMoves, porab));
    }
    
    public static double dfsRobot(int n, int y, int x, double[] porab) {
        if(robotMap[y][x]) return 0;
        if(n == robotMoves) return 1;
        robotMap[y][x] = true;
        double ret = 0;
        for(int i = 0 ; i < 4; i++) {
            ret += dfsRobot(n + 1, dy[i] + y, dx[i] + x, porab) * porab[i];
        }
        robotMap[y][x] = false;
        return ret;
    }

    /**
     * N個目,重さの条件で最大の価値を格納するためのメモ
     */
    static int[][] knapsackDp;
    static int[] knapsackVp;
    static int[] knapsackWp;
    static int knapsackMaxWait;
    /**
     * ナップザック問題
     * 最大の重さの範囲内で最大の価値を求める。
     * @param maxWait
     * @param vp　重さの配列
     * @param wp　価値の配列
     */
    public static void searchKnapsack(int maxWait, int[] vp, int[] wp) {
        knapsackDp = new int[vp.length][maxWait + 1];
        knapsackVp = vp;
        knapsackWp = wp;
        knapsackMaxWait = maxWait;
        dfsKnapsack(0, 0);
        System.out.println(knapsackDp[0][0]);
//        for(int i = 0 ; i < vp.length; i++) {
//            for(int j = 0 ; j < maxWait; j++) {
//                System.out.printf("%1$ 2d", knapsackDp[i][j]);
//            }
//            System.out.println();
//        }
    }

    public static int dfsKnapsack(int n, int w) {
        if(w > knapsackMaxWait) return - Integer.MAX_VALUE;
        if(n >= knapsackVp.length) return 0;
        if(knapsackDp[n][w] > 0) return knapsackDp[n][w];
        
        return knapsackDp[n][w] = Math.max(dfsKnapsack(n + 1, w), dfsKnapsack(n + 1, w + knapsackVp[n]) + knapsackWp[n]);
    }

    public static void main(String[] args) {
//        dfsSearch(1,1);
//        searchRobot(new double[]{0.25, 0.25, 0.25, 0.25});
        searchKnapsack(10, new int[]{1,2,3,4,5,6,10}, new int[]{2,3,4,5,6,7,10});
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
