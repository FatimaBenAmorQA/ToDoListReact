package com.e2etests.automation.step_definitions;

import org.junit.Assert;

import com.e2etests.automation.page_object.NavigationPageObject;
import com.e2etests.automation.utils.ConfigFileReader;
import com.e2etests.automation.utils.SeleniumUtils;
import com.e2etests.automation.utils.Validations;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class NavigationStepDefinition {
	
	private NavigationPageObject navigationPageObject;
	private SeleniumUtils seleniumUtils;
	private Validations validations;
	private ConfigFileReader configFileReader;
	
	public NavigationStepDefinition() {
		this.seleniumUtils = new SeleniumUtils();
		this.configFileReader = new ConfigFileReader();
		this.validations = new Validations();
		this.navigationPageObject = new NavigationPageObject();

	}
	
	@When("je ne suis pas identife")
	public void jeNeSuisPasIdentife() {
		String currentUrl = seleniumUtils.getCurrentUrl();
		validations.assertEquals(currentUrl, configFileReader.getProperties("home.url"));

	}
	
//	@Then("les liens tache et deconnxion ne sont pas affiches")
//	public void lesLiensTacheEtDeconnxionNeSontPasAffiches() {
		//validations.assertTrueBoolean(navigationPageObject.taskLink);
	    //validations.assertTrueBoolean(navigationPageObject.deconnectionLink);
		
	//}


	@Then("les liens {string} n est pas affiche")
	public void lesLiensNEstPasAffiche(String text) {
		String task = navigationPageObject.taskLink.getText();
		Assert.assertEquals(text, task);

	}
	@Then("le lien {string} n est pass affiche")
	public void leLienNEstPassAffiche(String text) {
		String deconnexion = navigationPageObject.deconnectionLink.getText();
		Assert.assertEquals(text, deconnexion);


	}





}
