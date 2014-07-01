import static java.util.Arrays.copyOfRange;

import java.util.Arrays;


public class ArrayCommon {

    final int[] addArray(final int[] original, final int addNum) {
        int[] res = new int[original.length + 1];
        System.arraycopy(original, 0, res, 0, original.length);
        res[original.length] = addNum;
        return res;
    }

    final int[] addArray(final int[] original, final int[] addArray) {
        int[] res = new int[original.length + addArray.length];
        System.arraycopy(original, 0, res, 0, original.length);
        System.arraycopy(addArray, 0, res, original.length, addArray.length);
        return res;
    }
    
    final int[] removeArray(final int[] original, final int removeIndex) {
        int[] res = new int[original.length - 1];
        int[] before = copyOfRange(original, 0, removeIndex);
        int[] after = copyOfRange(original, removeIndex + 1, original.length);
        System.arraycopy(before, 0, res, 0, before.length);
        System.arraycopy(after, 0, res, before.length, after.length);
        return res;
    }

    final int[] swapArray(final int[] original, final int fromIndex, final int toIndex) {
        int[] res = Arrays.copyOf(original, original.length);
        int tmp = res[fromIndex];
        res[fromIndex] = res[toIndex];
        res[toIndex] = tmp;
        return res;
    }

    final int convArray(final int[] compare1, final int[] compare2) {
        int sum = 0;
        for (int i = 0; i < compare1.length; i++) {
            if (compare1[i] != compare2[i]) sum++;
        }
        return sum;
    }


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
    

    final long[][] maltipuleMatrix(long[][] lineMatrix, long[][] columnMatrix) {
        
        if (lineMatrix[0].length != columnMatrix.length) {
            throw new IllegalArgumentException(" line elements and column elements does'nt matching");
        }
        
        long[][] res = new long[lineMatrix.length][columnMatrix[0].length];

        for (int lineIndex = 0; lineIndex < lineMatrix.length; lineIndex ++) {
            for (int columnIndex = 0; columnIndex < columnMatrix[0].length; columnIndex ++) {
                long num = 0;
                for (int numIndex = 0; numIndex < lineMatrix.length; numIndex++) {
                    num ^= lineMatrix[lineIndex][numIndex] & columnMatrix[numIndex][columnIndex];
//                    num += lineMatrix[lineIndex][numIndex] * columnMatrix[numIndex][columnIndex];
                }
                res[lineIndex][columnIndex] = num;
            }
        }
        
        return res;
    }

    final void printMatrix(int[][] p) {
        for (int[] i : p) printArray(i);
    }
    
    final void printArray(int[] p) {
        for (int i : p) System.out.print(i + " ");
        System.out.println();
    }

    final boolean deepEquals(char[] i1, char[] i2) {
        if (i1.length != i2.length) return false;
        for (int i = 0 ; i < i1.length; i++) if (i1[i] != i2[i]) return false;
        return true;
    }
    
    final boolean deepEquals(int[] i1, int[] i2) {
        if (i1.length != i2.length) return false;
        for (int i = 0 ; i < i1.length; i++) if (i1[i] != i2[i]) return false;
        return true;
    }
    final String getKey(int[] i) {
        StringBuilder sb = new StringBuilder();
        for (int s : i) sb.append(" " + s);
        return sb.toString();
    }

    private final Integer[] convIntArray(int[] arg) {
        int len = arg.length;
        Integer[] res = new Integer[len];
        for (int i = 0; i < len; i++) res[i] = arg[i];
        return res;
    }

}
