package entities;

import interceptors.LogInterceptorBinding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Sander on 23-11-2016.
 */
@Entity(name = "brand")
@Builder
@Data
@AllArgsConstructor
@LogInterceptorBinding
public class Brand implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long id;
    private String name;

    public Brand() {
    }
}
