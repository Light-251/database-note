package it.softwareInside.NoteAppLezione22.models;



import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Nota {
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Integer id;
	
	@NotBlank 
	@NotNull
	private String autore;
	
	@NotNull
	@NotBlank
	private String testo;
	
	public Nota(String autore, String testo) {
		setAutore(autore);
		setTesto(testo);
	}

}
