package alekseybykov.portfolio.jasperreports;

import alekseybykov.portfolio.jasperreports.helpers.CustomPathHelper;
import net.sf.jasperreports.engine.JRException;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;

import static org.junit.Assert.assertFalse;

/**
 * @author Aleksey Bykov
 * @since 04.06.2020
 */
public class JasperReportsTest extends JasperReportsTestBase {

	@Test
	public void testCreatePdf() throws JRException, FileNotFoundException {
		createPdf("exchange-rates-2020-may.jrxml", "exchange-rates-2020-may.csv", "exchange-rates-2020-may.pdf");
		assertFalse(CustomPathHelper.isDirectoryEmpty(new File(pdfReportsPath)));
	}
}
