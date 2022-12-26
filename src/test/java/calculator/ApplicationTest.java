package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


class ApplicationTest {
	private static final String ERROR = "[ERROR] ";
	private OutputStream outputStream;
	
	@BeforeEach
	public void setUpOutputStream() {
		outputStream = new ByteArrayOutputStream();
		System.setOut(new PrintStream(outputStream));
	}
	
	@DisplayName("2 + 3 * 4 / 2 입력시 10을 출력한다")
	@Test
	void 기능_테스트() {
		String input = "2 + 3 * 4 / 2";
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(byteArrayInputStream);
		
		runMain();
		
		String actual = outputStream.toString();
		String expected = "10" + System.lineSeparator();
		
		assertEquals(expected, actual);
	}
	
	@DisplayName("숫자가 연속으로 입력될 시 에러를 출력한다")
	@Test
	void 예외_테스트1() {
		String input = "2 2 + 3 * 4 / 2";
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(byteArrayInputStream);
		
		runMain();
		
		String actual = outputStream.toString();
		String expected = ERROR;
		
		assertThat(actual).contains(expected);
	}
	
	@DisplayName("사칙연산 연산자 이외의 연산자를 입력할 시 에러를 출력한다.")
	@Test
	void 예외_테스트2() {
		String input = "22 ^ 3 * 4 / 2";
		ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(input.getBytes());
		System.setIn(byteArrayInputStream);
		
		runMain();
		
		String actual = outputStream.toString();
		String expected = ERROR;
		
		assertThat(actual).contains(expected);
	}
	
	private void runMain() {
		Application.main(new String[]{});
	}
}