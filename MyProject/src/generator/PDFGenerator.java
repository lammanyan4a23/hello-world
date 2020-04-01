package generator;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import config.Config;
import data.DataBean;
import data.DataBeanList;
import data.DataRetriever;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


public class PDFGenerator {
	
	
	
	public static void main(String[] args) {
		//String jrxmlFilePath = "C:\\Users\\user\\jasper\\sample1.jrxml";
		//String jrxmlFilePath = "C:\\Users\\user\\jasper\\JapserDemo\\JapserDemo\\bin\\main\\template1.jrxml";
		//Config config = new Config();
		String jrxmlFilePath = Config.getProperty(Config.jrxmlFilePath);
		//System.out.println(jrxmlFilePath);
		//String jrxmlFilePath = "C:\\Users\\user\\jasper\\template1.jrxml"; 
		String jasperFilePath = Config.getProperty(Config.jasperFilePath);
		//String jasperFilePath = "C:\\Users\\user\\jasper\\template1.jasper"; 
		String pdfExportPath = Config.getProperty(Config.pdfExportPath);
		//String pdfExportPath = "C:\\Users\\user\\jasper\\template1.pdf"; //how they generate pdf name in stm lol
		
		try {
			JasperCompileManager.compileReportToFile(jrxmlFilePath, jasperFilePath);
			DataBeanList beanList = new DataBeanList();
			ArrayList<DataBean> datalist = beanList.getDataBeanList();
			JRBeanCollectionDataSource ds = new JRBeanCollectionDataSource(datalist);
			
			Map<String, Object> param = new HashMap<String, Object>();
			JasperPrint jprint = (JasperPrint) JasperFillManager.fillReport(jasperFilePath, param, ds);
			JasperExportManager.exportReportToPdfFile(jprint, pdfExportPath);
			
		} catch (JRException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
