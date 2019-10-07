package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

//Create the Querys
@NamedQueries({@NamedQuery(name = "Subscriber.findAll", query = "select o from Subscriber o"),
		@NamedQuery(name = "Subscriber.findByUsername", query = "select o from Subscriber o where o.username=:username")
})

@Entity
public class Subscriber {



	//Subscriber has one profile (Has a string descrription)

	@Id @GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String username;
	private String password;

	@OneToOne
	private Profile subscriberProfile;


	public Subscriber() {

	}

	public Subscriber(String username, String password, Profile subprof) {
		this.username=username;
		this.password=password;
		this.subscriberProfile=subprof;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


}
