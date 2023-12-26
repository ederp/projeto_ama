package com.ama.springboot.service;

import com.ama.springboot.model.Produto;
import com.ama.springboot.model.ProdutoCreate;
import com.ama.springboot.model.ProdutoUpdate;

public class ProdutoMapperImpl implements ProdutoMapper {
	
	@Override
	public Produto updateToProduto(ProdutoUpdate produtoUpdate, Integer id) {
		// TODO Auto-generated method stub
		return new Produto(produtoUpdate.getId(),
				produtoUpdate.getNome(),
				produtoUpdate.isAtivo(),
				produtoUpdate.getSku(),
				produtoUpdate.getCategoria(),
				produtoUpdate.getValorCusto(),
				produtoUpdate.getIcms(),
				produtoUpdate.getValorVenda(),
				produtoUpdate.getImagem(),
				produtoUpdate.getQuantidadeEstoque(),
				id);
	}

	@Override
	public Produto createToProduto(ProdutoCreate produtoCreate, Integer id) {
		// TODO Auto-generated method stub
		return new Produto(produtoCreate.getNome(),
				produtoCreate.isAtivo(),
				produtoCreate.getSku(),
				produtoCreate.getCategoria(),
				produtoCreate.getValorCusto(),
				produtoCreate.getIcms(),
				produtoCreate.getValorVenda(),
				produtoCreate.getImagem(),
				produtoCreate.getQuantidadeEstoque(),
				id);
	}

}
