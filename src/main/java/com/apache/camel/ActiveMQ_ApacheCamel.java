/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.apache.camel;

import javax.jms.ConnectionFactory;
import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.impl.DefaultCamelContext;

import org.apache.camel.component.jms.JmsComponent;

/**
 *
 * @author rthirugnanas
 */
public class ActiveMQ_ApacheCamel {
    
    public static void main(String[] a){
        FirstRoutBulder firstRoutBulder = new FirstRoutBulder();
        CamelContext camelContext = new DefaultCamelContext();
        String brokerURL = ActiveMQConnection.DEFAULT_BROKER_URL;
        //jms connection factory
        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(brokerURL);
        camelContext.addComponent("jms", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));
        
        try{
            camelContext.addRoutes(firstRoutBulder);
            camelContext.start();
            Thread.sleep(1000 * 60);
            camelContext.start();
        } catch(Exception e){
            e.printStackTrace();
        }
        
    }
    
}
