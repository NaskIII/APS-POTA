import Arrays.Array;
import Sorts.Sort;

import java.util.Arrays;

public class Teste {
    public static void main(String[] args) {
        Array arr = new Array();

        int[] array = arr.getArray(10000);
        Sort sort = new Sort();

        long inicio = System.currentTimeMillis();
        sort.countSort(array);
        long fim = System.currentTimeMillis() - inicio;

        System.out.println(fim);
    }
}
