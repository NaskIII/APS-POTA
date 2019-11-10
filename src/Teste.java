import Arrays.Array;
import Sorts.Sort;

import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        Array arr = new Array();


        int[] array = arr.getArray(100000);
        Sort sort = new Sort();

        sort.radixSort(array, array.length);

        System.out.println(Arrays.toString(array));
    }
}
