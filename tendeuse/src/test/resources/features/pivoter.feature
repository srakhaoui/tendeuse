
Feature: Pivoter avec la commande D et G
  En tant que pilote, je dois pouvoir pivoter la tendeuse de 90° à droite ou à gauche avec les commandes D et G 

  Scenario Outline: Pivoter la tendeuse avec les commandes D et G
    Given une tendeuse orientee <Orientation>
    When j execute la commande <Commande>
    Then l orientation de la tendeuse devient <Nouvelle orientation>
    
    Examples:
    | Orientation	| Commande | Nouvelle orientation	|
    |  N 					|  D  				  |  E   								|
    |  E 					|  D  				  |  S   								|
	|  S 					|  D  				  |  W   								|
	|  W 					|  D  				  |  N   								|	
	|  N 					|  G  				  |  W   								|
    |  W 					|  G  				  |  S   								|
	|  S 					|  G  				  |  E   								|
	|  E 					|  G  				  |  N   								|