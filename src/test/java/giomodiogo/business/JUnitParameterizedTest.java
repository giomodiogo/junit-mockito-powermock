package giomodiogo.business;

import com.giomodiogo.helper.AppHelper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class JUnitParameterizedTest {

    @ParameterizedTest
    @MethodSource("createArrays")
    void onlyEvenNumbers(Integer[] expected, Integer[] actual) {
        assertArrayEquals(expected, AppHelper.returnsEven(actual));
    }

    private static Stream createArrays() {
        return Stream.of(
                Arguments.of(new Integer[]{2, 4, 6}, new Integer[]{1, 2, 3, 4, 5, 6}),
                Arguments.of(new Integer[]{12, 16}, new Integer[]{11, 12, 16, 23})
        );
    }
}
