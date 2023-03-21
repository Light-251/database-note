package it.softwareInside.NoteAppLezione22.repository;

import org.springframework.data.repository.CrudRepository;

import it.softwareInside.NoteAppLezione22.models.Nota;

public interface NoteRepository extends CrudRepository<Nota, Integer>{

}
