package by.ecp.db;

import by.ecp.common.BaseDao;
import by.ecp.entity.*;
import com.querydsl.jpa.impl.JPAQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

/**
 * Created by User on 09.06.2017.
 */
public class PublicationDao extends BaseDao<Publication>{
    public PublicationDao() {
        super(Publication.class);
    }
}
