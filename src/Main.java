import Arrays.Array;
import Sorts.Sort;
import Tempo.Time;
import Graficos.Grafico;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

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

        System.out.println("\n\n================ STARTING =================\n");

        grafico.reader(System.getProperty("user.dir") + "/src/Graficos/Canvas.html");

        for (int i = 0; i < vetor.length; i++) {
            for (int j = 0; j < 50; j++) {
                int[] arr = array.getArray(vetor[i]);

                if (arr.length >= 10000) {
                    start(time, sort, arr, true);
                } else {
                    start(time, sort, arr, false);
                }
            }
            grafico(grafico, time, i, vetor[i]);
        }

        System.out.println("================ FINISH ===================");
    }

    private static void start(Time time, Sort sort, int[] arr, boolean milli) {
        time.start(milli);
        sort.bubbleSort(arr.clone());
        time.add("BUBBLE_SORT", time.stop(milli));

        //=======================================

        time.start(milli);
        sort.selectionSort(arr.clone());
        time.add("SELECTION_SORT", time.stop(milli));

        //=======================================

        time.start(milli);
        sort.insertionSort(arr.clone());
        time.add("INSERTION_SORT", time.stop(milli));

        //=======================================

        time.start(milli);
        sort.heapSort(arr.clone());
        time.add("HEAP_SORT", time.stop(milli));

        //=======================================

        time.start(milli);
        sort.mergeSort(arr.clone(), 0, arr.length - 1);
        time.add("MERGE_SORT", time.stop(milli));

        //=======================================

        time.start(milli);
        sort.quickSort(arr.clone(), 0, arr.length - 1);
        time.add("QUICK_SORT", time.stop(milli));

        //=======================================

        time.start(milli);
        sort.countSort(arr.clone());
        time.add("COUNT_SORT", time.stop(milli));

        //=======================================

        time.start(milli);
        sort.bucketSort(arr.clone());
        time.add("BUCKET_SORT", time.stop(milli));

        //=======================================

        time.start(milli);
        sort.radixSort(arr.clone(), arr.length);
        time.add("RADIX_SORT", time.stop(milli));
    }

    private static void grafico(Grafico grafico, Time time, int i, int size) throws IOException {
        if (size >= 10000) {
            grafico.writer("FinalGraph.html", (i + 1) + "(¨)", "(ms)");
        } else {
            grafico.writer("FinalGraph.html", (i + 1) + "(¨)", "(ns)");
        }
        grafico.writer("FinalGraph.html", (i + 1) + "!", time.get("BUBBLE_SORT"));
        grafico.writer("FinalGraph.html", (i + 1) + "@", time.get("SELECTION_SORT"));
        grafico.writer("FinalGraph.html", (i + 1) + "#", time.get("INSERTION_SORT"));
        grafico.writer("FinalGraph.html", (i + 1) + "$", time.get("HEAP_SORT"));
        grafico.writer("FinalGraph.html", (i + 1) + "%", time.get("MERGE_SORT"));
        grafico.writer("FinalGraph.html", (i + 1) + "&", time.get("QUICK_SORT"));
        grafico.writer("FinalGraph.html", (i + 1) + "*", time.get("COUNT_SORT"));
        grafico.writer("FinalGraph.html", (i + 1) + "(", time.get("BUCKET_SORT"));
        grafico.writer("FinalGraph.html", (i + 1) + ")", time.get("RADIX_SORT"));
        grafico.writer("FinalGraph.html", (i + 1) + "<", String.valueOf(size));
        time.restart();
    }
}