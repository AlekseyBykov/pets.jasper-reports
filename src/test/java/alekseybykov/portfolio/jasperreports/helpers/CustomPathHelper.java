package alekseybykov.portfolio.jasperreports.helpers;

import java.io.File;
import java.io.InputStream;
import java.util.Objects;

/**
 * @author Aleksey Bykov
 * @since 04.06.2020
 */
public class CustomPathHelper {

	public static File getResourceAsFile(String fileName) {
		return new File(Objects.requireNonNull(getClassLoader().getResource(fileName)).getFile());
	}

	public static InputStream getResourceAsStream(String fileName) {
		return Objects.requireNonNull(getClassLoader().getResourceAsStream(fileName));
	}

	public static boolean isFileExists(File file) {
		return !file.isDirectory() && file.exists();
	}

	public static void deleteFiles(File file) {
		if (file.isDirectory()) {
			for (File f : file.listFiles()) {
				deleteFiles(f);
			}
		} else {
			file.delete();
		}
	}

	private static ClassLoader getClassLoader() {
		return Objects.requireNonNull(CustomPathHelper.class.getClassLoader());
	}
}
