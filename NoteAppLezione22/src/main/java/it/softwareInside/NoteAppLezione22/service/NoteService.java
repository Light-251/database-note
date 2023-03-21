package it.softwareInside.NoteAppLezione22.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.softwareInside.NoteAppLezione22.models.Nota;
import it.softwareInside.NoteAppLezione22.repository.NoteRepository;
import jakarta.validation.Valid;

@Service
public class NoteService {

	@Autowired
	NoteRepository noteRepository;

	/**
	 * Aggiunge una nota nel database se non è nulla o vuota
	 * 
	 * @param note
	 * @return
	 */
	public boolean addNote(@Valid Nota note) {
		try {
			noteRepository.save(note);
			return true;
		} catch (Exception e) {
			System.err.println("Aggiunta fallita: " + e);
			return false;
		}

	}

	/**
	 * Ritorna un Iterable con tutte le note nel database
	 * 
	 * @return
	 */
	public Iterable<Nota> getAllNotes() {
		return noteRepository.findAll();
	}

	public Nota getNoteById(@Valid Integer id) {
		try {
			return noteRepository.findById(id).get();
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Cancella una nota nel database specificando l'id
	 * 
	 * @param id
	 * @return
	 */
	public Nota deleteById(@Valid Integer id) {
		try {
			Nota noteRemoved = getNoteById(id);
			noteRepository.deleteById(id);
			return noteRemoved;

		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * Cancella tutte le note nel database
	 * 
	 * @return
	 */
	public boolean deleteAll() {
		try {
			noteRepository.deleteAll();
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	/**
	 * Aggiorna i campi di una nota specificando l'id
	 * @param note
	 * @return
	 */
	public boolean udpateNote(@Valid Nota note) {
		return addNote(note);
	}

}
