package alekseybykov.portfolio.jasperreports.helpers;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Aleksey Bykov
 * @since 07.06.2020
 */
public class JasperPrintBuilder {
	private static final String designFilesPath = "jrxml/";
	public static JasperPrint build(JRDataSource jrDataSource, String designFileName) throws FileNotFoundException, JRException {
		InputStream inputStream = new FileInputStream(CustomPathHelper.getResourceAsFile(designFilesPath.concat(designFileName)));
		JasperReport jasperReport = JasperCompileManager.compileReport(JRXmlLoader.load(inputStream));
		return JasperFillManager.fillReport(jasperReport, null, jrDataSource);
	}
}
