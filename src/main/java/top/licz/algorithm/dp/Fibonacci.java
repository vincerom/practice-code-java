package top.licz.algorithm.dp;

/**
 * 动态规划求解斐波那契数列问题
 * DP法时间复杂度为O(n)
 * 递归法时间复杂度为O(2^n)
 * <p>
 * etc.
 * Input 45
 * Output: 701408733
 *
 * @author vince
 */
public class Fibonacci {

    public static void main(String[] args) {
        Fibonacci f = new Fibonacci();
        System.out.println(f.calculate(45));
    }

    /**
     * calculate fibonacci number
     * dynamic programming implement
     *
     * @param n input n
     * @return fib
     */
    public int calculate(int n) {
        if (n == 1) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        // store n-2 and n-1
        int[] cache = {0, 1};
        // start from 3
        for (int i = 3; i <= n; i++) {
            int temp = cache[1];
            cache[1] += cache[0];
            cache[0] = temp;
        }
        return cache[1];
    }

}
