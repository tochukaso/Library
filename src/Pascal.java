import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;


public class Pascal {
    static BigDecimal[][] probability = new BigDecimal[1010][1010];
    
    static {
       //probability[0] = new double[1]l;
        for (int i = 0; i < probability.length; i++) {
            Arrays.fill(probability[i], BigDecimal.ZERO);
        }
       probability[0][0] = BigDecimal.ONE;
       for (int i = 1; i < probability.length; i++) {
          //probability[i] = new double[i + 1];
          probability[i][0] = BigDecimal.ONE;
          probability[i][i] = BigDecimal.ONE;
          for (int j = 1; j < i ; j++) {
              probability[i][j] = probability[i - 1][j - 1].add(probability[i - 1][j]);
          }
       }
        
    }
    
    static BigDecimal calc(int cnt, int pCnt) {
        BigDecimal allCnt = new BigDecimal(2).pow(cnt); 
        BigDecimal elementCnt = probability[cnt][pCnt]; 
        BigDecimal p = elementCnt.divide(allCnt, MathContext.DECIMAL128);
        return p;
    }
}
