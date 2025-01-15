package com.hugodev.eventsystem.entities;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_atividade")
public class Atividade {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	private String descricao;
	private double preco;
	
	@OneToMany(mappedBy = "atv")
	private List<Bloco> bl = new ArrayList<>();
	
	@ManyToMany(mappedBy = "atvv")
	private Set<Participantes> participante = new HashSet<>();
	
	@ManyToOne
	@JoinColumn(name = "categoria_id")
	private Categoria category;
	
	public Atividade() {
	}

	public Atividade(Long id, String name, String descricao, double preco, Categoria category) {
		this.id = id;
		this.name = name;
		this.descricao = descricao;
		this.preco = preco;
		this.category = category;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public List<Bloco> getBloco() {
		return bl;
	}

	public Categoria getCategoria() {
		return category;
	}

	public void setCategoria(Categoria categoria) {
		this.category = categoria;
	}

	public Set<Participantes> getParticipante() {
		return participante;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atividade other = (Atividade) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
