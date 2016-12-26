<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.crawler.po.${rawObject.name}Po">
	<resultMap type="com.crawler.po.${rawObject.name}Po" id="${rawObject.name?uncap_first}Po">
		<id column="id_" property="id" />
		<#list rawFields as field>
			<result column="${field.columnsTbl.columnName}" property="${field.name}" />
		</#list>
	</resultMap>

	<select id="select" resultType="com.crawler.po.${rawObject.name}Po">
		SELECT 
		<#list rawFields as field>
			${field.columnsTbl.columnName} ${field.name}<#sep>,
		</#list>
		FROM 
			${rawObject.tablesTbl.tableName} 
		WHERE 
			id_ = ${r"#{"}id}
	</select>

	<insert id="insert">
		INSERT INTO ${rawObject.tablesTbl.tableName}(
		<#list rawFields as field>
			${field.columnsTbl.columnName}<#sep>,
		</#list>
		)
		${'\r'}${'\t'}${'\t'}VALUES
		(
		<#list rawFields as field>
			${r"#{"}${field.name}}<#sep>,
		</#list>
		)
	</insert>

	<insert id="insertList">
		INSERT INTO ${rawObject.tablesTbl.tableName} (
		<#list rawFields as field>
			${field.columnsTbl.columnName}<#sep>,
		</#list>
		) 
		VALUES
		<foreach item="item" collection="list" separator=",">
		(
		<#list rawFields as field>
			${r"#{"}item.${field.name}}<#sep>,
		</#list>
		)
		</foreach>
	</insert>

	<update id="update">
		UPDATE ${rawObject.tablesTbl.tableName} 
		SET 
		<#list rawFields as field>
			${field.columnsTbl.columnName} = ${r"#{"}${field.name}}<#sep>,
		</#list>
		 ${'\r'}${'\t'}${'\t'}WHERE 
		id_=${r"#{"}id}
	</update>

	<delete id="delete" parameterType="com.crawler.po.${rawObject.name}Po">
		DELETE FROM ${rawObject.tablesTbl.tableName} WHERE id_ = ${r"#{"}id}
	</delete>

	<select id="selectList" parameterType="String" resultMap="${rawObject.name}">
		SELECT
		<#list rawFields as field>
			${field.columnsTbl.columnName} ${field.name}<#sep>,
		</#list> 
		 ${'\r'}${'\t'}${'\t'}FROM 
		${rawObject.tablesTbl.tableName}
	</select>

	<select id="count" resultType="Integer">
		SELECT COUNT(*) FROM ${rawObject.tablesTbl.tableName}
	</select>
</mapper>