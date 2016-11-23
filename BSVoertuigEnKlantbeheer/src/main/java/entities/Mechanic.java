package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by Sander on 23-11-2016.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
public class Mechanic {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String Name;

    public Mechanic() {
    }
}
