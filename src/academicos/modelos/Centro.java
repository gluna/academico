package academicos.modelos;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

@Entity
public class Centro implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column
	private String CDCENTRO;

	@Column
	private String DSCENTRO;

	@Column
	private Date DTINICIO;

	@Column
	private String ANOPERIODOINICIO;

	@Column
	private Date DTTERMINO;

	@Column
	private String ANOPERIODOTERMINO;
	
	@JoinColumn(name = "CDCENTRO")
	private ArrayList<Curso> cursos;
	
	public String getCDCENTRO() {
		return CDCENTRO;
	}

	public void setCDCENTRO(String cDCENTRO) {
		CDCENTRO = cDCENTRO;
	}

	public String getDSCENTRO() {
		return DSCENTRO;
	}

	public void setDSCENTRO(String dSCENTRO) {
		DSCENTRO = dSCENTRO;
	}

	public Date getDTINICIO() {
		return DTINICIO;
	}

	public void setDTINICIO(Date dTINICIO) {
		DTINICIO = dTINICIO;
	}

	public String getANOPERIODOINICIO() {
		return ANOPERIODOINICIO;
	}

	public void setANOPERIODOINICIO(String aNOPERIODOINICIO) {
		ANOPERIODOINICIO = aNOPERIODOINICIO;
	}

	public Date getDTTERMINO() {
		return DTTERMINO;
	}

	public void setDTTERMINO(Date dTTERMINO) {
		DTTERMINO = dTTERMINO;
	}

	public String getANOPERIODOTERMINO() {
		return ANOPERIODOTERMINO;
	}

	public void setANOPERIODOTERMINO(String aNOPERIODOTERMINO) {
		ANOPERIODOTERMINO = aNOPERIODOTERMINO;
	}
}
