package ma.isga.categoryservice.service;

import java.util.List;
import ma.isga.categoryservice.entities.Categorie;

public interface ICategorieService {
	public Categorie addCategorie(Categorie c);
	public Categorie updateCategorie(Categorie c, Long id);
	public Categorie getCategorieById(Long id);
	public List<Categorie> getAllCategories();
	public void deleteCategorie(Long id);
}
