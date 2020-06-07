package alekseybykov.portfolio.jasperreports;

import alekseybykov.portfolio.jasperreports.fixtures.ExchangeRateFixture;
import alekseybykov.portfolio.jasperreports.helpers.CustomPathHelper;
import alekseybykov.portfolio.jasperreports.helpers.JasperPrintBuilder;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.data.JRCsvDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;
import org.junit.BeforeClass;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;

/**
 * @author Aleksey Bykov
 * @since 05.06.2020
 */
public class JasperReportsTestBase {

	protected static final String pdfReportsPath = System.getProperty("user.dir").concat("/out/reports/pdf/");
	protected static final String htmlReportsPath = System.getProperty("user.dir").concat("/out/reports/html/");
	protected static final String docxReportsPath = System.getProperty("user.dir").concat("/out/reports/docx/");
	protected static final String xmlReportsPath = System.getProperty("user.dir").concat("/out/reports/xml/");
	protected static final String xlsxReportsPath = System.getProperty("user.dir").concat("/out/reports/xlsx/");

	private static final String rootReportsPath = System.getProperty("user.dir").concat("/out/");;
	private static final String csvDataSourcePath = "data/csv/";

	private static final String csvDesignFileName = "report-design-for-csv-dataset.jrxml";
	private static final String beansDesignFileName = "report-design-for-beans-dataset.jrxml";

	private static final String csvDataSourceFileName = "exchange-rates-2020-may.csv";

	@BeforeClass
	public static void init() {
		CustomPathHelper.deleteFiles(new File(rootReportsPath));
	}

	protected void createPdfFromCsv(String pdfFileName) throws JRException, FileNotFoundException {
		JRDataSource dataSource = new JRCsvDataSource(CustomPathHelper.getResourceAsStream(csvDataSourcePath.concat(csvDataSourceFileName)));
		JasperExportManager.exportReportToPdfFile(JasperPrintBuilder.build(dataSource, csvDesignFileName), pdfReportsPath.concat(pdfFileName));
	}

	protected void createPdfFromBeansCollection(String pdfFileName) throws JRException, ParseException, FileNotFoundException {
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ExchangeRateFixture.getFixture());
		JasperExportManager.exportReportToPdfFile(JasperPrintBuilder.build(dataSource, beansDesignFileName), pdfReportsPath.concat(pdfFileName));
	}

	protected void createHtmlFromCsv(String htmlFileName) throws JRException, FileNotFoundException {
		JRDataSource dataSource = new JRCsvDataSource(CustomPathHelper.getResourceAsStream(csvDataSourcePath.concat(csvDataSourceFileName)));
		JasperExportManager.exportReportToHtmlFile(JasperPrintBuilder.build(dataSource, csvDesignFileName), htmlReportsPath.concat(htmlFileName));
	}

	protected void createHtmlFromBeansCollection(String htmlFileName) throws JRException, ParseException, FileNotFoundException {
		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(ExchangeRateFixture.getFixture());
		JasperExportManager.exportReportToHtmlFile(JasperPrintBuilder.build(dataSource, beansDesignFileName), htmlReportsPath.concat(htmlFileName));
	}

	protected void createDocxFromCsv(String docxFileName) throws JRException, FileNotFoundException {
		JRDataSource dataSource = new JRCsvDataSource(CustomPathHelper.getResourceAsStream(csvDataSourcePath.concat(csvDataSourceFileName)));
		JRDocxExporter jrDocxExporter = new JRDocxExporter();
		jrDocxExporter.setExporterInput(new SimpleExporterInput(JasperPrintBuilder.build(dataSource, csvDesignFileName)));
		jrDocxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(new File(docxReportsPath.concat(docxFileName))));
		jrDocxExporter.exportReport();
	}

	protected void createXmlFromCsv(String xmlFileName) throws JRException, FileNotFoundException {
		JRDataSource dataSource = new JRCsvDataSource(CustomPathHelper.getResourceAsStream(csvDataSourcePath.concat(csvDataSourceFileName)));
		JasperExportManager.exportReportToXmlFile(JasperPrintBuilder.build(dataSource, csvDesignFileName), xmlReportsPath.concat(xmlFileName), false);
	}

	protected void createXlsxFromCsv(String xlsxFileName) throws JRException, FileNotFoundException {
		JRDataSource dataSource = new JRCsvDataSource(CustomPathHelper.getResourceAsStream(csvDataSourcePath.concat(csvDataSourceFileName)));
		JRXlsxExporter jrXlsxExporter = new JRXlsxExporter();
		jrXlsxExporter.setExporterInput(new SimpleExporterInput(JasperPrintBuilder.build(dataSource, csvDesignFileName)));
		jrXlsxExporter.setExporterOutput(new SimpleOutputStreamExporterOutput(xlsxReportsPath.concat(xlsxFileName)));
		SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
		configuration.setCollapseRowSpan(false);
		jrXlsxExporter.setConfiguration(configuration);
		jrXlsxExporter.exportReport();
	}
}
