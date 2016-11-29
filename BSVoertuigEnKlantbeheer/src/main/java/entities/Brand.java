package entities;

import interceptors.LogInterceptorBinding;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

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
    @GeneratedValue(strategy= GenerationType.TABLE)
    private Long id;
    private String name;

    public Brand() {
    }
}
