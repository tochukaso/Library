/**
 * UnionFindのデータ構造を実現するクラス
 * UnionFindは各要素がどの集合に所属しているかを判別するために使用できる
 *
 */
public class UnionFind {
    // 各要素が保持している親のindex
    private int[] parentArray ;
    
    // 各要素が保持している木の深さ
    private int[] rankArray;
    
    // 要素数
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
     * 要素検索
     * インデックスが要素の順番と等しいときは引数の値をそのまま返却する。
     * インデックスの順番が等しくないときは検索したインデックスリストに
     * 格納されている番号を元に再度検索を行い、再帰的にインデックス配列の番号を入れ替える。
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
