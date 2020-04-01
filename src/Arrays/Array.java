package Arrays;

import org.jetbrains.annotations.Contract;

import java.util.Random;

public class Array {


    private int cont = 0;

    public int[] getArray(int size) {
        int array[] = new int[size];
        Random r = new Random();
        for (int i = 0; i < size; i++) {
            array[i] = r.nextInt(1001);
        }
        cont++;
        return array;
    }

    public int getCont(){
        return cont;
    }

}