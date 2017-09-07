package com.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * @author hjd
 * @time：2014-10-11 下午3:50:18
 */
@Repository
public class GeneralDAOImpl extends MybatisBaseDAO implements GeneralDAO {

    @Override
    public <T> T find(Class<T> paramClass, Serializable paramSerializable) {
//		TODO
        return null;
    }

    @Override
    public <T> T[] find(Class<T> paramClass, Serializable... paramVarArgs) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T getReference(Class<T> paramClass,
                              Serializable paramSerializable) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public <T> T[] getReferences(Class<T> paramClass,
                                 Serializable... paramVarArgs) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean save(Object paramObject) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean[] save(Object... paramVarArgs) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean remove(Object paramObject) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void remove(Object... paramVarArgs) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean removeById(Class<?> paramClass,
                              Serializable paramSerializable) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void removeByIds(Class<?> paramClass, Serializable... paramVarArgs) {
        // TODO Auto-generated method stub

    }

    @Override
    public <T> List<T> findAll(Class<T> paramClass) {
//		return _all(paramClass);
//		TODO
        return null;
    }

    @Override
    public boolean isAttached(Object paramObject) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public void refresh(Object... paramVarArgs) {
        // TODO Auto-generated method stub

    }

    @Override
    public void flush() {
        // TODO Auto-generated method stub

    }

}
