package ma.isga.productservice.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ma.isga.productservice.entities.Categorie;
import ma.isga.productservice.entities.Product;
import ma.isga.productservice.remote.CategoryRemote;
import ma.isga.productservice.repository.ProductRepository;

@Service
public class ProductServiceImp implements IProductService {
	@Autowired
	private ProductRepository repository;
	@Autowired
	private CategoryRemote remote;
	
	@Override
	public Product addProduct(Product p,Long id) {
		Categorie categorie = remote.getCategorie(id);
		p.setIdcategorie(id);
		p.setCategorie(categorie);
		return repository.save(p);
	}

	@Override
	public Product updateProduct(Product p, Long id) {
		Product product = repository.findById(id).get();
		if( product != null) {
			product.setTitle(p.getTitle());
			product.setPrice(p.getPrice());
			product.setQuantity(p.getQuantity());
			product.setDescription(p.getDescription());
			product.setIdcategorie(p.getIdcategorie());
			repository.save(product);
			return product;
		}else return null;
	}

	@Override
	public Product getProductById(Long id) {
		return repository.findById(id).get();
	}

	@Override
	public List<Product> getAllProducts(Long id) {
		return repository.findProductByIdcategorie(id);
	}

	@Override
	public void deleteProduct(Long id) {
		repository.deleteById(id);
	}

}
