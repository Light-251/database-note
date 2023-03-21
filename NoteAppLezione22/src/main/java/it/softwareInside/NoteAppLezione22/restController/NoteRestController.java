package it.softwareInside.NoteAppLezione22.restController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import it.softwareInside.NoteAppLezione22.models.Nota;
import it.softwareInside.NoteAppLezione22.service.NoteService;
import it.softwareInside.NoteAppLezione22.service.PDFService;

@RestController
public class NoteRestController {

	@Autowired
	NoteService noteService;

	@Autowired
	PDFService pdfService;

	@PostMapping("/add-nota")
	public boolean addNote(@RequestBody Nota note) {
		return noteService.addNote(note);
	}

	@GetMapping("/get-notes")
	public Iterable<Nota> getNotes() {
		return noteService.getAllNotes();
	}

	@GetMapping("/get-id-note")
	@ResponseBody
	public Nota getNoteById(@RequestParam("id") int id) {
		return noteService.getNoteById(id);
	}

	@DeleteMapping("/delete-by-id")
	public Nota deleteById(@RequestParam("id") int id) {
		return noteService.deleteById(id);
	}

	@DeleteMapping("/delete-all")
	public boolean deleteAll() {
		return noteService.deleteAll();
	}

	@PostMapping("/update-note")
	public boolean deleteNote(@RequestBody Nota note) {
		return noteService.addNote(note);
	}

	@GetMapping("/save-pdf")
	public void savePdf(@RequestParam("id") int id) {
		Nota note = getNoteById(id);
		
		pdfService.salvaDocumento();
		pdfService.addPagina();
		pdfService.insertText("Autore: " + note.getAutore() + " Testo: " + note.getTesto());
		
		pdfService.salvaDocumento();
		//pdfService.chiudiDocumento();
		
	}
	
	

}
