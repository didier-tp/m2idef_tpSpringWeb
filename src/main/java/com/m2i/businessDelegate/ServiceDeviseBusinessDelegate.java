package com.m2i.businessDelegate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.m2i.entity.Devise;
//idéalement dans autre projet/module maven et sur autre ordinateur
public class ServiceDeviseBusinessDelegate /* implements IServiceDevise */ {
	
	private RestTemplate restTemplate = new RestTemplate();
	private String debutURL = "http://localhost:8080"; //valeur par defaut
	//ou bien private String debutURL = "http://192.111.89.12:8080";
	
	public void setDebutURL(String debutURL) {
		this.debutURL = debutURL;
	}
	
	public List<Devise> rechercherToutesDevise(){
		String wsUri = debutURL + "/tpSpringWeb/mvc/rest/devise";
		Devise[] tabDevise = restTemplate.getForObject(wsUri,Devise[].class);
		return Arrays.asList(tabDevise);
	}

	

}
