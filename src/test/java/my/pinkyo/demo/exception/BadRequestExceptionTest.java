package my.pinkyo.demo.exception;

import org.junit.Test;

public class BadRequestExceptionTest {

	@Test
	public void test() {
		BadRequestException exception = new BadRequestException();
		exception = new BadRequestException("bad request");
		exception = new BadRequestException(new Exception());
		exception = new BadRequestException("bad request", new Exception());
	}

}
