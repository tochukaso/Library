package main.algorithm;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 幅優先探索の使用例を辞書的に格納したクラス 
 *
 */
public class BFS {

    /**
     * 幅優先探索を使用したフィールドの捜査
     * 2次元配列のマップを捜査する。
     * 
     */
    static char[][] field = new char[12][12];
    static {
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                field[i][j]  = Math.random() >= 0.3 ? '.' : '-' ;
            }
        }
        field[1][1] = 'S';
        field[10][10] = '.';
    }

    static int[] dx = {1, 0, 0, -1};
    static int[] dy = {0, 1, -1, 0};

    static boolean[][] used = new boolean[12][12];

    /**
     * 幅優先探索を使用して、ゴール地点までの最短経路での歩数をカウントする。
     * ゴールに到達できない場合は、impossibleを出力する。
     */
    public static void main(String[] args) {

        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.print(field[i][j]); 
            }
            System.out.println();
        } 
        Deque<Integer> xQue = new ArrayDeque<Integer>();
        Deque<Integer> yQue = new ArrayDeque<Integer>();

        xQue.add(1);
        yQue.add(1);

        Deque<Integer> nextXQue = new ArrayDeque<Integer>();
        Deque<Integer> nextYQue = new ArrayDeque<Integer>();
        boolean isPossible = false;
        int index = 0;
        for (; index < 100; index++) {
            while(!xQue.isEmpty()) {
                int x = xQue.poll();
                int y = yQue.poll();
                if (x == 10 && y == 10) {
                    isPossible = true;
                    System.out.println(index);
                    break;
                }


                for (int i = 0; i < 4; i++) {
                    int mx = x + dx[i];
                    int my = y + dy[i];
                    if (field[my][mx] == '.' && !used[my][mx]) {
                        used[my][mx] = true;
                        nextXQue.add(mx);
                        nextYQue.add(my);
                    }
                }
            }
            Deque<Integer> tmpXQue = xQue;
            Deque<Integer> tmpYQue = yQue;
            xQue = nextXQue;
            yQue = nextYQue;
            nextXQue = tmpXQue;
            nextYQue = tmpYQue;
        }
        if (!isPossible) System.out.println("impossible");

    }

}
