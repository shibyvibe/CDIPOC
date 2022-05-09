package com.restfully.shop.CDIPOC;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

import org.apache.openwebbeans.junit5.Scopes;

@ApplicationScoped
public class ShoppingCart {
	
	public Item getItem() {
		return getBean(Item.class);
	}
	
    @SuppressWarnings("unchecked")
	private <T> T getBean(Class<T> beanClass) {
        BeanManager bm = CDI.current().getBeanManager();
        @SuppressWarnings("unchecked")
		Bean<T> bean = (Bean<T>) bm.getBeans(beanClass).iterator().next();
        CreationalContext<T> ctx = bm.createCreationalContext(bean);
        return (T) bm.getReference(bean, beanClass, ctx);
    }		
}
