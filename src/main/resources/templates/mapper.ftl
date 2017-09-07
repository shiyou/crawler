<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="gov.center.mapper.manager.${rawObject.name}Mapper">
	<resultMap type="gov.center.entity.manager.${rawObject.name}" id="${rawObject.name?uncap_first}">
		<#list rawFields as field>
			<#if field.name == 'id'>
			<id column="${field.columnsTbl.columnName}" property="${field.name}" />
			<#else>
			<result column="${field.columnsTbl.columnName}" property="${field.name}" />
			</#if>
		</#list>
	</resultMap>

   <sql id="cols">
<#list rawFields as field>
	${field.columnsTbl.columnName} ${field.name}<#sep>,
</#list>${'\r'}
   </sql>
	
   <update id="update">
		UPDATE ${rawObject.tablesTbl.tableName} 
		<trim prefix="set" suffixOverrides=",">
		<#list rawFields as field>
			<if test="${field.name} != null">${field.columnsTbl.columnName} = ${r"#{"}${field.name}}<#sep>,</if>
		</#list></if>
		</trim>
		 ${'\r'}${'\t'}${'\t'}WHERE 
		id_=${r"#{"}id}
	</update>
</mapper>