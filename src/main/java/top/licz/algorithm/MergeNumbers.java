package top.licz.algorithm;

/**
 * 给定一组非负数值，排列这些数使之成为一个最大的数，用字符串输出最终数值
 * Input: {15, 20, 9, 6}
 * Output: "962015"
 */
public class MergeNumbers {

    public static void main(String[] args) {
        MergeNumbers mn = new MergeNumbers();
        int[] nums = {15, 20, 9, 6};
        String s = mn.largestNumber(nums);
        System.out.println(s);

    }


    public String largestNumber(int[] nums) {
        int arrLen = nums.length;
        // based on bubble sort
        for (int i = 0; i < arrLen - 1; i++) {
            for (int j = 0; j < arrLen - i - 1; j++) {
                int n1 = nums[j];
                int n2 = nums[j + 1];
                int[] n1a = splitNum(n1);
                int[] n2a = splitNum(n2);
                if (!compare(n1a, n2a)) {
                    // swap
                    int temp = nums[j + 1];
                    nums[j + 1] = nums[j];
                    nums[j] = temp;
                }
            }

        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nums.length; i++) {
            sb.append(nums[i]);
        }
        return sb.toString();
    }

    // fixme
    public boolean compare(int[] n1a, int[] n2a) {
        int[] loopNum = n1a.length <= n2a.length ? n1a : n2a;
        for (int i = 0; i < loopNum.length; i++) {
            if (n1a[i] > n2a[i]) {
                return true;
            } else if (n1a[i] < n2a[i]) {
                return false;
            }
        }
        return false;
    }


    public int[] splitNum(int num) {
        if (num == 0) {
            return new int[]{0};
        }
        int length = getNumLength(num);
        int[] result = new int[length];
        for (int i = 0; i < length; i++) {
            int d = (int) Math.pow(10, length - i - 1);
            result[i] = num / d % 10;
        }
        return result;
    }

    public int getNumLength(int num) {
        int length = 0;
        int t = num;
        do {
            t = t / 10;
            length++;
        } while (t != 0);
        return length;
    }


}
