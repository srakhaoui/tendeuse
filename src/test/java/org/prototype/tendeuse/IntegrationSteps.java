package org.prototype.tendeuse;

import static org.junit.Assert.assertEquals;

import org.prototype.tendeuse.Commande;
import org.prototype.tendeuse.Orientation;
import org.prototype.tendeuse.Pelouse;
import org.prototype.tendeuse.Tendeuse;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class IntegrationSteps {
	
	private Tendeuse tendeuse;
	
	@Given("^une tendeuse orientee (N|E|S|W) a la position \\((\\d+),(\\d+)\\) sur une pelouse de largeur (\\d+) et de longeur (\\d+)$")
	public void tendeuse_sur_pelouse(Character valeurOrientation, Integer x, Integer y, Integer largeur, Integer longueur){
		final Orientation orientation = Orientation.fromValue(valeurOrientation);
		tendeuse = new Tendeuse.TendeuseBuilder(orientation).x(x).y(y).pelouse(new Pelouse(largeur, longueur)).build();
	}
	
	@When("^j execute les commandes ([A|G|D]+)$")
	public void execute_command(String commandes) {
		commandes.chars().forEach(valeurCommande ->	
			tendeuse.execute(Commande.fromValue((char) valeurCommande)) 
		);
	}
	
	@Then("^la tendeuse se trouvera a la position \\((\\d+),(\\d+)\\) avec une orientation (N|E|S|W)$")
	public void position_orientation_tendeuse(Integer x, Integer y, Character valeurOrientation){
		final Orientation orientation = Orientation.fromValue(valeurOrientation);
		assertEquals(orientation, tendeuse.getOrientation());
		assertEquals(x, tendeuse.getX());
		assertEquals(y, tendeuse.getY());
	}
}