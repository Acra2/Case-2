package entities;

import lombok.*;

import javax.persistence.*;
import java.util.Calendar;

/**
 * Created by Sander on 22-11-2016.
 */
@Data
@NoArgsConstructor
@Entity
public class Maintenance {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long id;

    @ManyToOne
    private Car car;

    private Calendar startDateTime;

    @Enumerated(EnumType.STRING)
    private MaintenanceState state;

    private String description;
}
