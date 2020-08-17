package top.licz.algorithm.sort;

/**
 * 插入排序 Insert Sort
 * 在保持左侧有序的规则下，将右侧元素插入有序的序列中
 * [优化]：为避免数组插入和每次交换产生多余的对比和赋值操作，另记录待插入的元素值，
 * 将左侧元素依次赋值覆盖右侧元素，找到插入位置后将另记录的元素值直接赋值到插入的位置
 * 插入排序内循环遍历的是左侧有序的序列
 *
 * @author vince
 */
public class InsertSort implements Sort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 3, 8, 1, 9, 6, 7, 0};
        InsertSort is = new InsertSort();
        is.sort(arr);
    }

    public void sort(int[] arr) {
        print(arr);
        for (int i = 1; i <= arr.length - 1; i++) {
            int cur = arr[i];
            int j = i - 1;
            for (; j >= 0 && arr[j] > cur; j--) {
                arr[j + 1] = arr[j];

            }
            arr[j + 1] = cur;
            print(arr);
        }
    }

}
