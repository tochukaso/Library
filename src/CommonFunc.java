import java.util.ArrayList;
import java.util.List;


/**
 * �ėp�I�Ȋ֐����`����B
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
     * �ő���񐔂��擾����
     * �ċA�֐����g�p���āA
     * ��]��0�ɂȂ邩���ׂ�B��]��0�̏ꍇ�A���̐��Ŋ���؂��̂ł��̐����ő���񐔂ƂȂ�B
     * ��]��0�łȂ��ꍇ�A��]�Ɗ��鐔���w�肵�čċA����B 
     * @param n1
     * @param n2
     * @return
     */
    static int gcd(int n1, int n2) {
        return (n2 == 0)?n1:gcd(n2, n1%n2);
    }

    /**
     * �����̐��l�̖񐔂�ݒ肵�����X�g��ԋp����B
     * �������A�������g�̐���1�͖񐔂Ɋ܂߂Ȃ��B
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
