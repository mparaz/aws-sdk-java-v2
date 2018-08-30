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

package software.amazon.awssdk.awscore.http.response;

import static software.amazon.awssdk.awscore.AwsResponseMetadata.AWS_REQUEST_ID;

import com.fasterxml.jackson.core.JsonFactory;
import java.util.HashMap;
import java.util.Map;
import software.amazon.awssdk.annotations.SdkProtectedApi;
import software.amazon.awssdk.awscore.AwsResponse;
import software.amazon.awssdk.awscore.AwsResponseMetadata;
import software.amazon.awssdk.core.http.JsonResponseHandler;
import software.amazon.awssdk.core.interceptor.ExecutionAttributes;
import software.amazon.awssdk.core.runtime.transform.JsonUnmarshallerContext;
import software.amazon.awssdk.core.runtime.transform.Unmarshaller;
import software.amazon.awssdk.http.SdkHttpFullResponse;
import software.amazon.awssdk.http.SdkHttpResponse;

@SdkProtectedApi
public class AwsJsonResponseHandler<T extends AwsResponse> extends JsonResponseHandler<T> {

    public AwsJsonResponseHandler(Unmarshaller<T, JsonUnmarshallerContext> responseUnmarshaller, Map<Class<?>, Unmarshaller<?,
        JsonUnmarshallerContext>> simpleTypeUnmarshallers, JsonFactory jsonFactory, boolean needsConnectionLeftOpen,
                                  boolean isPayloadJson) {
        super(responseUnmarshaller, simpleTypeUnmarshallers, jsonFactory, needsConnectionLeftOpen, isPayloadJson);
    }

    @Override
    @SuppressWarnings("unchecked")
    public final T handle(SdkHttpFullResponse response, ExecutionAttributes executionAttributes) throws Exception {
        T result = super.handle(response, executionAttributes);

        AwsResponseMetadata responseMetadata = generateResponseMetadata(response);
        return (T) result.toBuilder().responseMetadata(responseMetadata).build();
    }

    /**
     * Create the default {@link AwsResponseMetadata}. Subclasses may override this to create a
     * subclass of {@link AwsResponseMetadata}.
     */
    protected AwsResponseMetadata generateResponseMetadata(SdkHttpResponse response) {
        Map<String, String> metadata = new HashMap<>();

        metadata.put(AWS_REQUEST_ID, response.firstMatchingHeader(X_AMZN_REQUEST_ID_HEADER).orElse(null));
        return new AwsResponseMetadata(metadata);
    }
}
