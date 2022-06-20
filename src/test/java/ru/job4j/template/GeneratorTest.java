package ru.job4j.template;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class GeneratorTest {
    static Generator generator;

    @BeforeClass
    public static void beforeClass() throws Exception {
        generator = new GeneratorPair();
    }

    @Test
    public void whenArgumentsValid() {
        Map<String, String> pair
                = Map.of("name", "Petr Arsentev", "subject", "you");
        String expected = "I am a Petr Arsentev, Who are you? ";
        String actual = generator.produce("I am a ${name}, Who are ${subject}? ", pair);
        assertThat(actual, is(expected));
    }

    @Test(expected = UnknownKeyInTemplateException.class)
    public void whenUnknownKeyInTemplate() {
        Map<String, String> pair
                = Map.of("name", "Petr Arsentev", "subject", "you");
        String actual = generator.produce("I am a ${name} ${surname}, Who are ${subject}? ", pair);
    }

    @Test(expected = UnknownKeyInMapException.class)
    public void whenUnknownKeyInMap() {
        Map<String, String> pair
                = Map.of("name", "Petr", "surname", "Arsentev", "subject", "you");
        String actual = generator.produce("I am a ${name}, Who are ${subject}? ", pair);
    }
}