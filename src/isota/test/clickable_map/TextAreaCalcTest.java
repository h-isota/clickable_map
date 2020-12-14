package isota.test.clickable_map;

import static org.junit.Assert.*;

import java.awt.Font;

import org.junit.Test;

import isota.clickable_map.Size;
import isota.clickable_map.TextAreaCalc;

public class TextAreaCalcTest {

	@Test
	public void testGetSize() {
		TextAreaCalc tac = TextAreaCalc.getInstance();
		String value = "Test123";
		Font font = new Font("Courier", Font.PLAIN, 12);
		Size s = tac.getSize(value, font);
		assertEquals(new Size(48, 7), s);
//		System.out.printf("width: %d, height: %d", s.getWidth(), s.getHeight());
	}

}
