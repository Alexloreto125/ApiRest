package AlexSpring.ApiRest.entities;

import lombok.*;

import java.util.Date;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class AutoreBlog {

    private int id;


    private String name;
    private String surname;
    private String email;
    private Date date;
}
