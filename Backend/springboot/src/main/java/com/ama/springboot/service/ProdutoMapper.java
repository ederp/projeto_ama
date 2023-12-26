package com.ama.springboot.service;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.ama.springboot.model.Produto;
import com.ama.springboot.model.ProdutoCreate;
import com.ama.springboot.model.ProdutoUpdate;

@Mapper
public interface ProdutoMapper {
	ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);
	Produto updateToProduto(ProdutoUpdate produtoUpdate, Integer id);
	Produto createToProduto(ProdutoCreate produtoCreate, Integer id);
}
