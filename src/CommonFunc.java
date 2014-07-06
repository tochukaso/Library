import java.util.ArrayList;
import java.util.List;


/**
 * 汎用的な関数を定義する。
 *
 */
public class CommonFunc {

    /**
     * 
     * @param n1
     * @param n2
     * @return
     */
    static long gcd(long n1, long n2) {
        return (n2 == 0)?n1:gcd(n2, n1%n2);
    }
    
    /**
     * 最大公約数を取得する
     * 再帰関数を使用して、
     * 剰余が0になるか調べる。剰余が0の場合、その数で割り切れるのでその数が最大公約数となる。
     * 剰余が0でない場合、剰余と割る数を指定して再帰する。 
     * @param n1
     * @param n2
     * @return
     */
    static int gcd(int n1, int n2) {
        return (n2 == 0)?n1:gcd(n2, n1%n2);
    }

    /**
     * 引数の数値の約数を設定したリストを返却する。
     * ただし、引数自身の数と1は約数に含めない。
     * 
     * @param n
     * @return
     */
    static List<Integer> searchFactor(int n) {
        List<Integer> list = new ArrayList<Integer>();
      
        int length = (int) Math.sqrt(n);
        for (int i = 2; i <= length; i++) {
            if(n % i == 0) {
                list.add(i);
                if (n / i != i) {
                    list.add(n / i);
                }
            }
        }
        return list; 
    }
}
