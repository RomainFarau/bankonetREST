package com.bankonet.filter;

import java.io.IOException;

import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;

@Provider
public class CorsFilter implements ContainerResponseFilter {

	@Override
	public void filter(ContainerRequestContext requestCtx,
			ContainerResponseContext responseCtx) throws IOException {
		// TODO Auto-generated method stub
		responseCtx.getHeaders().add("Access-Control-Allow-Origin", "*");
		responseCtx.getHeaders().add("Access-Control-Allow-Credentials", "true");
		responseCtx.getHeaders().add("Access-Control-Allow-Methods", "GET,POST,DELETE,PUT");
	
	}

}
