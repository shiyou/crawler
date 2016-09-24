package until.codeGenerator;

import java.util.List;

/**
 * 表对象：转载表和对象相关信息
 * @author hjd
 * @date 2016年9月22日
 */
public class RawObject {

	private String name;
	private TablesTbl tablesTbl;
	private List<RawField> rawFields;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public TablesTbl getTablesTbl() {
		return tablesTbl;
	}
	public void setTablesTbl(TablesTbl tablesTbl) {
		this.tablesTbl = tablesTbl;
	}
	public List<RawField> getRawFields() {
		return rawFields;
	}
	public void setRawFields(List<RawField> rawFields) {
		this.rawFields = rawFields;
	}
	
	
}
