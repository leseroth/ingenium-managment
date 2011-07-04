package com.ingenium.ash.load;

/**
 *
 * @author Erik
 */
public class StartLoadBalancer {

    public static void main(String... args) {
        LoadBalancer loadBalancer = LoadBalancer.getInstance();
        loadBalancer.startCentralSystemServerConnection();
        loadBalancer.startHomeSystemServerConnection();
    }
}
