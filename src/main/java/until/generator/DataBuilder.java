package until.generator;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.StringUtils;

/**
 * 数据构造类
 *
 * @author hjd
 * @date 2016年9月23日
 */
public class DataBuilder {

    //public static String tableSchema ="crawler";
//	public static String tableName ="crawl_info";

    /*	private static String SQL_TABLE_INFO = "SELECT TABLE_SCHEMA,TABLE_NAME,TABLE_COMMENT FROM INFORMATION_SCHEMA.tables WHERE "
                + "TABLE_SCHEMA ='"+PropertyUtil.getPropValue("tableSchema")+"' AND TABLE_NAME = '"+PropertyUtil.getPropValue("tableName")+"'";
     */
    private static String SQL_TABLE_INFO = "SELECT T.TABLE_NAME, T.COMMENTS TABLE_COMMENT  FROM ALL_TAB_COMMENTS T WHERE T.TABLE_NAME = '"
            + PropertyUtil.getPropValue("tableName").toUpperCase() + "'";

    private static String MYSQL_COLUMN_INFO = "SELECT TABLE_SCHEMA, TABLE_NAME, COLUMN_NAME, ORDINAL_POSITION, COLUMN_DEFAULT, IS_NULLABLE, DATA_TYPE, COLUMN_TYPE, COLUMN_KEY, COLUMN_COMMENT "
            + "FROM INFORMATION_SCHEMA. COLUMNS WHERE TABLE_SCHEMA = '" + PropertyUtil.getPropValue("tableSchema") + "' AND TABLE_NAME = '" + PropertyUtil.getPropValue("tableName") + "'";

    /*private static String MYSQL_COLUMN_INFO = "SELECT COL.TABLE_NAME,COL.TABLE_NAME,COL.COLUMN_NAME,COLUMN_ID as ORDINAL_POSITION, COL.DATA_DEFAULT as  COLUMN_DEFAULT,"
            + " NULLABLE as IS_NULLABLE, DATA_TYPE,DATA_LENGTH as characterOctetLength, DATA_SCALE as NUMERIC_PRECISION,DATA_SCALE"
            + " as NUMERIC_SCALE, COMMENTS  as COLUMN_COMMENT FROM USER_TAB_COLUMNS  COL INNER JOIN USER_COL_COMMENTS COMM ON COMM.COLUMN_NAME "
            + "= COL.COLUMN_NAME AND COMM.TABLE_NAME = COL.TABLE_NAME WHERE COL.TABLE_NAME = '" + PropertyUtil.getPropValue("tableName").toUpperCase() + "'  ORDER BY col.column_id ";
*/
    private static PreparedStatement pst = null;
    private static ResultSet rs = null;

    /**
     * 转换字段名称
     * 转换规则：
     * 列表：所有字母小写，把下划线右侧第一字母转为大写，移除下划线；
     * 类型：
     */
    public static String converName(String columnName) {
        StringBuilder builder = new StringBuilder();
        String name = columnName.toLowerCase();
        name = replacePrefix(name);
        char[] nameChars = name.toCharArray();
        boolean upcase = false;
        for (int index = 0; index < nameChars.length; index++) {
            if (nameChars[index] == '_' && index != nameChars.length - 1) {
                upcase = true;
            }
            if (nameChars[index] != '_') {
                if (upcase) {
                    builder.append(Character.toUpperCase(nameChars[index]));
                    upcase = false;
                } else {
                    builder.append(nameChars[index]);
                }
            }
        }
        return builder.toString();
    }

    /**
     * 删除前缀
     *
     * @param columnName
     */
    public static String replacePrefix(String columnName) {
        String prefix = PropertyUtil.getPropValue("prefix");
        prefix = prefix.toLowerCase();
        String[] prefixs = null;
        if (StringUtils.isNotBlank(prefix)) {
            prefixs = prefix.split(";");
        }
        if (prefix != null && prefixs.length > 0) {
            for (String pre : prefixs) {
                if (columnName.startsWith(pre)) {
                    return columnName.replaceFirst(pre, "");
                }
            }
        }
        return columnName;
    }


    /**
     * 转换类型
     *
     * @param dataType
     * @return
     */
    public static String convertType(String dataType) {
        String type = "String";
        String upperCaseType = dataType.toUpperCase();
        if (upperCaseType.equals("VARCHAR2") || upperCaseType.equals("VARCHAR") || upperCaseType.equals("CHAR") || upperCaseType.equals("BLOB") ||
                upperCaseType.equals("TEXT") || upperCaseType.equals("LONGTEXT") || upperCaseType.equals("TINYTEXT")) {
            type = "String";
        } else if (upperCaseType.equals("INT") || upperCaseType.equals("BIGINT")
                || upperCaseType.equals("TINYINT") || upperCaseType.equals("SMALLINT") || upperCaseType.equals("INTEGER")) {
            type = "Integer";
        } else if (upperCaseType.equals("DATETIME") || upperCaseType.equals("DATE") || upperCaseType.equals("TIMESTAMP")
                || upperCaseType.equals("TIME")) {
            type = "Date";
        } else if (upperCaseType.equals("FLOAT") || upperCaseType.equals("DOUBLE") || upperCaseType.equals("DECIMAL") || upperCaseType.equals("NUMBER")) {
            type = "Double";
        }
        return type;
    }


    /**
     * 转换类型(针对oracle）
     *
     * @param
     * @return
     */
    public static String convertOracleType(ColumnsTbl columnsTbl) {
        String dataType = columnsTbl.getDataType();
        String type = "String";
        String upperCaseType = dataType.toUpperCase();
        if (upperCaseType.equals("VARCHAR2") || upperCaseType.equals("VARCHAR") || upperCaseType.equals("CHAR") || upperCaseType.equals("BLOB") ||
                upperCaseType.equals("TEXT") || upperCaseType.equals("LONGTEXT") || upperCaseType.equals("TINYTEXT")) {
            type = "String";
        } else if (upperCaseType.equals("INT") || upperCaseType.equals("BIGINT")
                || upperCaseType.equals("TINYINT") || upperCaseType.equals("SMALLINT")) {
            type = "Integer";
        } else if (upperCaseType.equals("DATETIME") || upperCaseType.equals("DATE") || upperCaseType.contains("TIMESTAMP")
                || upperCaseType.equals("TIME")) {
            type = "Date";
        } else if (upperCaseType.equals("NUMBER")) {
            if (columnsTbl.getNumericScale() != null && columnsTbl.getNumericScale() > 0) {
                type = "Double";
            } else if (columnsTbl.getCharacterOctetLength() != null && columnsTbl.getCharacterOctetLength() <= 8) {
                type = "Integer";
            } else {
                type = "Long";
            }
        }
        return type;
    }


    /**
     * 获取初始对象
     *
     * @param fileURL
     * @return
     */
    public static RawObject getRawObject(String fileURL) {
        TablesTbl tablesTbl = queryTableInfo();
        RawObject rawObject = new RawObject();
        String className = converName(tablesTbl.getTableName());
        rawObject.setTablesTbl(tablesTbl);
        rawObject.setName(className.substring(0, 1).toUpperCase() + className.substring(1));
        String packageName = fileURL.replace("src/main/java/", "").replace("/", ".");
        rawObject.setPackageName(packageName.substring(0, packageName.length() - 1));
        rawObject.setCreateTime(new Date());
        return rawObject;
    }


    /**
     * 获取初始字段
     *
     * @return
     */
    public static List<RawField> getRawFields() {
        List<ColumnsTbl> columnsTbls = queryColumnInfo();
        List<RawField> rawFields = new ArrayList<RawField>();
        for (ColumnsTbl columnsTbl : columnsTbls) {
            RawField rawField = new RawField();
            rawField.setColumnsTbl(columnsTbl);
            rawField.setName(converName(columnsTbl.getColumnName()));
            rawField.setType(convertOracleType(columnsTbl));
            rawFields.add(rawField);
        }
        return rawFields;
    }


    /**
     * 获取数据库连接
     *
     * @return
     */
    public static Connection getConnection() {
        String url = PropertyUtil.getPropValue("url");
        String user = PropertyUtil.getPropValue("user");
        String password = PropertyUtil.getPropValue("password");
        Connection conn = null;
        try {
            Class.forName(PropertyUtil.getPropValue("drive"));
            conn = DriverManager.getConnection(url, user, password);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return conn;
    }


    /**
     * 查询表信息
     *
     * @return
     */
    public static TablesTbl queryTableInfo() {
        TablesTbl tablesTbl = new TablesTbl();
        try {
            pst = getConnection().prepareStatement(SQL_TABLE_INFO);
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
//				tablesTbl.setTableSchema(rs.getString("TABLE_SCHEMA"));
                tablesTbl.setTableName(rs.getString("TABLE_NAME"));
                tablesTbl.setTableComment(rs.getString("TABLE_COMMENT"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tablesTbl;
    }

    /**
     * 查询列信息
     *
     * @return
     */
    public static List<ColumnsTbl> queryColumnInfo() {
        List<ColumnsTbl> columnsTbls = new ArrayList<ColumnsTbl>();
        try {
            pst = getConnection().prepareStatement(MYSQL_COLUMN_INFO);
            rs = pst.executeQuery();
            while (rs.next()) {
                ColumnsTbl columnsTbl = new ColumnsTbl();
//				columnsTbl.setTableSchema(rs.getString("TABLE_SCHEMA"));
                columnsTbl.setTableName(rs.getString("TABLE_NAME"));
                columnsTbl.setColumnName(rs.getString("COLUMN_NAME"));
                columnsTbl.setDataType(rs.getString("DATA_TYPE"));
//				columnsTbl.setColumnType(rs.getString("COLUMN_TYPE"));
                columnsTbl.setOrdinalPosition(rs.getInt("ORDINAL_POSITION"));
//				columnsTbl.setColumnDefault(rs.getString("COLUMN_DEFAULT"));
//				columnsTbl.setColumnDefault(String.valueOf(rs.getLong("COLUMN_DEFAULT"))); oracle long 类型报异常，去除
//				columnsTbl.setColumnKey(rs.getString("COLUMN_KEY"));
                columnsTbl.setColumnComment(rs.getString("COLUMN_COMMENT"));
                columnsTbl.setIsNullable(rs.getString("IS_NULLABLE"));
                columnsTbl.setCharacterOctetLength(rs.getInt("characterOctetLength"));
                columnsTbl.setNumericScale(rs.getInt("NUMERIC_SCALE"));
                columnsTbls.add(columnsTbl);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return columnsTbls;
    }

}
