package alekseybykov.portfolio.jasperreports;

import alekseybykov.portfolio.jasperreports.helpers.CustomPathHelper;
import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author Aleksey Bykov
 * @since 04.06.2020
 */
public class JasperReportsTest extends JasperReportsTestBase {

	@Test
	public void testCreatePdf() throws JRException, FileNotFoundException {
		createPdf("exchange-rates-2020-may.jrxml", "exchange-rates-2020-may.csv", "exchange-rates-2020-may.pdf");
		assertTrue(CustomPathHelper.isFileExists(new File(pdfReportsPath.concat("exchange-rates-2020-may.pdf"))));
	}

	@Test
	public void testCreateHtml() throws JRException, FileNotFoundException {
		createHtml("exchange-rates-2020-may.jrxml", "exchange-rates-2020-may.csv", "exchange-rates-2020-may.html");
		assertTrue(CustomPathHelper.isFileExists(new File(htmlReportsPath.concat("exchange-rates-2020-may.html"))));
	}

	@Test
	public void testCreateDocx() throws JRException, FileNotFoundException {
		createDocx("exchange-rates-2020-may.jrxml", "exchange-rates-2020-may.csv", "exchange-rates-2020-may.docx");
		assertTrue(CustomPathHelper.isFileExists(new File(docxReportsPath.concat("exchange-rates-2020-may.docx"))));
	}
}
