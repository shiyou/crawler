package until;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.junit.Test;

public class GeneratorUtil {

	/**
	 * 读取数据库
	 * @throws IOException 
	 */
	public void readDataBase() throws IOException{
		Properties properties = new Properties();
		InputStream inStream =GeneratorUtil.class.getResourceAsStream("../jdbc.properties");
		properties.load(inStream);
		properties.getProperty("username");
	}
	
	/**	
	 * 生成代码
	 */
	public void genertorCode(){
		String tableName = "crawl_info_";
		
	}
	
	@Test
	public void test(){
		try {
			readDataBase();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
