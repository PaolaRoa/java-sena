package com.sena.inventory.product;

import org.hibernate.procedure.ProcedureOutputs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "api/products")
public class ProductController {
    private final ProductService productService;
    @Autowired
    public ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping
    public List<Product> getProducts(){
        return productService.getProducts();
    }

    @PostMapping
    public Product saveProduct(@RequestBody Product product){
        return productService.saveProduct(product);
    }

    @DeleteMapping("/{id}")
    public Product deleteProduct(@PathVariable int id){
        Product product = productService.getProduct(id);
        productService.deleteProduct(id);
        return product;
    }
    @PutMapping()
    public Product editProduct(@RequestBody Product product){
        return productService.editProduct(product);
    }
    /*public Map<String,String>
    ManejoExcepcionValidacion(MethodArgumentNotValidException exception){
        Map<String, String> errores = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error)->{

        });

    }*/
    @PutMapping("/{id}")
    public Boolean logicDelete(@PathVariable int id){
        return productService.logicDelete(id);
    }
    @GetMapping("/{price}")
    public List<Product> getGreaterThan(@PathVariable Double price){
        return productService.findGreaterThan(price);
    }
}
