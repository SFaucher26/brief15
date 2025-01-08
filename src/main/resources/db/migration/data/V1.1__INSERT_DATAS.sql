INSERT INTO genre (nom)
VALUES
    ('Fantasy'),
    ('Science-fiction'),
    ('Roman historique'),
    ('Thriller');

INSERT INTO livre (titre, auteur, genre_id)
VALUES
    ('Le Seigneur des Anneaux', 'J.R.R. Tolkien', 1),
    ('Dune', 'Frank Herbert', 2),
    ('Les Misérables', 'Victor Hugo', 3),
    ('La vérité sur l’affaire Harry Quebert', 'Joël Dicker', 4);

INSERT INTO emprunteur (firstname, lastname, email)
VALUES
    ('Alice', 'Durand', 'alice.durand@example.com'),
    ('Bob', 'Martin', 'bob.martin@example.com'),
    ('Carla', 'Lemoine', 'carla.lemoine@example.com'),
    ('David', 'Bernard', 'david.bernard@example.com');

INSERT INTO emprunt (emprunteur_id, livre_id, debut, fin)
VALUES
      (1, 1, '2025-01-01', '2025-01-15'),  -- Alice emprunte 'Le Seigneur des Anneaux'
      (2, 2, '2025-01-05', '2025-01-20'),  -- Bob emprunte 'Dune'
      (1, 2, '2025-01-21', '2025-01-23'),  -- Alice empreunt 'Dune'
      (3, 3, '2025-01-10', '2025-01-25'),  -- Carla emprunte 'Les Misérables'
      (4, 4, '2025-01-12', '2025-01-18');  -- David emprunte 'La vérité sur l’affaire Harry Quebert'