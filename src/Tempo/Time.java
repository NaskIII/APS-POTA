package Tempo;

import java.util.HashMap;

public class Time {

    private long begin;
    private long end;
    private HashMap<String, String> dict = new HashMap<String, String>();

    public void start(boolean milli) {
        end = 0;
        if (milli) {
            begin = System.currentTimeMillis();
        } else {
            begin = System.nanoTime();
        }
    }

    public void restart() {
        end = 0;
        begin = 0;
        dict.clear();
    }

    public long stop(boolean millis) {
        if (millis) {
            return end = System.currentTimeMillis() - begin;
        } else {
            return end = System.nanoTime() - begin;
        }
    }

    public void add(String key, double value) {
        String valor = dict.get(key);

        if (valor == null) {
            dict.put(key, String.valueOf(value));
        } else {
            double aux = Double.parseDouble(valor);
            dict.put(key, String.valueOf(aux + value));
        }
    }

    public String get(String key) {
        double aux = Double.parseDouble(dict.get(key)) / 50;
        return String.valueOf(aux);
    }


    public void getHash() {
        dict.forEach((key, value) -> System.out.println(key + ": " + Double.parseDouble(value) / 50 )) ;
    }
}
