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
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import org.junit.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * @author Aleksey Bykov
 * @since 05.06.2020
 */
public class JasperReportsTestBase {

	protected static final String rootReportsPath = System.getProperty("user.dir").concat("/out/");;

	protected static final String designFilesPath = "jrxml/";
	protected static final String csvDataSourcePath = "data/csv/";

	protected static final String pdfReportsPath = System.getProperty("user.dir").concat("/out/reports/pdf/");
	protected static final String htmlReportsPath = System.getProperty("user.dir").concat("/out/reports/html/");
	protected static final String docxReportsPath = System.getProperty("user.dir").concat("/out/reports/docx/");
	protected static final String xmlReportsPath = System.getProperty("user.dir").concat("/out/reports/xml/");

	@BeforeClass
	public static void init() {
		CustomPathHelper.deleteFiles(new File(rootReportsPath));
	}

	protected void createPdf(String designFileName, String dataSourceFileName, String pdfFileName) throws JRException, FileNotFoundException {
		JasperPrint jasperPrint = compileAndFillReport(designFileName, dataSourceFileName);
		JasperExportManager.exportReportToPdfFile(jasperPrint, pdfReportsPath.concat(pdfFileName));
	}

	protected void createHtml(String designFileName, String dataSourceFileName, String htmlFileName) throws JRException, FileNotFoundException {
		JasperPrint jasperPrint = compileAndFillReport(designFileName, dataSourceFileName);
		JasperExportManager.exportReportToHtmlFile(jasperPrint, htmlReportsPath.concat(htmlFileName));
	}

	protected void createDocx(String designFileName, String dataSourceFileName, String docxFileName) throws JRException, FileNotFoundException {
		JasperPrint jasperPrint = compileAndFillReport(designFileName, dataSourceFileName);
		JRDocxExporter jrDocxExporter = new JRDocxExporter();
		jrDocxExporter.setExporterInput(new SimpleExporterInput(jasperPrint));
		jrDocxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(docxReportsPath.concat(docxFileName))));
		jrDocxExporter.exportReport();
	}

	protected void createXml(String designFileName, String dataSourceFileName, String xmlFileName) throws JRException, FileNotFoundException {
		JasperPrint jasperPrint = compileAndFillReport(designFileName, dataSourceFileName);
		JasperExportManager.exportReportToXmlFile(jasperPrint, xmlReportsPath.concat(xmlFileName), false);
	}

	private JasperPrint compileAndFillReport(String designFileName, String dataSourceFileName) throws JRException, FileNotFoundException {
		InputStream inputStream = new FileInputStream(CustomPathHelper.getResourceAsFile(designFilesPath.concat(designFileName)));
		JasperReport jasperReport = JasperCompileManager.compileReport(JRXmlLoader.load(inputStream));
		JRDataSource dataSource = new JRCsvDataSource(CustomPathHelper.getResourceAsStream(csvDataSourcePath.concat(dataSourceFileName)));
		return JasperFillManager.fillReport(jasperReport, null, dataSource);
	}
}
