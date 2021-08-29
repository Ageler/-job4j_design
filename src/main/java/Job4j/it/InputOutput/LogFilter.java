package Job4j.it.InputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class LogFilter {
    public static List<String> filter(String file) {
        List<String> res = new ArrayList<>();
        try (BufferedReader in = new BufferedReader(new FileReader(file))) {
           res =  in.lines().filter(str -> str.contains(" 404 ")).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    public static void main(String[] args) {
        List<String> log = filter("C:\\Users\\User\\IdeaProjects\\-job4j_design\\src\\main\\java\\Job4j\\it\\InputOutput\\log.txt");
        System.out.println(log);
    }

}
