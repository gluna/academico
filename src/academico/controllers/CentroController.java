package academico.controllers;


import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import academico.modelos.Centro;

@ManagedBean
@SessionScoped
public class CentroController implements Serializable{
	
	private static final long serialVersionUID = 6115226572598184538L;

	private static EntityManager entityManager = UtilController.GetEntityManager();
	
	/*@PersistenceUnit(unitName = "academico")
	private EntityManager entityManager;*/
	
	List<Centro> centros;
	Centro centro = new Centro();;

	public String salvar() {
		Centro newcentro = new Centro();
		newcentro = centro;
		entityManager.getTransaction().begin();
		entityManager. persist(newcentro);
		entityManager.getTransaction().commit();
		centro = new Centro();
		return "resultado";
	}
	
	public String update() {
		entityManager.getTransaction().begin();
		entityManager.merge(centro);
		entityManager.getTransaction().commit();
		return "resultado";
	}
	
	public String editar(Centro c) {
		centro = c;
		return "/centro/atualizar";
	}
	
	public String excluir(Centro c) {
		entityManager.getTransaction().begin();
		entityManager.remove(c);
		entityManager.getTransaction().commit();		
		return "resultado";
	}

	@SuppressWarnings("unchecked")
	public List<Centro> getCentros() {
		centros = (List<Centro>) entityManager.createQuery("select c from Centro c").getResultList();
		return centros;
	}

	public void setCentros(List<Centro> centros) {
		this.centros = centros;
	}

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}
}
