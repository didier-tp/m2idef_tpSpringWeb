package com.m2i.test;

import java.util.List;

import com.m2i.businessDelegate.ServiceDeviseBusinessDelegate;
import com.m2i.entity.Devise;

//idéalement dans autre projet/module maven et sur autre ordinateur
public class BusinessDelegateIT {
	
	public static void main(String[] args) {
		ServiceDeviseBusinessDelegate serviceDistant  = 
				new ServiceDeviseBusinessDelegate();
		
		//serviceDistant.setDebutURL("http://172.28.11.5:8080");
		//serviceDistant.setDebutURL("http://172.28.10.166:8080");
		
		
		List<Devise> devises = serviceDistant.rechercherToutesDevise();
		
		for(Devise d : devises){
			System.out.println("\t" + d);
		}
	}
}
