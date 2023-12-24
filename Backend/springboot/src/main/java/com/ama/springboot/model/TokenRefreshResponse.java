package com.ama.springboot.model;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.validation.annotation.Validated;

@Validated
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")


public class TokenRefreshResponse   {
	@JsonProperty("accessToken")
	private String accessToken;

	@JsonProperty("refreshToken")
	private String refreshToken;

	private final String tokenType = "Bearer";

	public TokenRefreshResponse() {
		super();
		// TODO Auto-generated constructor stub
	}



	public TokenRefreshResponse(String accessToken, String refreshToken) {
		super();
		this.accessToken = accessToken;
		this.refreshToken = refreshToken;
	}



	public TokenRefreshResponse(String accessToken) {
		// TODO Auto-generated constructor stub
		this.accessToken = accessToken;
	}

	public TokenRefreshResponse accessToken(String accessToken) {
		this.accessToken = accessToken;
		return this;
	}

	/**
	 * Get accessToken
	 * @return accessToken
	 **/
	@Schema(description = "")

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public TokenRefreshResponse refreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
		return this;
	}

	/**
	 * Get refreshToken
	 * @return refreshToken
	 **/
	@Schema(description = "")

	public String getRefreshToken() {
		return refreshToken;
	}

	public void setRefreshToken(String refreshToken) {
		this.refreshToken = refreshToken;
	}

	public String getTokenType() {
		return tokenType;
	}

	@Override
	public boolean equals(java.lang.Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}
		TokenRefreshResponse inlineResponse200 = (TokenRefreshResponse) o;
		return Objects.equals(this.accessToken, inlineResponse200.accessToken) &&
				Objects.equals(this.refreshToken, inlineResponse200.refreshToken);
	}

	@Override
	public int hashCode() {
		return Objects.hash(accessToken, refreshToken);
	}


	@Override
	public String toString() {
		return "{\"accessToken\":\"" + accessToken + "\",\n \"refreshToken\":\"" + refreshToken + "\",\n \"tokenType\":\""
				+ tokenType + "\"}";
	}

}
