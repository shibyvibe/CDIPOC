package com.restfully.shop.CDIPOC;

import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.webbeans.config.WebBeansContext;
import org.apache.webbeans.spi.ContainerLifecycle;
@Named
public class MainApp  {
	@Inject public ShoppingCart cart;

	private static ContainerLifecycle lifecycle = null;
    public static void main(String[] args)  {

    	
    	
        lifecycle = WebBeansContext.currentInstance().getService(ContainerLifecycle.class);
        lifecycle.startApplication(MainApp.class);
//        Bean<?> m = lifecycle.getBeanManager().
//        System.out.print(m.cart.getItem());
//        System.out.print(m.cart.getItem());
    }

    public static void shutdown()  {
        lifecycle.stopApplication(null);
    }
    
    @Produces
    public Item createItem() {
    	return new Item();
    }
    
}