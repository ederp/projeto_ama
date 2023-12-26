/**
 * NOTE: This class is auto generated by the swagger code generator program (3.0.51).
 * https://github.com/swagger-api/swagger-codegen
 * Do not edit the class manually.
 */
package com.ama.springboot.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import com.ama.springboot.model.Produto;
import com.ama.springboot.model.ProdutoCreate;
import com.ama.springboot.model.ProdutoUpdate;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.*;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")
@Validated
public interface ProdutosApi {

    @Operation(summary = "Lista produtos com paginação, ordenação e filtros", description = "", security = {
        @SecurityRequirement(name = "jwt")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Lista de produtos", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))) })
    @RequestMapping(value = "/produtos",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    @PreAuthorize(value = "isAuthenticated()")
    ResponseEntity<?> produtosGet();


    @Operation(summary = "Exclui um produto por ID", description = "", security = {
        @SecurityRequirement(name = "jwt")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "204", description = "Produto excluído com sucesso"),
        @ApiResponse(responseCode = "404", description = "Produto não encontrado") })
    @RequestMapping(value = "/produtos/{id}",
        method = RequestMethod.DELETE)
    @PreAuthorize(value = "isAuthenticated()")
    ResponseEntity<?> produtosIdDelete(@Parameter(in = ParameterIn.PATH, description = "ID do produto", required=true, schema=@Schema()) @PathVariable("id") Integer id
);


    @Operation(summary = "Obtém detalhes de um produto por ID", description = "", security = {
        @SecurityRequirement(name = "jwt")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Detalhes do produto", content = @Content(mediaType = "application/json", schema = @Schema(implementation = Produto.class))),
        
        @ApiResponse(responseCode = "404", description = "Produto não encontrado") })
    @RequestMapping(value = "/produtos/{id}",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    @PreAuthorize(value = "isAuthenticated()")
    ResponseEntity<?> produtosIdGet(@Parameter(in = ParameterIn.PATH, description = "ID do produto", required=true, schema=@Schema()) @PathVariable("id") Integer id
);


    @Operation(summary = "Atualiza um produto por ID", description = "", security = {
        @SecurityRequirement(name = "jwt")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "Produto atualizado com sucesso"),
        
        @ApiResponse(responseCode = "404", description = "Produto não encontrado") })
    @RequestMapping(value = "/produtos/{id}",
        consumes = { "application/json" }, 
        method = RequestMethod.PUT)
    @PreAuthorize(value = "isAuthenticated()")
    ResponseEntity<?> produtosIdPut(@Parameter(in = ParameterIn.PATH, description = "ID do produto", required=true, schema=@Schema()) @PathVariable("id") Integer id
, @Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ProdutoUpdate body
);


    @Operation(summary = "Cria um novo produto", description = "", security = {
        @SecurityRequirement(name = "jwt")    }, tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Produto criado com sucesso") })
    @RequestMapping(value = "/produtos",
        consumes = { "application/json" }, 
        method = RequestMethod.POST)
    @PreAuthorize(value = "isAuthenticated()")
    ResponseEntity<?> produtosPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) @Valid @RequestBody ProdutoCreate body
);

}

