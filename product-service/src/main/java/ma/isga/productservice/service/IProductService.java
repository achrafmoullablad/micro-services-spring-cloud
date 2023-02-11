package ma.isga.productservice.service;

import java.util.List;
import ma.isga.productservice.entities.Product;

public interface IProductService {
	public Product addProduct(Product c, Long id);
	public Product updateProduct(Product c, Long id);
	public Product getProductById(Long id);
	public List<Product> getAllProducts(Long id);
	public void deleteProduct(Long id);
}
