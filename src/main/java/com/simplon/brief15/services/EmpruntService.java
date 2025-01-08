package com.simplon.brief15.services;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.simplon.brief15.models.Emprunteur;
import com.simplon.brief15.models.Livre;
import com.simplon.brief15.repositories.EmpruntRepository;
import com.simplon.brief15.repositories.EmprunteurRepository;
import com.simplon.brief15.repositories.LivreRepository;

@Service
public class EmpruntService {

    private LivreRepository livreRepository;
    private EmprunteurRepository emprunteurRepository;

    public EmpruntService(LivreRepository livreRepository, EmprunteurRepository emprunteurRepository){
        this.livreRepository= livreRepository;
        this.emprunteurRepository = emprunteurRepository;
    }

    public Optional<Livre> getLivreById(Long id){
        return livreRepository.findById(id);
    }

    public Optional <Emprunteur> getEmprunteurById(Long id){
        return emprunteurRepository.findById(id);
    }
}
