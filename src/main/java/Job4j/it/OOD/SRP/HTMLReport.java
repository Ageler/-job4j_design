package Job4j.it.OOD.SRP;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class HTMLReport implements Report {

    private Report reportEngine;

    public HTMLReport(Report reportEngine) {
        this.reportEngine = reportEngine;
    }

    @Override
    public String generate(Predicate<Employee> filter) {
        String sourceData = reportEngine.generate(filter);
        StringBuilder converted =  new StringBuilder();
        converted.append("<html>" +
                        "<body>" +
                        "<h2>")
                .append(sourceData)
                .append("</h2>" +
                        "</body>" +
                        "</html>");
        return converted.toString();
    }
}
