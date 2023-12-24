package com.ama.springboot.api;

import com.ama.springboot.exception.TokenRefreshException;
import com.ama.springboot.model.AuthTokenBody;
import com.ama.springboot.model.RefreshToken;
import com.ama.springboot.model.TokenRefreshRequest;
import com.ama.springboot.model.TokenRefreshResponse;
import com.ama.springboot.service.JwtTokenUtil;
import com.ama.springboot.service.RefreshTokenService;

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
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")
@RestController
@CrossOrigin(origins = "http://localhost:4200/") 
public class AuthApiController implements AuthApi {

    private static final Logger log = LoggerFactory.getLogger(AuthApiController.class);
    @Autowired
    private final AuthenticationManager authenticationManager;
    @Autowired
    RefreshTokenService refreshTokenService;
    
    private final JwtTokenUtil jwtTokenUtil;

    @org.springframework.beans.factory.annotation.Autowired
    public AuthApiController(AuthenticationManager authenticationManager,
    		JwtTokenUtil jwtTokenUtil, RefreshTokenService refreshTokenService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.refreshTokenService = refreshTokenService;
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
            RefreshToken refreshToken = refreshTokenService.createRefreshToken(user.getUsername());
            TokenRefreshResponse response = new TokenRefreshResponse(token, refreshToken.getToken());

            return ResponseEntity.ok(response.toString());

        } catch (BadCredentialsException ex) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Acesso não autorizado. Verifique seu login e senha ou se você possui autorização para acessar esta área.");
        } catch (Exception ex) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
            		.body("A autenticação falhou.");
        }
    }

	@Override
	public ResponseEntity refreshtoken(@Valid TokenRefreshRequest request) {
		// TODO Auto-generated method stub
		 String requestRefreshToken = request.getRefreshToken();

		    return refreshTokenService.findByToken(requestRefreshToken)
		        .map(refreshTokenService::verifyExpiration)
		        .map(RefreshToken::getUsuario)
		        .map(user -> {
		          String token = jwtTokenUtil.createToken((UserDetails) user);
		          return ResponseEntity.ok(new TokenRefreshResponse(token, requestRefreshToken));
		        })
		        .orElseThrow(() -> new TokenRefreshException(requestRefreshToken,
		            "Refresh token não está na base de dados!"));
	}
}