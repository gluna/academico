package academicos.modelos;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Curso {
	
	@Id
	String CDCURSO;
	
	@ManyToOne
	@JoinColumn(name = "CDCENTRO")
	Centro CENTRO;
	
	@Column
	String DSCURSO;
	
	@Column
	Date   DTINICIO;
	
	@Column
	String ANOPERIODOINICIO;
	
	@Column
	Date   DTTERMINO;
	
	@Column
	String ANOPERIODOTERMINO;
	
	@Column
	String AUTORIZACAO;
	
	@Column
	String RECONHECIMENTO;
	
	@Column
	String PUBLICACAODO;
	
	@Column
	String FLGENC;
	
	@Column
	String ANOENC;
	
	@Column
	String TITULO;
	
	@Column
	String ABREVIADO;
	
	@Column
	String CODIGOINEP;
	
	@Column
	String CH;
	
	@Column
	String TITULO_FEMININO;
	
	@Column
	String TEMPOINTEGRALIZACAO;

	public String getCDCURSO() {
		return CDCURSO;
	}

	public void setCDCURSO(String cDCURSO) {
		CDCURSO = cDCURSO;
	}

	public String getDSCURSO() {
		return DSCURSO;
	}

	public void setDSCURSO(String dSCURSO) {
		DSCURSO = dSCURSO;
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

	public String getAUTORIZACAO() {
		return AUTORIZACAO;
	}

	public void setAUTORIZACAO(String aUTORIZACAO) {
		AUTORIZACAO = aUTORIZACAO;
	}

	public String getRECONHECIMENTO() {
		return RECONHECIMENTO;
	}

	public void setRECONHECIMENTO(String rECONHECIMENTO) {
		RECONHECIMENTO = rECONHECIMENTO;
	}

	public String getPUBLICACAODO() {
		return PUBLICACAODO;
	}

	public void setPUBLICACAODO(String pUBLICACAODO) {
		PUBLICACAODO = pUBLICACAODO;
	}

	public String getFLGENC() {
		return FLGENC;
	}

	public void setFLGENC(String fLGENC) {
		FLGENC = fLGENC;
	}

	public String getANOENC() {
		return ANOENC;
	}

	public void setANOENC(String aNOENC) {
		ANOENC = aNOENC;
	}

	public String getTITULO() {
		return TITULO;
	}

	public void setTITULO(String tITULO) {
		TITULO = tITULO;
	}

	public String getABREVIADO() {
		return ABREVIADO;
	}

	public void setABREVIADO(String aBREVIADO) {
		ABREVIADO = aBREVIADO;
	}

	public String getCODIGOINEP() {
		return CODIGOINEP;
	}

	public void setCODIGOINEP(String cODIGOINEP) {
		CODIGOINEP = cODIGOINEP;
	}

	public String getCH() {
		return CH;
	}

	public void setCH(String cH) {
		CH = cH;
	}

	public String getTITULO_FEMININO() {
		return TITULO_FEMININO;
	}

	public void setTITULO_FEMININO(String tITULO_FEMININO) {
		TITULO_FEMININO = tITULO_FEMININO;
	}

	public String getTEMPOINTEGRALIZACAO() {
		return TEMPOINTEGRALIZACAO;
	}

	public void setTEMPOINTEGRALIZACAO(String tEMPOINTEGRALIZACAO) {
		TEMPOINTEGRALIZACAO = tEMPOINTEGRALIZACAO;
	}

	public Centro getCENTRO() {
		return CENTRO;
	}

	public void setCENTRO(Centro cENTRO) {
		CENTRO = cENTRO;
	}

}
