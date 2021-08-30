package Job4j.it.InputOutput;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> res = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
           res =  in.lines().filter(str -> {
               String[] rls = str.split("\\s+");
               return rls[rls.length - 2].equals("404");
           }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void save(List<String> log, String file) {
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(file)
                ))) {
            for (String s: log) {
                out.println(s);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        List<String> log = filter("C:\\Users\\User\\IdeaProjects\\-job4j_design\\src\\main\\java\\Job4j\\it\\InputOutput\\log.txt");
        save(log, "src/main/java/Job4j/it/InputOutput/res.txt");
    }

}
