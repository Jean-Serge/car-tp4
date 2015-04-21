# CAR - TP4 
Jean-Serge Monbailly

Implémentation d'une librairie en ligne utilisant JEE, JSP et EJB.

Fonctionnalités
===============
+ Ajouter un livre
+ Rechercher un Livre
+ Lister les auteurs
+ Lister les livres
+ Initialiser la base



Notes
=====
La base permet de stocker des livres (classe Books).
Les livres sont composés :
+ d'un titre (identifiant)
+ d'un auteur
+ d'une année de parution

La base est manipulée par le BookManager (singleton) qui initialise la base.


Ajouter un livre
----------------
L'utilisateur doit indiquer le titre, l'auteur et l'année de parution
du livre en question.

TODO : 
+ Utiliser la JSP en parallèle de la servlet pour vérifier les champs
+ Vérifier dans la JSP que l'année de parution spécifiée est belle et bien un entier


Rechercher un livre
-------------------
L'utilisateur saisi le titre du livre qu'il rechercher.
Si le livre en question existe, une description de celui-ci est retournée.
Sinon un message l'indiquant est affiché à l'utilisateur.


Lister les auteurs
------------------
Permet de lister l'ensemble des auteurs ayant au moins un livre dans la base.
La servlet affiche un message si la base est vide.


Lister les livres
-----------------
Permet de lister tous les livres contenus dans la base.
La servlet affiche un message si la base est vide.


Initialiser la base
-------------------
La base est initialisée avec des valeurs par défaut (@PostConstruct)
