package it.softwareInside.NoteAppLezione22.service;

import java.io.IOException;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.springframework.stereotype.Service;

@Service
public class PDFService {
	PDDocument document = new PDDocument();
	PDPage page = new PDPage();
	
	public PDDocument getDocument() {
		return this.document;
	}
	
	/**
	 * Salva il PDF nel percorso del progetto con il nome provaDPF.pdf
	 * 
	 */
	public void salvaDocumento() {
		try {
			document.save("./provaPDF.pdf"); // ./ indica il percorso del progetto

		} catch (IOException e) {
			System.err.println("Errore nel salvataggio del documento " + e);

		}
	}

	/**
	 * Aggiunge una pagina vuota al documento
	 * 
	 */
	public void addPagina() {
		document.addPage(page);
	}

	public void insertText(String text) {
		try {
			PDPageContentStream contentStream = new PDPageContentStream(document, page);
			contentStream.beginText();

			contentStream.setFont(PDType1Font.TIMES_ROMAN, 12);
			contentStream.newLineAtOffset(25, 500);

			contentStream.showText(text);

			contentStream.endText();
			contentStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Chiude il documento PDF
	 * 
	 */
	public void chiudiDocumento() {
		try {
			document.close();
		} catch (IOException e) {
			System.err.println("Errore nella chiusura del documento " + e);
		}
	}

}
