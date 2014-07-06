import java.util.Arrays;

/**
 * 配列に関する捜査を取り扱うクラス
 *  
 *
 */
public class ArrayCommon {

    /**
     * 配列の末尾に指定の要素を追加する。
     * 元の配列をコピーした新しい配列を返却する。
     * 元の配列がnullの場合、NullPointerExceptionをスローする 
     * @param original コピー元のint配列 
     * @param addNum   末尾に追加したい要素
     * @return 要素を追加した配列を返却する
     */
    final int[] addArray(final int[] original, final int addNum) {
        int[] res = new int[original.length + 1];
        System.arraycopy(original, 0, res, 0, original.length);
        res[original.length] = addNum;
        return res;
    }

    /**
     * 配列の末尾に指定の配列を追加する。
     * 元の配列をコピーした新しい配列を返却する。
     * 配列がnullの場合、NullPointerExceptionをスローする 
     * @param original コピー元のint配列
     * @param addArray 末尾に追加したい配列
     * @return 要素を追加した配列を返却する
     */
    final int[] addArray(final int[] original, final int[] addArray) {
        int[] res = new int[original.length + addArray.length];
        System.arraycopy(original, 0, res, 0, original.length);
        System.arraycopy(addArray, 0, res, original.length, addArray.length);
        return res;
    }

    /**
     * 配列から指定されたインデックスの要素を削除する
     * 元の配列をコピーした新しい配列を返却する。
     * @param original コピー元のint配列
     * @param removeIndex 削除対象のインデックス
     * @return 要素を削除した配列を返却する
     */
    final int[] removeArray(final int[] original, final int removeIndex) {
        int[] res = new int[original.length - 1];
        System.arraycopy(original, 0, res, 0, removeIndex);
        System.arraycopy(original, removeIndex + 1, res, removeIndex, original.length - removeIndex - 1);
        return res;
    }
    
   
    /**
     * 配列の要素を取りかえる。
     * 元の配列をコピーした新しい配列を返却する
     * @param original コピー元のint配列
     * @param fromIndex 交換元のインデックス番号
     * @param toIndex 交換先のインデックス番号
     * @return 要素を交換した配列を返却する
     */
    final int[] swapArray(final int[] original, final int fromIndex, final int toIndex) {
        int[] res = Arrays.copyOf(original, original.length);
        int tmp = res[fromIndex];
        res[fromIndex] = res[toIndex];
        res[toIndex] = tmp;
        return res;
    }

    /**
     * int型配列の要素の比較
     * @param compare1
     * @param compare2
     * @return
     */
    final int convArray(final int[] compare1, final int[] compare2) {
        int sum = 0;
        for (int i = 0; i < compare1.length; i++) {
            if (compare1[i] != compare2[i]) sum++;
        }
        return sum;
    }


    /**
     * int型行列の掛け算
     * 第一引数の横幅の長さと第2引数の縦の様素数が一致しない場合にIllegalArgumentExceptionをスローする。
     * @param lineMatrix
     * @param columnMatrix
     * @return
     */
    final int[][] maltipuleMatrix(final int[][] lineMatrix, int[][] columnMatrix) {
        
        if (lineMatrix[0].length != columnMatrix.length) {
            throw new IllegalArgumentException(" line elements and column elements does'nt matching");
        }
        
        int[][] res = new int[lineMatrix.length][columnMatrix[0].length];

        for (int lineIndex = 0; lineIndex < lineMatrix.length; lineIndex ++) {
            for (int columnIndex = 0; columnIndex < columnMatrix[0].length; columnIndex ++) {
                int num = 0;
                for (int numIndex = 0; numIndex < lineMatrix.length; numIndex++) {
                    num += lineMatrix[lineIndex][numIndex] * columnMatrix[numIndex][columnIndex];
                }
                res[lineIndex][columnIndex] = num;
            }
        }
        
        return res;
    }
    

    /**
     * 
     * long型行列の掛け算
     * 第一引数の横幅の長さと第2引数の縦の様素数が一致しない場合にIllegalArgumentExceptionをスローする。
     * @param lineMatrix
     * @param columnMatrix
     * @return
     */
    final long[][] maltipuleMatrix(long[][] lineMatrix, long[][] columnMatrix) {
        
        if (lineMatrix[0].length != columnMatrix.length) {
            throw new IllegalArgumentException(" line elements and column elements does'nt matching");
        }
        
        long[][] res = new long[lineMatrix.length][columnMatrix[0].length];

        for (int lineIndex = 0; lineIndex < lineMatrix.length; lineIndex ++) {
            for (int columnIndex = 0; columnIndex < columnMatrix[0].length; columnIndex ++) {
                long num = 0;
                for (int numIndex = 0; numIndex < lineMatrix.length; numIndex++) {
                    num += lineMatrix[lineIndex][numIndex] * columnMatrix[numIndex][columnIndex];
                }
                res[lineIndex][columnIndex] = num;
            }
        }
        
        return res;
    }

    /**
     * int型の2次元配列を標準出力に出力する。
     * @param p
     */
    final void printMatrix(int[][] p) {
        for (int[] i : p) printArray(i);
    }
    
    /**
     * int型の配列を標準出力に半角スペースを区切り文字として出力する。
     * @param p
     */
    final void printArray(int[] p) {
        for (int i : p) System.out.print(i + " ");
        System.out.println();
    }

    /**
     * char型の配列が等しいか、全ての要素を捜査する。
     * @param i1
     * @param i2
     * @return
     */
    final boolean deepEquals(char[] i1, char[] i2) {
        if (i1.length != i2.length) return false;
        for (int i = 0 ; i < i1.length; i++) if (i1[i] != i2[i]) return false;
        return true;
    }
   
    /**
     * int型の配列が等しいか、全ての要素を捜査する。
     * @param i1
     * @param i2
     * @return
     */
    final boolean deepEquals(int[] i1, int[] i2) {
        if (i1.length != i2.length) return false;
        for (int i = 0 ; i < i1.length; i++) if (i1[i] != i2[i]) return false;
        return true;
    }
    
    /**
     * int型の配列を半角スペース区切りの文字列型に変換する。
     * @param i
     * @return
     */
    final String getKey(int[] i) {
        StringBuilder sb = new StringBuilder();
        for (int s : i) sb.append(" " + s);
        return sb.toString();
    }

    /**
     * int型の配列をInteger型の配列に変換して返却する。
     * @param arg
     * @return
     */
    final Integer[] convIntArray(int[] arg) {
        int len = arg.length;
        Integer[] res = new Integer[len];
        for (int i = 0; i < len; i++) res[i] = arg[i];
        return res;
    }

}
