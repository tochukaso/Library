import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;

/**
 * �p�X�J����3�p�n�𗘗p���邽�߂̃N���X�B
 * �ӂ̒�����1010���f�t�H���g�Ŏw�肷��B
 * �l�f����1010���z����悤�ȏꍇ�A�p�t�H�[�}���X�I�ɓ���͓���Ǝv����B
 * �ȉ����p�X�J����3�p�n�B
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
     * �c�̕ӂ̒����ƁA���̏��Ԃ������Ɏ��B
     * ���̎��ۂ���������m����ԋp����B
     * ���Ƃ��΁A�ӂ̒�����4,���̏��Ԃ�1�̏ꍇ�A
     * 3/8��ԋp����B
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
