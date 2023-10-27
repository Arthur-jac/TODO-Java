package models;

import java.util.Date;

public class Tarefas {
	// id é autoincrement, toda vez que é adicionado uma tarefa ele soma pelo atributo estático, sendo id=1, id=2, id=3 ...
	private static int nextId = 1;
	private int id;
	private Status status;
	private String descricao;
	private Date prazo;
	
	public Tarefas() {
		this.id = nextId++;
	}

	public int getId() {
		return id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getPrazo() {
		return prazo;
	}

	public void setPrazo(Date prazo) {
		this.prazo = prazo;
	}

	@Override
	public String toString() {
		return "Tarefas [id=" + id + ", status=" + status + ", descricao=" + descricao + ", prazo=" + prazo + "]";
	}
	
}
