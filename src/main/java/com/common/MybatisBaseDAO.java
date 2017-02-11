package com.common;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

public class MybatisBaseDAO {
	
	// sqlmap.xml定义文件中对应的sqlid  
    public static final String SQLID_INSERT = "insert";  
    public static final String SQLID_INSERTLIST = "insertList";
    public static final String SQLID_UPDATE = "update";  
    public static final String SQLID_UPDATE_PARAM = "updateParam";  
    public static final String SQLID_DELETE = "delete";  
    public static final String SQLID_DELETE_PARAM = "deleteParam";  
    public static final String SQLID_TRUNCATE = "truncate";  
    public static final String SQLID_SELECT = "select";  
    public static final String SQLID_SELECTLIST ="selectList";
    public static final String SQLID_SELECT_PK = "selectPk";  
    public static final String SQLID_SELECT_PARAM = "selectParam";  
    public static final String SQLID_SELECT_FK = "selectFk";  
    public static final String SQLID_COUNT = "count";  
    public static final String SQLID_COUNT_PARAM = "countParam";  
    
    private String namespace = "";
    
	public String getNamespace() {
		return namespace;
	}

	public void setNamespace(String namespace) { 
		this.namespace = namespace;
	}

	@Autowired
	private SqlSession sqlSession;
	
/*	@Autowired
	private SqlSessionFactory sqlSessionFactory;

	public SqlSessionFactory getSqlSessionFactory() {
		return sqlSessionFactory;
	}

	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		this.sqlSessionFactory = sqlSessionFactory;
	}
	
	public SqlSession sqlSession{
		return sqlSessionFactory.openSession();
	}
	*/
	
	protected int _save(Object entity){
		return sqlSession.insert(namespace+"."+SQLID_INSERT, entity);
	}
	
	protected void _save(Object... entities){
		for(Object entity:entities){
			_save(entity);
		}
	}
	
	protected <T> int _save(Collection<T> list){
		return sqlSession.insert(namespace+"."+SQLID_INSERTLIST, list);
	}
	
	protected int _delete(Object entity){
		return sqlSession.delete(namespace+"."+SQLID_DELETE, entity);
	}
	
	protected int _deleteById(Serializable id){
		return sqlSession.delete(namespace+"."+SQLID_DELETE, id);
		
	}
	
	protected int _update(Object entity){
		return sqlSession.update(namespace+"."+SQLID_UPDATE, entity);
	}
	
	protected void _update(Object... entites){
		for(Object entity:entites){
			sqlSession.update(namespace+"."+SQLID_UPDATE, entity);
		}
	}
	
	protected <T> T _get(Object entity){
		return sqlSession.selectOne(namespace+"."+SQLID_SELECT, entity);
	}
	
	protected <T> T _get(Serializable id){
		return  sqlSession.selectOne(namespace+"."+SQLID_SELECT, id);
	}
	
	protected <T> T _get(Class<T> type,Serializable id ){
		type.getName(); //"select * from type.getname "
		return sqlSession.selectOne(namespace+"."+SQLID_SELECT, id);
	}
	
	protected  <E> List<E> _all(){
		return sqlSession.selectList(namespace+"."+SQLID_SELECTLIST);
	}
	
	
	protected int _count(){
		return sqlSession.selectOne(namespace+"."+SQLID_COUNT); 
	}
	
	
}
