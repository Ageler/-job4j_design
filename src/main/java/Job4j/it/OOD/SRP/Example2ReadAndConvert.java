package Job4j.it.OOD.SRP;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;

public class Example2ReadAndConvert {

    @SneakyThrows
    public String readtext(String nameOfFile) {
        String everything;
        try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
            StringBuilder sb = new StringBuilder();
            String line = br.readLine();
            while (line != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                line = br.readLine();
            }
             everything = sb.toString();
        }
        return everything;
    }

    public String convert(String inputData) {
        StringBuilder s = new StringBuilder();
        s.append(inputData);
        s.append("something");
        return s.toString();
    }
}
