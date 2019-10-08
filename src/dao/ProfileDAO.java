package dao;

import entities.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class ProfileDAO {

    public ProfileDAO(){
    }



    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conorspersistanceunit");

    public void persist(Profile profile) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(profile);
        em.getTransaction().commit();
        em.close();
    }

    public void mergeSubscriber() {
    }

    public void removeSubscriber() {

    }


}


