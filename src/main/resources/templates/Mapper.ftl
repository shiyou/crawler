<!DOCTYPE mapper
    PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
    "http://mybatis.org/dtd/mybatis-3-mapper.dtd">
<mapper namespace="com.crawler.po.UserPo">
	<resultMap type="com.crawler.po.${className}" id="${className}">
		<id column="id_" property="id" />
		<#list fields as field>
			<result column="${file.columnName}" property="${file.name}" />
		</#list>
	</resultMap>

	<select id="select" resultType="com.crawler.po.UserPo">
		select 
		<#list fields as field>
			${field.columnName} ${file.name} <#sep>,
		</#list>
		 from ${tableName}
		where id_= \#{id}
	</select>

	<insert id="insert">
		insert into ${tableName}(
		<#list fields as field>
			${field.columnName} <#sep>,
		</#list> values(
		<#list fields as field>
			\#\{ ${field.name}  }<#sep>,
		</#list>
		)
	</insert>

	<insert id="insertList">
		insert into ${tableName} (
		<#list fields as field>
			${field.columnName} <#sep>,
		</#list>
			) values
		<foreach item="item" collection="list" separator=",">
			(
				<#list fields as field>
					/#/{item.${field.name} }<#sep>,
				</#list>
			)
		</foreach>
	</insert>

	<update id="update">
		update ${tableName} set 
		<#list fields as field>
			${field.columnName} = /#/{ ${field.name} <#sep>,
		</#list>
		where id_=#{id}
	</update>

	<delete id="delete" parameterType="com.crawler.po.UserPo">
		delete from ${tableName} where id_ = #{id}
	</delete>

	<select id="selectList" parameterType="String" resultMap="userPo">
		select
		<#list fields as field>
			${field.columnName} ${field.name} <#sep>,
		</#list> from ${tableName}
	</select>

	<select id="count" resultType="Integer">
		select count(*) from ${tableName}
	</select>
</mapper>