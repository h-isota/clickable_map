package isota.test;

import static org.junit.Assert.*;

import org.junit.Test;

import isota.util.Size;
import isota.util.TextSizeCalc;

public class TextSizeCalcTest {

	@Test
	public void testGetSize() {
		String value = "Test123";
		Size s = TextSizeCalc.getSize(value);
		assertNotNull(s);
//		System.out.printf("width: %d, height: %d", s.getWidth(), s.getHeight());
	}

}
