package academicos.modelos;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Recurso implements Serializable{
	
	private static final long serialVersionUID = -6197383953513127580L;

	@Id
	@Column
	private String cdrecurso;
	
	@Column
	private String dsrecurso;
	
	public String getCdrecurso() {
		return cdrecurso;
	}
	public void setCdrecurso(String cdrecurso) {
		this.cdrecurso = cdrecurso;
	}
	public String getDsrecurso() {
		return dsrecurso;
	}
	public void setDsrecurso(String dsrecurso) {
		this.dsrecurso = dsrecurso;
	}

}
