package fr.lernejo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class SampleTests {

    private final Sample sample = new Sample();

    @Test
    void fact() {
        Assertions.assertThatExceptionOfType(IllegalArgumentException.class)
            .isThrownBy(() -> sample.fact(-1))
            .withMessage("N should be positive");
    }

    @ParameterizedTest
    @CsvSource({
        "0, 1",
        "1, 1",
        "2, 2",
        "3, 6",
        "4, 24",
        "13, 1932053504"
    })
    void fact_test_cases(int n, int expectedResult) {
        int result = sample.fact(n);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

    @ParameterizedTest
    @CsvSource({
        "ADD, 0, 1, 1",
        "MULT, 1, 1, 1",
        "ADD, 2, 2, 4",
        "MULT, 3, 6, 18",
        "ADD, 4, 24, 28"
    })
    void op_test_cases(Sample.Operation op ,int a, int b, int expectedResult) {
        int result = sample.op(op, a, b);
        Assertions.assertThat(result).isEqualTo(expectedResult);
    }

}
