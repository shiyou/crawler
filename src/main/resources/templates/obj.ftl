package ${rawObject.packageName};

import java.util.Date;
import java.io.Serializable;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
/**
<#if  rawObject.tablesTbl.tableComment??>
 * ${rawObject.tablesTbl.tableComment}
</#if>
 * @author hjd
 * @date ${rawObject.createTime?datetime?string('dd-MM-yyyy')}
 * @table( ${rawObject.tablesTbl.tableName})
 */
 @TableName("${rawObject.tablesTbl.tableName}")
public class ${rawObject.name} implements Serializable{

	private static final long serialVersionUID = 1L;
	
<#list rawFields as field>
	/**
	<#if  field.columnsTbl.columnComment??>
	*${field.columnsTbl.columnComment}
	</#if>
	*/
	<#if field.name == "id">
	@TableId("${field.columnsTbl.columnName}")
	<#else>
	@TableField("${field.columnsTbl.columnName}")
	</#if>
	private ${field.type} ${field.name};
	
</#list>

<#list rawFields as field>
	public ${field.type} get${field.name?cap_first }(){
		return ${field.name};
	}
	public void set${field.name?cap_first }(${field.type} ${field.name}){
		this.${field.name} = ${field.name};
	}
	
</#list>
	
	@Override
	public String toString() {
		return "${rawObject.name}[<#list rawFields as field>${field.name}="+${field.name}<#if field?counter%4==0> ${'\r'}${'\t'}${'\t'}${'\t'}${'\t'}</#if>+<#sep>",</#list>"]";
	}

}
