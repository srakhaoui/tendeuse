
Feature: Pilotage avec la commande Avancer
  En tant que pilote, je dois pouvoir piloter la tendeuse avec la commande Avancer

 Scenario Outline: Commande Avancer avec une orientation donnée
    Given une tendeuse a la position <Ancienne position>, orientee <Orientation> sur une pelouse de 5 metres de largeur et 10 metres de longueur
    When j execute la commande A
    Then la tendeuse est a la case <Nouvelle position>

    Examples:
    | Ancienne position	| Orientation	| Nouvelle position	|
    |   (4,9)     				|  N               	|  (4,9)						|
    |   (4,9)     				|  E               	|  (4,9)						|
    |   (4,9)     				|  S               	|  (4,8)						|
    |   (4,9)     				|  W               	|  (3,9)						|
    |   (0,0)     				|  E               	|  (1,0)						|            
    |   (0,0)     				|  S               	|  (0,0)						|
    |   (0,0)     				|  N               	|  (0,1)						|
    |   (0,0)     				|  W               	|  (0,0)						|	  