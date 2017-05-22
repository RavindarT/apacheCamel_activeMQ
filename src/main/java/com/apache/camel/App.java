/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apache.camel;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

/**
 *
 * @author rthirugnanas
 */
public class App {
    
    public static void main(String[] args) throws Exception{
        System.out.println("testing...");
        CamelContext context = new DefaultCamelContext();

        // add our route to the CamelContext
        context.addRoutes(new RouteBuilder() {
            public void configure() {
                from("file:src/data?noop=true").
                    choice().
                        when(xpath("/person/city = 'London'")).to("file:target/messages/uk").
                        otherwise().to("file:target/messages/others");
            }
        });

        // start the route and let it do its work
        System.out.println("Starting");
        context.start();
        Thread.sleep(20000);
        System.out.println("Done");
        // stop the CamelContext
        context.stop();
    }
    
}
