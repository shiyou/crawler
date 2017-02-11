package com.common;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * 
 * @time：2014-10-11 下午3:50:06   
 * @author hjd
 *
 * @param <T>
 * @param <PK>
 */
public class GenericDAOImpl<T,PK extends Serializable> extends MybatisBaseDAO implements GenericDAO<T, PK> {
	
	private Class<T> clazz;
	
	@SuppressWarnings( "unchecked" )
	public GenericDAOImpl() {
		Type type = getClass().getGenericSuperclass();
		ParameterizedType parameterizedType = (ParameterizedType) type;
		clazz =  (Class<T>) parameterizedType.getActualTypeArguments()[0];
		setNamespace(clazz.getName());		//这里设置命名空间，感觉不怎么好，
	}

	@Override
	public T find(PK id) {
		return _get(id);
	}

	@Override
	public <E> List<E> findAll() {
		return _all();
	}

	@Override
	public void save(T entity) {
		/*if(!this.clazz.isInstance(entity))
			throw new IllegalArgumentException("Object class does not match dao type");*/
		_save(entity);
	}

	@Override
	public void delete(T entity) {
		if(!this.clazz.isInstance(entity))
			throw new IllegalArgumentException("Object class does not match dao type");
		_delete(entity);
	}

	@Override
	public void deleteById(PK id) {
		_deleteById(id);
	}

	@Override
	public void update(T entity) {
		if(!this.clazz.isInstance(entity)){
			throw new IllegalArgumentException("Object class does not match dao type");
		}
		_update(new Object[] {entity});
	}

	@Override
	public void flush() {
//		_flush();
	}
	

}
