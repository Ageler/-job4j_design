package Job4j.it.InputOutput;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.*;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;


public class AnalizyTest {
    @Rule
    public TemporaryFolder folder = new TemporaryFolder();

    @Test
    public void tempTest() throws IOException {
        File source = folder.newFile("source.txt");
        File target = folder.newFile("target.txt");
        try (PrintWriter out = new PrintWriter(source)) {
            out.println("200 10:56:01\n" +
                    "500 10:57:01\n" +
                    "400 10:58:02\n" +
                    "500 10:59:01\n" +
                    "200 11:00:00\n" +
                    "400 11:01:02\n" +
                    "500 11:01:33\n" +
                    "200 11:02:02\n" +
                    "200 11:03:05");

        }
        Analizy.unavailable(source.getAbsolutePath(), target.getAbsolutePath());
        StringBuilder rsl = new StringBuilder();
        try (BufferedReader in = new BufferedReader(new FileReader(target))) {
            in.lines().forEach(rsl::append);
            assertThat(rsl.toString(), is("10:57:01;11:00:00" +
                    "11:01:02;11:02:02"));
        }
    }
}