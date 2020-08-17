package top.licz.algorithm.sort;

/**
 * 选择排序
 * 从第一个位置开始，遍历从该位置开始到数组结尾的所有元素，找出最小的元素与该位置交换。依次向右交换剩余最小的元素，直到结尾。
 * 选择排序遍历的是右侧无序的序列
 *
 * @author vince
 */
public class SelectionSort implements Sort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 3, 8, 1, 9, 6, 7, 0};
        SelectionSort ss = new SelectionSort();
        ss.sort(arr);
    }

    @Override
    public void sort(int[] arr) {
        print(arr);
        for (int i = 0; i < arr.length; i++) {
            int maxi = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[maxi]) {
                    maxi = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[maxi];
            arr[maxi] = temp;
            print(arr);
        }

    }
}
