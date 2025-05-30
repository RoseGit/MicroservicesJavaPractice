package com.rose.api.gateway;

import java.util.function.Function;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteDefinitionRouteLocator;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.Buildable;
import org.springframework.cloud.gateway.route.builder.PredicateSpec;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApiGatewayConfiguration {

	@Bean
	public RouteLocator gatewayRouter(RouteLocatorBuilder builder) {
		//si recive una peticion/get redireccionamos a uri
		Function<PredicateSpec, Buildable<Route>> routeFuncion
		= p-> p.path("/get") //Si recibimos esta request
		.filters(f-> 
					f.addRequestHeader("MyHeader", "MyURI")
					.addRequestParameter("Param", "MyValue")
				)//agregamos un encabezado a la request
		.uri("http://httpbin.org:80");//Redirigimos a este sitio
		
		//estas propiedades deben estar desactivadas 
		//spring.cloud.gateway.server.webflux.discovery.locator.enabled=true
		//spring.cloud.gateway.server.webflux.discovery.locator.lower-case-service-id=true
	/*Function<PredicateSpec, Buildable<Route>> routeFuncionCustom
		= p-> p.path("/CURRENCY-EXCHANGE/**")//Si una request comienza por esto 
		.uri("lb://CURRENCY-EXCHANGE/");
		*/
		return builder.routes()
				.route(routeFuncion)
				//.route(routeFuncionCustom)
				.build();
	}
}
