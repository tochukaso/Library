package geometry;

/**
 * 三角形に関する関数を格納する
 *
 */
public class Triangle {


    /**
     * 三角形の面積を求める。
     * 各辺の長さを求め、
     * ヘロンの公式を利用して面積を求める。
     * @param x1 頂点Aのx座標
     * @param y1 頂点Aのy座標
     * @param x2 頂点Bのx座標
     * @param y2 頂点Bのy座標
     * @param x3 頂点Cのx座標
     * @param y3 頂点Cのy座標
     * @return
     */
    public static final double calculateArea(int x1, int y1, int x2, int y2, int x3, int y3) {

        double edge1 = calculateEdgeLength(x1, y1, x2, y2);
        double edge2 = calculateEdgeLength(x1, y1, x3, y3);
        double edge3 = calculateEdgeLength(x2, y2, x3, y3);
        
        double p = (edge1 + edge2 + edge3) / 2;
        
        return Math.sqrt(p*(p - edge1) * (p - edge2) * (p - edge3));
        
    }
    
    /**
     * 2点間の辺の長さを求める。
     * @param x1 頂点Aのx座標
     * @param y1 頂点Aのy座標
     * @param x2 頂点Bのx座標
     * @param y2 頂点Bのy座標
     * @return
     */
    public static final double calculateEdgeLength(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2,2) + Math.pow(y1 - y2,2));
    }
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int j2 = 0; j2 < 5; j2++) {
                    for (int k = 0; k < 5; k++) {
                        System.out.println(calculateEdgeLength(i, j, j2, k));
                    }
                   
                }
                
            }
            
        }
        
    }
}
