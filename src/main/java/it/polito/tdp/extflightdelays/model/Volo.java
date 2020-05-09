package it.polito.tdp.extflightdelays.model;

public class Volo {
	
	private Integer idPartenza;
	private Integer idArrivo;
	private Integer peso;
	
	
	public Volo(Integer idPartenza, Integer idArrivo, Integer peso) {
		super();
		this.idPartenza = idPartenza;
		this.idArrivo = idArrivo;
		this.peso = peso;
	}
	
	public Integer getIdPartenza() {
		return idPartenza;
	}
	public void setIdPartenza(Integer idPartenza) {
		this.idPartenza = idPartenza;
	}
	public Integer getIdArrivo() {
		return idArrivo;
	}
	public void setIdArrivo(Integer idArrivo) {
		this.idArrivo = idArrivo;
	}
	public Integer getPeso() {
		return peso;
	}
	public void setPeso(Integer peso) {
		this.peso = peso;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((idArrivo == null) ? 0 : idArrivo.hashCode());
		result = prime * result + ((idPartenza == null) ? 0 : idPartenza.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Volo other = (Volo) obj;
		if (idArrivo == null) {
			if (other.idArrivo != null)
				return false;
		} else if (!idArrivo.equals(other.idArrivo))
			return false;
		if (idPartenza == null) {
			if (other.idPartenza != null)
				return false;
		} else if (!idPartenza.equals(other.idPartenza))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return String.format("%-10s %-20s %-20s", idPartenza, idArrivo, peso);
	}
	
	

}
