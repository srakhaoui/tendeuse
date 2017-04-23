
Feature: Pilotage de la tendeuse avec une s�rie de commandes
  En tant que testeur, je dois pouvoir fournir une liste d'instructions sp�cifiant la taille de la pelouse, la position initiale, l'orientation et la s�rie des commandes
  et d'en v�rifier le r�sultat  

  Scenario: Tendeuse n� 1
    Given une tendeuse orientee N a la position (1,2) sur une pelouse de largeur 5 et de longeur 5 
    When j execute les commandes GAGAGAGAA
    Then la tendeuse se trouvera a la position (1,3) avec une orientation N
    
  Scenario: Tendeuse n� 2
    Given une tendeuse orientee E a la position (3,3) sur une pelouse de largeur 5 et de longeur 5
    When j execute les commandes AADAADADDA
    Then la tendeuse se trouvera a la position (4,1) avec une orientation E
#
### Then la tendeuse se trouvera a la position (5,1) avec une orientation E (elle ne peut pas �tre � cette position car la tendeuse sortira de la pelouse )