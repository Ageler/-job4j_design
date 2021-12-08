package Job4j.it.generics;

public class Test {

    public String CaseDrop(String message) {
        String res;
        switch (message) {
            case "1" : res = "1";
            break;
            case "2" : res = "2";
            break;
            default: res = "shit";
            break;
        }
        return res;
    }

    public static void main(String[] args) {
        Test test = new Test();
        System.out.println(test.CaseDrop("1"));
        System.out.println(test.CaseDrop("Fuck"));
    }
}
