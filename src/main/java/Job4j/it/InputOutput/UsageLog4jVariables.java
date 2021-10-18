package Job4j.it.InputOutput;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4jVariables {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        BasicConfigurator.configure();
        String name = "Andrew Borchenko";
        byte age = 24;
        char sex = 'm';
        boolean married = false;
        int height = 178;
        float weight = 74.5f;
        long iq = 10000;
        double qq = 1112.0;

        LOG.debug("User info name : {}, age : {}, sex : {}, married : {}, " +
                "height : {}, weight : {}, iq : {}, qq : {}", name, age, sex, married, height, weight, iq, qq);
    }

}
