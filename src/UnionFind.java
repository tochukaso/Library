/**
 * UnionFind�̃f�[�^�\������������N���X
 * UnionFind�͊e�v�f���ǂ̏W���ɏ������Ă��邩�𔻕ʂ��邽�߂Ɏg�p�ł���
 *
 */
public class UnionFind {
    // �e�v�f���ێ����Ă���e��index
    private int[] parentArray ;
    
    // �e�v�f���ێ����Ă���؂̐[��
    private int[] rankArray;
    
    // �v�f��
    private int nodeCount;

    public UnionFind(int totalCount) {
        this.nodeCount = totalCount;
        parentArray = new int[totalCount];
        rankArray = new int[totalCount];
        
        for (int i = 0; i < totalCount; i++) {
            parentArray[i] = i;
            rankArray[i] = 0;
        }
    }
    
    /**
     * <pre>
     * �v�f����
     * �C���f�b�N�X���v�f�̏��ԂƓ������Ƃ��͈����̒l�����̂܂ܕԋp����B
     * �C���f�b�N�X�̏��Ԃ��������Ȃ��Ƃ��͌��������C���f�b�N�X���X�g��
     * �i�[����Ă���ԍ������ɍēx�������s���A�ċA�I�ɃC���f�b�N�X�z��̔ԍ������ւ���B
     * </pre>
     * @param nodeIndex
     * @return
     */
    public int findParent(int nodeIndex) {
        if (parentArray[nodeIndex] == nodeIndex) {
            return nodeIndex;
        } else {
            return parentArray[nodeIndex] = findParent(parentArray[nodeIndex]);
        }
    }
    
    public void union(int node1, int node2) {
        node1 = findParent(node1);
        node2 = findParent(node2);
        if (node1 == node2) {
            return;
        }
        
        if (rankArray[node1] < rankArray[node2]) {
            parentArray[node1] = node2;
        } else if (rankArray[node1] > rankArray[node2]) {
            parentArray[node2] = node1;
        } else {
            parentArray[node2] = node1;
            rankArray[node1]++;
        }
        
    }
    
    public boolean isSameParent(int node1, int node2) {
        return findParent(node1) == findParent(node2);
    }
    
    public int getNodeCount() {
        return this.nodeCount;
    }
}
