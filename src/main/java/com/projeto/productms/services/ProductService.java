package com.projeto.productms.services;

import com.projeto.productms.dto.ProductDTO;
import com.projeto.productms.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Optional<ProductDTO> getByID(Long id){
        return repository.findById(id);
    }

    public List<ProductDTO> findAll() {

        var lista = repository.findAll();

        var products = new ArrayList<ProductDTO>();
        lista.forEach(e -> products.add(e));

        return products;
    }

    public Long count() {
        return repository.count();
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<ProductDTO> findByFilter(String q, float min_price, float max_price){
        return repository.findByFilter(q,min_price,max_price);
    }

    public ProductDTO save(ProductDTO product){
        return repository.save(product);
    }

    @Transactional
    public ProductDTO update(Long id,ProductDTO product) {
        Optional<ProductDTO> p = getByID(id);
        if(!p.isEmpty()) {
            repository.update(id, product.getName(), product.getDescription(), product.getPrice());
            return p.get();
        }
        return null;
    }

}
