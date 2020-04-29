package academico.controllers;

import java.util.List;

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
	
	
	public static String geraCod(String tabela, String campo, Integer tamcampo) {
		String codigo;
		
		@SuppressWarnings("unchecked")
		List<String> list = GetEntityManager().createNativeQuery("select max("+campo+") from "+tabela+"").getResultList();
		
		codigo = list.get(0);
		
		return codigo;
	}
	
	//TODO criar chave primaria na tabela de centro
	
}