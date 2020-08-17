package top.licz.algorithm.search;

/**
 * 基于数组的二叉搜索树算法
 * 1. 循环实现
 * 2. 递归实现
 *
 * @author vince
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] nums = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8};
        int target = 8;
        System.out.println(binarySearch(nums, target));
        System.out.println(binarySearch(0, nums.length, nums, target));
    }


    /**
     * binary search algorithm
     *
     * @param nums   sorted int array
     * @param target target int num
     * @return -1 -> not found
     */
    public static int binarySearch(int[] nums, int target) {
        int head = 0;
        int tail = nums.length - 1;
        int midi;
        while (head <= tail) {
            midi = (head + tail) / 2;
            if (nums[midi] == target) {
                return midi;
            }
            if (nums[midi] > target) {
                // -1 和 +1 减少判断范围，同时处理边界问题
                tail = midi - 1;
            } else {
                head = midi + 1;

            }

        }
        return -1;
    }


    /**
     * binary search algorithm
     *
     * @param head   nums array head
     * @param tail   nums array tail
     * @param nums   nums array
     * @param target target num
     * @return -1 -> not found
     */
    public static int binarySearch(int head, int tail, int[] nums, int target) {
        int midi = (head + tail) / 2;
        if (head > tail) {
            return -1;
        }
        if (nums[midi] == target) {
            return midi;
        } else if (nums[midi] > target) {
            return binarySearch(head, midi - 1, nums, target);
        } else {
            return binarySearch(midi + 1, tail, nums, target);
        }
    }


}
