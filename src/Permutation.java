/**
 * 
 * ‡—ñ‚ğæ“¾‚·‚é‚½‚ß‚ÌƒNƒ‰ƒX
 *
 */
public class Permutation {

    void permutationAll(int[] p) {
        permutation(p, 0, p.length - 1);
    }

    void permutationRange(int from, int to) {
        int cnt = to - from + 1;
        int[] elements = new int[cnt];
        for (int i = 0 ; i <  cnt; i++) elements[i] = from++;
        permutation(elements, 0, cnt - 1);
    }

    void permutationString(String element) {
        char[] elements = element.toCharArray();
        permutationString(elements, 0, elements.length - 1);
    }


    void permutation(int[] elements, int nowCnt, int totalCnt) {
        if (nowCnt == totalCnt) { 

            // TODO insertCode
        } else {

            for (int i = nowCnt; i <= totalCnt; i++) {
                int tmp = elements[nowCnt]; 
                elements[nowCnt] = elements[i]; 
                elements[i] = tmp;
                permutation(elements, nowCnt+1, totalCnt);
                tmp = elements[nowCnt]; 
                elements[nowCnt] = elements[i]; 
                elements[i] = tmp;
            }
        }
    }

    void permutationString(char[] elements, int nowCnt, int totalCnt) {
        if (nowCnt == totalCnt) { 

            // TODO insertCode
        } else {

            for (int i = nowCnt; i <= totalCnt; i++) {
                char tmp = elements[nowCnt]; 
                elements[nowCnt] = elements[i]; 
                elements[i] = tmp;
                permutationString(elements, nowCnt+1, totalCnt);
                tmp = elements[nowCnt]; 
                elements[nowCnt] = elements[i]; 
                elements[i] = tmp;
            }
        }
    }

}
