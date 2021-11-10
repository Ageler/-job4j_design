package Job4j.it.tdd;

import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class GeneratorExampleTest {

    @Test
    public void produce() {
        GeneratorExample generatorExample = new GeneratorExample();
        Map<String, String> keyValue = Map.of("name", "Andrew", "subject", "you");
       String res = generatorExample.produce("I am a ${name}, Who are ${subject}? ", keyValue);
        String exp = "I am a Andrew, Who are you? ";
        assertEquals(exp, res);
    }

    @Test(expected = IllegalArgumentException.class)
    public void produceNoMapValue() {
        GeneratorExample generatorExample = new GeneratorExample();
        Map<String, String> keyValue = Map.of("name", "Andrew");
        String res = generatorExample.produce("I am a ${name}, Who are ${subject}? ", keyValue);
        String exp = "I am a Andrew, Who are you? ";
    }

    @Test(expected = IllegalArgumentException.class)
    public void produceExtraMapValue() {
        GeneratorExample generatorExample = new GeneratorExample();
        Map<String, String> keyValue = Map.of("name", "Andrew", "subject", "you", "value", "six");
        String res = generatorExample.produce("I am a ${name}, Who are ${subject}, ? ", keyValue);
        String exp = "I am a Andrew, Who are you? ";
    }
}