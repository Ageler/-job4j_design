package Job4j.it.OOD.SRP;

public class ConvertToHTML implements Converter {

    String sourceData;

    public ConvertToHTML(String sourceData) {
        this.sourceData = sourceData;
    }

    @Override
    public String convert(String sourceData) {
        StringBuilder converted =  new StringBuilder();
        converted.append("<html><head>")
                .append("<h1>")
                .append(sourceData)
                .append("</h1>")
                .append("</html></head>");


        return converted.toString();
    }
}
