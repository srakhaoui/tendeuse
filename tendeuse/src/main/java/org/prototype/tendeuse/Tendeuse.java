package org.prototype.tendeuse;

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * La tendeuse est caractérisée par ses coordonnées (x,y) et son orientation {@link Orientation}.
 * <br>Elle peut être placée sur une {@link Pelouse}
 * 
 * @author Said RAKHAOUI
 * @version 1.0
 * */
public class Tendeuse implements Mobile {
	
	private Logger logger = LogManager.getLogger(Tendeuse.class);

	private Integer x;
	private Integer y;
	private Orientation orientation;
	private Pelouse pelouse;
	
	private Tendeuse(TendeuseBuilder builder){
		this.x = builder.x;
		this.y = builder.y;
		this.orientation = builder.orientation;
		this.pelouse = builder.pelouse;
	}
	
	public Integer getX() {
		return x;
	}

	public void setX(Integer x) {
	    	logger.debug("Demande de changement de l'abscisse de {} à {}", this.x, x);
		final Integer longueur = Optional.ofNullable(pelouse).map(pelouse -> Math.max(pelouse.getLargeur()-1,0)).orElse(0);
		this.x = Math.min(Math.max(x,0), longueur);
	}

	public Integer getY() {
		return y;
	}

	public void setY(Integer y) {
	    	logger.debug("Demande de changement de l'ordonnée de {} à {}", this.y, y);
		final Integer largeur = Optional.ofNullable(pelouse).map(pelouse -> Math.max(pelouse.getLongueur()-1,0)).orElse(0);
		this.y = Math.min(Math.max(y,0), largeur);
	}

	public Orientation getOrientation() {
		return orientation;
	}

	public void setOrientation(Orientation orientation) {
		logger.debug("Changement de l'orientation : {} à {}", this.orientation.name(), orientation.name());
		this.orientation = orientation;
	}

	public Pelouse getPelouse() {
		return pelouse;
	}

	public void setPelouse(Pelouse pelouse) {
		this.pelouse = pelouse;
	}
	
	/**
	 * Permet d'exécuter une série de commandes et de communiquer la position et l'orientation actuelle 
	 * @param commandes : la liste des {@link Commande} à exécuter 
	 */
	public void execute(Commande... commandes){
		for(int i=0; i < commandes.length; i++){
			commandes[i]	.appliquer(this);	
		}
		logger.info("Position actuelle : ({},{}), Orientation : {}", this.x, this.y, this.orientation);
	}
	
	/**
	 * La classe TendeuseBuilder permet de construire les instances de la classe {@link Pelouse}.
	 * <br>La tendeuse se met par défaut à la position (0,0), l'orientation est obligatore
	 * */
	public static class TendeuseBuilder {
		
		private Integer x;
		private Integer y;
		private final Orientation orientation;//champ obligatoire
		private Pelouse pelouse;
		
		public TendeuseBuilder(Orientation orientation){
			this.orientation = orientation;
			this.x = 0;
			this.y = 0;
		}
		
		public TendeuseBuilder x(Integer x){
			this.x = x;
			return this;
		}
		
		public TendeuseBuilder y(Integer y){
			this.y = y;
			return this;
		}
		
		public TendeuseBuilder pelouse(Pelouse pelouse){
			this.pelouse = pelouse;
			return this;
		}
		
		public Tendeuse build(){
			final Tendeuse tendeuse = new Tendeuse(this);
			return tendeuse;
		}
	}
}