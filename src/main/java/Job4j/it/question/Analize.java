package Job4j.it.question;


import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Analize {
    private static int add;
    private static int update;
    private static int deleted;
    public static Info diff(Set<User> previous, Set<User> current) {
        Map<Integer, String> prev = previous.stream().collect(Collectors
                .toMap(User::getId, User::getName));
        Map<Integer, String> curr = current.stream().collect(Collectors
                .toMap(User::getId, User::getName));
        for (Map.Entry<Integer, String> pair : curr.entrySet()
        ) {
            System.out.println(pair);
            if (!prev.containsKey(pair.getKey())) {
                add++;
            } else if (prev.containsKey(pair.getKey()) && !pair.getValue().equals(prev.get(pair.getKey()))) {
                update++;
            }
        }
        deleted = add - curr.size() + prev.size();
        return new Info(add, update, deleted);
    }
}
