package beans;

import com.bibliotecajsf.bibliotecajsf.service.IDAO;
import com.bibliotecajsf.bibliotecajsf.service.ImplDAO;
import jakarta.annotation.PostConstruct;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Named;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Named("beanAutor")
@ViewScoped
@Getter
@Setter
public class BeanAutor implements Serializable {

    private IDAO dao = new ImplDAO();

    private List<Autor> lista;

    private Autor autor;

    private Autor selectAutor;

    @PostConstruct
    public void init(){
        lista = dao.getAll("Autor.all", Autor.class);
    }

    public void crearAutor() {
    }
}