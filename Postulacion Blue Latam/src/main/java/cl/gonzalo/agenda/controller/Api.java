package cl.gonzalo.agenda.controller;

import cl.gonzalo.agenda.model.Agenda;
import cl.gonzalo.agenda.repository.IAgenda;


import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000")
public class Api {

    @Autowired
    private IAgenda as;

    @GetMapping("/contactos")
    public Iterable<Agenda> index() {
        return as.findAll();
    }

    @GetMapping("/contactos/{nombre}")
    public Agenda show(@PathVariable String nombre) {
        return (Agenda) as.findByNombre(nombre);
    }

    @PostMapping("/contactos")
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda create(@RequestBody Agenda agenda) {
        this.as.save(agenda);
        return agenda;
    }

    @PutMapping("/contactos/{nombre}")
    @ResponseStatus(HttpStatus.CREATED)
    public Agenda update(@RequestBody Agenda agenda, @PathVariable String nombre) {
        
        Agenda currentAgenda = (Agenda) as.findByNombre(nombre);
        
        currentAgenda.setNombre(agenda.getNombre());
        currentAgenda.setNumero(agenda.getNumero());
        this.as.save(currentAgenda);
        return currentAgenda;
    }

    @DeleteMapping("/contactos/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
     public void delete(@PathVariable Long id) {
        as.deleteById(id);
       
    }

}
