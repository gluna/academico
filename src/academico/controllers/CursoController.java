package academico.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;

import academicos.modelos.Centro;
import academicos.modelos.Curso;

@ManagedBean
@SessionScoped
public class CursoController implements Serializable{
	
	private static final long serialVersionUID = -7060747349258640069L;

	private static EntityManager entityManager = UtilController.GetEntityManager();
	
    public Curso curso = new Curso();
    public Centro centro = new Centro();
    List<Curso> cursos = new ArrayList<Curso>();
    
    public String index() {

    	curso = new Curso();
        centro = new Centro();
        cursos = new ArrayList<Curso>();
    	
    	return "/curso/index";
    }
    
    
	public String salvar() {
		//Centro c = (Centro)entityManager.createQuery("select c from Centro c where c.CDCENTRO = :pcentro").setParameter("pcentro", centro).getSingleResult();
		//curso.setCENTRO(c);
		curso.setCDCURSO(gerarCodigo());
		Curso newcurso = new Curso();
		newcurso = curso;
		entityManager.getTransaction().begin();
		entityManager. persist(newcurso);
		entityManager.getTransaction().commit();
		curso = new Curso();
		return "resultado";
	}
	
	private String gerarCodigo() {
		
		String codcurso = (String) entityManager.createQuery("SELECT max(c.CDCURSO) from Curso c ").getSingleResult();
		
		codcurso = UtilController.strZero(codcurso, 10);
		
		return codcurso;
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
	
	public String cadastrar() {
    	curso = new Curso();
        centro = new Centro();
        cursos = new ArrayList<Curso>();
    	
    	return "/curso/cadastrar";
		
	}
	

	@SuppressWarnings("unchecked")
	public String consultar() {
		
		Centro c = new Centro();
		
		if(centro == null) {
			centro = new Centro();
		}
		
		if(centro.getCDCENTRO() != null) {
			c = (Centro)entityManager.createQuery("select c from Centro c where c.CDCENTRO = :pcentro").setParameter("pcentro", centro.getCDCENTRO()).getSingleResult();
		}else {
			c.setCDCENTRO("%");
		}
		curso.setCENTRO(c);
		List<Curso> c2 = new ArrayList<Curso>();
		c2 = (List<Curso>) entityManager.createQuery("select c from Curso c where c.DSCURSO like :pcurso and c.CENTRO.CDCENTRO like :pcentro").
				               setParameter("pcurso", "%"+curso.getDSCURSO()+"%").setParameter("pcentro", curso.getCENTRO().getCDCENTRO()).getResultList();
		
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

	public Centro getCentro() {
		return centro;
	}

	public void setCentro(Centro centro) {
		this.centro = centro;
	}

}
