package top.licz.algorithm.sort;

/**
 * 希尔排序
 * 设置一个增量d，跳跃式地处理序列，对新序列使用直接插入排序
 * 减小增量，重复上述过程，直至最终增量为1
 * <p>
 * 希尔排序是对直接插入排序的优化：
 * 1. 插入排序适合处理数据量较小的序列
 * 2. 插入排序对基本有序的序列效率较高，因为避免了大量的比较赋值（移动元素）操作
 * 基本有序是指序列中总体上值较小的元素分布在序列一侧，较大的在另一侧。
 *
 * @author vince
 * @see top.licz.algorithm.sort.InsertSort 直接插入排序
 */
public class ShellSort implements Sort {

    public static void main(String[] args) {
        int[] arr = {4, 2, 5, 3, 8, 1, 9, 6, 7, 0};
        ShellSort ss = new ShellSort();
        ss.sort(arr);
    }

    @Override
    public void sort(int[] arr) {
        int delta = arr.length;
        // iterate delta changes
        while (true) {
            delta = getDelta(delta);
            // iterate groups after divide
            for (int i = 0; i < delta; i++) {
                // insert sort implements
                for (int j = i + delta; j < arr.length; j += delta) {
                    int cur = arr[j];
                    int k = j - delta;
                    for (; k >= 0 && arr[k] > cur; k -= delta) {
                        arr[k + delta] = arr[k];
                    }
                    arr[k + delta] = cur;
                }
                print(arr);
            }
            if (delta == 1) {
                return;
            }
        }
    }

    private int getDelta(int lastDelta) {
        return lastDelta / 2;
    }

}
