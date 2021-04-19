package com.henry.noticiero.repository;


import com.henry.noticiero.model.Noticias;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiasRepository extends JpaRepository<Noticias, Integer> {
}
