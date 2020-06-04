package alekseybykov.portfolio.jasperreports;

import alekseybykov.portfolio.jasperreports.helpers.CustomPathHelper;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Aleksey Bykov
 * @since 04.06.2020
 */
public class JasperReportsTest {

	@Test
	public void testCreatePdfFormatReport() throws JRException, FileNotFoundException {
		InputStream input = new FileInputStream(CustomPathHelper.getResource("jrxml/report.jrxml"));
		JasperDesign jasperDesign = JRXmlLoader.load(input);
		JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
		JRDataSource dataSource = new JRCsvDataSource(new FileInputStream(CustomPathHelper.getResource("data/csv/data.csv")));
		JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, dataSource);
		JasperExportManager.exportReportToPdfFile(jasperPrint, System.getProperty("user.dir") + "/out/reports/pdf/report.pdf");
	}
}
