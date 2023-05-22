package org.example.dao;

import org.example.entity.Personnel;
import org.h2.util.json.JsonConstructorUtils;


import javax.persistence.*;
import java.util.List;

public class PersonnelDao {

    //todo: mistake3
    static EntityManager entityManager;

    //@PersistenceContext(name = "EntityPersonal")

    //todo: tip1
    public static void getEntityManager(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        entityManager = emf.createEntityManager();
    }

    public static Personnel creatQuery(Personnel personnel){
        try {
            getEntityManager();
            EntityTransaction tx= entityManager.getTransaction();
                tx.begin();
                entityManager.persist(personnel);
                tx.commit();
            System.out.println("insert the table");
            return personnel;
        }catch (Exception e) {
            return null;

        }
    }
    public  static List<Personnel> findAll(){
        try {
            getEntityManager();
            Query query = entityManager.createNamedQuery("findAllPersonnel");
            return query.getResultList();
        }catch (Exception e) {
            return null;
        }
    }
    public static Personnel findById(int id ){
        try {
            getEntityManager();
            Query query= entityManager.createNamedQuery("findPersonnelByID");
            query.setParameter("personalID",id);
            return (Personnel) query.getSingleResult();
        }catch (Exception e) {
            return null;
        }
    }
    public static void updateQuery(Personnel personnel){
        try {
            getEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(personnel);
            entityManager.getTransaction().commit();
        }catch (Exception e) {
            System.out.println("don't find user");
        }

    }
    public static void deleteByID(int id ) {
        try {
            getEntityManager();
            Personnel personnel= entityManager.find(Personnel.class,id);
            entityManager.getTransaction().begin();
            entityManager.remove(personnel);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println("don't find user");
        }


    }
}

