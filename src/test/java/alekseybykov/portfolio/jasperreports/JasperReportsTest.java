package alekseybykov.portfolio.jasperreports;

import alekseybykov.portfolio.jasperreports.helpers.CustomPathHelper;
import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import static org.junit.Assert.assertTrue;

/**
 * @author Aleksey Bykov
 * @since 04.06.2020
 */
public class JasperReportsTest extends JasperReportsTestBase {

	@Test
	public void testCreatePdfFromCsv() throws JRException, FileNotFoundException {
		String reportName = "report-from-csv-dataset.pdf";
		createPdfFromCsv(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(pdfReportsPath.concat(reportName))));
	}

	@Test
	public void testCreatePdfFromBeansCollection() throws ParseException, FileNotFoundException, JRException {
		String reportName = "report-from-beans-dataset.pdf";
		createPdfFromBeansCollection(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(pdfReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateHtmlFromCsv() throws JRException, FileNotFoundException {
		String reportName = "report-from-csv-dataset.html";
		createHtmlFromCsv(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(htmlReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateHtmlFromBeansCollection() throws ParseException, FileNotFoundException, JRException {
		String reportName = "report-from-beans-dataset.html";
		createHtmlFromBeansCollection(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(htmlReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateDocxFromCsv() throws JRException, FileNotFoundException {
		String reportName = "report-from-csv-dataset.docx";
		createDocxFromCsv(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(docxReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateDocxFromBeansCollection() throws ParseException, FileNotFoundException, JRException {
		String reportName = "report-from-beans-dataset.docx";
		createDocxFromBeansCollection(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(docxReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateXmlFromCsv() throws JRException, FileNotFoundException {
		String reportName = "report-from-csv-dataset.xml";
		createXmlFromCsv(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(xmlReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateXmlFromBeansCollection() throws JRException, FileNotFoundException, ParseException {
		String reportName = "report-from-beans-dataset.xml";
		createXmlFromBeansCollection(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(xmlReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateXlsxFromCsv() throws JRException, FileNotFoundException {
		String reportName = "report-from-csv-dataset.xlsx";
		createXlsxFromCsv(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(xlsxReportsPath.concat(reportName))));
	}

	@Test
	public void testCreateXlsxFromBeansCollection() throws JRException, FileNotFoundException, ParseException {
		String reportName = "report-from-beans-dataset.xlsx";
		createXlsxFromBeansCollection(reportName);
		assertTrue(CustomPathHelper.isFileExists(new File(xlsxReportsPath.concat(reportName))));
	}
}
