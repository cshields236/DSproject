package dao;

import java.util.List;

import javax.persistence.*;


import entities.Subscriber;

public class SubscriberDAO {
	public SubscriberDAO() {
	}

	protected static EntityManagerFactory emf = Persistence.createEntityManagerFactory("conorspersistanceunit");

	public void persistSubsriber(Subscriber subscriber) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(subscriber);
		em.getTransaction().commit();
		em.close();
	}

	public void mergeSubscriber(Subscriber subscriber) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(subscriber);
		em.getTransaction().commit();
		em.close();

	}

	public void removeSubscriber(Subscriber subscriber) {
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(subscriber);
		em.getTransaction().commit();
		em.close();

	}
	public List<Subscriber>  getAllSubscribers(){
		EntityManager em = emf.createEntityManager();
		List<Subscriber> subscribers = (List<Subscriber>) em.createNamedQuery("Subscriber.findAll").getResultList();
		em.close();
		return subscribers;

	}
}



