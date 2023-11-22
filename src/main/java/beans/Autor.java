package beans;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import lombok.Data;

@Entity
@Data // getter y setter
@NamedQueries(
        {
                @NamedQuery(name="Autor.all",
                            query="select e from Autor e")
        }
)
public class Autor {
    @Id
    private String id;

    private String primerNombre;

    private String segundoNombre;

    private String primerApellido;

    private String segundoApellido;
}