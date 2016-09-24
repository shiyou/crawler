package com.crawler.tbl;

/**
 * 表字段
 * @author hjd
 * @date 2016年9月22日
 * @table(COLUMNS)
 */
public class ColumnsTbl {
	
	/**
	 * 表模式 
	 * @column(TABLE_SCHEMA)
	 */
	private String tableSchema;
	/**
	 * 表名 
	 * @column(TABLE_NAME)
	 */
	private String tableName;
	private String columnName;
	private Integer ordinalPosition;
	private String columnDefault;
	private String isNullable;
	private String dataType;
	private Integer characterMaximumLength ;
	private Integer characterOctetLength;
	private Integer numericPrecision;
	private Integer numericScale;
	private String columnType;
	private String columnKey;
	private String columnComment;
	
	public String getTableSchema() {
		return tableSchema;
	}
	public void setTableSchema(String tableSchema) {
		this.tableSchema = tableSchema;
	}
	public String getTableName() {
		return tableName;
	}
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	public String getColumnName() {
		return columnName;
	}
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}
	public Integer getOrdinalPosition() {
		return ordinalPosition;
	}
	public void setOrdinalPosition(Integer ordinalPosition) {
		this.ordinalPosition = ordinalPosition;
	}
	public String getColumnDefault() {
		return columnDefault;
	}
	public void setColumnDefault(String columnDefault) {
		this.columnDefault = columnDefault;
	}

	public String getIsNullable() {
		return isNullable;
	}
	public void setIsNullable(String isNullable) {
		this.isNullable = isNullable;
	}
	public String getDataType() {
		return dataType;
	}
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}
	
	public Integer getCharacterMaximumLength() {
		return characterMaximumLength;
	}
	public void setCharacterMaximumLength(Integer characterMaximumLength) {
		this.characterMaximumLength = characterMaximumLength;
	}
	public Integer getCharacterOctetLength() {
		return characterOctetLength;
	}
	public void setCharacterOctetLength(Integer characterOctetLength) {
		this.characterOctetLength = characterOctetLength;
	}
	
	public Integer getNumericPrecision() {
		return numericPrecision;
	}
	public void setNumericPrecision(Integer numericPrecision) {
		this.numericPrecision = numericPrecision;
	}
	public Integer getNumericScale() {
		return numericScale;
	}
	public void setNumericScale(Integer numericScale) {
		this.numericScale = numericScale;
	}
	public String getColumnType() {
		return columnType;
	}
	public void setColumnType(String columnType) {
		this.columnType = columnType;
	}
	public String getColumnKey() {
		return columnKey;
	}
	public void setColumnKey(String columnKey) {
		this.columnKey = columnKey;
	}
	public String getColumnComment() {
		return columnComment;
	}
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}
	@Override
	public String toString() {
		return "ColumnsTbl [tableSchema=" + tableSchema + ", tableName=" + tableName + ", columnName=" + columnName
				+ ", ordinalPosition=" + ordinalPosition + ", columnDefault=" + columnDefault + ", isNullable="
				+ isNullable + ", dataType=" + dataType + ", characterMaximumLength=" + characterMaximumLength
				+ ", characterOctetLength=" + characterOctetLength + ", numericPrecision=" + numericPrecision
				+ ", numericScale=" + numericScale + ", columnType=" + columnType + ", columnKey=" + columnKey
				+ ", columnComment=" + columnComment + "]";
	}
	

}
