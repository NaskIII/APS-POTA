import Arrays.Array;
import Sorts.Sort;
import Tempo.Time;
import Graficos.Grafico;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        // System.out.println(array.call(50));

        int[] vetor = new int[6];
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 6; i++) {
            System.out.print("Digite o tamanho do " + (i + 1) + "° vetor: ");
            vetor[i] = sc.nextInt();
        }

        Array array = new Array();
        Sort sort = new Sort();
        Time time = new Time();
        Grafico grafico = new Grafico();
        System.out.println("\n\n================ Iniciando =================\n");

        grafico.reader(System.getProperty("user.dir") + "\\src\\Graficos\\Canvas.html");

        for (int i = 0; i < 5; i++){
            for (int j = 0; j < 50; j++){
                int arr[] = array.getArray(vetor[i]);

                time.start();
                sort.bubbleSort(arr.clone());
                time.add("BUBBLE_SORT", time.stop());

                //=======================================

                time.start();
                sort.selectionSort(arr.clone());
                time.add("SELECTION_SORT", time.stop());

                //=======================================

                time.start();
                sort.insertionSort(arr.clone());
                time.add("INSERTION_SORT", time.stop());

                //=======================================

                time.start();
                sort.heapSort(arr.clone());
                time.add("HEAP_SORT", time.stop());

                //=======================================

                /*time.start();
                sort.mergeSort(arr.clone());*/
                time.add("MERGE_SORT", 0);

                //=======================================

                time.start();
                sort.quickSort(arr.clone(), 0, arr.length - 1);
                time.add("QUICK_SORT", time.stop());

                //=======================================

                time.start();
                sort.countSort(arr.clone());
                time.add("COUNT_SORT", time.stop());

                //=======================================

                time.start();
                sort.bucketSort(arr.clone());
                time.add("BUCKET_SORT", time.stop());

                //=======================================

                /*time.start();
                sort.radixSort(arr.clone());*/
                time.add("RADIX_SORT", 0);
            }
            grafico.writer("FinalGraph.html", String.valueOf(i + 1) + "!", time.get("BUBBLE_SORT"));
            grafico.writer("FinalGraph.html", String.valueOf(i + 1) + "@", time.get("SELECTION_SORT"));
            grafico.writer("FinalGraph.html", String.valueOf(i + 1) + "#", time.get("INSERTION_SORT"));
            grafico.writer("FinalGraph.html", String.valueOf(i + 1) + "$", time.get("HEAP_SORT"));
            grafico.writer("FinalGraph.html", String.valueOf(i + 1) + "%", time.get("MERGE_SORT"));
            grafico.writer("FinalGraph.html", String.valueOf(i + 1) + "&", time.get("QUICK_SORT"));
            grafico.writer("FinalGraph.html", String.valueOf(i + 1) + "*", time.get("COUNT_SORT"));
            grafico.writer("FinalGraph.html", String.valueOf(i + 1) + "(", time.get("BUCKET_SORT"));
            grafico.writer("FinalGraph.html", String.valueOf(i + 1) + ")", time.get("RADIX_SORT"));
            time.restart();
        }

        for (int i = 0; i < 50; i++){
            int arr[] = array.getArray(vetor[5]);

            time.start(true);
            sort.bubbleSort(arr.clone());
            time.add("BUBBLE_SORT", time.stop(true));

            //=======================================

            time.start(true);
            sort.selectionSort(arr.clone());
            time.add("SELECTION_SORT", time.stop(true));

            //=======================================

            time.start(true);
            sort.insertionSort(arr.clone());
            time.add("INSERTION_SORT", time.stop(true));

            //=======================================

            time.start(true);
            sort.heapSort(arr.clone());
            time.add("HEAP_SORT", time.stop(true));

            //=======================================

            /*time.start();
            sort.mergeSort(arr.clone());*/
            time.add("MERGE_SORT", 0);

            //=======================================

            time.start(true);
            sort.quickSort(arr.clone(), 0, arr.length - 1);
            time.add("QUICK_SORT", time.stop(true));

            //=======================================

            time.start(true);
            sort.countSort(arr.clone());
            time.add("COUNT_SORT", time.stop(true));

            //=======================================

            time.start(true);
            sort.bucketSort(arr.clone());
            time.add("BUCKET_SORT", time.stop(true));

            //=======================================

            /*time.start();
            sort.radixSort(arr.clone());*/
            time.add("RADIX_SORT", 0);
        }


        grafico.writer("FinalGraph.html", String.valueOf(6) + "!", time.get("BUBBLE_SORT"));
        grafico.writer("FinalGraph.html", String.valueOf(6) + "@", time.get("SELECTION_SORT"));
        grafico.writer("FinalGraph.html", String.valueOf(6) + "#", time.get("INSERTION_SORT"));
        grafico.writer("FinalGraph.html", String.valueOf(6) + "$", time.get("HEAP_SORT"));
        grafico.writer("FinalGraph.html", String.valueOf(6) + "%", time.get("MERGE_SORT"));
        grafico.writer("FinalGraph.html", String.valueOf(6) + "&", time.get("QUICK_SORT"));
        grafico.writer("FinalGraph.html", String.valueOf(6) + "*", time.get("COUNT_SORT"));
        grafico.writer("FinalGraph.html", String.valueOf(6) + "(", time.get("BUCKET_SORT"));
        grafico.writer("FinalGraph.html", String.valueOf(6) + ")", time.get("RADIX_SORT"));
        time.getHash();
        time.restart();

        System.out.println("=================== FINISH ====================");
    }
}