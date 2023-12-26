package com.ama.springboot.api;

import com.ama.springboot.model.Produto;
import com.ama.springboot.model.ProdutoCreate;
import com.ama.springboot.model.ProdutoUpdate;
import com.ama.springboot.model.Usuario;
import com.ama.springboot.service.ProdutoMapper;
import com.ama.springboot.service.ProdutoService;
import com.ama.springboot.service.UsuarioRepository;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import javax.validation.Valid;
import java.util.List;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")
@RestController
@CrossOrigin(origins = "http://localhost:4200/") 
public class ProdutosApiController implements ProdutosApi {

    private static final Logger log = LoggerFactory.getLogger(ProdutosApiController.class);
    
    private final ProdutoService produtoService;
	private final UsuarioRepository usuarioRepository;
    
 
	@Autowired
	public ProdutosApiController(ProdutoService produtoService, UsuarioRepository usuarioRepository) {
		super();
		this.produtoService = produtoService;
		this.usuarioRepository = usuarioRepository;
	}

	public ResponseEntity<?> produtosGet() {
        if (!this.produtoService.getListaProduto().isEmpty()) {
            return new ResponseEntity<List<Produto>>(this.produtoService.getListaProduto(), HttpStatus.OK);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }

    public ResponseEntity<?> produtosIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID do produto", required=true, schema=@Schema()) @PathVariable("id") Integer id
) {
    	String response = this.produtoService.excluiProduto(id);
        if (response.contains("Produto excluído com sucesso")) {
        	return ResponseEntity.status(HttpStatus.NO_CONTENT).body(response);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    public ResponseEntity<?> produtosIdGet(@Parameter(in = ParameterIn.PATH, description = "ID do produto", required=true, schema=@Schema()) @PathVariable("id") Integer id
) {
    	Produto produto = this.produtoService.consultaProduto(id);
    	if(produto != null) {
    		return new ResponseEntity<Produto>(produto, HttpStatus.OK);
    	}
    	
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Produto não encontrado");
    }

    public ResponseEntity<?> produtosIdPut(@Parameter(in = ParameterIn.PATH, description = "ID do produto", required=true, schema=@Schema()) @PathVariable("id") Integer id
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ProdutoUpdate body
) {
    	Usuario usuario = this.usuarioRepository.findByUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
    	String response = this.produtoService.atualizaProduto(id, ProdutoMapper.INSTANCE.updateToProduto(body, usuario.getId()));
    	if(response.contains("Produto atualizado com sucesso")) {
    		return ResponseEntity.status(HttpStatus.OK).body(response);
    	}
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }

    public ResponseEntity<?> produtosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ProdutoCreate body
) {
    	Usuario usuario = this.usuarioRepository.findByUsuario(SecurityContextHolder.getContext().getAuthentication().getName());
    	if(this.produtoService.cadastraProduto(ProdutoMapper.INSTANCE.createToProduto(body, usuario.getId())) != null) {
    		return ResponseEntity.status(HttpStatus.CREATED).body("Produto criado com sucesso");
    	}
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao cadastrar produto");
    }

}
