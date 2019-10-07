package main;

import dao.SubscriberDAO;
import entities.Subscriber;

public class Test {


	public Test() {
		SubscriberDAO subscriberdao = new SubscriberDAO();
		Subscriber subscriber = new Subscriber("tommy260", "ireland2019");

		subscriberdao.persistSubscriber(subscriber);
	}

	public static void main(String[] args) {
		new Test();
	}

}
