package com.example.bakery.domain;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
@RepositoryRestResource
public interface BreadRepository extends CrudRepository<Bread, Long> {
    //Fetch breads by id
    Bread findAllById(Long id);

    //Fetch bread by name
    //http://localhost:8080/api/breads/search/findByName?name=ruismies
    Bread findByName(@Param("name") String name);

    //Fetch breads by brand
    //
    List<Bread> findByBrand(@Param("brand") String brand);

    //Fetch breads by type
    //THis is unsolved
    //List<Bread> findByType(@Param("Type.typeName") String typeName);



}
