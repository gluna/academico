package academico.controllers;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

import academicos.modelos.Centro;
import academicos.modelos.Curso;

@ManagedBean
public class CursoController {
	
	
	private static EntityManager entityManager = Persistence.createEntityManagerFactory("academico").createEntityManager();
	
    public Curso curso = new Curso();
    public String mensagemdeerro;
    public String erro;
    List<Curso> cursos;
    
    
	public String salvar() {
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
		return "resultado";
	}
	
	public String editar(Curso c) {
		curso = c;
		return "/curso/atualizar";
	}
	
	public String excluir(Centro c) {
		entityManager.getTransaction().begin();
		entityManager.remove(c);
		entityManager.getTransaction().commit();		
		return "resultado";
	}
	
	
	@SuppressWarnings("unchecked")
	public String consultar() {
		cursos = (List<Curso>) entityManager.createQuery("select c from Curso c where c.DSCURSO like '"+curso.getDSCURSO()+"%' and c.CENTRO = :pcentro").setParameter("pcentro", curso.getCENTRO()).getResultList();
		return "index";
	}
	

	public String getErro() {
		return erro;
	}

	public void setErro(String erro) {
		this.erro = erro;
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

}
