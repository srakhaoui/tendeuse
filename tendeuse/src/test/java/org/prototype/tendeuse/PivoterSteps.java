package org.prototype.tendeuse;

import static org.junit.Assert.assertEquals;

import org.prototype.tendeuse.Commande;
import org.prototype.tendeuse.Orientation;
import org.prototype.tendeuse.Tendeuse;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class PivoterSteps {
	
	private Tendeuse tendeuse;
	
	@Given("^une tendeuse orientee (N|E|S|W)$")
	public void tendeuse_orientee(Character valeurOrientation){
		final Orientation orientation = Orientation.fromValue(valeurOrientation);
		tendeuse = new Tendeuse.TendeuseBuilder(orientation).build();
	}

	@When("^j execute la commande (G|D)$")
	public void execute_command(Character valeurCommand){
		final Commande commande = Commande.fromValue(valeurCommand);
		tendeuse.execute(commande);
	}
	
	@Then("^l orientation de la tendeuse devient (N|E|S|W)$")
	public void orientation_tendeuse_devient(Character valeurOrientation){
		final Orientation orientation = Orientation.fromValue(valeurOrientation);
		assertEquals(orientation, tendeuse.getOrientation());
	}
}