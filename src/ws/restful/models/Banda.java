package ws.restful.models;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Banda {
	private String nome;
	private int anoFormacao;
	private int id;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public int getAnoFormacao() {
		return anoFormacao;
	}
	public void setAnoFormacao(int anoFormacao) {
		this.anoFormacao = anoFormacao;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	

}
