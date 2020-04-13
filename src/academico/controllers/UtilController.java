package academico.controllers;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@ManagedBean
public class UtilController {
	
	private static EntityManager em;
	
	
	public static EntityManager GetEntityManager() {
		
		if (em == null) {
			em = Persistence.createEntityManagerFactory("academico").createEntityManager();
		}
		
		return em;
	}
	
	public String centroIndex() {
		return "centro/index";
	}


	public EntityManager getEm() {
		return em;
	}


	public void setEm(EntityManager em) {
		UtilController.em = em;
	}
	
	//TODO criar chave primaria na tabela de centro
	
}
