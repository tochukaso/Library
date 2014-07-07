package algorithm;

/**
 * いもす法の利用方法について
 *
 */
public class Imos {

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

}
