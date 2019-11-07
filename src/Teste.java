import Arrays.Array;
import Sorts.Sort;

import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        Array arr = new Array();

        int[] array = arr.getArray(10);
        Sort sort = new Sort();

        sort.bucketSort(array);

        System.out.println(Arrays.toString(array));
    }
}
