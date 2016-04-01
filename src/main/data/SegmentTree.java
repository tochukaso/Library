package main.data;

/**
 * セグメントツリーの実装
 * セグメントツリー構造はRMQ(Range Minimum Query)
 * 特定の区間での最小値を保持するために使用するデータ構造を保持する。
 *  
 * segment tree
 */
public class SegmentTree {

    // データのサイズ数
    int elementCnt;

    // セグメント木を持つ配列。木構造のため、2*elementCnt-1のデータ数になる。
    int[] dat;

    // オーバーフローを加味して最大値は2の30乗にしておく。
    static final int MAX = 2^30;

    /**
     * デフォルトコンストラクタは持たない。
     * 必ず特定の要素数が指定されるべき。
     * @param size ノードの要素数
     */
    public SegmentTree(int size) {
        init(size);
    }
    
    /**
     * init
     */
    void init(int n_) {
        elementCnt = 1;

        // 簡便のため、要素数を2のべき乗にしておく
        while (elementCnt < n_) {
            elementCnt *=2;
        }

        // 全ての値をMAX値にしておく。
        for (int i = 0; i < 2 * elementCnt - 1; i++) {
            dat[i] = Integer.MAX_VALUE;
        }
    }

    /**
     * 特定区間の最小値を更新する。
     * k番目の値(0 - indexed)をaに更新する 
     * @param k
     * @param a
     */
    void update (int k, int a) {
        // 葉の節点 木構造は要素数の2倍-1のデータを持つ。
        k += elementCnt - 1;
        dat[k] = a;
        // 末端からノードまで登りながら更新
        while (k > 0) {
            k = (k - 1) / 2;
            dat[k] = Math.min(dat[k * 2 + 1], dat[k * 2 + 2]);
        }
    }
   
    /**
    /**
     * 区間[a,b]の最小値を求める 
     * 
     * @param a 捜査対象の左端
     * @param b 捜査対象の右端
     * @return 特定区間の最小値
     */
    public int query(int a, int b) {
        return query(a, b, 0, 0, elementCnt);
    }

    /**
     * 区間[a,b]の最小値を求める 
     * 
     * @param a 捜査対象の左端
     * @param b 捜査対象の右端
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
