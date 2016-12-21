package com.crawler.tbl;

import java.util.Date;

/**
 * ${rawObject.tablesTbl.tableComment}
 * @author hjd
 * @date 2016年9月22日
 * @table(COLUMNS)
 */
public class ${rawObject.name}Po {
	<#list rawFields as field>
		/**
		 * ${field.columnsTbl.columnComment}
		 * @column(${field.columnsTbl.columnName})
		*/
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
		return "${rawObject.name}Tbl[<#list rawFields as field>${field.name}="+${field.name}+<#sep>",</#list>"]";
	}

}
