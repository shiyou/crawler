package until.codeGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author hjd
 * @date 2016年9月22日
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"../spring-mybatis.xml"})
public class Generator {
	
	public static String tableSchema ="crawler";
	public static String tableName ="crawl_info";
	
	static String TABLE_INFO_SQL = "SELECT TABLE_SCHEMA,TABLE_NAME,TABLE_COMMENT FROM INFORMATION_SCHEMA.tables WHERE TABLE_SCHEMA ='"+tableSchema+"' AND TABLE_NAME = '"+tableName+"'"; 
	static String COLUMN_INFO_SQL ="SELECT TABLE_SCHEMA, TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, COLUMN_DEFAULT, IS_NULLABLE, DATA_TYPE, COLUMN_TYPE, COLUMN_KEY, COLUMN_COMMENT "
			+ "FROM INFORMATION_SCHEMA. COLUMNS WHERE TABLE_SCHEMA = '"+tableSchema+"' AND TABLE_NAME = '"+tableName+"'";
	
	
	
	
	
	
	public static void main(String[] args) {
		
	}

}


