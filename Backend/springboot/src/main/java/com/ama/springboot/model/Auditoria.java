package com.ama.springboot.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Auditoria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "tabela")
	private String nomeTabela;
	private String operacao;
	private String campo;
	@Column(name = "valor_anterior")
	private String valorAnterior;
	@Column(name = "valor_atual")
	private String valorAtual;
	@Column(name = "data_hora")
	private LocalDateTime dataHora;
	@Column(name = "nome_usuario")
	private String nomeUsuario;
	
	public Auditoria(String nomeTabela, String operacao, String campo, String valorAnterior, String valorAtual,
			LocalDateTime dataHora, String nomeUsuario) {
		super();
		this.nomeTabela = nomeTabela;
		this.operacao = operacao;
		this.campo = campo;
		this.valorAnterior = valorAnterior;
		this.valorAtual = valorAtual;
		this.dataHora = dataHora;
		this.nomeUsuario = nomeUsuario;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTabela() {
		return nomeTabela;
	}

	public void setNomeTabela(String nomeTabela) {
		this.nomeTabela = nomeTabela;
	}

	public String getOperacao() {
		return operacao;
	}

	public void setOperacao(String operacao) {
		this.operacao = operacao;
	}
	

	public String getCampo() {
		return campo;
	}

	public void setCampo(String campo) {
		this.campo = campo;
	}

	public String getValorAnterior() {
		return valorAnterior;
	}

	public void setValorAnterior(String valorAnterior) {
		this.valorAnterior = valorAnterior;
	}

	public String getValorAtual() {
		return valorAtual;
	}

	public void setValorAtual(String valorAtual) {
		this.valorAtual = valorAtual;
	}

	public LocalDateTime getDataHora() {
		return dataHora;
	}

	public void setDataHora(LocalDateTime dataHora) {
		this.dataHora = dataHora;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campo == null) ? 0 : campo.hashCode());
		result = prime * result + ((dataHora == null) ? 0 : dataHora.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nomeTabela == null) ? 0 : nomeTabela.hashCode());
		result = prime * result + ((nomeUsuario == null) ? 0 : nomeUsuario.hashCode());
		result = prime * result + ((operacao == null) ? 0 : operacao.hashCode());
		result = prime * result + ((valorAnterior == null) ? 0 : valorAnterior.hashCode());
		result = prime * result + ((valorAtual == null) ? 0 : valorAtual.hashCode());
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
		Auditoria other = (Auditoria) obj;
		if (campo == null) {
			if (other.campo != null)
				return false;
		} else if (!campo.equals(other.campo))
			return false;
		if (dataHora == null) {
			if (other.dataHora != null)
				return false;
		} else if (!dataHora.equals(other.dataHora))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nomeTabela == null) {
			if (other.nomeTabela != null)
				return false;
		} else if (!nomeTabela.equals(other.nomeTabela))
			return false;
		if (nomeUsuario == null) {
			if (other.nomeUsuario != null)
				return false;
		} else if (!nomeUsuario.equals(other.nomeUsuario))
			return false;
		if (operacao == null) {
			if (other.operacao != null)
				return false;
		} else if (!operacao.equals(other.operacao))
			return false;
		if (valorAnterior == null) {
			if (other.valorAnterior != null)
				return false;
		} else if (!valorAnterior.equals(other.valorAnterior))
			return false;
		if (valorAtual == null) {
			if (other.valorAtual != null)
				return false;
		} else if (!valorAtual.equals(other.valorAtual))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Auditoria [id=" + id + ", nomeTabela=" + nomeTabela + ", operacao=" + operacao + ", campo=" + campo
				+ ", valorAnterior=" + valorAnterior + ", valorAtual=" + valorAtual + ", dataHora=" + dataHora
				+ ", nomeUsuario=" + nomeUsuario + "]";
	}
	
}
