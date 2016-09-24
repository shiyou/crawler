package com.crawler.tbl;

import java.util.Date;

/**
 * ${table.comment}
 * @author hjd
 * @date 2016年9月22日
 * @table(COLUMNS)
 */
public class ${className}TBL {
	<#list fields as field>
		/**
		 * ${field.comment}
		 * @column(${field.column})
		*/
		private ${field.type} ${field.name};
	</#list>
	
	<#list fields as field>
		public ${field.type} get${field.name?cap_first }(){
			return ${field.name};
		}
		public void set${field.name?cap_first }(${field.type} ${field.name}){
			this.${field.name} = ${field.name};
		}
	</#list>
	
	@Override
	public String toString() {
		return "${className}Tbl [
			<#list fields as field>
				${field.name}=" + ${field.name} + <#sep>",
			</#list> "]";
	}
	
	

}
