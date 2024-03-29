package Job4j.it.InputOutput;

import java.io.File;

public class Dir {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\User\\IdeaProjects\\-job4j_design\\src\\main\\java\\Job4j\\it");
        if (!file.exists()) {
            throw new IllegalArgumentException(String.format("Not exist %s", file.getAbsoluteFile()));
        }
        if (!file.isDirectory()) {
            throw new IllegalArgumentException(String.format("Not directory %s", file.getAbsoluteFile()));
        }

        for (File subfile : file.listFiles()) {
            System.out.println(subfile.length() + " " + subfile.getName());
        }
    }
}
