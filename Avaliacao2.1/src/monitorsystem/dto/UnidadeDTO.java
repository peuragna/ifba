package monitorsystem.dto;

import monitorsystem.Equipamentos;

public class UnidadeDTO {
	private String id;
    private Equipamentos configuracao;
    private float x, y;
    private int tipo;
    
	public UnidadeDTO(String id, Equipamentos configuracao, float x, float y, int tipo) {
		this.id = id;
		this.configuracao = configuracao;
		this.x = x;
		this.y = y;
		this.tipo = tipo;
	};
	
	public int getTipo() {
		return tipo;
	}

	public void setTipo(int tipo) {
		this.tipo = tipo;
	}

	public String getId() {
		return id;
	};
	
	public void setId(String id) {
		this.id = id;
	};
	
	public Equipamentos getConfiguracao() {
		return configuracao;
	};
	
	public void setConfiguracao(Equipamentos configuracao) {
		this.configuracao = configuracao;
	};
	
	public float getX() {
		return x;
	};
	
	public void setX(float x) {
		this.x = x;
	};
	
	public float getY() {
		return y;
	};
	
	public void setY(float y) {
		this.y = y;
	};
}
