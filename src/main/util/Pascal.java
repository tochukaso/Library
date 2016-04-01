package main.util;
import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

/**
 * パスカルの3角系を利用するためのクラス。
 * 辺の長さは1010をデフォルトで指定する。
 * 要素数が1010を越えるような場合、パフォーマンス的に動作は難しいと思われる。
 * 以下がパスカルの3角系。
 * 
 *     1
 *    1 1
 *   1 2 1
 *  1 3 3 1
 * 1 4 6 4 1
 *  
 */
public class Pascal {
    static BigDecimal[][] probability = new BigDecimal[1010][1010];

    static {
        for (int i = 0; i < probability.length; i++) {
            Arrays.fill(probability[i], BigDecimal.ZERO);
        }
        probability[0][0] = BigDecimal.ONE;
        for (int i = 1; i < probability.length; i++) {
            probability[i][0] = BigDecimal.ONE;
            probability[i][i] = BigDecimal.ONE;
            for (int j = 1; j < i ; j++) {
                probability[i][j] = probability[i - 1][j - 1].add(probability[i - 1][j]);
            }
        }

    }

    /**
     * 縦の辺の長さと、横の順番を引数に取る。
     * その事象が発生する確率を返却する。
     * たとえば、辺の長さが4,横の順番が1の場合、
     * 3/8を返却する。
     * @param cnt
     * @param pCnt
     * @return
     */
    static BigDecimal calc(int cnt, int pCnt) {

        BigDecimal allCnt = new BigDecimal(2).pow(cnt); 
        BigDecimal elementCnt = probability[cnt][pCnt]; 
        BigDecimal p = elementCnt.divide(allCnt, MathContext.DECIMAL128);
        return p;
    }
}
