import Arrays.Array;
import Sorts.Sort;
import Tempo.Time;

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
        Time time = new Time();
        System.out.println("\n\n================ Iniciando =================\n");

        for (int i = 0; i < 6; i++){
            for (int j = 0; j < 50; j++){
                int arr[] = array.getArray(vetor[i]);
                time.start();
                sort.bubbleSort(arr.clone());
                time.stop();
                time.add("BUBBLE_SORT", time.getResult());

                //=======================================
                time.start();
                sort.quickSort(arr.clone(), 0, arr.length - 1);
                time.stop();
                time.add("QUICK_SORT", time.getResult());
            }
            System.out.println("Tempo Bubble: " + time.get("BUBBLE_SORT"));
            System.out.println("Tempo Quick: " + time.get("QUICK_SORT"));
            System.out.println("Arrays criados: " + array.getCont() + "\n");
            time.restart();
        }
        //System.out.println("\n" + array.manager());
    }
}