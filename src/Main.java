import Arrays.Array;
import Sorts.Sort;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // System.out.println(array.call(50));

        int[] vetor = new int[6];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o tamanho do " + (i + 1) + "° vetor: ");
            vetor[i] = sc.nextInt();
        }

        Array array = new Array(vetor);
        Sort sort = new Sort();
        System.out.println("\n\n================ Iniciando =================\n");

        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 50; j++){
                int arr[] = array.getArray(vetor[i]);
                System.out.println("Heap Sort: " + Arrays.toString(sort.heapSort(arr.clone())));
            }
            System.out.println("Arrays criados: " + array.getCont());
        }
        //System.out.println("\n" + array.manager());
    }
}