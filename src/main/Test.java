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

		List<Subscriber>subscribers =  new ArrayList<Subscriber>();
		subscribers =  subscriberdao.getAllSubscribers();

		for (Subscriber s: subscribers){
			System.out.println(s);
		}

	}

	public static void main(String[] args) {
		new Test();

	}

}



