package by.dao;

import by.ecp.common.BaseDao;
import by.ecp.entity.IdMotherClass;
import org.junit.Test;

import java.util.List;

import static junit.framework.Assert.assertNotSame;
import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created by User on 15.06.2017.
 */
public abstract class BaseDaoTest<T extends IdMotherClass> {

    protected abstract BaseDao<T> getDao();
    protected abstract T getModel();

    @Test
    public  void testFindById(){
        T model = getModel();
        getDao().save(model);

        T entity = getDao().findOne(1L);
        assertNotNull(entity);
    }

    @Test
    public void testDelete(){
        T model = getModel();
        getDao().save(model);

        getDao().delete(model);

        T entity = getDao().findOne(1L);
        assertNotNull(entity);
    }

    @Test
    public void testSave(){
        T model = getModel();
        getDao().save(model);

        List<T> entity = getDao().findAll();
        assertNotNull(entity);
    }

    @Test
    public void testUpdate(){
        T model = getModel();
        getDao().save(model);

        T model2 = getModel();
        getDao().update(model);

        List<T> entity = getDao().findAll();
        assertNotNull(entity);
        assertNotSame(model, model2);
    }
}
