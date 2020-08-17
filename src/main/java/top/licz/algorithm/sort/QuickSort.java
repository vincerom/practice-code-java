package top.licz.algorithm.sort;

/**
 * 快速排序
 * 任意选择一个元素作为基准（取队首元素），将大于该元素的放在右侧，小于该元素的放在左侧
 * [优化]避免数组的插入产生元素交换赋值操作，比对和交换使用如下方式进行：
 * 1. 先另存队首元素为pivot
 * 2. 取队尾元素对比pivot，大于则向前移动指针，直至出现小于，将该元素赋值到head指针位置
 * 3. 取队首元素对比pivot，小于则向后移动指针，直至出现大于，将该元素赋值到tail指针位置
 * 4. 直至head指针与tail指针重叠
 *
 * @author vince
 */
public class QuickSort implements Sort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 3, 8, 1, 9, 6, 7, 0};
        QuickSort qs = new QuickSort();
        qs.sort(arr);
    }

    @Override
    public void sort(int[] arr) {
        print(arr);
        fixedSort(arr, 0, arr.length - 1);
    }

    private void fixedSort(int[] arr, int head, int tail) {
        if (head >= tail) {
            return;
        }
        int rawHead = head;
        int rawTail = tail;

        int pivot = arr[head];
        while (head < tail) {
            // resolve array tail
            while (head < tail && arr[tail] >= pivot) {
                tail--;
            }
            arr[head] = arr[tail];

            // resolve array head
            while (head < tail && arr[head] <= pivot) {
                head++;
            }
            arr[tail] = arr[head];
        }
        arr[head] = pivot;
        print(arr);
        fixedSort(arr, rawHead, tail - 1);
        fixedSort(arr, head + 1, rawTail);
    }
}
