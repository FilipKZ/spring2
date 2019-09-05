package com.sda.catmvc.service;

import com.sda.catmvc.config.HibernateUtil;
import com.sda.catmvc.model.Cat;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

@Service
public class CatManager implements InitializingBean {

    public List<Cat> getCats(){
        EntityManager em = HibernateUtil.getEntityManager();
        CriteriaBuilder builder = HibernateUtil.getCriteriaBuilder();
        CriteriaQuery<Cat> criteria = builder.createQuery(Cat.class);
        criteria.from(Cat.class);
        return em.createQuery(criteria).getResultList();
    }

    public void saveCat(Cat cat) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        em.persist(cat);
        em.getTransaction().commit();
    }

    public void deleteCat(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Cat existingCat = em.find(Cat.class, id);
        if (existingCat != null) {
            em.remove(em.contains(existingCat) ? existingCat : em.merge(existingCat));
        }
        em.getTransaction().commit();
    }

    public Cat getCat(Long id) {
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        Cat existingCat = em.find(Cat.class, id);
        em.getTransaction().commit();
        return existingCat;
    }

    @Override
    public void afterPropertiesSet(){
        Cat cat = new Cat("Rys", "m", 11);
        saveCat(cat);
    }


    public void editCat(Long id, Cat cat) {
        cat.setId(id);
        EntityManager em = HibernateUtil.getEntityManager();
        em.getTransaction().begin();
        System.out.println("ID " + cat.getId());
        em.merge(cat);
        em.getTransaction().commit();
    }
}
