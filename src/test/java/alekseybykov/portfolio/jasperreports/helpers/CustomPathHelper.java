package alekseybykov.portfolio.jasperreports.helpers;

import java.io.File;
import java.net.URL;
import java.util.Objects;

/**
 * @author Aleksey Bykov
 * @since 04.06.2020
 */
public class CustomPathHelper {

	public static File getResource(String fileName) {
		return new File(Objects.requireNonNull(CustomPathHelper.class.getClassLoader().getResource(fileName)).getFile());
	}

	public static URL getResourceURL(String fileName) {
		return CustomPathHelper.class.getClassLoader().getResource(fileName);
	}
}
