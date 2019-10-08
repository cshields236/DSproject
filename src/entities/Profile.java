package entities;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;





@Entity
public class Profile {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String description;

    @OneToMany
    private List<Comments> commentsList=  new ArrayList<Comments>();
    public Profile(){

    }

    public Profile (String description)
    {
        this.description = description;

    }
    public Profile (String description, ArrayList <Comments> commentsList)
    {
        this.description = description;
        this.commentsList = commentsList;
    }

    public String getDescription() {
        return description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void addComment(Comments comments)
    {
        this.commentsList.add(comments);
    }


}



