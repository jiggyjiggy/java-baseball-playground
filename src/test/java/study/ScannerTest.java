package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScannerTest {

    @DisplayName("trim 함수는 input의 양끝 공백을 제거한다")
    @Test
    void trim() {
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream("  2 + 3 * 4 / 2 ".getBytes());
        System.setIn(byteArrayInputStream);

        Scanner scanner = new Scanner(System.in);

        String actual = scanner.nextLine().trim();
        String expected = "2 + 3 * 4 / 2";

        assertEquals(expected, actual);
    }
}
