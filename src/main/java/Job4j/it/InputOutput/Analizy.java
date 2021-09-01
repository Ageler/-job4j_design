package Job4j.it.InputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

public class Analizy {
    public void unavailable(String source, String target) throws FileNotFoundException {
        boolean status = false;
        BufferedReader bufferedReader = new BufferedReader(new FileReader(source));
        List<String> res = bufferedReader.lines().collect(Collectors.toList());
        try (PrintWriter out = new PrintWriter(new FileOutputStream("src/main/java/Job4j/it/InputOutput/unavailable.csv"))) {
            for (String s : res) {
                if (((s.contains("400 ") || s.contains("500 ")) && !status)) {
                   out.print(s.split(" ")[1] + ";");
                   status = true;
                }
                if (s.contains("300 ") || s.contains("200 ") && status) {
                    out.print(s.split(" ")[1] + "\n");
                    status = false;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws FileNotFoundException {

        Analizy analizy = new Analizy();
        analizy.unavailable("src/main/java/Job4j/it/InputOutput/analizyLogs.txt", "src/main/java/Job4j/it/InputOutput/unavailable.csv");

    }
}
