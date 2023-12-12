package com.ama.springboot.api;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.SpringCodegen", date = "2023-12-12T18:50:24.325627535Z[GMT]")
public class ApiException extends Exception {
    /**
	 * 
	 */
	private static final long serialVersionUID = 467690273321947439L;
	private int code;
    public ApiException (int code, String msg) {
        super(msg);
        this.code = code;
    }
}
