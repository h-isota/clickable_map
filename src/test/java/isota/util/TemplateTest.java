package isota.util;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @author isota
 *
 */
public class TemplateTest {
    private Template tplObj;
    private PrivateAccessor pa;

    /**
     * @throws java.lang.Exception
     */
    @Before
    public void setUp() throws Exception {
	String text = """
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
</head>
<body>
こんにちは。
<table border="1"><tr><td>
<%-- ↓ img タグに置き換わる --%>
<%= test1 %>
</td><%= test2 %><%= test2 %></tr></table>
<%-- これはヒットしない
<%= test3 %>
--%>
</body>
</html>
""";
	String tpl = text;
	tplObj = new Template(tpl);
	pa = new PrivateAccessor(tplObj);
    }

    /**
     * @throws java.lang.Exception
     */
    @After
    public void tearDown() throws Exception {
    }

    /**
     * {@link isota.util.Template#Template(java.lang.String)} のためのテスト・メソッド。
     */
    @Test
    public void testTemplate() {
	Map<String, Integer> tplParams = pa.<Map<String, Integer>>getField("tplParams");
	assertEquals(Integer.valueOf(1), tplParams.get("test1"));
	assertEquals(Integer.valueOf(2), tplParams.get("test2"));
    }

    /**
     * {@link isota.util.Template#getParamKeys()} のためのテスト・メソッド。
     */
    @Test
    public void testGetParamKeys() {
	assertArrayEquals(new String[] { "test1", "test2" }, tplObj.getParamKeys());
    }

    /**
     * {@link isota.util.Template#setParam(java.lang.String, java.lang.String)}
     * のためのテスト・メソッド。
     */
    @Test
    public void testSetParam() {
	assertThrows(RuntimeException.class, () -> {
	    tplObj.setParam("hoge", "value");
	});
	tplObj.setParam("test1", "value");
	Map<String, String> setParams = pa.<Map<String, String>>getField("setParams");
	assertEquals("value", setParams.get("test1"));
	assertThrows(RuntimeException.class, () -> {
	    tplObj.setParam("test1", "value");
	});
    }

    /**
     * {@link isota.util.Template#getResult()} のためのテスト・メソッド。
     */
    @Test
    public void testGetResult() {
	String text = """
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="UTF-8">
</head>
<body>
こんにちは。
<table border="1"><tr><td>

value
</td><td>a</td><td>a</td></tr></table>

</body>
</html>
""";
	tplObj.setParam("test1", "value");
	tplObj.setParam("test2", "<td>a</td>");
	assertEquals(text, tplObj.getResult());
    }

}
