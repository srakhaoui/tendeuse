
Feature: Pilotage de la tendeuse avec une série de commandes
  En tant que testeur, je dois pouvoir fournir une liste d'instructions spécifiant la taille de la pelouse, la position initiale, l'orientation et la série des commandes
  et d'en vérifier le résultat  

  Scenario: Tendeuse n° 1
    Given une tendeuse orientee N a la position (1,2) sur une pelouse de largeur 5 et de longeur 5 
    When j execute les commandes GAGAGAGAA
    Then la tendeuse se trouvera a la position (1,3) avec une orientation N
    
  Scenario: Tendeuse n° 2
    Given une tendeuse orientee E a la position (3,3) sur une pelouse de largeur 5 et de longeur 5
    When j execute les commandes AADAADADDA
    Then la tendeuse se trouvera a la position (4,1) avec une orientation E
#
### Then la tendeuse se trouvera a la position (5,1) avec une orientation E (elle ne peut pas être à cette position car la tendeuse sortira de la pelouse )