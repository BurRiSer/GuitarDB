package com.burriser.dao;

import com.burriser.model.Guitar;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by BurRiSer on 17.05.2017.
 */

@Repository
public class GuitarDaoImpl implements GuitarDao {
    private static final Logger logger = LoggerFactory.getLogger(GuitarDaoImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addGuitar(Guitar guitar) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(guitar);
        logger.info("Guitar added. Details: " + guitar);
    }

    @Override
    public void updateGuitar(Guitar guitar) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(guitar);
        logger.info("Guitar updated. Details: " + guitar);
    }

    @Override
    public void removeGuitar(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Guitar guitar = (Guitar) session.load(Guitar.class, new Integer(id));

        if (guitar != null)
            session.delete(guitar);

        logger.info("Guitar deleted. Details: " + guitar);
    }

    @Override
    public Guitar getGuitarById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Guitar guitar = (Guitar) session.load(Guitar.class, new Integer(id));
        logger.info("Guitar loaded. Details: " + guitar);
        return guitar;
    }

    @Override
    @SuppressWarnings("unchecked")
    public List<Guitar> listGuitars() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Guitar> guitarList = session.createQuery("from Guitar").list();

        for (Guitar guitar : guitarList) {
            logger.info("Guitar list: " + guitar);
        }
        return guitarList;
    }
}
