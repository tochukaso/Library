import java.util.Arrays;

/**
 * �z��Ɋւ���{������舵���N���X
 *  
 *
 */
public class ArrayCommon {

    /**
     * �z��̖����Ɏw��̗v�f��ǉ�����B
     * ���̔z����R�s�[�����V�����z���ԋp����B
     * ���̔z��null�̏ꍇ�ANullPointerException���X���[���� 
     * @param original �R�s�[����int�z�� 
     * @param addNum   �����ɒǉ��������v�f
     * @return �v�f��ǉ������z���ԋp����
     */
    final int[] addArray(final int[] original, final int addNum) {
        int[] res = new int[original.length + 1];
        System.arraycopy(original, 0, res, 0, original.length);
        res[original.length] = addNum;
        return res;
    }

    /**
     * �z��̖����Ɏw��̔z���ǉ�����B
     * ���̔z����R�s�[�����V�����z���ԋp����B
     * �z��null�̏ꍇ�ANullPointerException���X���[���� 
     * @param original �R�s�[����int�z��
     * @param addArray �����ɒǉ��������z��
     * @return �v�f��ǉ������z���ԋp����
     */
    final int[] addArray(final int[] original, final int[] addArray) {
        int[] res = new int[original.length + addArray.length];
        System.arraycopy(original, 0, res, 0, original.length);
        System.arraycopy(addArray, 0, res, original.length, addArray.length);
        return res;
    }

    /**
     * �z�񂩂�w�肳�ꂽ�C���f�b�N�X�̗v�f���폜����
     * ���̔z����R�s�[�����V�����z���ԋp����B
     * @param original �R�s�[����int�z��
     * @param removeIndex �폜�Ώۂ̃C���f�b�N�X
     * @return �v�f���폜�����z���ԋp����
     */
    final int[] removeArray(final int[] original, final int removeIndex) {
        int[] res = new int[original.length - 1];
        System.arraycopy(original, 0, res, 0, removeIndex);
        System.arraycopy(original, removeIndex + 1, res, removeIndex, original.length - removeIndex - 1);
        return res;
    }
    
   
    /**
     * �z��̗v�f����肩����B
     * ���̔z����R�s�[�����V�����z���ԋp����
     * @param original �R�s�[����int�z��
     * @param fromIndex �������̃C���f�b�N�X�ԍ�
     * @param toIndex ������̃C���f�b�N�X�ԍ�
     * @return �v�f�����������z���ԋp����
     */
    final int[] swapArray(final int[] original, final int fromIndex, final int toIndex) {
        int[] res = Arrays.copyOf(original, original.length);
        int tmp = res[fromIndex];
        res[fromIndex] = res[toIndex];
        res[toIndex] = tmp;
        return res;
    }

    /**
     * int�^�z��̗v�f�̔�r
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
     * int�^�s��̊|���Z
     * �������̉����̒����Ƒ�2�����̏c�̗l�f������v���Ȃ��ꍇ��IllegalArgumentException���X���[����B
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
     * long�^�s��̊|���Z
     * �������̉����̒����Ƒ�2�����̏c�̗l�f������v���Ȃ��ꍇ��IllegalArgumentException���X���[����B
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
     * int�^��2�����z���W���o�͂ɏo�͂���B
     * @param p
     */
    final void printMatrix(int[][] p) {
        for (int[] i : p) printArray(i);
    }
    
    /**
     * int�^�̔z���W���o�͂ɔ��p�X�y�[�X����؂蕶���Ƃ��ďo�͂���B
     * @param p
     */
    final void printArray(int[] p) {
        for (int i : p) System.out.print(i + " ");
        System.out.println();
    }

    /**
     * char�^�̔z�񂪓��������A�S�Ă̗v�f��{������B
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
     * int�^�̔z�񂪓��������A�S�Ă̗v�f��{������B
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
     * int�^�̔z��𔼊p�X�y�[�X��؂�̕�����^�ɕϊ�����B
     * @param i
     * @return
     */
    final String getKey(int[] i) {
        StringBuilder sb = new StringBuilder();
        for (int s : i) sb.append(" " + s);
        return sb.toString();
    }

    /**
     * int�^�̔z���Integer�^�̔z��ɕϊ����ĕԋp����B
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
