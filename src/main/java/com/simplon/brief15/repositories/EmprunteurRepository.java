package com.simplon.brief15.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.simplon.brief15.models.Emprunteur;

@Repository
public interface EmprunteurRepository extends JpaRepository <Emprunteur, Long> {

}
