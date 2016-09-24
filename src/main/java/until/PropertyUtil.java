package until;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @author hjd
 * @date 2016年9月23日
 */
public class PropertyUtil {
	private String path ;
	private static InputStream inStream; 
	
	public  void setInputSteam(String path){
		inStream = ClassLoader.getSystemResourceAsStream(path);
	}
//	public static String path ="jdbc.properties";
//	public static InputStream inStream = ClassLoader.getSystemResourceAsStream(path);
	
	public static String getPropValue(String key){
		Properties properties = new Properties();
		try {
			properties.load(inStream);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	
	public String getPath() {
		return path;
	}


	public void setPath(String path) {
		this.path = path;
	}


	public static void main(String[] args){
		
		System.out.println(getPropValue( "driver"));
	}
}
