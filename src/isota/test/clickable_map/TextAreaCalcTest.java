package isota.test.clickable_map;

import static org.junit.Assert.*;

import org.junit.Test;

import isota.clickable_map.Size;
import isota.clickable_map.TextSizeCalc;

public class TextAreaCalcTest {

	@Test
	public void testGetSize() {
		String value = "Test123";
		Size s = TextSizeCalc.getSize(value);
		assertNotNull(s);
//		System.out.printf("width: %d, height: %d", s.getWidth(), s.getHeight());
	}

}
