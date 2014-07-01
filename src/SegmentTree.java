
/**
 * �Z�O�����g�c���[�̎���
 * �Z�O�����g�c���[�\����RMQ(Range Minimum Query)
 * ����̋�Ԃł̍ŏ��l��ێ����邽�߂Ɏg�p����f�[�^�\����ێ�����B
 *  
 * segment tree
 */
public class SegmentTree {

    // �f�[�^�̃T�C�Y��
    int elementCnt;

    // �Z�O�����g�؂����z��B�؍\���̂��߁A2*elementCnt-1�̃f�[�^���ɂȂ�B
    int[] dat;

    // �I�[�o�[�t���[���������čő�l��2��30��ɂ��Ă����B��2��30��ɂ��Ă����B
    static final int MAX = 2^30;

    /**
     * �f�t�H���g�R���X�g���N�^�͎����Ȃ��B
     * �K������̗v�f�����w�肳���ׂ��B
     * @param size �m�[�h�̗v�f��
     */
    public SegmentTree(int size) {
        init(size);
    }
    
    /**
     * init
     */
    void init(int n_) {
        elementCnt = 1;

        // �ȕւ̂��߁A�v�f����2�ׂ̂���ɂ��Ă���
        while (elementCnt < n_) {
            elementCnt *=2;
        }

        // �S�Ă̒l��MAX�l�ɂ��Ă����B
        for (int i = 0; i < 2 * elementCnt - 1; i++) {
            dat[i] = Integer.MAX_VALUE;
        }
    }

    /**
     * �����Ԃ̍ŏ��l���X�V����B
     * k�Ԗڂ̒l(0 - indexed)��a�ɍX�V���� 
     * @param k
     * @param a
     */
    void update (int k, int a) {
        // �t�̐ߓ_ �؍\���͗v�f����2�{-1�̃f�[�^�����B
        k += elementCnt - 1;
        dat[k] = a;
        // ���[����m�[�h�܂œo��Ȃ���X�V
        while (k > 0) {
            k = (k - 1) / 2;
            dat[k] = Math.min(dat[k * 2 + 1], dat[k * 2 + 2]);
        }
    }
   
    /**
    /**
     * ���[a,b]�̍ŏ��l�����߂� 
     * 
     * @param a �{���Ώۂ̍��[
     * @param b �{���Ώۂ̉E�[
     * @return �����Ԃ̍ŏ��l
     */
    public int query(int a, int b) {
        return query(a, b, 0, 0, elementCnt);
    }

    /**
     * ���[a,b]�̍ŏ��l�����߂� 
     * 
     * @param a �{���Ώۂ̍��[
     * @param b �{���Ώۂ̉E�[
     * @param k 
     * @param l
     * @param r
     * @return
     */
    private int query (int a, int b, int k , int l, int r) {
        if (r <= a || b <= l) return Integer.MAX_VALUE;

        if ( a <= l && r <= b) return dat[k];
        else {
            int vl = query(a, b, k * 2 + 1, l, (l + r) / 2);
            int vr = query(a, b, k * 2 + 2, (l + r) / 2, r);
            return Math.min(vl, vr);
        }
    }
}
