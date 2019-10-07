package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import entities.Subscriber;

public class SubscriberDAO{
	
	//Create get all subs method
	
	public SubscriberDAO() {
	
	}
		
	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("seanspersistenceunit");
	
	
	public void persistSubscriber(Subscriber subscriber) {
		//use factory to make local entity manager
		EntityManager em = emf.createEntityManager();
		
		//use this entity manager
							//Start the transaction
		em.getTransaction().begin();
		
		//update entities
		em.persist(subscriber);
							//commit transaction. write changes to database.
		em.getTransaction().commit();
		em.close();
	}
	
	public void removeSubscriber(Subscriber subscriber) {
		EntityManager em2 = emf.createEntityManager();
		em2.getTransaction().begin();
		//if subscriber is managed then remove if not merge so can be removed
		em2.remove(em2.contains(subscriber)? subscriber: em2.merge(subscriber));
		em2.getTransaction().commit();
		em2.close();
	}
	
	public List<Subscriber> getAllSubscribers(){
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		
		List<Subscriber> subscribers = (List<Subscriber>) em.createNamedQuery("Subscriber.findAll").getResultList();
		em.getTransaction().commit();
		em.close();
		
		for (Subscriber s: subscribers) {
			System.out.println(s.getUsername());
		}
		return subscribers;
		
	}
	
	public void mergeSubscribers(Subscriber sub) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(sub);
		em.getTransaction().commit();
		em.close();
	}
	
	public void RemoveSubscribers(Subscriber sub) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(sub);
		em.getTransaction().commit();
		em.close();
		
	}
	
	public Subscriber getSubscriber(String nameOfSub) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		Subscriber aSub = (Subscriber) em.createNamedQuery("Subscriber.findByUsername").setParameter("username", nameOfSub).getSingleResult();
		em.getTransaction().commit();
		em.close();
		
		return aSub;
		
	}
}
	


