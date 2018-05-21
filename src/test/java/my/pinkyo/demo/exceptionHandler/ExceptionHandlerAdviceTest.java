package my.pinkyo.demo.exceptionHandler;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class ExceptionHandlerAdviceTest {
	ExceptionHandlerAdvice advice = new ExceptionHandlerAdvice();
	
	@Test
	public void test() {
		Exception exception = new Exception("internal error");
		String res = advice.handleControllerException(exception);
		assertNotNull(res);
	}

}
