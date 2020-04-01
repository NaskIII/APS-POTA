package Sorts;

import java.util.Arrays;
import java.util.LinkedList;

public class Sort {

    public void bubbleSort(int[] arr) {
        for (int i = 1; i <= arr.length; i++) {
            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1])
                    swap(arr, j, j + 1);
            }
        }
    }

    public void selectionSort(int[] arr) {
        int current_min;

        for (int i = 0; i < arr.length; i++) {
            for (int j = current_min = i; j < arr.length; j++) {
                if (arr[j] < arr[current_min])
                    current_min = j;
            }
            swap(arr, i, current_min);
        }
    }

    public void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }

    public void mergeSort(int[] vetor, int inicio, int fim) {

        if (inicio < fim) {
            int meio = (inicio + fim) / 2;
            mergeSort(vetor, inicio, meio);
            mergeSort(vetor, meio + 1, fim);
            intercala(vetor, inicio, meio, fim);
        }
    }

    private void intercala(int[] vetor, int inicio, int meio, int fim) {
        int[] vetorAux = new int[fim + 1];
        int i;
        for (i = inicio; i <= meio; i++) {
            vetorAux[i] = vetor[i];
        }
        int j;
        for (j = meio + 1; j <= fim; j++) {
            vetorAux[fim + meio + 1 - j] = vetor[j];
        }
        i = inicio;
        j = fim;
        for (int k = inicio; k <= fim; k++) {
            if (vetorAux[i] <= vetorAux[j]) {
                vetor[k] = vetorAux[i];
                i = i + 1;
            } else {
                vetor[k] = vetorAux[j];
                j = j - 1;
            }
        }
    }

    public void heapSort(int[] arr) {
        criaHeap(arr, arr.length);
        int fim = arr.length - 1;
        while (fim > 0) {
            swap(arr, 0, fim);
            fim -= 1;
            arrumaHeap(arr, 0, fim);
        }
    }

    private void criaHeap(int[] arr, int size) {
        int inicio = (size - 2) / 2;
        while (inicio >= 0) {
            arrumaHeap(arr, inicio, size - 1);
            inicio -= 1;
        }
    }

    private void arrumaHeap(int[] arr, int inicio, int fim) {
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

    public void quickSort(int[] arr, int inicio, int fim) {
        if (inicio < fim) {
            int meio = particionar(arr, inicio, fim);
            quickSort(arr, inicio, meio - 1);
            quickSort(arr, meio + 1, fim);
        }
    }

    private int particionar(int[] arr, int inicio, int fim) {
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

    public void countSort(int[] arr) {
        int maior = encontrarMaior(arr);
        int[] count = new int[maior + 1];

        for (int value : arr) {
            count[value] += 1;
        }

        int indice = 0;

        for (int i = 0; i < count.length; i++) {
            while (count[i] > 0) {
                arr[indice] = i;
                indice++;
                count[i]--;
            }
        }
    }

    private void countSort(int[] arr, int n, int exp) {
        int[] output = new int[n];
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++;

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i];
            count[(arr[i] / exp) % 10]--;
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i];
    }

    public void bucketSort(int[] arr) {
        int maiorValor = encontrarMaior(arr);
        int numBaldes = maiorValor / 5;

        LinkedList[] B = new LinkedList[numBaldes];

        for (int i = 0; i < numBaldes; i++) {
            B[i] = new LinkedList<Integer>();
        }

        for (int value : arr) {
            int j = numBaldes - 1;

            while (true) {
                if (j < 0) {
                    break;
                }
                if (value >= (j * 5)) {
                    B[j].add(value);
                    break;
                }
                j--;
            }
        }

        int indice = 0;

        for (int i = 0; i < numBaldes; i++) {
            int[] aux = new int[B[i].size()];

            for (int j = 0; j < aux.length; j++) {
                aux[j] = (Integer) B[i].get(j);
            }

            insertionSort(aux);

            for (int j = 0; j < aux.length; j++, indice++) {
                arr[indice] = aux[j];
            }

        }
    }

    public void radixSort(int[] arr, int n) {
        int max = encontrarMaior(arr);

        for (int exp = 1; max / exp > 0; exp *= 10)
            countSort(arr, n, exp);
    }

    private int encontrarMaior(int[] arr) {
        int maior = arr[0];
        for (int value : arr) {
            if (value > maior) {
                maior = value;
            }
        }
        return maior;
    }

    private void swap(int[] arr, int p1, int p2) {
        int aux = arr[p1];
        arr[p1] = arr[p2];
        arr[p2] = aux;
    }
}