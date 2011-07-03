/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ingenium.ash.load;

/**
 *
 * @author Erik
 */
public class StartLoadBalancer {

    public static void main(String... args) {
        LoadBalancer loadBalancer = LoadBalancer.getInstance();
        loadBalancer.startCentralSystemServerConnection();
    }
}
