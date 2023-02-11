package ma.isga.categoryservice.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ma.isga.categoryservice.entities.Categorie;
import ma.isga.categoryservice.service.CategorieServiceImp;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class CategorieController {
	@Autowired
	private CategorieServiceImp service;
	
	@PostMapping("/categories")
	public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie){
		try {
			Categorie c = service.addCategorie(categorie);
			return new ResponseEntity<Categorie>(c,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/categories/{id}")
	public ResponseEntity<Categorie> updateCategorie(@RequestBody Categorie categorie,@PathVariable(name = "id") Long id){
		try {
			Categorie c = service.updateCategorie(categorie, id);
			if(c !=null) {
				return new ResponseEntity<Categorie>(c,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/categories")
	public ResponseEntity<List<Categorie>> getAllCategorie(){
		try {
			List<Categorie> categories = service.getAllCategories();
			if(!categories.isEmpty()) {
				return new ResponseEntity<List<Categorie>>(categories,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/categories/{id}")
	public ResponseEntity<Categorie> getCategorie(@PathVariable(name = "id") Long id){
		try {
			Categorie c = service.getCategorieById(id);
			if(c !=null) {
				return new ResponseEntity<Categorie>(c,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/categories/{id}")
	public ResponseEntity<Categorie> deleteCategorie(@PathVariable(name = "id") Long id){
		try {
			service.deleteCategorie(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
