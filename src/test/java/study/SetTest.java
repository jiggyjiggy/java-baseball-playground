package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SetTest {
    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    // Test Case 구현

    @Test
    @DisplayName("Set의 size() 메소드를 활용해 Set의 크기를 확인")
    void size_test() {
        int actual = numbers.size();
        assertThat(actual).isEqualTo(3);
    }

    @DisplayName("Set의 contains() 메소드를 활용해 1, 2, 3의 값이 존재하는지를 확인")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertTrue(numbers.contains(number));
    }
}
