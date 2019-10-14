package academico.controllers;

import java.io.Serializable;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import academicos.modelos.Recurso;

@ManagedBean
public class RecursoController implements Serializable{
	

	private static final long serialVersionUID = -2171507286591563474L;
	
	/*@PersistenceContext
    private static EntityManager entityManager;*/
	
	private static EntityManager entityManager = Persistence.createEntityManagerFactory("academico").createEntityManager();
	
    public Recurso recurso = new Recurso();
    public String mensagemdeerro;
    public String erro;
    List<Recurso> recursos;
    
    @SuppressWarnings("unchecked")
	public String Salvar() {
    	mensagemdeerro = "resposta";
    	Recurso r = new Recurso();
    	r = recurso;
    	entityManager.getTransaction().begin();
    	entityManager.persist(r);
    	entityManager.getTransaction().commit();
    	recurso = new Recurso();
		recursos = (List<Recurso>) entityManager.createQuery("select r from Recurso r").getResultList();
    	return mensagemdeerro;
    }

	public Recurso getRecurso() {
		return recurso;
	}

	public void setRecurso(Recurso recurso) {
		this.recurso = recurso;
	}

	public List<Recurso> getRecursos() {
		return recursos;
	}

	public void setRecursos(List<Recurso> recursos) {
		this.recursos = recursos;
	}

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
	}

}
