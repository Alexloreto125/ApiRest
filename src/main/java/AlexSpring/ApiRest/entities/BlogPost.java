package AlexSpring.ApiRest.entities;

import lombok.*;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BlogPost {
    private int id;


    private String categoria;
    private String titolo;
    private String cover;
    private String contenuto;
    private int tempoLettura;

}
