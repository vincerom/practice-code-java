package top.licz.algorithm.sort;

/**
 * 冒泡排序
 * 从左向右两两对比，将最大的元素交换至最右侧。每一趟循环结束，右侧有序序列将多一位元素，直至整个序列有序。
 *
 * @author vince
 */
public class BubbleSort implements Sort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 3, 8, 1, 9, 6, 7, 0};
        BubbleSort bs = new BubbleSort();
        bs.sort(arr);
    }


    public void sort(int[] arr) {
        print(arr);
        for (int j = 0; j < arr.length - 1; j++) {
            for (int i = 0; i < arr.length - 1 - j; i++) {
                int p = arr[i];
                int q = arr[i + 1];
                if (p > q) {
                    arr[i + 1] = p;
                    arr[i] = q;
                }
                print(arr);
            }
        }

    }

}
