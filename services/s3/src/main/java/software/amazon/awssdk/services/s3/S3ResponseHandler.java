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

package software.amazon.awssdk.services.s3;

import java.util.Map;
import software.amazon.awssdk.annotations.SdkProtectedApi;
import software.amazon.awssdk.awscore.AwsResponseMetadata;
import software.amazon.awssdk.awscore.http.response.StaxResponseHandler;
import software.amazon.awssdk.awscore.internal.protocol.xml.StaxOperationMetadata;
import software.amazon.awssdk.awscore.protocol.xml.StaxUnmarshallerContext;
import software.amazon.awssdk.core.runtime.transform.Unmarshaller;
import software.amazon.awssdk.http.SdkHttpResponse;
import software.amazon.awssdk.services.s3.model.S3Response;


@SdkProtectedApi
public final class S3ResponseHandler<T extends S3Response> extends StaxResponseHandler<T> {

    private static final String EXTENDED_REQUEST_ID_HEADER = "x-amz-id-2";
    private static final String CLOUD_FRONT_ID_HEADER = "X-Amz-Cf-Id";
    private static final String REQUEST_ID_HEADER = "x-amz-request-id";

    /**
     * Constructs a new response handler that will use the specified StAX
     * unmarshaller to unmarshall the service response and uses the specified
     * response element path to find the root of the business data in the
     * service's response.
     *
     * @param responseUnmarshaller The StAX unmarshaller to use on the response.
     */
    public S3ResponseHandler(Unmarshaller<T, StaxUnmarshallerContext> responseUnmarshaller, StaxOperationMetadata operationMetadata) {
        super(responseUnmarshaller, operationMetadata);
    }

    @Override
    protected AwsResponseMetadata generateResponseMetadata(SdkHttpResponse response, StaxUnmarshallerContext
        unmarshallerContext) {
        Map<String, String> metadata = unmarshallerContext.getMetadata();

        metadata.put(S3ResponseMetadata.REQUEST_ID,
                     response.firstMatchingHeader(REQUEST_ID_HEADER).orElse(null));
        metadata.put(S3ResponseMetadata.EXTENDED_REQUEST_ID, response.firstMatchingHeader(EXTENDED_REQUEST_ID_HEADER).orElse(null));
        metadata.put(S3ResponseMetadata.CLOUD_FRONT_ID, response.firstMatchingHeader(CLOUD_FRONT_ID_HEADER).orElse(null));

        return new S3ResponseMetadata(metadata);
    }
}
