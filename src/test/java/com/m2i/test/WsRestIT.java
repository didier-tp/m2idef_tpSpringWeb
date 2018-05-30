package com.m2i.test;

import java.util.List;

import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.m2i.entity.Compte;
import com.m2i.web.rest.data.OrdreVirement;

/*
 * cette classe à un nom qui commence ou se termine par IT (et par par Test)
 * car c'est un Test d'Integration qui ne fonctionne que lorque Tomcat est démarré
 */
public class WsRestIT {
	
	private static Logger logger = LoggerFactory.getLogger(WsRestIT.class);
	
	private static RestTemplate restTemplate; //objet technique fourni par Spring tester WS REST
	
	//pas de @Autowired ni de @RunWith , @ContextConfiguration
	//car ce test EXTERNE est censé tester le WebService sans connaître sa structure interne
	// (test BOITE_NOIRE)
	@BeforeClass
	public static void init(){
		restTemplate = new RestTemplate();
	}
	
	@Test
	public void testListeComptesDuClient(){
		final Integer numCli = 1;
	    final String uri = "http://localhost:8080/tpSpringWeb/mvc/rest/compte/duClient?numClient="
		       +numCli;
	    String resultAsJsonString = restTemplate.getForObject(uri, String.class);
	    logger.info("json listeComptes via rest: " + resultAsJsonString);
	    List<Compte> listeComptes = restTemplate.getForObject(uri, List.class);
	    logger.info("java listeComptes via rest: "  +listeComptes.toString());
	    Assert.assertNotNull(listeComptes);
	    Assert.assertTrue(listeComptes.size()>=0);

	}
	
	@Test
	public void testVirement(){
		 final String uri = "http://localhost:8080/tpSpringWeb/mvc/rest/compte/virement";
		    //post/envoi:
		    OrdreVirement ordreVirement = new OrdreVirement();
		    ordreVirement.setMontant(50.0);
		    ordreVirement.setNumCptDeb(1L);
		    ordreVirement.setNumCptCred(2L);
		   
		    OrdreVirement savedOrdreVirement =
		    		restTemplate.postForObject(uri, ordreVirement, OrdreVirement.class);
		    logger.info("savedOrdreVirement via rest: " + savedOrdreVirement.toString());
		    Assert.assertTrue(savedOrdreVirement.getOk().equals(true));
		   
		   
	}

}
