package Job4j.it.OOD.SRP;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class ConvertToHTML implements Converter {

    private Report reportEngine;

    public ConvertToHTML(Report reportEngine) {
        this.reportEngine = reportEngine;
    }

    @Override
    public String convert(Predicate<Employee> filter) {
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
