package Arrays;

import org.jetbrains.annotations.Contract;

import java.util.Random;

public class Array {

    private int[] vetor;
    private int cont = 0;

    @Contract(pure = true)
    public Array(int[] arr) {
        this.vetor = arr;
    }

    /*public String manager() {
        call(vetor[0]);
        call(vetor[1]);
        call(vetor[2]);
        call(vetor[3]);
        call(vetor[4]);
        return call(vetor[5]);
    }*/

    /*public String call(int loops, int size) {
        if (loops == 0) {
            return "\nArrays criados: " + cont;
        } else {
            int[] arr = getArray(size);
            System.out.println("BubbleSort: " + Arrays.toString(bubbleSort(arr.clone())));
            cont++;
            return call(loops - 1, size);
        }
    }*/

    /*public String call(int size) {
        for (int i = 0; i < 50; i++) {
            int[] arr = getArray(size);
            //bubbleSort(arr.clone());
            //insertionSort(arr.clone());
            //selectionSort(arr.clone());
            //mergeSort(arr.clone(), 0, arr.length - 1);
            //System.out.println("Heap Sort: " + Arrays.toString(heapSort(arr)));
            //System.out.println("Quick Sort: " + Arrays.toString(quickSort(arr.clone(), 0, arr.clone().length - 1)));
            //System.out.println("Count Sort: " + Arrays.toString(countSort(arr.clone())));
            cont++;
        }
        return "Arrays criados: " + cont;
    }*/

    public int[] getArray(int size) {
        int array[] = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(101);
        }
        cont++;
        return array;
    }

    public int getCont(){
        return cont;
    }

}