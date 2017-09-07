package until.generator;

import java.util.Date;

/**
 * 表对象：转载表和对象相关信息
 * @author hjd
 * @date 2016年9月22日
 */
public class RawObject {

	private String name;
	private TablesTbl tablesTbl;
	private String packageName;
	
	/**
	 * 建表时间
	 */
	private Date createTime; 
	
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
	public String getPackageName() {
		return packageName;
	}
	public void setPackageName(String packageName) {
		this.packageName = packageName;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	
	
	
}
