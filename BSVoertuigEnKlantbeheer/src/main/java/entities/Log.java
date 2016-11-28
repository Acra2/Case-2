package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Gebruiker on 28-11-2016.
 */

@Entity(name = "log")
@Data
public class Log implements Serializable{
    @Id
    private String id;

    public Log(){}

    private String Message;
    private LocalDateTime DateTime;
}
