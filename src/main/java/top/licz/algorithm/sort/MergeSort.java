package top.licz.algorithm.sort;

/**
 * 归并排序
 * 分治思想（Divide and Conquer）
 * Divide: 将数组一分为二，接着对两侧数组继续对分，直到细分至左右数组最多只有一个元素
 * Conquer: 切分完成后合并左右数组，合并过程中进行比较，返回有序的结果数组
 *
 * @author vince
 */
public class MergeSort implements Sort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 3, 8, 1, 9, 6, 7, 0};
        MergeSort ms = new MergeSort();
        ms.sort(arr);
    }

    @Override
    public void sort(int[] arr) {
        int[] result = fixedSort(arr, 0, arr.length - 1);
        copyToRawArr(arr, result);
        print(arr);
    }

    private int[] fixedSort(int[] arr, int head, int tail) {
        // until 1 element
        if (head == tail) {
            return new int[]{arr[head]};
        }
        // divide part
        int mid = (head + tail) / 2;
        int[] leftArr = fixedSort(arr, head, mid);
        int[] rightArr = fixedSort(arr, mid + 1, tail);
        int[] result = new int[leftArr.length + rightArr.length];
        // conquer part
        int i = 0, l = 0, r = 0;
        while (l < leftArr.length && r < rightArr.length) {
            result[i++] = leftArr[l] < rightArr[r] ? leftArr[l++] : rightArr[r++];
        }
        while (l < leftArr.length) {
            result[i++] = leftArr[l++];
        }
        while (r < rightArr.length) {
            result[i++] = rightArr[r++];
        }
        return result;
    }

    private void copyToRawArr(int[] rawArr, int[] result) {
        System.arraycopy(result, 0, rawArr, 0, result.length);
    }

}
