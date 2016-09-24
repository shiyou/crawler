package until.codeGenerator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * 数据构造类
 * @author hjd
 * @date 2016年9月23日
 */
public class DataBuilder {
	
	
	static PreparedStatement pst =null;
	static ResultSet rs =null;
	
	
	/**
	 * 转换字段名称
	 * 转换规则：
	 * 列表：所有字母小写，把下划线右侧第一字母转为大写，移除下划线；
	 * 类型：
	 */
	public static String converName(String columnName){
		StringBuilder builder = new StringBuilder();
		String name = columnName.toLowerCase();
		char[] nameChars = name.toCharArray();
		boolean upcase =false;
		for(int index=0;index<nameChars.length;index++){
			if(nameChars[index] == '_' && index!=nameChars.length-1){
				upcase=true;
			}
			if(nameChars[index] != '_'){
				if(upcase) {
					builder.append(Character.toUpperCase(nameChars[index]));
					upcase =false;
				}else {
					builder.append(nameChars[index]);
				}
			}
		}
		return builder.toString();
	}
	
	
	/**
	 * 转换类型
	 * @param dataType
	 * @return
	 */
	public static String convertType(String dataType){
		String type="String";
		String lowerCaseType = dataType.toUpperCase();
		if(lowerCaseType.equals("VARCHAR") || lowerCaseType.equals("CHAR") ||lowerCaseType.equals("BLOB")||
				lowerCaseType.equals("TEXT") || lowerCaseType.equals("LONGTEXT") || lowerCaseType.equals("TINYTEXT")){
			type= "String";
		}else if(lowerCaseType.equals("INTEGER") || lowerCaseType.equals("INT") || lowerCaseType.equals("BIGINT") 
				|| lowerCaseType.equals("TINYINT") || lowerCaseType.equals("SMALLINT")){
			type= "Integer";
		}else if(lowerCaseType.equals("DATETIME") || lowerCaseType.equals("DATE") || lowerCaseType.equals("TIMESTAMP")
				|| lowerCaseType.equals("TIME")){
			type ="Date";
		}else if(lowerCaseType.equals("FLOAT") || lowerCaseType.equals("DOUBLE") || lowerCaseType.equals("DECIMAL")){
			type ="Double";
		}
		return type;
	}
	
	
	
	/**
	 * 获取初始对象
	 * @param tablesTbl
	 * @return
	 */
	public static RawObject getRawObject(TablesTbl tablesTbl){
		RawObject rawObject = new RawObject();
		rawObject.setTablesTbl(tablesTbl);
		rawObject.setName(converName(tablesTbl.getTableName()));
		return rawObject;
	}
	
	/**
	 * 获取初始字段
	 * @param columnsTbls
	 * @return
	 */
	public static List<RawField> getRawFields(List<ColumnsTbl> columnsTbls){
		List<RawField> rawFields = new ArrayList<>();
		for(ColumnsTbl columnsTbl:columnsTbls){
			RawField rawField = new RawField();
			rawField.setColumnsTbl(columnsTbl);
		}
		return rawFields;
	}
	
	
	/**
	 * 获取数据库连接
	 * @return
	 */
	public static Connection getConnection(){
		String url = "jdbc:mysql://localhost:3306/test" ;    
		String user = "root" ;   
		String password = "root" ;   
		Connection conn = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url, user, password);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return conn;
	}
	

	/**
	 * 查询表信息
	 * @param sql
	 * @return
	 */
	public static TablesTbl queryTableInfo(String sql){
		TablesTbl tablesTbl = new TablesTbl();
		try {
			pst = getConnection().prepareStatement(sql);
			ResultSet rs =pst.executeQuery();
			while(rs.next()){
				tablesTbl.setTableSchema(rs.getString("TABLE_SCHEMA"));
				tablesTbl.setTableName(rs.getString("TABLE_NAME"));
				tablesTbl.setTableComment(rs.getString("TABLE_COMMENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return tablesTbl;
	}
	
	/**
	 * 查询列信息
	 * @param sql
	 * @return
	 */
	public static List<ColumnsTbl> queryColumnInfo(String sql){
		List<ColumnsTbl> columnsTbls = new ArrayList<>();
		try {
			pst = getConnection().prepareStatement(sql);
			rs = pst.executeQuery();
			while(rs.next()){
				ColumnsTbl columnsTbl = new ColumnsTbl();
				columnsTbl.setTableSchema(rs.getString("TABLE_SCHEMA"));
				columnsTbl.setTableName(rs.getString("TABLE_NAME"));
				columnsTbl.setColumnName(rs.getString("COLUMN_NAME"));
				columnsTbl.setDataType(rs.getString("DATA_TYPE"));
				columnsTbl.setColumnType(rs.getString("COLUMN_TYPE"));
				columnsTbl.setOrdinalPosition(rs.getInt("ORDINAL_POSITION"));
				columnsTbl.setColumnDefault(rs.getString("COLUMN_DEFAULT"));
				columnsTbl.setColumnKey(rs.getString("COLUMN_KEY"));
				columnsTbl.setColumnComment(rs.getString("COLUMN_COMMENT"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return columnsTbls;
	}
	
	

}
