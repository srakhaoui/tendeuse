package org.prototype.tendeuse;

/**
 * Repr�sente la liste des commandes support�es pour piloter la tendeuse
 * <ul>
 *  <li>AVANCER	: Avancer la tendeuse d'une case dans le sens de l'orientation</li>
 *  <li>DRIOTE	: Pivoter la tendeuse de 90� � droite sans changer d'orientation</li>
 *  <li>GAUCHE	: Pivoter la tendeuse de 90� � gauche sans changer d'orientation</li>
 * </ul>
 * @author Said RAKHAOUI
 * @version 1.0
 * */
public enum Commande {
	
	/**
	 * Avancer la tendeuse d'une case dans le sens de l'orientation
	 * */
	AVANCER('A'){
	    @Override
	    public void appliquer(Mobile mobile) {
		
		switch(mobile.getOrientation()){
        		case NORD 	: mobile.setY(mobile.getY() + 1); 
        		break;
        		case EST		: mobile.setX(mobile.getX() + 1); 
        		break;
        		case OUEST	: mobile.setX(mobile.getX() -1); 
        		break;
        		case SUD  	: mobile.setY(mobile.getY() - 1); 
        		break;
		}
	    }
	}, 
	
	/**
	 * Pivoter la tendeuse de 90� � droite sans changer d'orientation
	 * */
	DROITE('D'){
	    @Override
	    public void appliquer(Mobile reperable) {
		reperable.setOrientation(reperable.getOrientation().droite());
	    }
	}, 
	
	/**
	 * Pivoter la tendeuse de 90� � gauche sans changer d'orientation
	 * */
	GAUCHE('G'){
	    @Override
	    public void appliquer(Mobile reperable) {
		reperable.setOrientation(reperable.getOrientation().gauche());	        
	    }
	};
	
	private Character value;
	
	Commande(Character value){
		this.value = value;
	}
	
	public abstract void appliquer(Mobile reperable);
	
	public Character value(){
		return value;
	}
	
	public static Commande fromValue(Character value){
		final Commande commande;
		switch (value) {
			case 'A'	: commande = AVANCER;
			break;
			case 'D'	: commande = DROITE; 
			break;
			case 'G'	: commande = GAUCHE; 
			break;	
			default	: throw new IllegalArgumentException("La commande "+ value +" n'est pas support�e !");
		}
		return commande;
	}
}