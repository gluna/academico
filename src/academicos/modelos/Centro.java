package academicos.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Centro {

	@Id
	@Column
	String CDCENTRO;

	@Column
	String DSCENTRO;

	@Column
	Date DTINICIO;

	@Column
	String ANOPERIODOINICIO;

	@Column
	Date DTTERMINO;

	@Column
	String ANOPERIODOTERMINO;

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
