package com.simplon.brief15.models;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Emprunt {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // plusieurs occurencees emprunt sont liées à une occurence emprunteur
    @ManyToOne
    @JoinColumn(name = "emprunteur_id", nullable = false)
    private Emprunteur emprunteur;

    // plusieurs occurences emprunt sont liées à une occurence livre
    @ManyToOne
    @JoinColumn(name = "livre_id", nullable = false)
    private Livre livre;

    private LocalDate debut;

    private LocalDate fin;
}
