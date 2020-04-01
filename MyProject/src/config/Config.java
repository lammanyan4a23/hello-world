package config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {

	public static final String jrxmlFilePath = "jrxmlFilePath";
	public static final String jasperFilePath = "jasperFilePath";
	public static final String pdfExportPath = "pdfExportPath";
	private static final String ConfigurationPath = "/config.properties";
	private static Properties prop;
	static {
		try {
			Config.init();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	private Config() {
		
	}
	
	public static void init() throws IOException {
		//hihihihihi hahahahahah 123
		if (prop==null) {
			prop = new java.util.Properties();
			InputStream in = Config.class.getResourceAsStream(ConfigurationPath);
			prop.load(in);
		}
		
	}

	public static String getProperty(String key) {
		String value = prop.getProperty(key);
		return value;
	}
}
