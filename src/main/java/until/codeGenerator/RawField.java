package until.codeGenerator;

/**
 * 字段:
 * @author hjd
 * @date 2016年9月20日
 */
public class RawField {
	
	private String type;
	private String name;
	private ColumnsTbl columnsTbl;
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public ColumnsTbl getColumnsTbl() {
		return columnsTbl;
	}
	public void setColumnsTbl(ColumnsTbl columnsTbl) {
		this.columnsTbl = columnsTbl;
	}

}
