package ma.isga.productservice.controller;

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
import ma.isga.productservice.entities.Product;
import ma.isga.productservice.service.ProductServiceImp;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api")
public class ProductController {
	@Autowired
	private ProductServiceImp service;
	
	@PostMapping("/products/{idcategorie}")
	public ResponseEntity<Product> createProduct(@RequestBody Product Product,@PathVariable(name = "idcategorie") Long idcategorie){
		try {
			Product c = service.addProduct(Product,idcategorie);
			return new ResponseEntity<Product>(c,HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/products/{id}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product Product,@PathVariable(name = "id") Long id){
		try {
			Product c = service.updateProduct(Product, id);
			if(c !=null) {
				return new ResponseEntity<Product>(c,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/products/{id}")
	public ResponseEntity<List<Product>> getAllProduct(@PathVariable(name = "id") Long id){
		try {
			List<Product> Products = service.getAllProducts(id);
			if(!Products.isEmpty()) {
				return new ResponseEntity<List<Product>>(Products,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping("/products/idcategorie={id}")
	public ResponseEntity<Product> getProduct(@PathVariable(name = "id") Long id){
		try {
			Product c = service.getProductById(id);
			if(c !=null) {
				return new ResponseEntity<Product>(c,HttpStatus.OK);
			}else {
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/products/{id}")
	public ResponseEntity<Product> deleteProduct(@PathVariable(name = "id") Long id){
		try {
			service.deleteProduct(id);
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
}
