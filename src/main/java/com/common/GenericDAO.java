package com.common;

import java.io.Serializable;
import java.util.List;

/**
 * @param <T>
 * @param <PK>
 * @author hjd
 * @time：2014-10-11 下午3:50:13
 */
public interface GenericDAO<T, PK extends Serializable> {

    public T find(PK id);

    public <E> List<E> findAll();

    public void save(T entity);

    public void delete(T entity);

    public void deleteById(PK id);

    public void update(T entity);

    public void flush();

}
