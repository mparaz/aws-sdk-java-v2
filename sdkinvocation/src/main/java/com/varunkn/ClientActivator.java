package com.varunkn;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class ClientActivator implements BundleActivator {

    @Override
    public void start(BundleContext bundleContext) throws Exception {
        System.out.println("Start InterfaceActivator");
        ClientLoader.load();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        System.out.println("Stop InterfaceActivator");
    }
}