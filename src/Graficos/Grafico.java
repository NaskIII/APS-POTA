package Graficos;

import java.io.*;

public class Grafico {

    private String grafico = "";
    private int count = 0;

    public void reader(String path) throws IOException {
        BufferedReader read = new BufferedReader(new FileReader(path));
        String texto = "";
        while ((texto = read.readLine()) != null){
                grafico += texto + "\n";
            }
        read.close();
        }

    public void writer(String path, String old, String newer) throws IOException {
        BufferedWriter write = new BufferedWriter(new FileWriter(path));

        grafico = grafico.replace(old, newer);
        write.write(grafico);
        write.close();
    }

}
