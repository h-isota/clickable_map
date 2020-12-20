/**
 *
 */
package isota.test;

import static org.junit.Assert.*;

import java.util.Hashtable;

import org.junit.Test;

/**
 * @author isota
 *
 */
public class PrivateAccessorTest {
	private static class Sample {
		private Hashtable<String, String> ht = new Hashtable<>();
		private String put(String key, String value) {
			return ht.put(key, value);
		}
		private static String getMessage(String name) {
			return "Hello " + name + "!";
		}
	}

	/**
	 * {@link isota.test.PrivateAccessor#call(java.lang.String, java.lang.Object[])} のためのテスト・メソッド。
	 */
	@Test
	public void testCall() {
		PrivateAccessor pa = new PrivateAccessor(new Sample());
		assertNull(pa.call("put", "key1", "value1"));
	}

	/**
	 * {@link isota.test.PrivateAccessor#call(java.lang.String, java.lang.Object[])} のためのテスト・メソッド。
	 */
	@Test
	public void testStaticCall() {
		assertEquals("Hello aaa!", PrivateAccessor.call(Sample.class, "getMessage", "aaa"));
	}

	/**
	 * {@link isota.test.PrivateAccessor#getField(java.lang.String)} のためのテスト・メソッド。
	 */
	@Test
	public void testGetField() {
		PrivateAccessor pa = new PrivateAccessor(new Sample());
		pa.call("put", "key1", "value1");
		assertEquals("value1", pa.<Hashtable<String, String>>getField("ht").get("key1"));
	}

	/**
	 * {@link isota.test.PrivateAccessor#setField(java.lang.String, java.lang.Object)} のためのテスト・メソッド。
	 */
	@Test
	public void testSetField() {
		PrivateAccessor pa = new PrivateAccessor(new Sample());
		pa.call("put", "key1", "value1");
		assertEquals(1, pa.<Hashtable<String, String>>getField("ht").size());
		pa.setField("ht", new Hashtable<String, String>());
		assertEquals(0, pa.<Hashtable<String, String>>getField("ht").size());
		try {
			pa.setField("ht", "aaa");
			fail();
		} catch (IllegalArgumentException e) {}
	}

}
