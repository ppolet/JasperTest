package jaspertest;

import java.io.File;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JREmptyDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;

public class JasperTest {

    public void create() throws JRException {
            File reportPattern = new File("d:\\Raznoe\\JAVA\\JasperTest\\jrxml\\Blank_A4.jrxml");
            JasperDesign jasperDesign = JRXmlLoader.load(reportPattern);
            
            Map<String, Object> parameters = new HashMap<String, Object>();
            parameters.put("myExpression", "My supertext --- Динамический из программы");
           
            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);

            JRDataSource jrDataSource = new JREmptyDataSource();

            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, parameters, jrDataSource);

            JasperExportManager.exportReportToPdfFile(jasperPrint, "d:\\Raznoe\\JAVA\\JasperTest\\jasperTest.pdf");
    }
    
    public static void main(String[] args) {
        try {
            System.out.println("Start JasperReport PDF creating...");
            new JasperTest().create();
            System.out.println("We did it!");
        } catch (JRException ex) {
            ex.printStackTrace();
        }
    }
    
}
