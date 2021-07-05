
package cl.gonzalo.agenda.repository;

import cl.gonzalo.agenda.model.Agenda;
import java.util.Optional;
import org.springframework.data.repository.CrudRepository;


public interface IAgenda extends CrudRepository<Agenda,Long> {

    public Object findByNombre(String nombre);

   Agenda deleteById(long id);

    
    
}
