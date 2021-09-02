package Job4j.it.InputOutput;

import com.sun.security.jgss.GSSUtil;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        return values.get(key);
    }

    private void parse(String[] args) {
        if (args.length > 0) {
            for (int i = 0; i < args.length; i++) {
                args[i] = args[i].replace("-", "");
                String[] keyValue = args[i].split("=");
                if (keyValue.length > 1) {
                    values.put(keyValue[0], keyValue[1]);
                } else throw new IllegalArgumentException();
            }
        } else throw new IllegalArgumentException();
        /* TODO parse args to values. */
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    public static void main(String[] args) {
    }
}
