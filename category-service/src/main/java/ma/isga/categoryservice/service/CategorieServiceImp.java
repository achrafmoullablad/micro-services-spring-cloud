package ma.isga.categoryservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.isga.categoryservice.entities.Categorie;
import ma.isga.categoryservice.repository.CategorieRepository;

@Service
public class CategorieServiceImp implements ICategorieService {
	@Autowired
	private CategorieRepository repository;
	
	@Override
	public Categorie addCategorie(Categorie c) {
		return repository.save(c);
	}

	@Override
	public Categorie updateCategorie(Categorie c, Long id) {
		Categorie categorie = repository.findById(id).get();
		if(categorie != null ) {
			categorie.setName(c.getName());
			repository.save(categorie);
		}
		return categorie;
	}

	@Override
	public Categorie getCategorieById(Long id) {
		Categorie categorie = repository.findById(id).get();
		return categorie;
	}

	@Override
	public List<Categorie> getAllCategories() {
		return repository.findAll();
	}

	@Override
	public void deleteCategorie(Long id) {
		repository.deleteById(id);
	}

}
