package academico.controllers;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import academicos.modelos.Centro;
import academicos.modelos.Curso;

@ManagedBean
@SessionScoped
public class CursoController {
	
	
	private static EntityManager entityManager = Persistence.createEntityManagerFactory("academico").createEntityManager();
	
    public Curso curso = new Curso();
    public String centro = new String();
    List<Curso> cursos = new ArrayList<Curso>();
    
    
	public String salvar() {
		Centro c = (Centro)entityManager.createQuery("select c from Centro c where c.CDCENTRO = :pcentro").setParameter("pcentro", centro).getSingleResult();
		curso.setCENTRO(c);
		Curso newcurso = new Curso();
		newcurso = curso;
		entityManager.getTransaction().begin();
		entityManager. persist(newcurso);
		entityManager.getTransaction().commit();
		curso = new Curso();
		return "resultado";
	}
	
	public String update() {
		entityManager.getTransaction().begin();
		entityManager.merge(curso);
		entityManager.getTransaction().commit();
		curso = new Curso();
		return "resultado";
	}
	
	public String editar(Curso c) {
		curso = c;
		return "atualizar";
	}
	
	public String excluir(Curso c) {
		entityManager.getTransaction().begin();
		entityManager.remove(c);
		entityManager.getTransaction().commit();		
		return "resultado";
	}
	
	@SuppressWarnings("unchecked")
	public String consultar() {
		
		Centro c = new Centro();
		if(!centro.equals("")) {
			c = (Centro)entityManager.createQuery("select c from Centro c where c.CDCENTRO = :pcentro").setParameter("pcentro", centro).getSingleResult();
		}else {
			c.setCDCENTRO("%");
		}
		curso.setCENTRO(c);
		List<Curso> c2 = new ArrayList<Curso>();
		c2 = (List<Curso>) entityManager.createQuery("select c from Curso c where c.DSCURSO like :pcurso and c.CENTRO.CDCENTRO like :pcentro").
				               setParameter("pcurso", curso.getDSCURSO()+"%").setParameter("pcentro", curso.getCENTRO().getCDCENTRO()).getResultList();
		
		setCursos(c2);
		
		return "index";
	}

	public Curso getCurso() {
		return curso;
	}

	public void setCurso(Curso curso) {
		this.curso = curso;
	}

	public void setCursos(List<Curso> cursos) {
		this.cursos = cursos;
	}

	public List<Curso> getCursos() {
		
		return cursos;
	}

	public String getCentro() {
		return centro;
	}

	public void setCentro(String centro) {
		this.centro = centro;
	}

}
