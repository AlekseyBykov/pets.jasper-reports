package alekseybykov.portfolio.jasperreports;

import alekseybykov.portfolio.jasperreports.helpers.CustomPathHelper;
import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertTrue;

/**
 * @author Aleksey Bykov
 * @since 04.06.2020
 */
public class JasperReportsTest extends JasperReportsTestBase {

	@Test
	public void testCreatePdf() throws JRException, FileNotFoundException {
		String reportName = "exchange-rates-2020-may.pdf";
		createPdf("exchange-rates-2020-may.jrxml", "exchange-rates-2020-may.csv", reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(pdfReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateHtml() throws JRException, FileNotFoundException {
		String reportName = "exchange-rates-2020-may.html";
		createHtml("exchange-rates-2020-may.jrxml", "exchange-rates-2020-may.csv", reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(htmlReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateDocx() throws JRException, FileNotFoundException {
		String reportName = "exchange-rates-2020-may.docx";
		createDocx("exchange-rates-2020-may.jrxml", "exchange-rates-2020-may.csv", reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(docxReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateXml() throws JRException, FileNotFoundException {
		String reportName = "exchange-rates-2020-may.xml";
		createXml("exchange-rates-2020-may.jrxml", "exchange-rates-2020-may.csv", reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(xmlReportsPath.concat(reportName))));
	}
}
