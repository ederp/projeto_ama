package com.ama.springboot.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")
public class NotFoundException extends ApiException {
    /**
	 * 
	 */
	private static final long serialVersionUID = -1671753334651403336L;
	private int code;
    public NotFoundException (int code, String msg) {
        super(code, msg);
        this.code = code;
    }
}
