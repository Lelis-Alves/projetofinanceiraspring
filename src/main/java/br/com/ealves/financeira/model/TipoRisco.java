package br.com.ealves.financeira.model;

public enum TipoRisco {

	A(1, "A"), B(2, "B"), C(3, "C");

	private int cod;
	private String descricao;

	private TipoRisco(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}

	
	public static TipoRisco toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (TipoRisco x : TipoRisco.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido" + cod);
		
		
		
	}
	
}
