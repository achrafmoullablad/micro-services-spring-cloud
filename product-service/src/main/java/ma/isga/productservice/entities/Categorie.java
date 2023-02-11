package ma.isga.productservice.entities;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data @NoArgsConstructor @AllArgsConstructor @ToString
public class Categorie implements Serializable{
	private static final long serialVersionUID = 1L;
	private Long id;
	private String name;
}
