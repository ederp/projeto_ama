package com.ama.springboot.api;

import com.ama.springboot.configuration.JwtTokenUtil;
import com.ama.springboot.model.AuthTokenBody;
import com.ama.springboot.model.InlineResponse200;
import com.ama.springboot.model.Usuario;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Schema;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")
@RestController
public class AuthApiController implements AuthApi {

    private static final Logger log = LoggerFactory.getLogger(AuthApiController.class);
    @Autowired
    private final AuthenticationManager authenticationManager;
    
    private final JwtTokenUtil jwtTokenUtil;

    @org.springframework.beans.factory.annotation.Autowired
    public AuthApiController(AuthenticationManager authenticationManager,
    		JwtTokenUtil jwtTokenUtil) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
    }

    public ResponseEntity authTokenPost(@Parameter(in = ParameterIn.DEFAULT, description = "", required=true, schema=@Schema()) 
    @Valid @RequestBody AuthTokenBody body) {
    	try {
            Authentication authenticate = authenticationManager
                .authenticate(
                    new UsernamePasswordAuthenticationToken(
                        body.getUsername(), body.getPassword()
                    )
                );
            UserDetails user = (UserDetails) authenticate.getPrincipal();
            String token = jwtTokenUtil.createToken(user);
            InlineResponse200 response = new InlineResponse200(token);

            return ResponseEntity.ok(response.toString());

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso não autorizado. Verifique seu login e senha ou se você possui autorização para acessar esta área.");
        } catch (Exception ex) {
        	System.out.println(ex.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            		.body("A autenticação falhou.");
        }
    }
}