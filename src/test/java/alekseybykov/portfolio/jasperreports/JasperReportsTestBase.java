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
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author Aleksey Bykov
 * @since 05.06.2020
 */
public class JasperReportsTestBase {

	protected static final String designFilesPath = "jrxml/";
	protected static final String csvDataSourcePath = "data/csv/";
	protected static final String pdfReportsPath = System.getProperty("user.dir").concat("/out/reports/pdf/");
	protected static final String htmlReportsPath = System.getProperty("user.dir").concat("/out/reports/html/");

	@BeforeClass
	public static void init() throws IOException {
		FileUtils.cleanDirectory(new File(pdfReportsPath));
		FileUtils.cleanDirectory(new File(htmlReportsPath));
	}

	protected void createPdf(String designFileName, String dataSourceFileName, String pdfFileName) throws JRException, FileNotFoundException {
		JasperPrint jasperPrint = compileAndFillReport(designFileName, dataSourceFileName);
		JasperExportManager.exportReportToPdfFile(jasperPrint, pdfReportsPath.concat(pdfFileName));
	}

	protected void createHtml(String designFileName, String dataSourceFileName, String htmlFileName) throws JRException, FileNotFoundException {
		JasperPrint jasperPrint = compileAndFillReport(designFileName, dataSourceFileName);
		JasperExportManager.exportReportToHtmlFile(jasperPrint, htmlReportsPath.concat(htmlFileName));
	}

	private JasperPrint compileAndFillReport(String designFileName, String dataSourceFileName) throws JRException, FileNotFoundException {
		InputStream inputStream = new FileInputStream(CustomPathHelper.getResourceAsFile(designFilesPath.concat(designFileName)));
		JasperReport jasperReport = JasperCompileManager.compileReport(JRXmlLoader.load(inputStream));
		JRDataSource dataSource = new JRCsvDataSource(CustomPathHelper.getResourceAsStream(csvDataSourcePath.concat(dataSourceFileName)));
		return JasperFillManager.fillReport(jasperReport, null, dataSource);
	}
}
