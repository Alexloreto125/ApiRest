package AlexSpring.ApiRest.entities;

import jakarta.persistence.*;
import lombok.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Blog")
public class BlogPost {
    @Id
    @GeneratedValue
    private int id;

    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoLettura;

    @ManyToOne
    @JoinColumn(name = "autore_id")
    private AutoreBlog autore;

}
