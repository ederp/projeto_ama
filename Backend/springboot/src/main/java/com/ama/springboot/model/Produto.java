package com.ama.springboot.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.math.BigDecimal;
import org.threeten.bp.LocalDate;
import org.springframework.validation.annotation.Validated;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;

/**
 * Produto
 */
@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")
@Entity
@Table(name = "produtos")
public class Produto   {
  @JsonProperty("id")
  @Id
  private Integer id;

  @JsonProperty("nome")
  private String nome;

  @JsonProperty("ativo")
  private Boolean ativo;

  @JsonProperty("sku")
  private String sku;

  @JoinColumn
  @JsonProperty("categoria")
  private Integer categoria;

  @JsonProperty("valorCusto")
  private BigDecimal valorCusto;

  @JsonProperty("icms")
  private BigDecimal icms;

  @JsonProperty("valorVenda")
  private BigDecimal valorVenda;

  @JsonProperty("imagem")
  private String imagem;

  @JsonProperty("dataCadastro")
  private LocalDate dataCadastro;

  @JsonProperty("quantidadeEstoque")
  private Integer quantidadeEstoque;
  
  

  public Produto() {
	super();
	// TODO Auto-generated constructor stub
  }
  
  

public Produto(Integer id, String nome, Boolean ativo, String sku, Integer categoria, BigDecimal valorCusto,
		BigDecimal icms, BigDecimal valorVenda, String imagem, LocalDate dataCadastro, Integer quantidadeEstoque) {
	super();
	this.id = id;
	this.nome = nome;
	this.ativo = ativo;
	this.sku = sku;
	this.categoria = categoria;
	this.valorCusto = valorCusto;
	this.icms = icms;
	this.valorVenda = valorVenda;
	this.imagem = imagem;
	this.dataCadastro = dataCadastro;
	this.quantidadeEstoque = quantidadeEstoque;
}



public Produto id(Integer id) {
    this.id = id;
    return this;
  }

  /**
   * Get id
   * @return id
   **/
  @Schema(description = "")
  
    public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Produto nome(String nome) {
    this.nome = nome;
    return this;
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

  public Produto ativo(Boolean ativo) {
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

  public Produto sku(String sku) {
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

  public Produto categoria(Integer categoria) {
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

  public Produto valorCusto(BigDecimal valorCusto) {
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

  public Produto icms(BigDecimal icms) {
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

  public Produto valorVenda(BigDecimal valorVenda) {
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

  public Produto imagem(String imagem) {
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

  public Produto dataCadastro(LocalDate dataCadastro) {
    this.dataCadastro = dataCadastro;
    return this;
  }

  /**
   * Get dataCadastro
   * @return dataCadastro
   **/
  @Schema(description = "")
  
    @Valid
    public LocalDate getDataCadastro() {
    return dataCadastro;
  }

  public void setDataCadastro(LocalDate dataCadastro) {
    this.dataCadastro = dataCadastro;
  }

  public Produto quantidadeEstoque(Integer quantidadeEstoque) {
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
    Produto produto = (Produto) o;
    return Objects.equals(this.id, produto.id) &&
        Objects.equals(this.nome, produto.nome) &&
        Objects.equals(this.ativo, produto.ativo) &&
        Objects.equals(this.sku, produto.sku) &&
        Objects.equals(this.categoria, produto.categoria) &&
        Objects.equals(this.valorCusto, produto.valorCusto) &&
        Objects.equals(this.icms, produto.icms) &&
        Objects.equals(this.valorVenda, produto.valorVenda) &&
        Objects.equals(this.imagem, produto.imagem) &&
        Objects.equals(this.dataCadastro, produto.dataCadastro) &&
        Objects.equals(this.quantidadeEstoque, produto.quantidadeEstoque);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, nome, ativo, sku, categoria, valorCusto, icms, valorVenda, imagem, dataCadastro, quantidadeEstoque);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class Produto {\n");
    
    sb.append("    id: ").append(toIndentedString(id)).append("\n");
    sb.append("    nome: ").append(toIndentedString(nome)).append("\n");
    sb.append("    ativo: ").append(toIndentedString(ativo)).append("\n");
    sb.append("    sku: ").append(toIndentedString(sku)).append("\n");
    sb.append("    categoria: ").append(toIndentedString(categoria)).append("\n");
    sb.append("    valorCusto: ").append(toIndentedString(valorCusto)).append("\n");
    sb.append("    icms: ").append(toIndentedString(icms)).append("\n");
    sb.append("    valorVenda: ").append(toIndentedString(valorVenda)).append("\n");
    sb.append("    imagem: ").append(toIndentedString(imagem)).append("\n");
    sb.append("    dataCadastro: ").append(toIndentedString(dataCadastro)).append("\n");
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
