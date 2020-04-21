package com.formacionbdi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PreTiempoTranscurridoFilter extends ZuulFilter {

	//Para mostrar la ruta completa del request que estamos enviando
	private static Logger log = LoggerFactory.getLogger(PreTiempoTranscurridoFilter.class);
	
	//Si queremos que se ejecute el filtro en cada Request
	@Override
	public boolean shouldFilter() {
		return true;
	}

	//Aquí va la lógica de nuestro filtro
	@Override
	public Object run() throws ZuulException {
		
		//Para poder pasar datos al request
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		
		log.info(String.format("%s request enrutado a %s", request.getMethod(), request.getRequestURL().toString()));
		
		Long tiempoInicio = System.currentTimeMillis();
		request.setAttribute("tiempoInicio", tiempoInicio);
		
		return null;
	}

	//En el return siempre debe utilizar la expresión "pre" ó post o route
	@Override
	public String filterType() {
		return "pre";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
