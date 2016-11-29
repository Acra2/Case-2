package entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Created by Gebruiker on 28-11-2016.
 */

@Entity(name = "log")
@Data
public class ErrorLog implements Serializable{
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private long id;

    private String Message;

    private LocalDateTime DateTime;

    public ErrorLog(){}
}
