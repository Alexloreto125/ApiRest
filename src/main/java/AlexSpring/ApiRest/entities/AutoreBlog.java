package AlexSpring.ApiRest.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.List;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Autore")
public class AutoreBlog {
    @Id
    @GeneratedValue
    private int id;

    private String name;
    private String surname;
    private String email;
    private Date date;
    @OneToMany(mappedBy = "autore", cascade = CascadeType.ALL)
    private List<BlogPost> blogList;

    public List<BlogPost> getBlogList(){
        return blogList;
    }

    public void setBlogList(List<BlogPost> blogList) {
        this.blogList = blogList;
    }
}
