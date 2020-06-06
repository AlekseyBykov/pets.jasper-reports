package alekseybykov.portfolio.jasperreports;

import alekseybykov.portfolio.jasperreports.helpers.CustomPathHelper;
import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

import java.io.File;

import static org.junit.Assert.assertTrue;

/**
 * @author Aleksey Bykov
 * @since 04.06.2020
 */
public class JasperReportsTest extends JasperReportsTestBase {

	@Test
	public void testCreatePdfFromCsv() throws JRException {
		String reportName = "exchange-rates-2020-may.pdf";
		createPdfFromCsv(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(pdfReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateHtmlFromCsv() throws JRException {
		String reportName = "exchange-rates-2020-may.html";
		createHtmlFromCsv(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(htmlReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateDocxFromCsv() throws JRException {
		String reportName = "exchange-rates-2020-may.docx";
		createDocxFromCsv(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(docxReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateXmlFromCsv() throws JRException {
		String reportName = "exchange-rates-2020-may.xml";
		createXmlFromCsv(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(xmlReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateXlsxFromCsv() throws JRException {
		String reportName = "exchange-rates-2020-may.xlsx";
		createXlsxFromCsv(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(xlsxReportsPath.concat(reportName))));
	}
}
