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
import software.amazon.awssdk.annotations.SdkPublicApi;
import software.amazon.awssdk.awscore.AwsResponseMetadata;

/**
 * Contains response metadata for S3.
 */
@SdkPublicApi
public final class S3ResponseMetadata extends AwsResponseMetadata {

    static final String EXTENDED_REQUEST_ID = "EXTENDED_REQUEST_ID";
    static final String CLOUD_FRONT_ID = "CLOUD_FRONT_ID";
    static final String REQUEST_ID = "REQUEST_ID";

    public S3ResponseMetadata(Map<String, String> metadata) {
        super(metadata);
    }

    public S3ResponseMetadata(AwsResponseMetadata awsResponseMetadata) {
        this(awsResponseMetadata.metadata());
    }

    @Override
    public String requestId() {
        return getValue(REQUEST_ID);
    }

    /**
     * @return the extended RequestId if available or "UNKONWN" otherwise.
     *
     * <p>
     * See https://docs.aws.amazon.com/AmazonS3/latest/dev/troubleshooting.html#get-request-ids
     */
    public String extendedRequestId() {
        return getValue(EXTENDED_REQUEST_ID);
    }

    /**
     * @return the cloudfront Id if available or "UNKONWN" otherwise.
     */
    public String cloudFrontId() {
        return getValue(CLOUD_FRONT_ID);
    }
}
