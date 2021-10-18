package Job4j.it.InputOutput;

import org.apache.log4j.BasicConfigurator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4jExExample {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) throws Exception {
        BasicConfigurator.configure();
        try {
            throw new Exception("Not supported code");
        } catch (Exception e) {
            LOG.error("Error", e);
            throw e;
        }
    }
}
