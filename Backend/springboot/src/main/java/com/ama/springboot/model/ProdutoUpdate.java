package com.ama.springboot.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.springframework.validation.annotation.Validated;
import javax.validation.Valid;

/**
 * ProdutoUpdate
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")


public class ProdutoUpdate   {
	@JsonProperty("id")
	private Integer id = null;
	
	@JsonProperty("nome")
	private String nome = null;

	@JsonProperty("ativo")
	private Boolean ativo = null;

	@JsonProperty("sku")
	private String sku = null;

	@JsonProperty("categoria")
	private Integer categoria = null;

	@JsonProperty("valorCusto")
	private BigDecimal valorCusto = null;

	@JsonProperty("icms")
	private BigDecimal icms = null;

	@JsonProperty("valorVenda")
	private BigDecimal valorVenda = null;

	@JsonProperty("imagem")
	private String imagem = null;

	@JsonProperty("quantidadeEstoque")
	private Integer quantidadeEstoque = null;

	public ProdutoUpdate nome(String nome) {
		this.nome = nome;
		return this;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	/**
	 * Get nome
	 * @return nome
	 **/
	@Schema(description = "")

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public ProdutoUpdate ativo(Boolean ativo) {
		this.ativo = ativo;
		return this;
	}

	/**
	 * Get ativo
	 * @return ativo
	 **/
	@Schema(description = "")

	public Boolean isAtivo() {
		return ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	public ProdutoUpdate sku(String sku) {
		this.sku = sku;
		return this;
	}

	/**
	 * Get sku
	 * @return sku
	 **/
	@Schema(description = "")

	public String getSku() {
		return sku;
	}

	public void setSku(String sku) {
		this.sku = sku;
	}

	public ProdutoUpdate categoria(Integer categoria) {
		this.categoria = categoria;
		return this;
	}

	/**
	 * Get categoria
	 * @return categoria
	 **/
	@Schema(description = "")

	public Integer getCategoria() {
		return categoria;
	}

	public void setCategoria(Integer categoria) {
		this.categoria = categoria;
	}

	public ProdutoUpdate valorCusto(BigDecimal valorCusto) {
		this.valorCusto = valorCusto;
		return this;
	}

	/**
	 * Get valorCusto
	 * @return valorCusto
	 **/
	@Schema(description = "")

	@Valid
	public BigDecimal getValorCusto() {
		return valorCusto;
	}

	public void setValorCusto(BigDecimal valorCusto) {
		this.valorCusto = valorCusto;
	}

	public ProdutoUpdate icms(BigDecimal icms) {
		this.icms = icms;
		return this;
	}

	/**
	 * Get icms
	 * @return icms
	 **/
	@Schema(description = "")

	@Valid
	public BigDecimal getIcms() {
		return icms;
	}

	public void setIcms(BigDecimal icms) {
		this.icms = icms;
	}

	public ProdutoUpdate valorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
		return this;
	}

	/**
	 * Get valorVenda
	 * @return valorVenda
	 **/
	@Schema(description = "")

	@Valid
	public BigDecimal getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}

	public ProdutoUpdate imagem(String imagem) {
		this.imagem = imagem;
		return this;
	}

	/**
	 * Get imagem
	 * @return imagem
	 **/
	@Schema(description = "")

	public String getImagem() {
		return imagem;
	}

	public void setImagem(String imagem) {
		this.imagem = imagem;
	}

	public ProdutoUpdate quantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
		return this;
	}

	/**
	 * Get quantidadeEstoque
	 * @return quantidadeEstoque
	 **/
	@Schema(description = "")

	public Integer getQuantidadeEstoque() {
		return quantidadeEstoque;
	}

	public void setQuantidadeEstoque(Integer quantidadeEstoque) {
		this.quantidadeEstoque = quantidadeEstoque;
	}


	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		ProdutoUpdate produtoUpdate = (ProdutoUpdate) o;
		return Objects.equals(this.nome, produtoUpdate.nome) &&
				Objects.equals(this.ativo, produtoUpdate.ativo) &&
				Objects.equals(this.sku, produtoUpdate.sku) &&
				Objects.equals(this.categoria, produtoUpdate.categoria) &&
				Objects.equals(this.valorCusto, produtoUpdate.valorCusto) &&
				Objects.equals(this.icms, produtoUpdate.icms) &&
				Objects.equals(this.valorVenda, produtoUpdate.valorVenda) &&
				Objects.equals(this.imagem, produtoUpdate.imagem) &&
				Objects.equals(this.quantidadeEstoque, produtoUpdate.quantidadeEstoque);
	}

	@Override
	public int hashCode() {
		return Objects.hash(nome, ativo, sku, categoria, valorCusto, icms, valorVenda, imagem, quantidadeEstoque);
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("class ProdutoUpdate {\n");

		sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
		sb.append("    ativo: ").append(toIndentedString(ativo)).append("\n");
		sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
		sb.append("    categoria: ").append(toIndentedString(categoria)).append("\n");
		sb.append("    valorCusto: ").append(toIndentedString(valorCusto)).append("\n");
		sb.append("    icms: ").append(toIndentedString(icms)).append("\n");
		sb.append("    valorVenda: ").append(toIndentedString(valorVenda)).append("\n");
		sb.append("    imagem: ").append(toIndentedString(imagem)).append("\n");
		sb.append("    quantidadeEstoque: ").append(toIndentedString(quantidadeEstoque)).append("\n");
		sb.append("}");
		return sb.toString();
	}

	/**
	 * Convert the given object to string with each line indented by 4 spaces
	 * (except the first line).
	 */
	private String toIndentedString(java.lang.Object o) {
		if (o == null) {
			return "null";
		}
		return o.toString().replace("\n", "\n    ");
	}
}
