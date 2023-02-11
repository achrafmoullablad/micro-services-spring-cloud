package ma.isga.productservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ma.isga.productservice.entities.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long>{
	public List<Product> findProductByIdcategorie(Long id);
}
