package com.varunkn;

import software.amazon.awssdk.services.glue.GlueClient;

public class ClientLoader {

    public static GlueClient load() {
        return GlueClient.create();
    }
}
