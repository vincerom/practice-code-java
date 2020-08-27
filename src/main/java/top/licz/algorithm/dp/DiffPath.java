package top.licz.algorithm.dp;

/**
 * 路径计算问题
 * w * h的网格，从左上格子开始[向下]或[向右]移动，到右下格子有多少不同的路径可走
 * <p>
 * etc.
 * Input 7,3
 * Output 28
 *
 * @author vince
 */
public class DiffPath {

    public static void main(String[] args) {
        DiffPath dp = new DiffPath();
        System.out.println(dp.calculate(7, 3));
    }

    /**
     * 计算路径
     *
     * @param w 网格宽
     * @param h 网格高
     * @return 路径数
     */
    public int calculate(int w, int h) {
        // int[w][h]
        int[][] cache = new int[w][h];
        // i -> w, j -> h
        for (int i = 1; i <= w; i++) {
            for (int j = 1; j <= h; j++) {
                int p = i - 1;
                int q = j - 1;
                if (p == 0 || q == 0) {
                    cache[p][q] = 1;
                    continue;
                }
                cache[p][q] = cache[p - 1][q] + cache[p][q - 1];
            }
        }
        return cache[w - 1][h - 1];
    }


}
