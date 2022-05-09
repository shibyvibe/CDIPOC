package com.restfully.shop.CDIPOC;

import static org.junit.jupiter.api.Assertions.*;


import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;
import javax.inject.Inject;

import org.apache.openwebbeans.junit5.Cdi;
import org.apache.openwebbeans.junit5.internal.CdiExtension;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@Cdi
@ExtendWith(CdiExtension.class)
class ShoppingCartTest {
	
	@Inject ShoppingCart cart;
	ShoppingCart cart2;
	
	@BeforeEach
	void setupCart() {
		cart2 = getBean(ShoppingCart.class);
	}
	
	@Test
	void test() {
		assertNotNull(cart);
		assertNotNull(cart2);
		assertEquals(cart.getItem().getProductCode(), cart2.getItem().getProductCode());
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
