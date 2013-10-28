package com.webservice.provider;

import java.lang.reflect.Type;

import javax.ws.rs.core.Context;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;

import com.sun.jersey.api.core.HttpContext;
import com.sun.jersey.core.spi.component.ComponentContext;
import com.sun.jersey.core.spi.component.ComponentScope;
import com.sun.jersey.server.impl.inject.AbstractHttpContextInjectable;
import com.sun.jersey.spi.inject.Injectable;
import com.sun.jersey.spi.inject.InjectableProvider;

@Provider
@Component
public class HeaderProvider extends AbstractHttpContextInjectable<Header> implements InjectableProvider<Context, Type>{

	@Override
	public Header getValue(HttpContext c) {
		String username = c.getRequest().getHeaderValue("username");
		String password = c.getRequest().getHeaderValue("password");
		Header header = new Header();
		header.setUsername(username);
		header.setPassword(password);
		return header;
	}

	@Override
	public Injectable<Header> getInjectable(ComponentContext arg0, Context arg1, Type arg2) {
		if(arg2.equals(Header.class)){
			return this;
		}
		return null;
	}

	@Override
	public ComponentScope getScope() {
		return ComponentScope.PerRequest;
	}

}
