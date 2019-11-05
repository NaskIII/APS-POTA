package Tempo;

import java.util.HashMap;

public class Time {

    private double begin;
    private double end;
    private double result;
    private HashMap<String, String> dict = new HashMap<String, String>();

    public void start(){
        end = 0;
        begin = System.nanoTime();
    }

    public void restart(){
        end = 0;
        begin = 0;
        result = 0;
        dict.clear();
    }

    public void stop(){
        end = System.nanoTime();
        result = end - begin;
    }

    public void add(String key, double value){
        dict.put(key, String.valueOf(value));
    }

    public String get(String key){
        return dict.get(key);
    }

    public double getResult(){
        return result;
    }
}
