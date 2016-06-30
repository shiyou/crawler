package until;

import java.sql.DriverManager;
import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.mysql.jdbc.Connection;

public class GeneratorUtil {

	/**
	 * 读取数据库
	 */
	public void readDataBase(){
		String[] configLocation = {"database.properties"};
		ApplicationContext context = new FileSystemXmlApplicationContext(configLocation);
		Properties properties = new Properties();
//		Connection connection  = DriverManager.getConnection(context.get, user, password);
	}
	
	/**
	 * 生成代码
	 */
	public void genertorCode(){
		String tableName = "crawl_info_";
		
	}
}
