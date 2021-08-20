package Job4j.it.InputOutput;

import java.io.FileInputStream;

public class EvenNumberFile {
    public static void main(String[] args) {
        try (FileInputStream in = new FileInputStream("src/main/java/Job4j/it/InputOutput/even.txt")) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            String[] lines = text.toString().split(System.lineSeparator());
            for (String line : lines) {
                String[] numbers = line.split(" ");
                for ( String n: numbers
                     ) {
                    System.out.println(Integer.parseInt(n) % 2 == 0);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
