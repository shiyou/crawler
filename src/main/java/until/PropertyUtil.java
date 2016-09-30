package until;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hjd
 * @date 2016年9月23日
 */
public class PropertyUtil {
	private static String path ="templates/generate.properties";
	private static InputStream inStream = null; 
	private static Properties properties  = null;
	public static InputStream getInputStream(){
		if(inStream ==null){
			inStream = ClassLoader.getSystemResourceAsStream(path);
		}
		return inStream;
	}
	public  void setInputSteam(String path){
		inStream = ClassLoader.getSystemResourceAsStream(path);
	}
	
	public static String getPropValue(String key){
		if(properties == null){
			properties = new Properties();
			try {
				properties.load(getInputStream());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return properties.getProperty(key);
	}

	
}
