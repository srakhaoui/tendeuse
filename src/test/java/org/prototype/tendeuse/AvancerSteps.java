package org.prototype.tendeuse;

import static org.junit.Assert.assertEquals;

import org.prototype.tendeuse.Commande;
import org.prototype.tendeuse.Orientation;
import org.prototype.tendeuse.Pelouse;
import org.prototype.tendeuse.Tendeuse;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class AvancerSteps {
	
	private Tendeuse tendeuse;
	
	@Given("^une tendeuse a la position \\((\\d+),(\\d+)\\), orientee (N|E|S|W) sur une pelouse de (\\d+) metres de largeur et (\\d+) metres de longueur$")
	public void tendeuse_sur_pelouse(Integer x, Integer y, Character valeurOrientation, Integer largeur, Integer longueur){
		final Orientation orientation = Orientation.fromValue(valeurOrientation);
		tendeuse = new Tendeuse.TendeuseBuilder(orientation).x(x).y(y).pelouse(new Pelouse(largeur, longueur)).build();
	}
	
	@When("^j execute la commande (A)$")
	public void execute_command_A(Character valeurCommand){
		final Commande commande = Commande.fromValue(valeurCommand);
		tendeuse.execute(commande);
	}
	
	@Then("^la tendeuse est a la case \\((\\d+),(\\d+)\\)$")
	public void tendeuse_est_a_la_case(Integer x, Integer y){
	    	assertEquals(x, tendeuse.getX());
		assertEquals(y, tendeuse.getY());
	}
}