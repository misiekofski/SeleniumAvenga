package unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.IntStream;

public class ParamTest {
    @ParameterizedTest
    @CsvFileSource(resources = "/test-data.csv")
    void testString(int a, int b, int c) {
        System.out.println(a + " + " + b + " = " + c);
    }

    @ParameterizedTest
    @MethodSource("range")
    void testString(int argument) {
        System.out.println(argument);
    }

    static IntStream range() {
        return IntStream.range(0,20).skip(10);
    }
}
