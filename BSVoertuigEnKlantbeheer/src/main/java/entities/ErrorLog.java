package entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Gebruiker on 28-11-2016.
 */

@Entity(name = "log")
@Data
public class ErrorLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String Message;

    private LocalDateTime DateTime;

    public ErrorLog() {
    }
}
