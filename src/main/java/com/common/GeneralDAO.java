package com.common;

import java.io.Serializable;
import java.util.List;
/**
 * 
 * @time：2014-10-11 下午3:50:23   
 * @author hjd
 *
 */
public interface GeneralDAO {
	
	  public abstract <T> T find(Class<T> paramClass, Serializable paramSerializable);
	  
	  public abstract <T> T[] find(Class<T> paramClass, Serializable... paramVarArgs);
	  
	  public abstract <T> T getReference(Class<T> paramClass, Serializable paramSerializable);
	  
	  public abstract <T> T[] getReferences(Class<T> paramClass, Serializable... paramVarArgs);
	  
	  public abstract boolean save(Object paramObject);
	  
	  public abstract boolean[] save(Object... paramVarArgs);
	  
	  public abstract boolean remove(Object paramObject);
	  
	  public abstract void remove(Object... paramVarArgs);
	  
	  public abstract boolean removeById(Class<?> paramClass, Serializable paramSerializable);
	  
	  public abstract void removeByIds(Class<?> paramClass, Serializable... paramVarArgs);
	  
	  public abstract <T> List<T> findAll(Class<T> paramClass);
	  
	  public abstract boolean isAttached(Object paramObject);
	  
	  public abstract void refresh(Object... paramVarArgs);
	  
	  public abstract void flush();
	  

}
