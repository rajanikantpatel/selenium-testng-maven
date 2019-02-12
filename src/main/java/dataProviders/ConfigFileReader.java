package dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Properties;

public class ConfigFileReader {
	
	private static Properties properties;
	private static final String propertyFilePath= "Configuration.properties";

	static ClassLoader classLoader = ClassLoader.getSystemClassLoader();
	static InputStream inputStream = classLoader.getResourceAsStream(propertyFilePath);
	
	static {
		BufferedReader reader;
		try {
			//reader = new BufferedReader(new FileReader(propertyFilePath));
			reader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (UnsupportedEncodingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public ConfigFileReader(){
				
	}
	
	public static String getProperty(String propertyName){
		String driverPath = properties.getProperty(propertyName);
		if(driverPath!= null) return driverPath;
		else throw new RuntimeException(propertyName+" not specified in the Configuration.properties file.");		
	}
}