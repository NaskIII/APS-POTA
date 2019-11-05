package Sorts;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;

public class Sort {
    public int[] bubbleSort(@NotNull int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }
        }
        return arr;
    }

    public int[] selectionSort(@NotNull int[] arr) {
        int current_min;

        for (int i = 0; i < arr.length; i++) {
            for (int j = current_min = i; j < arr.length; j++) {
                if (arr[j] < arr[current_min])
                    current_min = j;
            }
            swap(arr, i, current_min);
        }
        return arr;
    }

    public int[] insertionSort(@NotNull int[] arr) {
        for (int i = 1; i <= arr.length - 1; i++) {
            int j = i;
            while (j > 0 && arr[j - 1] > arr[j]) {
                swap(arr, j, j - 1);
            }
        }
        return arr;
    }

    /*public void mergeSort(int arr[], int begin, int end){
        if (begin < end){
            int mid = (begin + end)/2;
            mergeSort(arr, begin, mid);
            mergeSort(arr, mid + 1, end);
            intercala(arr, begin, mid, end);
        }
    }

    public void intercala(int arr[], int begin, int mid, int end){
        int aux[] = new int[arr.length];
        for (int i = begin; i < mid; i++){
            aux[i] = arr[i];
        }
        for (int j = mid + 1; j < end; j++){
            aux[end + mid + 1 - j] = arr[j];
        }

        int i = begin;
        int j = end;

        for (int k = begin; k < end; k++){
            if (aux[i] <= aux[j]){
                arr[k] = aux[i];
                i += 1;
            } else{
                arr[k] = aux[j];
                j -= 1;
            }
        }

        System.out.println(Arrays.toString(arr));
    }*/

    @NotNull
    @Contract("_ -> param1")
    public int[] heapSort(int[] arr) {
        criaHeap(arr, arr.length);
        int fim = arr.length - 1;
        while (fim > 0) {
            swap(arr, 0, fim);
            fim -= 1;
            arrumaHeap(arr, 0, fim);
        }
        return arr;
    }

    public void criaHeap(int[] arr, int size) {
        int inicio = (size - 2) / 2;
        while (inicio >= 0) {
            arrumaHeap(arr, inicio, size - 1);
            inicio -= 1;
        }
    }

    public void arrumaHeap(int[] arr, int inicio, int fim) {
        int raiz = inicio;
        while (raiz * 2 + 1 <= fim) {
            int filho = raiz * 2 + 1;
            int trocar = raiz;

            if (arr[trocar] < arr[filho]) {
                trocar = filho;
            }
            if (filho + 1 <= fim && arr[trocar] < arr[filho + 1]) {
                trocar = filho + 1;
            }
            if (trocar == raiz) {
                break;
            } else {
                swap(arr, raiz, trocar);
                raiz = trocar;
            }
        }
    }

    @Contract("_, _, _ -> param1")
    public int[] quickSort(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int meio = particionar(arr, inicio, fim);
            quickSort(arr, inicio, meio - 1);
            quickSort(arr, meio + 1, fim);
        }
        return arr;
    }

    public int particionar(int arr[], int inicio, int fim) {
        int i = inicio + 1;
        int j = fim;
        while (i <= j) {
            if (arr[i] < arr[inicio]) {
                i++;
            } else {
                if (arr[j] > arr[inicio]) {
                    j--;
                } else {
                    swap(arr, i, j);
                    i++;
                    j--;
                }
            }
        }

        swap(arr, inicio, j);
        return j;
    }

    @Contract("_ -> param1")
    public int[] countSort(int[] arr) {
        int maior = encontrarMaior(arr);
        int[] count = new int[maior + 1];

        for (int i = 0; i < arr.length; i++) {
            count[arr[i]] += 1;
        }

        int indice = 0;

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[indice] = i;
                indice++;
                count[i]--;
            }
        }

        return arr;
    }

    public int[] bucketSort(int[] arr) {
        int maior = encontrarMaior(arr);
        ArrayList<Integer>[] auxiliar;
        auxiliar = new ArrayList[arr.length];
        for (int i = 0; i < auxiliar.length; i++) {
            auxiliar[i] = new ArrayList<Integer>(arr.length);
        }
        int indice;
        for (int i = 0; i < auxiliar.length; i++) {
            indice = (arr[i] * arr.length) / (maior + 1);
            ArrayList<Integer> temporario = auxiliar[indice];
            int contador = 0;
            while (contador < temporario.size() && temporario.get(contador) < arr[i]) {
                contador++;
            }
            temporario.add(contador, arr[i]);
        }
        indice = 0;
        for (int i = 0; i < auxiliar.length; i++) {
            while (!auxiliar[i].isEmpty()) {
                arr[indice++] = auxiliar[i].remove(0);
            }
        }

        return arr;
    }

    @Contract(pure = true)
    public int encontrarMaior(@NotNull int[] arr) {
        int maior = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maior) {
                maior = arr[i];
            }
        }
        return maior;
    }

    private void swap(@NotNull int[] arr, int p1, int p2) {
        int aux = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = aux;
    }
}