package com.projeto.productms.resources;

import com.projeto.productms.dto.ProductDTO;
import com.projeto.productms.dto.ProductResponse;
import com.projeto.productms.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products/")
public class ProductResource {

    @Autowired
    private final ProductService service;

    public ProductResource(ProductService service) {
        this.service = service;
    }

    //GET 	/products/search 	Lista de produtos filtrados
    @GetMapping("/search")
    public List<ProductDTO> getProductByFiltro(
            @RequestParam String q,
            @RequestParam String min_price,
            @RequestParam String max_price){
        return service.findByFilter(q,Float.parseFloat(min_price),Float.parseFloat(max_price));
    }

    //POST 	/products 	Criação de um produto
    @PostMapping
    public ResponseEntity<ProductDTO> createProducts(
            @RequestBody ProductDTO product){
        try{
            return new ResponseEntity<>(service.save(product), HttpStatus.CREATED);
        }
        catch(Exception e){
            return new ResponseEntity("Invalid request", HttpStatus.BAD_REQUEST);
        }
    }

    //GET 	/products 	Lista de produtos
    @GetMapping
    public List<ProductDTO> getProducts(){
        return service.findAll();
    }

    //DELETE 	/products/ 	Deleção de um produto
    @DeleteMapping("/{id}")
    public ResponseEntity<? extends Object> deleteById(@PathVariable String id){
        try {
            service.deleteById(Long.parseLong(id));
            return new ResponseEntity<String>("Ok", HttpStatus.OK);
        }
        catch (Exception e) {
            return new ResponseEntity<String>("Not found", HttpStatus.NOT_FOUND);
        }
    }

    //GET 	/products/ 	Busca de um produto por ID
    @GetMapping("/{id}")
    public ResponseEntity<? extends Object> getProductById(@PathVariable String id){
        try{
            return new ResponseEntity(service.getByID(Long.parseLong(id)),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        }

    }

    //PUT 	/products/ 	Atualização de um produto
    @PutMapping("/{id}")
    public ResponseEntity<? extends Object> updateProducts(
            @PathVariable String id,
            @RequestBody ProductDTO product){
        try{
            return new ResponseEntity(service.update(Long.parseLong(id),product),HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity("Not Found", HttpStatus.NOT_FOUND);
        }
    }
}