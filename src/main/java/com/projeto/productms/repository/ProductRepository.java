package com.projeto.productms.repository;

import com.projeto.productms.dto.ProductDTO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

//import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface ProductRepository extends CrudRepository<ProductDTO, Long> {

    public Optional<ProductDTO> findById(long id);

    public ProductDTO save(ProductDTO product);

    @Modifying
    @Query("update ProductDTO set name = ?2, description = ?3, price = ?4 where id = ?1")
    public void update(long id,String name,String description, float price);

    public List<ProductDTO> findAll();

    //q 	deverá bater o valor contra os campos name e description
    //min_price 	deverá bater o valor ">=" contra o campo price
    //max_price 	deverá bater o valor "<=" contra o campo price

    @Query("select p from ProductDTO p " +
            "where (p.name = ?1 or p.description = ?1)" +
            "and p.price >= ?2 and p.price <= ?3")
    public List<ProductDTO> findByFilter (String q, float min_price, float max_price);

}