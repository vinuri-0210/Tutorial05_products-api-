package uk.ac.westminster.products_api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {


    @Autowired
    private ProductService productService;

    /*@GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }*/

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id).orElse(null);
    }

    @PostMapping("/products")
    public Product createProduct(@RequestBody DigitalProduct product) {
        return productService.addProduct(product);
    }
                                                 // Temporary: Product is abstract, so Jackson needs a concrete type.


    @GetMapping("/products/summaries")
    public List<String> getSummaries() { return productService.getAllSummaries(); }


    @DeleteMapping("/products/{id}")
    public void deleteProduct (@PathVariable Long id) {
        productService.deleteProduct(id);
    }










  /*  @GetMapping("/products/{id}")
    public Product getById(@PathVariable Long id) {
        return new Product(id, "Laptop", 999.99);
    }*/

}





