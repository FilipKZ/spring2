package com.sda.catmvc.config;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;

public class HibernateUtil {

    private static final EntityManagerFactory emFactory;

    static {
        emFactory = Persistence.createEntityManagerFactory("com.sda.catmvc");
    }

    public static CriteriaBuilder getCriteriaBuilder() {
        return emFactory.getCriteriaBuilder();
    }

    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }
}