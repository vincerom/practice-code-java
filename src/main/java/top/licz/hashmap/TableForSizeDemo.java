package top.licz.hashmap;

/**
 * HashMap类的tableForSize方法
 */
public class TableForSizeDemo {

    private static final int MAXIMUM_CAPACITY = 1 << 30;

    public static void main(String[] args) {
        System.out.println(tableSizeFor(-5));
    }

    /**
     * 将输入转换成大于等于输入的2幂次
     *
     * @param cap 容量入参
     * @return 标准2幂次容量
     */
    public static int tableSizeFor(int cap) {
        // 处理输入cap刚好为2幂次的情况
        int n = cap - 1;
        // 从首位1的位置开始，不断向右拷贝1至最右侧
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        // 处理整型溢出的情况，再+1转换成2幂次输出[000111...11]=>[001000...00]
        return (n < 0) ? 1 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

}
