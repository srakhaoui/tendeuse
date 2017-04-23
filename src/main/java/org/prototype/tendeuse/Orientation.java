package org.prototype.tendeuse;

/**
 * Repr�sente la liste des orientations selon la notation cardinale anglaise
 * <ul>
 * 	<li>NORD</li>
 *  	<li>EST</li>
 *  	<li>SUD</li>
 *  	<li>OUEST</li>
 * </ul>
 * @author Said RAKHAOUI
 * @version 1.0
 * */
public enum Orientation {

	NORD('N'){
		
		@Override
		public Orientation gauche() {
			return OUEST;
		}
		@Override
		public Orientation droite() {
			return EST;
		}
	}, 
	EST('E'){

		@Override
		public Orientation gauche() {
			return NORD;
		}

		@Override
		public Orientation droite() {
			return SUD;
		}
		
	}, 
	SUD('S'){

		@Override
		public Orientation gauche() {
			return EST;
		}

		@Override
		public Orientation droite() {
			return OUEST;
		}
		
	}, 
	OUEST('W'){

		@Override
		public Orientation gauche() {
			return SUD;
		}

		@Override
		public Orientation droite() {
			return NORD;
		}
		
	};
	
	private Character value;
	
	private Orientation(Character value){
		this.value = value;
	}
	
	/**
	 * Indique l'orientation apr�s un basculement de 90� � gauche de l'orientation en cours
	 * */
	public abstract Orientation gauche();
	
	/**
	 * Indique l'orientation apr�s un basculement de 90� � droite de l'orientation en cours
	 * */
	public abstract Orientation droite();
	
	Character value(){
		return value;
	}
	
	public static Orientation fromValue(Character value){
		final Orientation orientation;
		switch(value){
			case 'N'	: orientation = NORD; 
			break;
			case 'E'	: orientation = EST; 
			break;
			case 'S'	: orientation = SUD; 
			break;
			case 'W'	: orientation = OUEST; 
			break;
			default: throw new IllegalArgumentException("Le type "+ value +" n'est pas support� !");
		}
		return orientation;
	}
}