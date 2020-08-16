package top.licz.algorithm.sort;

public interface Sort {

    void sort(int[] arr);

    default void print(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println("");
    }

}
