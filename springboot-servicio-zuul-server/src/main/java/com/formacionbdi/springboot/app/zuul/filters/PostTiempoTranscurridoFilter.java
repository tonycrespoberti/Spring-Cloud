package com.formacionbdi.springboot.app.zuul.filters;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

@Component
public class PostTiempoTranscurridoFilter extends ZuulFilter {

	//Para mostrar la ruta completa del request que estamos enviando
	private static Logger log = LoggerFactory.getLogger(PostTiempoTranscurridoFilter.class);
	
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
		
		log.info("entrando a post filter");
		
		Long tiempoInicio = (Long) request.getAttribute("tiempoInicio");
		Long tiempoFinal = System.currentTimeMillis();
		Long tiempoTranscurrido = tiempoFinal - tiempoInicio;

		log.info(String.format("Tiempo transcurrido en segundos %s seg.", tiempoTranscurrido.doubleValue()/1000.00));
		log.info(String.format("Tiempo transcurrido en miliseg %s miliseg.", tiempoTranscurrido.doubleValue()/1000.00));
		
		return null;
	}

	//En el return siempre debe utilizar la expresión "pre" ó post o route
	@Override
	public String filterType() {
		return "post";
	}

	@Override
	public int filterOrder() {
		return 1;
	}

}
