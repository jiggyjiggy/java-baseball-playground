package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {
    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    @DisplayName("\"1,2\"을 ,로 split 했을 때 1과 2로 잘 분리되는지 확인")
    void split_test() {
        String[] actual = "1,2".split(",");
        assertThat(actual).containsExactly("1", "2");
    }
    @Test
    @DisplayName("\"1\"을 ,로 split 했을 때 1만을 포함하는 배열이 반환되는지 확인")
    void split_test2() {
        String[] actual = "1,".split(",");
        assertThat(actual).containsExactly("1");
    }

    @Test
    @DisplayName("\"(1,2)\" 값이 주어졌을 때 String의 substring() 메소드를 활용해 ()을 제거하고 \"1,2\"를 반환")
    void substring_test() {
        String actual = "(1,2)".substring(1, 4);
        assertThat(actual).isEqualTo("1,2");
    }

    @Test
    @DisplayName("\"abc\" 값이 주어졌을 때 String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져오는 학습")
    void charAt_test1() {
        String target = "abc";
        assertThat(target.charAt(0)).isEqualTo('a');
        assertThat(target.charAt(1)).isEqualTo('b');
        assertThat(target.charAt(2)).isEqualTo('c');
    }

    /*
    * The assertThatExceptionOfType method allows you to test whether an exception of a specific type is thrown, while the assertThatThrownBy method allows you to test whether a piece of code throws any exception at all.
    * */
    @Test
    @DisplayName("String의 charAt() 메소드를 활용해 특정 위치의 문자를 가져올 때 위치 값을 벗어나면 " +
            "StringIndexOutOfBoundsException이 발생하는 부분에 대한 학습")
    void charAt_test2() {
        String target = "abc";
        assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
                .isThrownBy(() -> target.charAt(4))
                .withMessageMatching("String index out of range: \\d+");
    }
}
