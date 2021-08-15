package Job4j.it.InputOutput;

import java.io.FileOutputStream;


public class Calculator {
    public static void main(String[] args) {
        try (FileOutputStream out = new FileOutputStream("C:\\Users\\User\\Desktop\\Output.txt")) {
            for (int i = 1; i < 10; i++) {
                for (int j = 1; j < 10; j++) {
                    out.write(Integer.toString(i*j).getBytes());
                    out.write(" ".getBytes());
                }
                out.write(System.lineSeparator().getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
