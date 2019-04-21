package br.com.ealves.financeira.model;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Emprestimo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codigo;
	private String nomeCliente;
	private double limiteCredito;
	private Integer tipo;

	public Emprestimo() {
		super();
	}

	public Emprestimo(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public Emprestimo(Long codigo, String nomeCliente, double limiteCredito, TipoRisco tipo) {
		super();
		this.codigo = codigo;
		this.nomeCliente = nomeCliente;
		this.limiteCredito = limiteCredito;
		this.tipo = tipo.getCod();
	}

	public Long getCodigo() {
		return codigo;
	}

	public void setCodigo(Long codigo) {
		this.codigo = codigo;
	}

	public String getNomeCliente() {
		return nomeCliente;
	}

	public void setNomeCliente(String nomeCliente) {
		this.nomeCliente = nomeCliente;
	}

	public double getLimiteCredito() {
		return limiteCredito;
	}

	public void setLimiteCredito(double limiteCredito) {
		this.limiteCredito = limiteCredito;
	}

	public TipoRisco getTipo() {
		return TipoRisco.toEnum(tipo);
	}

	public void setTipo(TipoRisco tipo) {
		this.tipo = tipo.getCod();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Emprestimo other = (Emprestimo) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

}
