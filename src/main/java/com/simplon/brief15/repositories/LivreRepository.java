package com.simplon.brief15.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplon.brief15.models.Livre;

@Repository
public interface LivreRepository extends JpaRepository <Livre, Long> {
    @Override
    Optional<Livre> findById(Long id);
}
