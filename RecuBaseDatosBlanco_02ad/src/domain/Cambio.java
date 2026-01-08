package domain;

import java.sql.Date;

public class Cambio {
	int idCambio;
	String motivo;
	Date fecha;
	int STOCK_STAND_idStand_Original;
	int STOCK_STAND_ZONA_idzona_Original;
	int STOCK_JUGUETE_idJuguete_Original;
	int STOCK_STAND_idStand_Nuevo;
	int STOCK_STAND_ZONA_idzona_Nuevo;
	int STOCK_JUGUETE_idJuguete_Nuevo;
	int EMPLEADO_idEMPLEADO;

	public Cambio() {
	}

	public Cambio(int idCambio, String motivo, Date fecha, int sTOCK_STAND_idStand_Original,
			int sTOCK_STAND_ZONA_idzona_Original, int sTOCK_JUGUETE_idJuguete_Original, int sTOCK_STAND_idStand_Nuevo,
			int sTOCK_STAND_ZONA_idzona_Nuevo, int sTOCK_JUGUETE_idJuguete_Nuevo, int eMPLEADO_idEMPLEADO) {
		super();
		this.idCambio = idCambio;
		this.motivo = motivo;
		this.fecha = fecha;
		STOCK_STAND_idStand_Original = sTOCK_STAND_idStand_Original;
		STOCK_STAND_ZONA_idzona_Original = sTOCK_STAND_ZONA_idzona_Original;
		STOCK_JUGUETE_idJuguete_Original = sTOCK_JUGUETE_idJuguete_Original;
		STOCK_STAND_idStand_Nuevo = sTOCK_STAND_idStand_Nuevo;
		STOCK_STAND_ZONA_idzona_Nuevo = sTOCK_STAND_ZONA_idzona_Nuevo;
		STOCK_JUGUETE_idJuguete_Nuevo = sTOCK_JUGUETE_idJuguete_Nuevo;
		EMPLEADO_idEMPLEADO = eMPLEADO_idEMPLEADO;
	}

	public int getIdCambio() {
		return idCambio;
	}

	public void setIdCambio(int idCambio) {
		this.idCambio = idCambio;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public int getSTOCK_STAND_idStand_Original() {
		return STOCK_STAND_idStand_Original;
	}

	public void setSTOCK_STAND_idStand_Original(int sTOCK_STAND_idStand_Original) {
		STOCK_STAND_idStand_Original = sTOCK_STAND_idStand_Original;
	}

	public int getSTOCK_STAND_ZONA_idzona_Original() {
		return STOCK_STAND_ZONA_idzona_Original;
	}

	public void setSTOCK_STAND_ZONA_idzona_Original(int sTOCK_STAND_ZONA_idzona_Original) {
		STOCK_STAND_ZONA_idzona_Original = sTOCK_STAND_ZONA_idzona_Original;
	}

	public int getSTOCK_JUGUETE_idJuguete_Original() {
		return STOCK_JUGUETE_idJuguete_Original;
	}

	public void setSTOCK_JUGUETE_idJuguete_Original(int sTOCK_JUGUETE_idJuguete_Original) {
		STOCK_JUGUETE_idJuguete_Original = sTOCK_JUGUETE_idJuguete_Original;
	}

	public int getSTOCK_STAND_idStand_Nuevo() {
		return STOCK_STAND_idStand_Nuevo;
	}

	public void setSTOCK_STAND_idStand_Nuevo(int sTOCK_STAND_idStand_Nuevo) {
		STOCK_STAND_idStand_Nuevo = sTOCK_STAND_idStand_Nuevo;
	}

	public int getSTOCK_STAND_ZONA_idzona_Nuevo() {
		return STOCK_STAND_ZONA_idzona_Nuevo;
	}

	public void setSTOCK_STAND_ZONA_idzona_Nuevo(int sTOCK_STAND_ZONA_idzona_Nuevo) {
		STOCK_STAND_ZONA_idzona_Nuevo = sTOCK_STAND_ZONA_idzona_Nuevo;
	}

	public int getSTOCK_JUGUETE_idJuguete_Nuevo() {
		return STOCK_JUGUETE_idJuguete_Nuevo;
	}

	public void setSTOCK_JUGUETE_idJuguete_Nuevo(int sTOCK_JUGUETE_idJuguete_Nuevo) {
		STOCK_JUGUETE_idJuguete_Nuevo = sTOCK_JUGUETE_idJuguete_Nuevo;
	}

	public int getEMPLEADO_idEMPLEADO() {
		return EMPLEADO_idEMPLEADO;
	}

	public void setEMPLEADO_idEMPLEADO(int eMPLEADO_idEMPLEADO) {
		EMPLEADO_idEMPLEADO = eMPLEADO_idEMPLEADO;
	}

	@Override
	public String toString() {
		return "Cambio [idCambio=" + idCambio + ", motivo=" + motivo + ", fecha=" + fecha
				+ ", STOCK_STAND_idStand_Original=" + STOCK_STAND_idStand_Original
				+ ", STOCK_STAND_ZONA_idzona_Original=" + STOCK_STAND_ZONA_idzona_Original
				+ ", STOCK_JUGUETE_idJuguete_Original=" + STOCK_JUGUETE_idJuguete_Original
				+ ", STOCK_STAND_idStand_Nuevo=" + STOCK_STAND_idStand_Nuevo + ", STOCK_STAND_ZONA_idzona_Nuevo="
				+ STOCK_STAND_ZONA_idzona_Nuevo + ", STOCK_JUGUETE_idJuguete_Nuevo=" + STOCK_JUGUETE_idJuguete_Nuevo
				+ ", EMPLEADO_idEMPLEADO=" + EMPLEADO_idEMPLEADO + "]";
	}

}
