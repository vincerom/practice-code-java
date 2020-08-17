package top.licz.algorithm.sort;

/**
 * 排序算法类接口
 *
 * @author vince
 */
public interface Sort {

    /**
     * main sort method
     *
     * @param arr input array
     */
    void sort(int[] arr);

    /**
     * default print method
     *
     * @param arr input array
     */
    default void print(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
