package alekseybykov.portfolio.jasperreports.helpers;

import java.util.Calendar;
import java.util.Date;

/**
 * @author Aleksey Bykov
 * @since 06.06.2020
 */
public class CustomDateHelper {
	public static Date plusDay(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add (Calendar.DATE, 1);
		return calendar.getTime();
	}
}
