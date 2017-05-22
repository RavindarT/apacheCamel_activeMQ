/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apache.camel;

import org.apache.camel.builder.RouteBuilder;

/**
 *
 * @author rthirugnanas
 */
public class FirstRoutBulder extends RouteBuilder{

    @Override
    public void configure() throws Exception {
        from("file:C:/Users/rthirugnanas/Documents/NetBeansProjects/mavenproject1/src/messages").split().tokenize("\n").to("jms:queue:apacheCamel");
    }
    
}
