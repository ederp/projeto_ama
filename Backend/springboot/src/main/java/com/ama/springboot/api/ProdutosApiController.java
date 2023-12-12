package com.ama.springboot.api;

import com.ama.springboot.model.InlineResponse2001;
import com.ama.springboot.model.Produto;
import com.ama.springboot.model.ProdutoCreate;
import com.ama.springboot.model.ProdutoUpdate;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;
import javax.validation.constraints.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")
@RestController
public class ProdutosApiController implements ProdutosApi {

    private static final Logger log = LoggerFactory.getLogger(ProdutosApiController.class);

    private final ObjectMapper objectMapper;

    private final HttpServletRequest request;

    @org.springframework.beans.factory.annotation.Autowired
    public ProdutosApiController(ObjectMapper objectMapper, HttpServletRequest request) {
        this.objectMapper = objectMapper;
        this.request = request;
    }

    public ResponseEntity<InlineResponse2001> produtosGet(@Min(1)@Parameter(in = ParameterIn.QUERY, description = "Número da página" ,schema=@Schema(allowableValues={ "1" }, minimum="1"
)) @Valid @RequestParam(value = "page", required = false) Integer page
,@Min(1) @Max(10) @Parameter(in = ParameterIn.QUERY, description = "Quantidade de itens por página" ,schema=@Schema(allowableValues={ "1", "10" }, minimum="1", maximum="10"
)) @Valid @RequestParam(value = "size", required = false) Integer size
,@Parameter(in = ParameterIn.QUERY, description = "Ordenação (ex:+nome, -categoria)" ,schema=@Schema()) @Valid @RequestParam(value = "sort", required = false) String sort
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<InlineResponse2001>(objectMapper.readValue("{\n  \"number\" : 3,\n  \"last\" : true,\n  \"size\" : 9,\n  \"totalPages\" : 2,\n  \"sort\" : { },\n  \"content\" : [ {\n    \"icms\" : 1.4658129805029452,\n    \"ativo\" : true,\n    \"valorCusto\" : 6.027456183070403,\n    \"valorVenda\" : 5.962133916683182,\n    \"categoria\" : \"categoria\",\n    \"imagem\" : \"imagem\",\n    \"nome\" : \"nome\",\n    \"quantidadeEstoque\" : 5,\n    \"id\" : 0,\n    \"sku\" : \"sku\",\n    \"dataCadastro\" : \"2000-01-23\"\n  }, {\n    \"icms\" : 1.4658129805029452,\n    \"ativo\" : true,\n    \"valorCusto\" : 6.027456183070403,\n    \"valorVenda\" : 5.962133916683182,\n    \"categoria\" : \"categoria\",\n    \"imagem\" : \"imagem\",\n    \"nome\" : \"nome\",\n    \"quantidadeEstoque\" : 5,\n    \"id\" : 0,\n    \"sku\" : \"sku\",\n    \"dataCadastro\" : \"2000-01-23\"\n  } ],\n  \"totalElements\" : 7\n}", InlineResponse2001.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<InlineResponse2001>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<InlineResponse2001>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> produtosIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID do produto", required=true, schema=@Schema()) @PathVariable("id") Integer id
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Produto> produtosIdGet(@Parameter(in = ParameterIn.PATH, description = "ID do produto", required=true, schema=@Schema()) @PathVariable("id") Integer id
) {
        String accept = request.getHeader("Accept");
        if (accept != null && accept.contains("application/json")) {
            try {
                return new ResponseEntity<Produto>(objectMapper.readValue("{\n  \"icms\" : 1.4658129805029452,\n  \"ativo\" : true,\n  \"valorCusto\" : 6.027456183070403,\n  \"valorVenda\" : 5.962133916683182,\n  \"categoria\" : \"categoria\",\n  \"imagem\" : \"imagem\",\n  \"nome\" : \"nome\",\n  \"quantidadeEstoque\" : 5,\n  \"id\" : 0,\n  \"sku\" : \"sku\",\n  \"dataCadastro\" : \"2000-01-23\"\n}", Produto.class), HttpStatus.NOT_IMPLEMENTED);
            } catch (IOException e) {
                log.error("Couldn't serialize response for content type application/json", e);
                return new ResponseEntity<Produto>(HttpStatus.INTERNAL_SERVER_ERROR);
            }
        }

        return new ResponseEntity<Produto>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> produtosIdPut(@Parameter(in = ParameterIn.PATH, description = "ID do produto", required=true, schema=@Schema()) @PathVariable("id") Integer id
,@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ProdutoUpdate body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

    public ResponseEntity<Void> produtosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ProdutoCreate body
) {
        String accept = request.getHeader("Accept");
        return new ResponseEntity<Void>(HttpStatus.NOT_IMPLEMENTED);
    }

}
