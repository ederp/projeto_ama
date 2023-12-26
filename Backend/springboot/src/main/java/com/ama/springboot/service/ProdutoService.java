package com.ama.springboot.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.ama.springboot.model.Auditoria;
import com.ama.springboot.model.Produto;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private AuditoriaRepository auditoriaRepository;

	private final DateTimeFormatter dtf = DateTimeFormatter.ISO_LOCAL_DATE_TIME;

    public ProdutoService() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Produto> getListaProduto(){
    	return this.produtoRepository.findAll();
    }
	
	public Produto cadastraProduto(Produto produto) {
		Produto produtoCadastrado = this.produtoRepository.save(produto);
		if (produtoCadastrado != null) {
			this.geraAuditoria("Inclusão", "", "", "");
		}		
		return this.produtoRepository.save(produto);
	}
	
	public Produto consultaProduto(Integer id) {
		return this.getProduto(id).get();
	}
	
	public String excluiProduto(Integer id) {
		Produto produto = this.getProduto(id).get();
		if(produto != null) {
			this.produtoRepository.delete(produto);
			this.geraAuditoria("Exclusão", "", "", "");
			return "Produto excluído com sucesso";
		}
		return "Produto não encontrado";
	}
	
	public String atualizaProduto(Integer id, Produto novoProduto) {
		Produto produtoAtual = this.getProduto(id).get();
		if(produtoAtual != null) {
			if(produtoAtual.getNome() != novoProduto.getNome()) {
				this.geraAuditoria("Alteração", "Nome", produtoAtual.getNome(), novoProduto.getNome());
			}
			if(produtoAtual.getSku() != novoProduto.getSku()) {
				this.geraAuditoria("Alteração", "SKU", produtoAtual.getSku(), novoProduto.getSku());
			}
			if(produtoAtual.getCategoria() != novoProduto.getCategoria()) {
				this.geraAuditoria("Alteração", "Categoria", produtoAtual.getCategoria().toString(), novoProduto.getCategoria().toString());
			}
			if(produtoAtual.getValorCusto() != novoProduto.getValorCusto()) {
				this.geraAuditoria("Alteração", "Valor de Custo", produtoAtual.getValorCusto().toString(), novoProduto.getValorCusto().toString());
			}
			if(produtoAtual.getIcms() != novoProduto.getIcms()) {
				this.geraAuditoria("Alteração", "ICMS", produtoAtual.getIcms().toString(), novoProduto.getIcms().toString());
			}
			if(produtoAtual.getValorVenda() != novoProduto.getValorVenda()) {
				this.geraAuditoria("Alteração", "Valor de Venda", produtoAtual.getValorVenda().toString(), novoProduto.getValorVenda().toString());
			}
			if(produtoAtual.getImagem() != novoProduto.getImagem()) {
				this.geraAuditoria("Alteração", "Imagem", produtoAtual.getImagem(), novoProduto.getImagem());
			}
			if(produtoAtual.getQuantidadeEstoque() != novoProduto.getQuantidadeEstoque() ) {
				this.geraAuditoria("Alteração", "Quantidade no estoque", produtoAtual.getQuantidadeEstoque().toString() , novoProduto.getQuantidadeEstoque().toString());
			}
			
			
			this.produtoRepository.findById(id).ifPresent(produto1 -> {
				produto1.setNome(novoProduto.getNome());
				produto1.setAtivo(novoProduto.isAtivo());
				produto1.setSku(novoProduto.getSku());
				produto1.setCategoria(novoProduto.getCategoria());
				produto1.setValorCusto(novoProduto.getValorCusto());
				produto1.setIcms(novoProduto.getIcms());
				produto1.setValorVenda(novoProduto.getValorVenda());
				produto1.setImagem(novoProduto.getImagem());
				produto1.setQuantidadeEstoque(novoProduto.getQuantidadeEstoque());
				
				this.produtoRepository.save(produto1);
			});
			
			return "Produto atualizado com sucesso";
		}
		return "Produto não encontrado";
	}
	
	private Optional<Produto> getProduto(Integer id){
		return Optional.of(this.produtoRepository.getReferenceById(id));
	}
	
	private void geraAuditoria(String operacao, String campo, String valorAnterior, String valorAtual) {
		String usuario = SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString();
		Auditoria auditoria = new Auditoria("produto", 
				operacao,
				campo,
				valorAnterior, 
				valorAtual, 
				LocalDateTime.parse(LocalDateTime.now().format(dtf)), 
				usuario);
		this.auditoriaRepository.save(auditoria);
	}
    
}
