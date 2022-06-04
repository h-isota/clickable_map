/**
 *
 */
package isota.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.charset.Charset;

/**
 * @author isota
 *
 */
public class Utils {
	public static String getLineCd() {
		return System.getProperty("line.separator");
	}
	public static String readAllLinesString(File file, String lineCd) {
		try (BufferedReader in = new BufferedReader(
				new FileReader(file, Charset.forName("UTF-8")))) {
			StringBuilder sb = new StringBuilder();
			String line;
			while ((line = in.readLine()) != null) {
				sb.append(line).append(lineCd);
			}
			return sb.toString();
		} catch (IOException e) {
			throw new Error(e);
		}
	}
	public static String readAllLinesString(String path, String lineCd) {
		return readAllLinesString(new File(path), lineCd);
	}
	public static String readAllLinesString(File file) {
		return readAllLinesString(file, getLineCd());
	}
	public static String readAllLinesString(String path) {
		return readAllLinesString(path, getLineCd());
	}
}
