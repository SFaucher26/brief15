package com.simplon.brief15.models;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Livre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String titre;
    private String auteur;

    // une occurence de la table livre peut etre dans plusieurs occurences de la table emprunt
    @OneToMany(mappedBy = "livre", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Emprunt> emprunts = new ArrayList<>();

    // plusieurs occurences de la table livres peuvent correspondre avec une occurence de la table genre
    @ManyToOne
    @JoinColumn(name = "genre_id")
    private Genre genre;

}
