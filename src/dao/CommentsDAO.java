package dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Comments;


public class CommentsDAO {

    public CommentsDAO(){
    }



    protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conorspersistanceunit");

    public void persist(Comments comments) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(comments);
        em.getTransaction().commit();
        em.close();
    }

    public void mergeSubscriber() {
    }

    public void removeSubscriber() {

    }


}


