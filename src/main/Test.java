package main;

import java.util.*;


import dao.CommentsDAO;
import dao.ProfileDAO;
import dao.SubscriberDAO;
import entities.Comments;
import entities.Profile;
import entities.Subscriber;

public class Test {

	public Test() {

		Comments c = new Comments("Hello");
		Comments c1 = new Comments("Hi");
		Comments c2 = new Comments("Hey");
		CommentsDAO commentsdao = new CommentsDAO();

		commentsdao.persist(c);
		commentsdao.persist(c1);
		commentsdao.persist(c2);

		Profile profile = new Profile("DEsccc");
		profile.addComment(c);
		profile.addComment(c1);
		profile.addComment(c2);

		ProfileDAO profiledao = new ProfileDAO();

		profiledao.persist(profile);

		SubscriberDAO subscriberdao = new SubscriberDAO();
		Subscriber subscriber = new Subscriber("tommy260", "ireland2019", profile);

		subscriberdao.persistSubsriber(subscriber);

		List<Subscriber> subscribers = subscriberdao.getAllSubscribers();

		for (Subscriber s: subscribers){
			System.out.println(s.getUsername() );
		}

		//subscriberdao.mergeSubscriber(subscriber);
		List <Subscriber> subscribers1 = subscriberdao.findSubByUsername("tommy260");

		for (Subscriber s1: subscribers1){
			System.out.println(s1.getUsername() +" "+ s1.getPassword());
		}


			Subscriber sub1 = subscribers.get(1);
			subscriberdao.removeSubscriber(sub1);

	}

	public static void main(String[] args) {
		new Test();

	}

}



