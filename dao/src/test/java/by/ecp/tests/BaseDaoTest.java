package by.ecp.tests;

import by.ecp.TestConfig;
import by.ecp.common.BaseDao;
import by.ecp.entity.BaseEntity;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.transaction.Transactional;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by SystemUser on 15.06.2017.
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = TestConfig.class)
@Transactional
public abstract class BaseDaoTest<T extends BaseEntity> {

    protected abstract BaseDao<T> getDao();
    protected abstract T getModel();

    @Test
    public void testSave(){
        T model = getModel();
        getDao().save(model);
        T entity = getDao().findOne(1L);
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

    @Test
    public void testDelete(){
        T model = getModel();
        getDao().save(model);
        getDao().delete(model);
        T entity = getDao().findOne(1L);
        assertNull(entity);
    }
}
