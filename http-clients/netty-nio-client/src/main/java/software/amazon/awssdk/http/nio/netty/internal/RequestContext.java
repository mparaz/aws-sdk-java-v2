/*
 * Copyright 2010-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License").
 * You may not use this file except in compliance with the License.
 * A copy of the License is located at
 *
 *  http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed
 * on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either
 * express or implied. See the License for the specific language governing
 * permissions and limitations under the License.
 */

package software.amazon.awssdk.http.nio.netty.internal;

import io.netty.channel.pool.ChannelPool;
import io.netty.handler.codec.http.HttpRequest;
import software.amazon.awssdk.annotations.SdkInternalApi;
import software.amazon.awssdk.http.SdkHttpRequest;
import software.amazon.awssdk.http.SdkRequestContext;
import software.amazon.awssdk.http.async.SdkHttpRequestProvider;
import software.amazon.awssdk.http.async.SdkHttpResponseHandler;

@SdkInternalApi
public final class RequestContext {

    private final ChannelPool channelPool;
    private final SdkHttpRequest sdkRequest;
    private final SdkHttpRequestProvider requestProvider;
    private final HttpRequest nettyRequest;
    private final SdkHttpResponseHandler handler;
    private final NettyConfiguration configuration;
    private final SdkRequestContext sdkRequestContext;

    public RequestContext(ChannelPool channelPool,
                          SdkHttpRequest sdkRequest,
                          SdkHttpRequestProvider requestProvider,
                          HttpRequest nettyRequest,
                          SdkHttpResponseHandler handler,
                          NettyConfiguration configuration,
                          SdkRequestContext sdkRequestContext) {
        this.channelPool = channelPool;
        this.sdkRequest = sdkRequest;
        this.requestProvider = requestProvider;
        this.nettyRequest = nettyRequest;
        this.handler = handler;
        this.configuration = configuration;
        this.sdkRequestContext = sdkRequestContext;
    }

    public SdkHttpResponseHandler handler() {
        return handler;
    }

    public ChannelPool channelPool() {
        return channelPool;
    }

    public SdkHttpRequest sdkRequest() {
        return this.sdkRequest;
    }

    public SdkHttpRequestProvider sdkRequestProvider() {
        return requestProvider;
    }

    public HttpRequest nettyRequest() {
        return nettyRequest;
    }

    NettyConfiguration configuration() {
        return configuration;
    }

    public SdkRequestContext sdkRequestContext() {
        return sdkRequestContext;
    }
}
