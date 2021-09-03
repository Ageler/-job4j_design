package Job4j.it.InputOutput;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Config {
    private final String path;
    private Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        values = Arrays.stream(toString().split(System.lineSeparator()))
                .filter(elem -> elem.charAt(0) != 35)
                .collect(Collectors.toMap(key -> key.split("=")[0], val -> val.split("=")[1]));
    }

    public String value(String key) {
        throw new UnsupportedOperationException("Don't impl this method yet!");
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public Map<String, String> getValues() {
        return values;
    }

    public void setValues(Map<String, String> values) {
        this.values = values;
    }

    public static void main(String[] args) {
      Config conf = new Config("src/main/java/Job4j/it/InputOutput/app.properties");
      conf.load();
        System.out.println(conf.getValues());

    }
}
