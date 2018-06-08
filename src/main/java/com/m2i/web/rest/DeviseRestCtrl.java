package com.m2i.web.rest;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.m2i.dao.IDaoDevise;
import com.m2i.entity.Devise;

@RestController
@RequestMapping(value="/rest/devise" , 
                headers="Accept=application/json")
public class DeviseRestCtrl {
	
	//business service (ou DAO) vers lequel déléguer les traitements :
	@Autowired
	private IDaoDevise daoDevise; 
	
	//sera appelé en HTTP / GET avec l' URL suivante:
	// http://localhost:8080/tpSpringWeb/mvc/rest/devise
	@RequestMapping(value="" , method=RequestMethod.GET)
	List<Devise> getToutesLesDevises(  ){
		return daoDevise.findAllDevise();
		//NB: le resultat java de type List<Devise>
		//sera automatiquement transformé au format JSON
	}
}

