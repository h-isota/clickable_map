/**
 *
 */
package isota.util;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * @author isota
 *
 */
public class UtilsTest {

    /**
     * {@link isota.util.Utils#getLineCd()} のためのテスト・メソッド。
     */
    @Test
    public void testGetLineCd() {
	assertEquals(System.getProperty("line.separator"), Utils.getLineCd());
    }

    /**
     * {@link isota.util.Utils#readAllLinesString()} のためのテスト・メソッド。
     */
    @Test
    public void testReadAllLinesString() {
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
</td></tr></table>
</body>
</html>
""";
	assertEquals(text, Utils.readAllLinesString("index.html.tpl", "\n"));
    }

}
