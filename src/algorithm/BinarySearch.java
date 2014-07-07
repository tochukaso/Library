package algorithm;

import java.util.Arrays;

/**
 * 2分木探索のサンプルクラス
 */
public class BinarySearch {

    static int[] list = new int[10000];
    
    static {
        for (int i = 0; i < 10000; i++) {
            list[i] = (int)(Math.random() * 100000);
        }
        
        Arrays.sort(list);
    }
   
    /**
     * 2分木探索を行う。
     * max値と最小値を初めに定めて、以降は
     * 探索一回ごとに範囲を半分ずつに狭めていく。
     * その要素が入るべき場所を返却する。
     * 既にその要素が存在している場合は、その要素の場所を返却する。
     * @param num
     * @return
     */
    public static int binarySearch(int num) {
        int max = list.length;
        int min = 0;
        int searchCnt = 0;
        while(min + 1 < max) {
            int now = (max + min) / 2;
            if (list[now] > num) {
                max = now;
            } else {
                min = now;
            }
            searchCnt++;
        }
        
        System.out.println("捜査回数は" + searchCnt + "です");
        return min;
    }
    
    public static void main(String[] args) {
        
        for (int i = 0; i < 10000; i++) {
           System.out.print(list[i] + " "); 
        }
        System.out.println();
        
        System.out.println(binarySearch(10000));
        System.out.println(Arrays.binarySearch(list, 10000));
        
    }
}
