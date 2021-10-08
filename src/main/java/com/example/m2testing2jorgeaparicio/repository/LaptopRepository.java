package com.example.m2testing2jorgeaparicio.repository;

import com.example.m2testing2jorgeaparicio.entities.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LaptopRepository extends JpaRepository <Laptop, Long> {

    List<Laptop> findBymodelo (String modelo);

    List<Laptop> findByram (Integer ram);

    List <Laptop> findByModeloAndRam (String modelo, Integer ram);

    List <Laptop> findByPriceLessThan (Double price);
}




