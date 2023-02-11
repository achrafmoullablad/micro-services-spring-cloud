package ma.isga.productservice.remote;

import java.util.List;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import ma.isga.productservice.entities.Categorie;


@FeignClient(name = "CATEGORY-SERVICE", url = "http://localhost:8120")
public interface CategoryRemote {
	
	@GetMapping("/api/categories")
	public List<Categorie> getAllCategorie();
	
	@GetMapping("/api/categories/{id}")
	public Categorie getCategorie(@PathVariable(name = "id") Long id);
	
}
