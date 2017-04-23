package org.prototype.tendeuse;

/**
 * La pelouse dispose d'une largeur et d'une longueur.
 * La largeur et la longueur ne peuvent être négatives
 * */
public class Pelouse {

	private Integer largeur;
	private Integer longueur;
	
	public Pelouse(Integer largeur, Integer longueur){
		if(largeur < 0 || longueur < 0){
			throw new IllegalArgumentException("Taille invalide");
		}
		this.largeur = largeur;
		this.longueur = longueur;
	}
	
	public Integer getLargeur() {
		return largeur;
	}
	public void setLargeur(Integer largeur) {
		if(largeur < 0){
			throw new IllegalArgumentException("La largeur doit être positive");
		}
		this.largeur = largeur;
	}
	public Integer getLongueur() {
		return longueur;
	}
	public void setLongueur(Integer longueur) {
		if(longueur < 0){
			throw new IllegalArgumentException("La longueur doit être positive");
		}
		this.longueur = longueur;
	}
}