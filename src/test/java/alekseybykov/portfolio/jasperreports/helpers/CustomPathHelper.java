package alekseybykov.portfolio.jasperreports.helpers;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.net.URL;
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

	public static URL getResourceURL(String fileName) {
		return Objects.requireNonNull(getClassLoader().getResource(fileName));
	}

	public static boolean isDirectoryEmpty(File directory) {
		return directory.list().length == 0;
	}

	private static ClassLoader getClassLoader() {
		return Objects.requireNonNull(CustomPathHelper.class.getClassLoader());
	}
}
