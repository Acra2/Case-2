package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Sander on 23-11-2016.
 */
@Entity(name="model")
@Builder
@Data
@AllArgsConstructor
public class Model {

    @Id
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id;
    private String name;

    @ManyToOne(cascade = CascadeType.PERSIST)
    private Brand brand;

    public Model() {
    }
}
