package domain;

public class Stock {

	int STAND_idStand;
	int STAND_ZONA_idzona;
	int JUGUETE_idJuguete;
	int CANTIDAD;

	public Stock(int sTAND_idStand, int sTAND_ZONA_idzona, int jUGUETE_idJuguete, int cANTIDAD) {
		super();
		STAND_idStand = sTAND_idStand;
		STAND_ZONA_idzona = sTAND_ZONA_idzona;
		JUGUETE_idJuguete = jUGUETE_idJuguete;
		CANTIDAD = cANTIDAD;
	}

	public int getSTAND_idStand() {
		return STAND_idStand;
	}

	public void setSTAND_idStand(int sTAND_idStand) {
		STAND_idStand = sTAND_idStand;
	}

	public int getSTAND_ZONA_idzona() {
		return STAND_ZONA_idzona;
	}

	public void setSTAND_ZONA_idzona(int sTAND_ZONA_idzona) {
		STAND_ZONA_idzona = sTAND_ZONA_idzona;
	}

	public int getJUGUETE_idJuguete() {
		return JUGUETE_idJuguete;
	}

	public void setJUGUETE_idJuguete(int jUGUETE_idJuguete) {
		JUGUETE_idJuguete = jUGUETE_idJuguete;
	}

	public int getCANTIDAD() {
		return CANTIDAD;
	}

	public void setCANTIDAD(int cANTIDAD) {
		CANTIDAD = cANTIDAD;
	}

	@Override
	public String toString() {
		return "Stock [STAND_idStand=" + STAND_idStand + ", STAND_ZONA_idzona=" + STAND_ZONA_idzona
				+ ", JUGUETE_idJuguete=" + JUGUETE_idJuguete + ", CANTIDAD=" + CANTIDAD + "]";
	}

}
