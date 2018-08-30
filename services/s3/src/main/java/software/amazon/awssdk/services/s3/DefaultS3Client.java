/*
 * Copyright 2013-2018 Amazon.com, Inc. or its affiliates. All Rights Reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"). You may not use this file except in compliance with
 * the License. A copy of the License is located at
 *
 * http://aws.amazon.com/apache2.0
 *
 * or in the "license" file accompanying this file. This file is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
 * CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */

package software.amazon.awssdk.services.s3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import org.w3c.dom.Node;
import software.amazon.awssdk.annotations.Generated;
import software.amazon.awssdk.annotations.SdkInternalApi;
import software.amazon.awssdk.awscore.AwsRequestOverrideConfiguration;
import software.amazon.awssdk.awscore.client.handler.AwsSyncClientHandler;
import software.amazon.awssdk.awscore.exception.AwsServiceException;
import software.amazon.awssdk.awscore.http.response.DefaultErrorResponseHandler;
import software.amazon.awssdk.awscore.internal.protocol.xml.StaxOperationMetadata;
import software.amazon.awssdk.core.ApiName;
import software.amazon.awssdk.core.client.handler.ClientExecutionParams;
import software.amazon.awssdk.core.client.handler.SyncClientHandler;
import software.amazon.awssdk.core.exception.SdkClientException;
import software.amazon.awssdk.core.exception.SdkException;
import software.amazon.awssdk.core.http.HttpResponseHandler;
import software.amazon.awssdk.core.internal.client.config.SdkClientConfiguration;
import software.amazon.awssdk.core.runtime.transform.StreamingRequestMarshaller;
import software.amazon.awssdk.core.runtime.transform.Unmarshaller;
import software.amazon.awssdk.core.sync.RequestBody;
import software.amazon.awssdk.core.sync.ResponseTransformer;
import software.amazon.awssdk.core.util.VersionInfo;
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.AbortMultipartUploadResponse;
import software.amazon.awssdk.services.s3.model.BucketAlreadyExistsException;
import software.amazon.awssdk.services.s3.model.BucketAlreadyOwnedByYouException;
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.CompleteMultipartUploadResponse;
import software.amazon.awssdk.services.s3.model.CopyObjectRequest;
import software.amazon.awssdk.services.s3.model.CopyObjectResponse;
import software.amazon.awssdk.services.s3.model.CreateBucketRequest;
import software.amazon.awssdk.services.s3.model.CreateBucketResponse;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadRequest;
import software.amazon.awssdk.services.s3.model.CreateMultipartUploadResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketAnalyticsConfigurationRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketAnalyticsConfigurationResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketCorsRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketCorsResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketInventoryConfigurationRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketInventoryConfigurationResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketLifecycleRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketLifecycleResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketMetricsConfigurationRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketMetricsConfigurationResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketPolicyRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketPolicyResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketReplicationRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketReplicationResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketTaggingRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketTaggingResponse;
import software.amazon.awssdk.services.s3.model.DeleteBucketWebsiteRequest;
import software.amazon.awssdk.services.s3.model.DeleteBucketWebsiteResponse;
import software.amazon.awssdk.services.s3.model.DeleteObjectRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectResponse;
import software.amazon.awssdk.services.s3.model.DeleteObjectTaggingRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectTaggingResponse;
import software.amazon.awssdk.services.s3.model.DeleteObjectsRequest;
import software.amazon.awssdk.services.s3.model.DeleteObjectsResponse;
import software.amazon.awssdk.services.s3.model.GetBucketAccelerateConfigurationRequest;
import software.amazon.awssdk.services.s3.model.GetBucketAccelerateConfigurationResponse;
import software.amazon.awssdk.services.s3.model.GetBucketAclRequest;
import software.amazon.awssdk.services.s3.model.GetBucketAclResponse;
import software.amazon.awssdk.services.s3.model.GetBucketAnalyticsConfigurationRequest;
import software.amazon.awssdk.services.s3.model.GetBucketAnalyticsConfigurationResponse;
import software.amazon.awssdk.services.s3.model.GetBucketCorsRequest;
import software.amazon.awssdk.services.s3.model.GetBucketCorsResponse;
import software.amazon.awssdk.services.s3.model.GetBucketInventoryConfigurationRequest;
import software.amazon.awssdk.services.s3.model.GetBucketInventoryConfigurationResponse;
import software.amazon.awssdk.services.s3.model.GetBucketLifecycleConfigurationRequest;
import software.amazon.awssdk.services.s3.model.GetBucketLifecycleConfigurationResponse;
import software.amazon.awssdk.services.s3.model.GetBucketLifecycleRequest;
import software.amazon.awssdk.services.s3.model.GetBucketLifecycleResponse;
import software.amazon.awssdk.services.s3.model.GetBucketLocationRequest;
import software.amazon.awssdk.services.s3.model.GetBucketLocationResponse;
import software.amazon.awssdk.services.s3.model.GetBucketLoggingRequest;
import software.amazon.awssdk.services.s3.model.GetBucketLoggingResponse;
import software.amazon.awssdk.services.s3.model.GetBucketMetricsConfigurationRequest;
import software.amazon.awssdk.services.s3.model.GetBucketMetricsConfigurationResponse;
import software.amazon.awssdk.services.s3.model.GetBucketNotificationConfigurationRequest;
import software.amazon.awssdk.services.s3.model.GetBucketNotificationConfigurationResponse;
import software.amazon.awssdk.services.s3.model.GetBucketNotificationRequest;
import software.amazon.awssdk.services.s3.model.GetBucketNotificationResponse;
import software.amazon.awssdk.services.s3.model.GetBucketPolicyRequest;
import software.amazon.awssdk.services.s3.model.GetBucketPolicyResponse;
import software.amazon.awssdk.services.s3.model.GetBucketReplicationRequest;
import software.amazon.awssdk.services.s3.model.GetBucketReplicationResponse;
import software.amazon.awssdk.services.s3.model.GetBucketRequestPaymentRequest;
import software.amazon.awssdk.services.s3.model.GetBucketRequestPaymentResponse;
import software.amazon.awssdk.services.s3.model.GetBucketTaggingRequest;
import software.amazon.awssdk.services.s3.model.GetBucketTaggingResponse;
import software.amazon.awssdk.services.s3.model.GetBucketVersioningRequest;
import software.amazon.awssdk.services.s3.model.GetBucketVersioningResponse;
import software.amazon.awssdk.services.s3.model.GetBucketWebsiteRequest;
import software.amazon.awssdk.services.s3.model.GetBucketWebsiteResponse;
import software.amazon.awssdk.services.s3.model.GetObjectAclRequest;
import software.amazon.awssdk.services.s3.model.GetObjectAclResponse;
import software.amazon.awssdk.services.s3.model.GetObjectRequest;
import software.amazon.awssdk.services.s3.model.GetObjectResponse;
import software.amazon.awssdk.services.s3.model.GetObjectTaggingRequest;
import software.amazon.awssdk.services.s3.model.GetObjectTaggingResponse;
import software.amazon.awssdk.services.s3.model.GetObjectTorrentRequest;
import software.amazon.awssdk.services.s3.model.GetObjectTorrentResponse;
import software.amazon.awssdk.services.s3.model.HeadBucketRequest;
import software.amazon.awssdk.services.s3.model.HeadBucketResponse;
import software.amazon.awssdk.services.s3.model.HeadObjectRequest;
import software.amazon.awssdk.services.s3.model.HeadObjectResponse;
import software.amazon.awssdk.services.s3.model.ListBucketAnalyticsConfigurationsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketAnalyticsConfigurationsResponse;
import software.amazon.awssdk.services.s3.model.ListBucketInventoryConfigurationsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketInventoryConfigurationsResponse;
import software.amazon.awssdk.services.s3.model.ListBucketMetricsConfigurationsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketMetricsConfigurationsResponse;
import software.amazon.awssdk.services.s3.model.ListBucketsRequest;
import software.amazon.awssdk.services.s3.model.ListBucketsResponse;
import software.amazon.awssdk.services.s3.model.ListMultipartUploadsRequest;
import software.amazon.awssdk.services.s3.model.ListMultipartUploadsResponse;
import software.amazon.awssdk.services.s3.model.ListObjectVersionsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectVersionsResponse;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Request;
import software.amazon.awssdk.services.s3.model.ListObjectsV2Response;
import software.amazon.awssdk.services.s3.model.ListPartsRequest;
import software.amazon.awssdk.services.s3.model.ListPartsResponse;
import software.amazon.awssdk.services.s3.model.NoSuchBucketException;
import software.amazon.awssdk.services.s3.model.NoSuchKeyException;
import software.amazon.awssdk.services.s3.model.NoSuchUploadException;
import software.amazon.awssdk.services.s3.model.ObjectAlreadyInActiveTierErrorException;
import software.amazon.awssdk.services.s3.model.ObjectNotInActiveTierErrorException;
import software.amazon.awssdk.services.s3.model.PutBucketAccelerateConfigurationRequest;
import software.amazon.awssdk.services.s3.model.PutBucketAccelerateConfigurationResponse;
import software.amazon.awssdk.services.s3.model.PutBucketAclRequest;
import software.amazon.awssdk.services.s3.model.PutBucketAclResponse;
import software.amazon.awssdk.services.s3.model.PutBucketAnalyticsConfigurationRequest;
import software.amazon.awssdk.services.s3.model.PutBucketAnalyticsConfigurationResponse;
import software.amazon.awssdk.services.s3.model.PutBucketCorsRequest;
import software.amazon.awssdk.services.s3.model.PutBucketCorsResponse;
import software.amazon.awssdk.services.s3.model.PutBucketInventoryConfigurationRequest;
import software.amazon.awssdk.services.s3.model.PutBucketInventoryConfigurationResponse;
import software.amazon.awssdk.services.s3.model.PutBucketLifecycleConfigurationRequest;
import software.amazon.awssdk.services.s3.model.PutBucketLifecycleConfigurationResponse;
import software.amazon.awssdk.services.s3.model.PutBucketLifecycleRequest;
import software.amazon.awssdk.services.s3.model.PutBucketLifecycleResponse;
import software.amazon.awssdk.services.s3.model.PutBucketLoggingRequest;
import software.amazon.awssdk.services.s3.model.PutBucketLoggingResponse;
import software.amazon.awssdk.services.s3.model.PutBucketMetricsConfigurationRequest;
import software.amazon.awssdk.services.s3.model.PutBucketMetricsConfigurationResponse;
import software.amazon.awssdk.services.s3.model.PutBucketNotificationConfigurationRequest;
import software.amazon.awssdk.services.s3.model.PutBucketNotificationConfigurationResponse;
import software.amazon.awssdk.services.s3.model.PutBucketNotificationRequest;
import software.amazon.awssdk.services.s3.model.PutBucketNotificationResponse;
import software.amazon.awssdk.services.s3.model.PutBucketPolicyRequest;
import software.amazon.awssdk.services.s3.model.PutBucketPolicyResponse;
import software.amazon.awssdk.services.s3.model.PutBucketReplicationRequest;
import software.amazon.awssdk.services.s3.model.PutBucketReplicationResponse;
import software.amazon.awssdk.services.s3.model.PutBucketRequestPaymentRequest;
import software.amazon.awssdk.services.s3.model.PutBucketRequestPaymentResponse;
import software.amazon.awssdk.services.s3.model.PutBucketTaggingRequest;
import software.amazon.awssdk.services.s3.model.PutBucketTaggingResponse;
import software.amazon.awssdk.services.s3.model.PutBucketVersioningRequest;
import software.amazon.awssdk.services.s3.model.PutBucketVersioningResponse;
import software.amazon.awssdk.services.s3.model.PutBucketWebsiteRequest;
import software.amazon.awssdk.services.s3.model.PutBucketWebsiteResponse;
import software.amazon.awssdk.services.s3.model.PutObjectAclRequest;
import software.amazon.awssdk.services.s3.model.PutObjectAclResponse;
import software.amazon.awssdk.services.s3.model.PutObjectRequest;
import software.amazon.awssdk.services.s3.model.PutObjectResponse;
import software.amazon.awssdk.services.s3.model.PutObjectTaggingRequest;
import software.amazon.awssdk.services.s3.model.PutObjectTaggingResponse;
import software.amazon.awssdk.services.s3.model.RestoreObjectRequest;
import software.amazon.awssdk.services.s3.model.RestoreObjectResponse;
import software.amazon.awssdk.services.s3.model.S3Exception;
import software.amazon.awssdk.services.s3.model.S3Request;
import software.amazon.awssdk.services.s3.model.UploadPartCopyRequest;
import software.amazon.awssdk.services.s3.model.UploadPartCopyResponse;
import software.amazon.awssdk.services.s3.model.UploadPartRequest;
import software.amazon.awssdk.services.s3.model.UploadPartResponse;
import software.amazon.awssdk.services.s3.paginators.ListMultipartUploadsIterable;
import software.amazon.awssdk.services.s3.paginators.ListObjectVersionsIterable;
import software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable;
import software.amazon.awssdk.services.s3.paginators.ListPartsIterable;
import software.amazon.awssdk.services.s3.transform.AbortMultipartUploadRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.AbortMultipartUploadResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.BucketAlreadyExistsExceptionUnmarshaller;
import software.amazon.awssdk.services.s3.transform.BucketAlreadyOwnedByYouExceptionUnmarshaller;
import software.amazon.awssdk.services.s3.transform.CompleteMultipartUploadRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.CompleteMultipartUploadResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.CopyObjectRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.CopyObjectResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.CreateBucketRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.CreateBucketResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.CreateMultipartUploadRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.CreateMultipartUploadResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketAnalyticsConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketAnalyticsConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketCorsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketCorsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketInventoryConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketInventoryConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketLifecycleRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketLifecycleResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketMetricsConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketMetricsConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketPolicyRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketPolicyResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketReplicationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketReplicationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketTaggingRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketTaggingResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketWebsiteRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteBucketWebsiteResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteObjectRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteObjectResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteObjectTaggingRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteObjectTaggingResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteObjectsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.DeleteObjectsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketAccelerateConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketAccelerateConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketAclRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketAclResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketAnalyticsConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketAnalyticsConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketCorsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketCorsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketInventoryConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketInventoryConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketLifecycleConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketLifecycleConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketLifecycleRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketLifecycleResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketLocationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketLocationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketLoggingRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketLoggingResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketMetricsConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketMetricsConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketNotificationConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketNotificationConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketNotificationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketNotificationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketPolicyRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketPolicyResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketReplicationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketReplicationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketRequestPaymentRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketRequestPaymentResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketTaggingRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketTaggingResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketVersioningRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketVersioningResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketWebsiteRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetBucketWebsiteResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetObjectAclRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetObjectAclResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetObjectRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetObjectResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetObjectTaggingRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetObjectTaggingResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.GetObjectTorrentRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.GetObjectTorrentResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.HeadBucketRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.HeadBucketResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.HeadObjectRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.HeadObjectResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ListBucketAnalyticsConfigurationsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.ListBucketAnalyticsConfigurationsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ListBucketInventoryConfigurationsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.ListBucketInventoryConfigurationsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ListBucketMetricsConfigurationsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.ListBucketMetricsConfigurationsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ListBucketsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.ListBucketsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ListMultipartUploadsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.ListMultipartUploadsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ListObjectVersionsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.ListObjectVersionsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ListObjectsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.ListObjectsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ListObjectsV2RequestMarshaller;
import software.amazon.awssdk.services.s3.transform.ListObjectsV2ResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ListPartsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.ListPartsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.NoSuchBucketExceptionUnmarshaller;
import software.amazon.awssdk.services.s3.transform.NoSuchKeyExceptionUnmarshaller;
import software.amazon.awssdk.services.s3.transform.NoSuchUploadExceptionUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ObjectAlreadyInActiveTierErrorExceptionUnmarshaller;
import software.amazon.awssdk.services.s3.transform.ObjectNotInActiveTierErrorExceptionUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketAccelerateConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketAccelerateConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketAclRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketAclResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketAnalyticsConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketAnalyticsConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketCorsRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketCorsResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketInventoryConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketInventoryConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketLifecycleConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketLifecycleConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketLifecycleRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketLifecycleResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketLoggingRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketLoggingResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketMetricsConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketMetricsConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketNotificationConfigurationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketNotificationConfigurationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketNotificationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketNotificationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketPolicyRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketPolicyResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketReplicationRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketReplicationResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketRequestPaymentRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketRequestPaymentResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketTaggingRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketTaggingResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketVersioningRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketVersioningResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketWebsiteRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutBucketWebsiteResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutObjectAclRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutObjectAclResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutObjectRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutObjectResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.PutObjectTaggingRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.PutObjectTaggingResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.RestoreObjectRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.RestoreObjectResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.StandardS3ExceptionUnmarshaller;
import software.amazon.awssdk.services.s3.transform.UploadPartCopyRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.UploadPartCopyResponseUnmarshaller;
import software.amazon.awssdk.services.s3.transform.UploadPartRequestMarshaller;
import software.amazon.awssdk.services.s3.transform.UploadPartResponseUnmarshaller;

/**
 * Internal implementation of {@link S3Client}.
 *
 * @see S3Client#builder()
 */
@Generated("software.amazon.awssdk:codegen")
@SdkInternalApi
final class DefaultS3Client implements S3Client {
    private final SyncClientHandler clientHandler;

    private final List<Unmarshaller<AwsServiceException, Node>> exceptionUnmarshallers;

    private final SdkClientConfiguration clientConfiguration;

    protected DefaultS3Client(SdkClientConfiguration clientConfiguration) {
        this.clientHandler = new AwsSyncClientHandler(clientConfiguration);
        this.clientConfiguration = clientConfiguration;
        this.exceptionUnmarshallers = init();
    }

    @Override
    public final String serviceName() {
        return SERVICE_NAME;
    }

    /**
     * <p>
     * Aborts a multipart upload.
     * </p>
     * <p>
     * To verify that all parts have been removed, so you don't get charged for the part storage, you should call the
     * List Parts operation and ensure the parts list is empty.
     * </p>
     *
     * @param abortMultipartUploadRequest
     * @return Result of the AbortMultipartUpload operation returned by the service.
     * @throws NoSuchUploadException
     *         The specified multipart upload does not exist.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.AbortMultipartUpload
     */
    @Override
    public AbortMultipartUploadResponse abortMultipartUpload(AbortMultipartUploadRequest abortMultipartUploadRequest)
        throws NoSuchUploadException, AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<AbortMultipartUploadResponse> responseHandler = new S3ResponseHandler<>(
            new AbortMultipartUploadResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<AbortMultipartUploadRequest, AbortMultipartUploadResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(abortMultipartUploadRequest).withMarshaller(new AbortMultipartUploadRequestMarshaller()));
    }

    /**
     * Completes a multipart upload by assembling previously uploaded parts.
     *
     * @param completeMultipartUploadRequest
     * @return Result of the CompleteMultipartUpload operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.CompleteMultipartUpload
     */
    @Override
    public CompleteMultipartUploadResponse completeMultipartUpload(CompleteMultipartUploadRequest completeMultipartUploadRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<CompleteMultipartUploadResponse> responseHandler = new S3ResponseHandler<>(
            new CompleteMultipartUploadResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<CompleteMultipartUploadRequest, CompleteMultipartUploadResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(completeMultipartUploadRequest).withMarshaller(new CompleteMultipartUploadRequestMarshaller()));
    }

    /**
     * Creates a copy of an object that is already stored in Amazon S3.
     *
     * @param copyObjectRequest
     * @return Result of the CopyObject operation returned by the service.
     * @throws ObjectNotInActiveTierErrorException
     *         The source object of the COPY operation is not in the active tier and is only stored in Amazon Glacier.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.CopyObject
     */
    @Override
    public CopyObjectResponse copyObject(CopyObjectRequest copyObjectRequest) throws ObjectNotInActiveTierErrorException,
                                                                                     AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<CopyObjectResponse> responseHandler = new S3ResponseHandler<>(new CopyObjectResponseUnmarshaller(),
                                                                                            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<CopyObjectRequest, CopyObjectResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler).withInput(copyObjectRequest)
                                         .withMarshaller(new CopyObjectRequestMarshaller()));
    }

    /**
     * Creates a new bucket.
     *
     * @param createBucketRequest
     * @return Result of the CreateBucket operation returned by the service.
     * @throws BucketAlreadyExistsException
     *         The requested bucket name is not available. The bucket namespace is shared by all users of the system.
     *         Please select a different name and try again.
     * @throws BucketAlreadyOwnedByYouException
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.CreateBucket
     */
    @Override
    public CreateBucketResponse createBucket(CreateBucketRequest createBucketRequest) throws BucketAlreadyExistsException,
                                                                                             BucketAlreadyOwnedByYouException, AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<CreateBucketResponse> responseHandler = new S3ResponseHandler<>(
            new CreateBucketResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<CreateBucketRequest, CreateBucketResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(createBucketRequest).withMarshaller(new CreateBucketRequestMarshaller()));
    }

    /**
     * <p>
     * Initiates a multipart upload and returns an upload ID.
     * </p>
     * <p>
     * <b>Note:</b> After you initiate multipart upload and upload one or more parts, you must either complete or abort
     * multipart upload in order to stop getting charged for storage of the uploaded parts. Only after you either
     * complete or abort multipart upload, Amazon S3 frees up the parts storage and stops charging you for the parts
     * storage.
     * </p>
     *
     * @param createMultipartUploadRequest
     * @return Result of the CreateMultipartUpload operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.CreateMultipartUpload
     */
    @Override
    public CreateMultipartUploadResponse createMultipartUpload(CreateMultipartUploadRequest createMultipartUploadRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<CreateMultipartUploadResponse> responseHandler = new S3ResponseHandler<>(
            new CreateMultipartUploadResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<CreateMultipartUploadRequest, CreateMultipartUploadResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(createMultipartUploadRequest).withMarshaller(new CreateMultipartUploadRequestMarshaller()));
    }

    /**
     * Deletes the bucket. All objects (including all object versions and Delete Markers) in the bucket must be deleted
     * before the bucket itself can be deleted.
     *
     * @param deleteBucketRequest
     * @return Result of the DeleteBucket operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteBucket
     */
    @Override
    public DeleteBucketResponse deleteBucket(DeleteBucketRequest deleteBucketRequest) throws AwsServiceException,
                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<DeleteBucketResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteBucketResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<DeleteBucketRequest, DeleteBucketResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(deleteBucketRequest).withMarshaller(new DeleteBucketRequestMarshaller()));
    }

    /**
     * Deletes an analytics configuration for the bucket (specified by the analytics configuration ID).
     *
     * @param deleteBucketAnalyticsConfigurationRequest
     * @return Result of the DeleteBucketAnalyticsConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteBucketAnalyticsConfiguration
     */
    @Override
    public DeleteBucketAnalyticsConfigurationResponse deleteBucketAnalyticsConfiguration(
        DeleteBucketAnalyticsConfigurationRequest deleteBucketAnalyticsConfigurationRequest) throws AwsServiceException,
                                                                                                    SdkClientException, S3Exception {

        S3ResponseHandler<DeleteBucketAnalyticsConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteBucketAnalyticsConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<DeleteBucketAnalyticsConfigurationRequest, DeleteBucketAnalyticsConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(deleteBucketAnalyticsConfigurationRequest)
                         .withMarshaller(new DeleteBucketAnalyticsConfigurationRequestMarshaller()));
    }

    /**
     * Deletes the cors configuration information set for the bucket.
     *
     * @param deleteBucketCorsRequest
     * @return Result of the DeleteBucketCors operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteBucketCors
     */
    @Override
    public DeleteBucketCorsResponse deleteBucketCors(DeleteBucketCorsRequest deleteBucketCorsRequest) throws AwsServiceException,
                                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<DeleteBucketCorsResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteBucketCorsResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<DeleteBucketCorsRequest, DeleteBucketCorsResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(deleteBucketCorsRequest).withMarshaller(new DeleteBucketCorsRequestMarshaller()));
    }

    /**
     * Deletes an inventory configuration (identified by the inventory ID) from the bucket.
     *
     * @param deleteBucketInventoryConfigurationRequest
     * @return Result of the DeleteBucketInventoryConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteBucketInventoryConfiguration
     */
    @Override
    public DeleteBucketInventoryConfigurationResponse deleteBucketInventoryConfiguration(
        DeleteBucketInventoryConfigurationRequest deleteBucketInventoryConfigurationRequest) throws AwsServiceException,
                                                                                                    SdkClientException, S3Exception {

        S3ResponseHandler<DeleteBucketInventoryConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteBucketInventoryConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<DeleteBucketInventoryConfigurationRequest, DeleteBucketInventoryConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(deleteBucketInventoryConfigurationRequest)
                         .withMarshaller(new DeleteBucketInventoryConfigurationRequestMarshaller()));
    }

    /**
     * Deletes the lifecycle configuration from the bucket.
     *
     * @param deleteBucketLifecycleRequest
     * @return Result of the DeleteBucketLifecycle operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteBucketLifecycle
     */
    @Override
    public DeleteBucketLifecycleResponse deleteBucketLifecycle(DeleteBucketLifecycleRequest deleteBucketLifecycleRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<DeleteBucketLifecycleResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteBucketLifecycleResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<DeleteBucketLifecycleRequest, DeleteBucketLifecycleResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(deleteBucketLifecycleRequest).withMarshaller(new DeleteBucketLifecycleRequestMarshaller()));
    }

    /**
     * Deletes a metrics configuration (specified by the metrics configuration ID) from the bucket.
     *
     * @param deleteBucketMetricsConfigurationRequest
     * @return Result of the DeleteBucketMetricsConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteBucketMetricsConfiguration
     */
    @Override
    public DeleteBucketMetricsConfigurationResponse deleteBucketMetricsConfiguration(
        DeleteBucketMetricsConfigurationRequest deleteBucketMetricsConfigurationRequest) throws AwsServiceException,
                                                                                                SdkClientException, S3Exception {

        S3ResponseHandler<DeleteBucketMetricsConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteBucketMetricsConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<DeleteBucketMetricsConfigurationRequest, DeleteBucketMetricsConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(deleteBucketMetricsConfigurationRequest)
                         .withMarshaller(new DeleteBucketMetricsConfigurationRequestMarshaller()));
    }

    /**
     * Deletes the policy from the bucket.
     *
     * @param deleteBucketPolicyRequest
     * @return Result of the DeleteBucketPolicy operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteBucketPolicy
     */
    @Override
    public DeleteBucketPolicyResponse deleteBucketPolicy(DeleteBucketPolicyRequest deleteBucketPolicyRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<DeleteBucketPolicyResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteBucketPolicyResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<DeleteBucketPolicyRequest, DeleteBucketPolicyResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(deleteBucketPolicyRequest).withMarshaller(new DeleteBucketPolicyRequestMarshaller()));
    }

    /**
     * Deletes the replication configuration from the bucket.
     *
     * @param deleteBucketReplicationRequest
     * @return Result of the DeleteBucketReplication operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteBucketReplication
     */
    @Override
    public DeleteBucketReplicationResponse deleteBucketReplication(DeleteBucketReplicationRequest deleteBucketReplicationRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<DeleteBucketReplicationResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteBucketReplicationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<DeleteBucketReplicationRequest, DeleteBucketReplicationResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(deleteBucketReplicationRequest).withMarshaller(new DeleteBucketReplicationRequestMarshaller()));
    }

    /**
     * Deletes the tags from the bucket.
     *
     * @param deleteBucketTaggingRequest
     * @return Result of the DeleteBucketTagging operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteBucketTagging
     */
    @Override
    public DeleteBucketTaggingResponse deleteBucketTagging(DeleteBucketTaggingRequest deleteBucketTaggingRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<DeleteBucketTaggingResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteBucketTaggingResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<DeleteBucketTaggingRequest, DeleteBucketTaggingResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(deleteBucketTaggingRequest).withMarshaller(new DeleteBucketTaggingRequestMarshaller()));
    }

    /**
     * This operation removes the website configuration from the bucket.
     *
     * @param deleteBucketWebsiteRequest
     * @return Result of the DeleteBucketWebsite operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteBucketWebsite
     */
    @Override
    public DeleteBucketWebsiteResponse deleteBucketWebsite(DeleteBucketWebsiteRequest deleteBucketWebsiteRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<DeleteBucketWebsiteResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteBucketWebsiteResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<DeleteBucketWebsiteRequest, DeleteBucketWebsiteResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(deleteBucketWebsiteRequest).withMarshaller(new DeleteBucketWebsiteRequestMarshaller()));
    }

    /**
     * Removes the null version (if there is one) of an object and inserts a delete marker, which becomes the latest
     * version of the object. If there isn't a null version, Amazon S3 does not remove any objects.
     *
     * @param deleteObjectRequest
     * @return Result of the DeleteObject operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteObject
     */
    @Override
    public DeleteObjectResponse deleteObject(DeleteObjectRequest deleteObjectRequest) throws AwsServiceException,
                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<DeleteObjectResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteObjectResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<DeleteObjectRequest, DeleteObjectResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(deleteObjectRequest).withMarshaller(new DeleteObjectRequestMarshaller()));
    }

    /**
     * Removes the tag-set from an existing object.
     *
     * @param deleteObjectTaggingRequest
     * @return Result of the DeleteObjectTagging operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteObjectTagging
     */
    @Override
    public DeleteObjectTaggingResponse deleteObjectTagging(DeleteObjectTaggingRequest deleteObjectTaggingRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<DeleteObjectTaggingResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteObjectTaggingResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<DeleteObjectTaggingRequest, DeleteObjectTaggingResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(deleteObjectTaggingRequest).withMarshaller(new DeleteObjectTaggingRequestMarshaller()));
    }

    /**
     * This operation enables you to delete multiple objects from a bucket using a single HTTP request. You may specify
     * up to 1000 keys.
     *
     * @param deleteObjectsRequest
     * @return Result of the DeleteObjects operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.DeleteObjects
     */
    @Override
    public DeleteObjectsResponse deleteObjects(DeleteObjectsRequest deleteObjectsRequest) throws AwsServiceException,
                                                                                                 SdkClientException, S3Exception {

        S3ResponseHandler<DeleteObjectsResponse> responseHandler = new S3ResponseHandler<>(
            new DeleteObjectsResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<DeleteObjectsRequest, DeleteObjectsResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(deleteObjectsRequest).withMarshaller(new DeleteObjectsRequestMarshaller()));
    }

    /**
     * Returns the accelerate configuration of a bucket.
     *
     * @param getBucketAccelerateConfigurationRequest
     * @return Result of the GetBucketAccelerateConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketAccelerateConfiguration
     */
    @Override
    public GetBucketAccelerateConfigurationResponse getBucketAccelerateConfiguration(
        GetBucketAccelerateConfigurationRequest getBucketAccelerateConfigurationRequest) throws AwsServiceException,
                                                                                                SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketAccelerateConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketAccelerateConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<GetBucketAccelerateConfigurationRequest, GetBucketAccelerateConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(getBucketAccelerateConfigurationRequest)
                         .withMarshaller(new GetBucketAccelerateConfigurationRequestMarshaller()));
    }

    /**
     * Gets the access control policy for the bucket.
     *
     * @param getBucketAclRequest
     * @return Result of the GetBucketAcl operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketAcl
     */
    @Override
    public GetBucketAclResponse getBucketAcl(GetBucketAclRequest getBucketAclRequest) throws AwsServiceException,
                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketAclResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketAclResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketAclRequest, GetBucketAclResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketAclRequest).withMarshaller(new GetBucketAclRequestMarshaller()));
    }

    /**
     * Gets an analytics configuration for the bucket (specified by the analytics configuration ID).
     *
     * @param getBucketAnalyticsConfigurationRequest
     * @return Result of the GetBucketAnalyticsConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketAnalyticsConfiguration
     */
    @Override
    public GetBucketAnalyticsConfigurationResponse getBucketAnalyticsConfiguration(
        GetBucketAnalyticsConfigurationRequest getBucketAnalyticsConfigurationRequest) throws AwsServiceException,
                                                                                              SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketAnalyticsConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketAnalyticsConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<GetBucketAnalyticsConfigurationRequest, GetBucketAnalyticsConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(getBucketAnalyticsConfigurationRequest)
                         .withMarshaller(new GetBucketAnalyticsConfigurationRequestMarshaller()));
    }

    /**
     * Returns the cors configuration for the bucket.
     *
     * @param getBucketCorsRequest
     * @return Result of the GetBucketCors operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketCors
     */
    @Override
    public GetBucketCorsResponse getBucketCors(GetBucketCorsRequest getBucketCorsRequest) throws AwsServiceException,
                                                                                                 SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketCorsResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketCorsResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketCorsRequest, GetBucketCorsResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketCorsRequest).withMarshaller(new GetBucketCorsRequestMarshaller()));
    }

    /**
     * Returns an inventory configuration (identified by the inventory ID) from the bucket.
     *
     * @param getBucketInventoryConfigurationRequest
     * @return Result of the GetBucketInventoryConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketInventoryConfiguration
     */
    @Override
    public GetBucketInventoryConfigurationResponse getBucketInventoryConfiguration(
        GetBucketInventoryConfigurationRequest getBucketInventoryConfigurationRequest) throws AwsServiceException,
                                                                                              SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketInventoryConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketInventoryConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<GetBucketInventoryConfigurationRequest, GetBucketInventoryConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(getBucketInventoryConfigurationRequest)
                         .withMarshaller(new GetBucketInventoryConfigurationRequestMarshaller()));
    }

    /**
     * Deprecated, see the GetBucketLifecycleConfiguration operation.
     *
     * @param getBucketLifecycleRequest
     * @return Result of the GetBucketLifecycle operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketLifecycle
     */
    @Override
    public GetBucketLifecycleResponse getBucketLifecycle(GetBucketLifecycleRequest getBucketLifecycleRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketLifecycleResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketLifecycleResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketLifecycleRequest, GetBucketLifecycleResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketLifecycleRequest).withMarshaller(new GetBucketLifecycleRequestMarshaller()));
    }

    /**
     * Returns the lifecycle configuration information set on the bucket.
     *
     * @param getBucketLifecycleConfigurationRequest
     * @return Result of the GetBucketLifecycleConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketLifecycleConfiguration
     */
    @Override
    public GetBucketLifecycleConfigurationResponse getBucketLifecycleConfiguration(
        GetBucketLifecycleConfigurationRequest getBucketLifecycleConfigurationRequest) throws AwsServiceException,
                                                                                              SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketLifecycleConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketLifecycleConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<GetBucketLifecycleConfigurationRequest, GetBucketLifecycleConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(getBucketLifecycleConfigurationRequest)
                         .withMarshaller(new GetBucketLifecycleConfigurationRequestMarshaller()));
    }

    /**
     * Returns the region the bucket resides in.
     *
     * @param getBucketLocationRequest
     * @return Result of the GetBucketLocation operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketLocation
     */
    @Override
    public GetBucketLocationResponse getBucketLocation(GetBucketLocationRequest getBucketLocationRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketLocationResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketLocationResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketLocationRequest, GetBucketLocationResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketLocationRequest).withMarshaller(new GetBucketLocationRequestMarshaller()));
    }

    /**
     * Returns the logging status of a bucket and the permissions users have to view and modify that status. To use GET,
     * you must be the bucket owner.
     *
     * @param getBucketLoggingRequest
     * @return Result of the GetBucketLogging operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketLogging
     */
    @Override
    public GetBucketLoggingResponse getBucketLogging(GetBucketLoggingRequest getBucketLoggingRequest) throws AwsServiceException,
                                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketLoggingResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketLoggingResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketLoggingRequest, GetBucketLoggingResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketLoggingRequest).withMarshaller(new GetBucketLoggingRequestMarshaller()));
    }

    /**
     * Gets a metrics configuration (specified by the metrics configuration ID) from the bucket.
     *
     * @param getBucketMetricsConfigurationRequest
     * @return Result of the GetBucketMetricsConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketMetricsConfiguration
     */
    @Override
    public GetBucketMetricsConfigurationResponse getBucketMetricsConfiguration(
        GetBucketMetricsConfigurationRequest getBucketMetricsConfigurationRequest) throws AwsServiceException,
                                                                                          SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketMetricsConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketMetricsConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<GetBucketMetricsConfigurationRequest, GetBucketMetricsConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(getBucketMetricsConfigurationRequest)
                         .withMarshaller(new GetBucketMetricsConfigurationRequestMarshaller()));
    }

    /**
     * Deprecated, see the GetBucketNotificationConfiguration operation.
     *
     * @param getBucketNotificationRequest
     * @return Result of the GetBucketNotification operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketNotification
     */
    @Override
    public GetBucketNotificationResponse getBucketNotification(GetBucketNotificationRequest getBucketNotificationRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketNotificationResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketNotificationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketNotificationRequest, GetBucketNotificationResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketNotificationRequest).withMarshaller(new GetBucketNotificationRequestMarshaller()));
    }

    /**
     * Returns the notification configuration of a bucket.
     *
     * @param getBucketNotificationConfigurationRequest
     * @return Result of the GetBucketNotificationConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketNotificationConfiguration
     */
    @Override
    public GetBucketNotificationConfigurationResponse getBucketNotificationConfiguration(
        GetBucketNotificationConfigurationRequest getBucketNotificationConfigurationRequest) throws AwsServiceException,
                                                                                                    SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketNotificationConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketNotificationConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<GetBucketNotificationConfigurationRequest, GetBucketNotificationConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(getBucketNotificationConfigurationRequest)
                         .withMarshaller(new GetBucketNotificationConfigurationRequestMarshaller()));
    }

    /**
     * Returns the policy of a specified bucket.
     *
     * @param getBucketPolicyRequest
     * @return Result of the GetBucketPolicy operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketPolicy
     */
    @Override
    public GetBucketPolicyResponse getBucketPolicy(GetBucketPolicyRequest getBucketPolicyRequest) throws AwsServiceException,
                                                                                                         SdkClientException, S3Exception {
        HttpResponseHandler<GetBucketPolicyResponse> responseHandler = (response, __) -> new GetBucketPolicyResponseUnmarshaller()
            .unmarshall(response);

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketPolicyRequest, GetBucketPolicyResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketPolicyRequest).withMarshaller(new GetBucketPolicyRequestMarshaller()));
    }

    /**
     * Returns the replication configuration of a bucket.
     *
     * @param getBucketReplicationRequest
     * @return Result of the GetBucketReplication operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketReplication
     */
    @Override
    public GetBucketReplicationResponse getBucketReplication(GetBucketReplicationRequest getBucketReplicationRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketReplicationResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketReplicationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketReplicationRequest, GetBucketReplicationResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketReplicationRequest).withMarshaller(new GetBucketReplicationRequestMarshaller()));
    }

    /**
     * Returns the request payment configuration of a bucket.
     *
     * @param getBucketRequestPaymentRequest
     * @return Result of the GetBucketRequestPayment operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketRequestPayment
     */
    @Override
    public GetBucketRequestPaymentResponse getBucketRequestPayment(GetBucketRequestPaymentRequest getBucketRequestPaymentRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketRequestPaymentResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketRequestPaymentResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketRequestPaymentRequest, GetBucketRequestPaymentResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketRequestPaymentRequest).withMarshaller(new GetBucketRequestPaymentRequestMarshaller()));
    }

    /**
     * Returns the tag set associated with the bucket.
     *
     * @param getBucketTaggingRequest
     * @return Result of the GetBucketTagging operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketTagging
     */
    @Override
    public GetBucketTaggingResponse getBucketTagging(GetBucketTaggingRequest getBucketTaggingRequest) throws AwsServiceException,
                                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketTaggingResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketTaggingResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketTaggingRequest, GetBucketTaggingResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketTaggingRequest).withMarshaller(new GetBucketTaggingRequestMarshaller()));
    }

    /**
     * Returns the versioning state of a bucket.
     *
     * @param getBucketVersioningRequest
     * @return Result of the GetBucketVersioning operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketVersioning
     */
    @Override
    public GetBucketVersioningResponse getBucketVersioning(GetBucketVersioningRequest getBucketVersioningRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketVersioningResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketVersioningResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketVersioningRequest, GetBucketVersioningResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketVersioningRequest).withMarshaller(new GetBucketVersioningRequestMarshaller()));
    }

    /**
     * Returns the website configuration for a bucket.
     *
     * @param getBucketWebsiteRequest
     * @return Result of the GetBucketWebsite operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetBucketWebsite
     */
    @Override
    public GetBucketWebsiteResponse getBucketWebsite(GetBucketWebsiteRequest getBucketWebsiteRequest) throws AwsServiceException,
                                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<GetBucketWebsiteResponse> responseHandler = new S3ResponseHandler<>(
            new GetBucketWebsiteResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetBucketWebsiteRequest, GetBucketWebsiteResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getBucketWebsiteRequest).withMarshaller(new GetBucketWebsiteRequestMarshaller()));
    }

    /**
     * Retrieves objects from Amazon S3.
     *
     * @param getObjectRequest
     * @param streamingHandler
     *        Functional interface for processing the streamed response content. The unmarshalled GetObjectResponse and
     *        an InputStream to the response content are provided as parameters to the callback. The callback may return
     *        a transformed type which will be the return value of this method. See
     *        {@link software.amazon.awssdk.core.sync.ResponseTransformer} for details on implementing this interface
     *        and for links to pre-canned implementations for common scenarios like downloading to a file. The service
     *        documentation for the response content is as follows 'Object data.'.
     * @return The transformed result of the ResponseTransformer.
     * @throws NoSuchKeyException
     *         The specified key does not exist.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetObject
     */
    @Override
    public <ReturnT> ReturnT getObject(GetObjectRequest getObjectRequest,
                                       ResponseTransformer<GetObjectResponse, ReturnT> responseTransformer) throws NoSuchKeyException, AwsServiceException,
                                                                                                                   SdkClientException, S3Exception {

        HttpResponseHandler<GetObjectResponse> responseHandler = new S3ResponseHandler<>(new GetObjectResponseUnmarshaller(),
                                                                                           new StaxOperationMetadata().withHasStreamingSuccessResponse(true));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(
            new ClientExecutionParams<GetObjectRequest, GetObjectResponse>().withResponseHandler(responseHandler)
                                                                            .withErrorResponseHandler(errorResponseHandler).withInput(getObjectRequest)
                                                                            .withMarshaller(new GetObjectRequestMarshaller()), responseTransformer);
    }

    /**
     * Returns the access control list (ACL) of an object.
     *
     * @param getObjectAclRequest
     * @return Result of the GetObjectAcl operation returned by the service.
     * @throws NoSuchKeyException
     *         The specified key does not exist.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetObjectAcl
     */
    @Override
    public GetObjectAclResponse getObjectAcl(GetObjectAclRequest getObjectAclRequest) throws NoSuchKeyException,
                                                                                             AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<GetObjectAclResponse> responseHandler = new S3ResponseHandler<>(
            new GetObjectAclResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetObjectAclRequest, GetObjectAclResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getObjectAclRequest).withMarshaller(new GetObjectAclRequestMarshaller()));
    }

    /**
     * Returns the tag-set of an object.
     *
     * @param getObjectTaggingRequest
     * @return Result of the GetObjectTagging operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetObjectTagging
     */
    @Override
    public GetObjectTaggingResponse getObjectTagging(GetObjectTaggingRequest getObjectTaggingRequest) throws AwsServiceException,
                                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<GetObjectTaggingResponse> responseHandler = new S3ResponseHandler<>(
            new GetObjectTaggingResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<GetObjectTaggingRequest, GetObjectTaggingResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(getObjectTaggingRequest).withMarshaller(new GetObjectTaggingRequestMarshaller()));
    }

    /**
     * Return torrent files from a bucket.
     *
     * @param getObjectTorrentRequest
     * @param streamingHandler
     *        Functional interface for processing the streamed response content. The unmarshalled
     *        GetObjectTorrentResponse and an InputStream to the response content are provided as parameters to the
     *        callback. The callback may return a transformed type which will be the return value of this method. See
     *        {@link software.amazon.awssdk.core.sync.ResponseTransformer} for details on implementing this interface
     *        and for links to pre-canned implementations for common scenarios like downloading to a file. The service
     *        documentation for the response content is as follows ''.
     * @return The transformed result of the ResponseTransformer.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.GetObjectTorrent
     */
    @Override
    public <ReturnT> ReturnT getObjectTorrent(GetObjectTorrentRequest getObjectTorrentRequest,
                                              ResponseTransformer<GetObjectTorrentResponse, ReturnT> responseTransformer) throws AwsServiceException,
                                                                                                                                 SdkClientException, S3Exception {

        HttpResponseHandler<GetObjectTorrentResponse> responseHandler = new S3ResponseHandler<>(
            new GetObjectTorrentResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(true));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(
            new ClientExecutionParams<GetObjectTorrentRequest, GetObjectTorrentResponse>()
                .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                .withInput(getObjectTorrentRequest).withMarshaller(new GetObjectTorrentRequestMarshaller()),
            responseTransformer);
    }

    /**
     * This operation is useful to determine if a bucket exists and you have permission to access it.
     *
     * @param headBucketRequest
     * @return Result of the HeadBucket operation returned by the service.
     * @throws NoSuchBucketException
     *         The specified bucket does not exist.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.HeadBucket
     */
    @Override
    public HeadBucketResponse headBucket(HeadBucketRequest headBucketRequest) throws NoSuchBucketException, AwsServiceException,
                                                                                     SdkClientException, S3Exception {

        S3ResponseHandler<HeadBucketResponse> responseHandler = new S3ResponseHandler<>(new HeadBucketResponseUnmarshaller(),
                                                                                            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<HeadBucketRequest, HeadBucketResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler).withInput(headBucketRequest)
                                         .withMarshaller(new HeadBucketRequestMarshaller()));
    }

    /**
     * The HEAD operation retrieves metadata from an object without returning the object itself. This operation is
     * useful if you're only interested in an object's metadata. To use HEAD, you must have READ access to the object.
     *
     * @param headObjectRequest
     * @return Result of the HeadObject operation returned by the service.
     * @throws NoSuchKeyException
     *         The specified key does not exist.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.HeadObject
     */
    @Override
    public HeadObjectResponse headObject(HeadObjectRequest headObjectRequest) throws NoSuchKeyException, AwsServiceException,
                                                                                     SdkClientException, S3Exception {

        S3ResponseHandler<HeadObjectResponse> responseHandler = new S3ResponseHandler<>(new HeadObjectResponseUnmarshaller(),
                                                                                            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<HeadObjectRequest, HeadObjectResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler).withInput(headObjectRequest)
                                         .withMarshaller(new HeadObjectRequestMarshaller()));
    }

    /**
     * Lists the analytics configurations for the bucket.
     *
     * @param listBucketAnalyticsConfigurationsRequest
     * @return Result of the ListBucketAnalyticsConfigurations operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListBucketAnalyticsConfigurations
     */
    @Override
    public ListBucketAnalyticsConfigurationsResponse listBucketAnalyticsConfigurations(
        ListBucketAnalyticsConfigurationsRequest listBucketAnalyticsConfigurationsRequest) throws AwsServiceException,
                                                                                                  SdkClientException, S3Exception {

        S3ResponseHandler<ListBucketAnalyticsConfigurationsResponse> responseHandler = new S3ResponseHandler<>(
            new ListBucketAnalyticsConfigurationsResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<ListBucketAnalyticsConfigurationsRequest, ListBucketAnalyticsConfigurationsResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(listBucketAnalyticsConfigurationsRequest)
                         .withMarshaller(new ListBucketAnalyticsConfigurationsRequestMarshaller()));
    }

    /**
     * Returns a list of inventory configurations for the bucket.
     *
     * @param listBucketInventoryConfigurationsRequest
     * @return Result of the ListBucketInventoryConfigurations operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListBucketInventoryConfigurations
     */
    @Override
    public ListBucketInventoryConfigurationsResponse listBucketInventoryConfigurations(
        ListBucketInventoryConfigurationsRequest listBucketInventoryConfigurationsRequest) throws AwsServiceException,
                                                                                                  SdkClientException, S3Exception {

        S3ResponseHandler<ListBucketInventoryConfigurationsResponse> responseHandler = new S3ResponseHandler<>(
            new ListBucketInventoryConfigurationsResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<ListBucketInventoryConfigurationsRequest, ListBucketInventoryConfigurationsResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(listBucketInventoryConfigurationsRequest)
                         .withMarshaller(new ListBucketInventoryConfigurationsRequestMarshaller()));
    }

    /**
     * Lists the metrics configurations for the bucket.
     *
     * @param listBucketMetricsConfigurationsRequest
     * @return Result of the ListBucketMetricsConfigurations operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListBucketMetricsConfigurations
     */
    @Override
    public ListBucketMetricsConfigurationsResponse listBucketMetricsConfigurations(
        ListBucketMetricsConfigurationsRequest listBucketMetricsConfigurationsRequest) throws AwsServiceException,
                                                                                              SdkClientException, S3Exception {

        S3ResponseHandler<ListBucketMetricsConfigurationsResponse> responseHandler = new S3ResponseHandler<>(
            new ListBucketMetricsConfigurationsResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<ListBucketMetricsConfigurationsRequest, ListBucketMetricsConfigurationsResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(listBucketMetricsConfigurationsRequest)
                         .withMarshaller(new ListBucketMetricsConfigurationsRequestMarshaller()));
    }

    /**
     * Returns a list of all buckets owned by the authenticated sender of the request.
     *
     * @param listBucketsRequest
     * @return Result of the ListBuckets operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListBuckets
     */
    @Override
    public ListBucketsResponse listBuckets(ListBucketsRequest listBucketsRequest) throws AwsServiceException, SdkClientException,
                                                                                         S3Exception {

        S3ResponseHandler<ListBucketsResponse> responseHandler = new S3ResponseHandler<>(
            new ListBucketsResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<ListBucketsRequest, ListBucketsResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(listBucketsRequest).withMarshaller(new ListBucketsRequestMarshaller()));
    }

    /**
     * This operation lists in-progress multipart uploads.
     *
     * @param listMultipartUploadsRequest
     * @return Result of the ListMultipartUploads operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListMultipartUploads
     */
    @Override
    public ListMultipartUploadsResponse listMultipartUploads(ListMultipartUploadsRequest listMultipartUploadsRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<ListMultipartUploadsResponse> responseHandler = new S3ResponseHandler<>(
            new ListMultipartUploadsResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<ListMultipartUploadsRequest, ListMultipartUploadsResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(listMultipartUploadsRequest).withMarshaller(new ListMultipartUploadsRequestMarshaller()));
    }

    /**
     * This operation lists in-progress multipart uploads.<br/>
     * <p>
     * This is a variant of
     * {@link #listMultipartUploads(software.amazon.awssdk.services.s3.model.ListMultipartUploadsRequest)} operation.
     * The return type is a custom iterable that can be used to iterate through all the pages. SDK will internally
     * handle making service calls for you.
     * </p>
     * <p>
     * When this operation is called, a custom iterable is returned but no service calls are made yet. So there is no
     * guarantee that the request is valid. As you iterate through the iterable, SDK will start lazily loading response
     * pages by making service calls until there are no pages left or your iteration stops. If there are errors in your
     * request, you will see the failures only after you start iterating through the iterable.
     * </p>
     *
     * <p>
     * The following are few ways to iterate through the response pages:
     * </p>
     * 1) Using a Stream
     *
     * <pre>
     * {@code
     * software.amazon.awssdk.services.s3.paginators.ListMultipartUploadsIterable responses = client.listMultipartUploadsPaginator(request);
     * responses.stream().forEach(....);
     * }
     * </pre>
     *
     * 2) Using For loop
     *
     * <pre>
     * {
     *     &#064;code
     *     software.amazon.awssdk.services.s3.paginators.ListMultipartUploadsIterable responses = client
     *             .listMultipartUploadsPaginator(request);
     *     for (software.amazon.awssdk.services.s3.model.ListMultipartUploadsResponse response : responses) {
     *         // do something;
     *     }
     * }
     * </pre>
     *
     * 3) Use iterator directly
     *
     * <pre>
     * {@code
     * software.amazon.awssdk.services.s3.paginators.ListMultipartUploadsIterable responses = client.listMultipartUploadsPaginator(request);
     * responses.iterator().forEachRemaining(....);
     * }
     * </pre>
     * <p>
     * <b>Note: If you prefer to have control on service calls, use the
     * {@link #listMultipartUploads(software.amazon.awssdk.services.s3.model.ListMultipartUploadsRequest)}
     * operation.</b>
     * </p>
     *
     * @param listMultipartUploadsRequest
     * @return A custom iterable that can be used to iterate through all the response pages.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListMultipartUploads
     */
    @Override
    public ListMultipartUploadsIterable listMultipartUploadsPaginator(ListMultipartUploadsRequest listMultipartUploadsRequest)
        throws AwsServiceException, SdkClientException, S3Exception {
        return new ListMultipartUploadsIterable(this, applyPaginatorUserAgent(listMultipartUploadsRequest));
    }

    /**
     * Returns metadata about all of the versions of objects in a bucket.
     *
     * @param listObjectVersionsRequest
     * @return Result of the ListObjectVersions operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListObjectVersions
     */
    @Override
    public ListObjectVersionsResponse listObjectVersions(ListObjectVersionsRequest listObjectVersionsRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<ListObjectVersionsResponse> responseHandler = new S3ResponseHandler<>(
            new ListObjectVersionsResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<ListObjectVersionsRequest, ListObjectVersionsResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(listObjectVersionsRequest).withMarshaller(new ListObjectVersionsRequestMarshaller()));
    }

    /**
     * Returns metadata about all of the versions of objects in a bucket.<br/>
     * <p>
     * This is a variant of
     * {@link #listObjectVersions(software.amazon.awssdk.services.s3.model.ListObjectVersionsRequest)} operation. The
     * return type is a custom iterable that can be used to iterate through all the pages. SDK will internally handle
     * making service calls for you.
     * </p>
     * <p>
     * When this operation is called, a custom iterable is returned but no service calls are made yet. So there is no
     * guarantee that the request is valid. As you iterate through the iterable, SDK will start lazily loading response
     * pages by making service calls until there are no pages left or your iteration stops. If there are errors in your
     * request, you will see the failures only after you start iterating through the iterable.
     * </p>
     *
     * <p>
     * The following are few ways to iterate through the response pages:
     * </p>
     * 1) Using a Stream
     *
     * <pre>
     * {@code
     * software.amazon.awssdk.services.s3.paginators.ListObjectVersionsIterable responses = client.listObjectVersionsPaginator(request);
     * responses.stream().forEach(....);
     * }
     * </pre>
     *
     * 2) Using For loop
     *
     * <pre>
     * {
     *     &#064;code
     *     software.amazon.awssdk.services.s3.paginators.ListObjectVersionsIterable responses = client
     *             .listObjectVersionsPaginator(request);
     *     for (software.amazon.awssdk.services.s3.model.ListObjectVersionsResponse response : responses) {
     *         // do something;
     *     }
     * }
     * </pre>
     *
     * 3) Use iterator directly
     *
     * <pre>
     * {@code
     * software.amazon.awssdk.services.s3.paginators.ListObjectVersionsIterable responses = client.listObjectVersionsPaginator(request);
     * responses.iterator().forEachRemaining(....);
     * }
     * </pre>
     * <p>
     * <b>Note: If you prefer to have control on service calls, use the
     * {@link #listObjectVersions(software.amazon.awssdk.services.s3.model.ListObjectVersionsRequest)} operation.</b>
     * </p>
     *
     * @param listObjectVersionsRequest
     * @return A custom iterable that can be used to iterate through all the response pages.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListObjectVersions
     */
    @Override
    public ListObjectVersionsIterable listObjectVersionsPaginator(ListObjectVersionsRequest listObjectVersionsRequest)
        throws AwsServiceException, SdkClientException, S3Exception {
        return new ListObjectVersionsIterable(this, applyPaginatorUserAgent(listObjectVersionsRequest));
    }

    /**
     * Returns some or all (up to 1000) of the objects in a bucket. You can use the request parameters as selection
     * criteria to return a subset of the objects in a bucket.
     *
     * @param listObjectsRequest
     * @return Result of the ListObjects operation returned by the service.
     * @throws NoSuchBucketException
     *         The specified bucket does not exist.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListObjects
     */
    @Override
    public ListObjectsResponse listObjects(ListObjectsRequest listObjectsRequest) throws NoSuchBucketException,
                                                                                         AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<ListObjectsResponse> responseHandler = new S3ResponseHandler<>(
            new ListObjectsResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<ListObjectsRequest, ListObjectsResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(listObjectsRequest).withMarshaller(new ListObjectsRequestMarshaller()));
    }

    /**
     * Returns some or all (up to 1000) of the objects in a bucket. You can use the request parameters as selection
     * criteria to return a subset of the objects in a bucket. Note: ListObjectsV2 is the revised List Objects API and
     * we recommend you use this revised API for new application development.
     *
     * @param listObjectsV2Request
     * @return Result of the ListObjectsV2 operation returned by the service.
     * @throws NoSuchBucketException
     *         The specified bucket does not exist.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListObjectsV2
     */
    @Override
    public ListObjectsV2Response listObjectsV2(ListObjectsV2Request listObjectsV2Request) throws NoSuchBucketException,
                                                                                                 AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<ListObjectsV2Response> responseHandler = new S3ResponseHandler<>(
            new ListObjectsV2ResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<ListObjectsV2Request, ListObjectsV2Response>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(listObjectsV2Request).withMarshaller(new ListObjectsV2RequestMarshaller()));
    }

    /**
     * Returns some or all (up to 1000) of the objects in a bucket. You can use the request parameters as selection
     * criteria to return a subset of the objects in a bucket. Note: ListObjectsV2 is the revised List Objects API and
     * we recommend you use this revised API for new application development.<br/>
     * <p>
     * This is a variant of {@link #listObjectsV2(software.amazon.awssdk.services.s3.model.ListObjectsV2Request)}
     * operation. The return type is a custom iterable that can be used to iterate through all the pages. SDK will
     * internally handle making service calls for you.
     * </p>
     * <p>
     * When this operation is called, a custom iterable is returned but no service calls are made yet. So there is no
     * guarantee that the request is valid. As you iterate through the iterable, SDK will start lazily loading response
     * pages by making service calls until there are no pages left or your iteration stops. If there are errors in your
     * request, you will see the failures only after you start iterating through the iterable.
     * </p>
     *
     * <p>
     * The following are few ways to iterate through the response pages:
     * </p>
     * 1) Using a Stream
     *
     * <pre>
     * {@code
     * software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable responses = client.listObjectsV2Paginator(request);
     * responses.stream().forEach(....);
     * }
     * </pre>
     *
     * 2) Using For loop
     *
     * <pre>
     * {
     *     &#064;code
     *     software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable responses = client.listObjectsV2Paginator(request);
     *     for (software.amazon.awssdk.services.s3.model.ListObjectsV2Response response : responses) {
     *         // do something;
     *     }
     * }
     * </pre>
     *
     * 3) Use iterator directly
     *
     * <pre>
     * {@code
     * software.amazon.awssdk.services.s3.paginators.ListObjectsV2Iterable responses = client.listObjectsV2Paginator(request);
     * responses.iterator().forEachRemaining(....);
     * }
     * </pre>
     * <p>
     * <b>Note: If you prefer to have control on service calls, use the
     * {@link #listObjectsV2(software.amazon.awssdk.services.s3.model.ListObjectsV2Request)} operation.</b>
     * </p>
     *
     * @param listObjectsV2Request
     * @return A custom iterable that can be used to iterate through all the response pages.
     * @throws NoSuchBucketException
     *         The specified bucket does not exist.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListObjectsV2
     */
    @Override
    public ListObjectsV2Iterable listObjectsV2Paginator(ListObjectsV2Request listObjectsV2Request) throws NoSuchBucketException,
                                                                                                          AwsServiceException, SdkClientException, S3Exception {
        return new ListObjectsV2Iterable(this, applyPaginatorUserAgent(listObjectsV2Request));
    }

    /**
     * Lists the parts that have been uploaded for a specific multipart upload.
     *
     * @param listPartsRequest
     * @return Result of the ListParts operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListParts
     */
    @Override
    public ListPartsResponse listParts(ListPartsRequest listPartsRequest) throws AwsServiceException, SdkClientException,
                                                                                 S3Exception {

        S3ResponseHandler<ListPartsResponse> responseHandler = new S3ResponseHandler<>(new ListPartsResponseUnmarshaller(),
                                                                                           new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<ListPartsRequest, ListPartsResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler).withInput(listPartsRequest)
                                         .withMarshaller(new ListPartsRequestMarshaller()));
    }

    /**
     * Lists the parts that have been uploaded for a specific multipart upload.<br/>
     * <p>
     * This is a variant of {@link #listParts(software.amazon.awssdk.services.s3.model.ListPartsRequest)} operation. The
     * return type is a custom iterable that can be used to iterate through all the pages. SDK will internally handle
     * making service calls for you.
     * </p>
     * <p>
     * When this operation is called, a custom iterable is returned but no service calls are made yet. So there is no
     * guarantee that the request is valid. As you iterate through the iterable, SDK will start lazily loading response
     * pages by making service calls until there are no pages left or your iteration stops. If there are errors in your
     * request, you will see the failures only after you start iterating through the iterable.
     * </p>
     *
     * <p>
     * The following are few ways to iterate through the response pages:
     * </p>
     * 1) Using a Stream
     *
     * <pre>
     * {@code
     * software.amazon.awssdk.services.s3.paginators.ListPartsIterable responses = client.listPartsPaginator(request);
     * responses.stream().forEach(....);
     * }
     * </pre>
     *
     * 2) Using For loop
     *
     * <pre>
     * {
     *     &#064;code
     *     software.amazon.awssdk.services.s3.paginators.ListPartsIterable responses = client.listPartsPaginator(request);
     *     for (software.amazon.awssdk.services.s3.model.ListPartsResponse response : responses) {
     *         // do something;
     *     }
     * }
     * </pre>
     *
     * 3) Use iterator directly
     *
     * <pre>
     * {@code
     * software.amazon.awssdk.services.s3.paginators.ListPartsIterable responses = client.listPartsPaginator(request);
     * responses.iterator().forEachRemaining(....);
     * }
     * </pre>
     * <p>
     * <b>Note: If you prefer to have control on service calls, use the
     * {@link #listParts(software.amazon.awssdk.services.s3.model.ListPartsRequest)} operation.</b>
     * </p>
     *
     * @param listPartsRequest
     * @return A custom iterable that can be used to iterate through all the response pages.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.ListParts
     */
    @Override
    public ListPartsIterable listPartsPaginator(ListPartsRequest listPartsRequest) throws AwsServiceException,
                                                                                          SdkClientException, S3Exception {
        return new ListPartsIterable(this, applyPaginatorUserAgent(listPartsRequest));
    }

    /**
     * Sets the accelerate configuration of an existing bucket.
     *
     * @param putBucketAccelerateConfigurationRequest
     * @return Result of the PutBucketAccelerateConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketAccelerateConfiguration
     */
    @Override
    public PutBucketAccelerateConfigurationResponse putBucketAccelerateConfiguration(
        PutBucketAccelerateConfigurationRequest putBucketAccelerateConfigurationRequest) throws AwsServiceException,
                                                                                                SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketAccelerateConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketAccelerateConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<PutBucketAccelerateConfigurationRequest, PutBucketAccelerateConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(putBucketAccelerateConfigurationRequest)
                         .withMarshaller(new PutBucketAccelerateConfigurationRequestMarshaller()));
    }

    /**
     * Sets the permissions on a bucket using access control lists (ACL).
     *
     * @param putBucketAclRequest
     * @return Result of the PutBucketAcl operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketAcl
     */
    @Override
    public PutBucketAclResponse putBucketAcl(PutBucketAclRequest putBucketAclRequest) throws AwsServiceException,
                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketAclResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketAclResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketAclRequest, PutBucketAclResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketAclRequest).withMarshaller(new PutBucketAclRequestMarshaller()));
    }

    /**
     * Sets an analytics configuration for the bucket (specified by the analytics configuration ID).
     *
     * @param putBucketAnalyticsConfigurationRequest
     * @return Result of the PutBucketAnalyticsConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketAnalyticsConfiguration
     */
    @Override
    public PutBucketAnalyticsConfigurationResponse putBucketAnalyticsConfiguration(
        PutBucketAnalyticsConfigurationRequest putBucketAnalyticsConfigurationRequest) throws AwsServiceException,
                                                                                              SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketAnalyticsConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketAnalyticsConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<PutBucketAnalyticsConfigurationRequest, PutBucketAnalyticsConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(putBucketAnalyticsConfigurationRequest)
                         .withMarshaller(new PutBucketAnalyticsConfigurationRequestMarshaller()));
    }

    /**
     * Sets the cors configuration for a bucket.
     *
     * @param putBucketCorsRequest
     * @return Result of the PutBucketCors operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketCors
     */
    @Override
    public PutBucketCorsResponse putBucketCors(PutBucketCorsRequest putBucketCorsRequest) throws AwsServiceException,
                                                                                                 SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketCorsResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketCorsResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketCorsRequest, PutBucketCorsResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketCorsRequest).withMarshaller(new PutBucketCorsRequestMarshaller()));
    }

    /**
     * Adds an inventory configuration (identified by the inventory ID) from the bucket.
     *
     * @param putBucketInventoryConfigurationRequest
     * @return Result of the PutBucketInventoryConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketInventoryConfiguration
     */
    @Override
    public PutBucketInventoryConfigurationResponse putBucketInventoryConfiguration(
        PutBucketInventoryConfigurationRequest putBucketInventoryConfigurationRequest) throws AwsServiceException,
                                                                                              SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketInventoryConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketInventoryConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<PutBucketInventoryConfigurationRequest, PutBucketInventoryConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(putBucketInventoryConfigurationRequest)
                         .withMarshaller(new PutBucketInventoryConfigurationRequestMarshaller()));
    }

    /**
     * Deprecated, see the PutBucketLifecycleConfiguration operation.
     *
     * @param putBucketLifecycleRequest
     * @return Result of the PutBucketLifecycle operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketLifecycle
     */
    @Override
    public PutBucketLifecycleResponse putBucketLifecycle(PutBucketLifecycleRequest putBucketLifecycleRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketLifecycleResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketLifecycleResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketLifecycleRequest, PutBucketLifecycleResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketLifecycleRequest).withMarshaller(new PutBucketLifecycleRequestMarshaller()));
    }

    /**
     * Sets lifecycle configuration for your bucket. If a lifecycle configuration exists, it replaces it.
     *
     * @param putBucketLifecycleConfigurationRequest
     * @return Result of the PutBucketLifecycleConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketLifecycleConfiguration
     */
    @Override
    public PutBucketLifecycleConfigurationResponse putBucketLifecycleConfiguration(
        PutBucketLifecycleConfigurationRequest putBucketLifecycleConfigurationRequest) throws AwsServiceException,
                                                                                              SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketLifecycleConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketLifecycleConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<PutBucketLifecycleConfigurationRequest, PutBucketLifecycleConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(putBucketLifecycleConfigurationRequest)
                         .withMarshaller(new PutBucketLifecycleConfigurationRequestMarshaller()));
    }

    /**
     * Set the logging parameters for a bucket and to specify permissions for who can view and modify the logging
     * parameters. To set the logging status of a bucket, you must be the bucket owner.
     *
     * @param putBucketLoggingRequest
     * @return Result of the PutBucketLogging operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketLogging
     */
    @Override
    public PutBucketLoggingResponse putBucketLogging(PutBucketLoggingRequest putBucketLoggingRequest) throws AwsServiceException,
                                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketLoggingResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketLoggingResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketLoggingRequest, PutBucketLoggingResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketLoggingRequest).withMarshaller(new PutBucketLoggingRequestMarshaller()));
    }

    /**
     * Sets a metrics configuration (specified by the metrics configuration ID) for the bucket.
     *
     * @param putBucketMetricsConfigurationRequest
     * @return Result of the PutBucketMetricsConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketMetricsConfiguration
     */
    @Override
    public PutBucketMetricsConfigurationResponse putBucketMetricsConfiguration(
        PutBucketMetricsConfigurationRequest putBucketMetricsConfigurationRequest) throws AwsServiceException,
                                                                                          SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketMetricsConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketMetricsConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<PutBucketMetricsConfigurationRequest, PutBucketMetricsConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(putBucketMetricsConfigurationRequest)
                         .withMarshaller(new PutBucketMetricsConfigurationRequestMarshaller()));
    }

    /**
     * Deprecated, see the PutBucketNotificationConfiguraiton operation.
     *
     * @param putBucketNotificationRequest
     * @return Result of the PutBucketNotification operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketNotification
     */
    @Override
    public PutBucketNotificationResponse putBucketNotification(PutBucketNotificationRequest putBucketNotificationRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketNotificationResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketNotificationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketNotificationRequest, PutBucketNotificationResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketNotificationRequest).withMarshaller(new PutBucketNotificationRequestMarshaller()));
    }

    /**
     * Enables notifications of specified events for a bucket.
     *
     * @param putBucketNotificationConfigurationRequest
     * @return Result of the PutBucketNotificationConfiguration operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketNotificationConfiguration
     */
    @Override
    public PutBucketNotificationConfigurationResponse putBucketNotificationConfiguration(
        PutBucketNotificationConfigurationRequest putBucketNotificationConfigurationRequest) throws AwsServiceException,
                                                                                                    SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketNotificationConfigurationResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketNotificationConfigurationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<PutBucketNotificationConfigurationRequest, PutBucketNotificationConfigurationResponse>()
                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                         .withInput(putBucketNotificationConfigurationRequest)
                         .withMarshaller(new PutBucketNotificationConfigurationRequestMarshaller()));
    }

    /**
     * Replaces a policy on a bucket. If the bucket already has a policy, the one in this request completely replaces
     * it.
     *
     * @param putBucketPolicyRequest
     * @return Result of the PutBucketPolicy operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketPolicy
     */
    @Override
    public PutBucketPolicyResponse putBucketPolicy(PutBucketPolicyRequest putBucketPolicyRequest) throws AwsServiceException,
                                                                                                         SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketPolicyResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketPolicyResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketPolicyRequest, PutBucketPolicyResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketPolicyRequest).withMarshaller(new PutBucketPolicyRequestMarshaller()));
    }

    /**
     * Creates a new replication configuration (or replaces an existing one, if present).
     *
     * @param putBucketReplicationRequest
     * @return Result of the PutBucketReplication operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketReplication
     */
    @Override
    public PutBucketReplicationResponse putBucketReplication(PutBucketReplicationRequest putBucketReplicationRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketReplicationResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketReplicationResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketReplicationRequest, PutBucketReplicationResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketReplicationRequest).withMarshaller(new PutBucketReplicationRequestMarshaller()));
    }

    /**
     * Sets the request payment configuration for a bucket. By default, the bucket owner pays for downloads from the
     * bucket. This configuration parameter enables the bucket owner (only) to specify that the person requesting the
     * download will be charged for the download. Documentation on requester pays buckets can be found at
     * http://docs.aws.amazon.com/AmazonS3/latest/dev/RequesterPaysBuckets.html
     *
     * @param putBucketRequestPaymentRequest
     * @return Result of the PutBucketRequestPayment operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketRequestPayment
     */
    @Override
    public PutBucketRequestPaymentResponse putBucketRequestPayment(PutBucketRequestPaymentRequest putBucketRequestPaymentRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketRequestPaymentResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketRequestPaymentResponseUnmarshaller(),
            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketRequestPaymentRequest, PutBucketRequestPaymentResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketRequestPaymentRequest).withMarshaller(new PutBucketRequestPaymentRequestMarshaller()));
    }

    /**
     * Sets the tags for a bucket.
     *
     * @param putBucketTaggingRequest
     * @return Result of the PutBucketTagging operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketTagging
     */
    @Override
    public PutBucketTaggingResponse putBucketTagging(PutBucketTaggingRequest putBucketTaggingRequest) throws AwsServiceException,
                                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketTaggingResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketTaggingResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketTaggingRequest, PutBucketTaggingResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketTaggingRequest).withMarshaller(new PutBucketTaggingRequestMarshaller()));
    }

    /**
     * Sets the versioning state of an existing bucket. To set the versioning state, you must be the bucket owner.
     *
     * @param putBucketVersioningRequest
     * @return Result of the PutBucketVersioning operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketVersioning
     */
    @Override
    public PutBucketVersioningResponse putBucketVersioning(PutBucketVersioningRequest putBucketVersioningRequest)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketVersioningResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketVersioningResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketVersioningRequest, PutBucketVersioningResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketVersioningRequest).withMarshaller(new PutBucketVersioningRequestMarshaller()));
    }

    /**
     * Set the website configuration for a bucket.
     *
     * @param putBucketWebsiteRequest
     * @return Result of the PutBucketWebsite operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutBucketWebsite
     */
    @Override
    public PutBucketWebsiteResponse putBucketWebsite(PutBucketWebsiteRequest putBucketWebsiteRequest) throws AwsServiceException,
                                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<PutBucketWebsiteResponse> responseHandler = new S3ResponseHandler<>(
            new PutBucketWebsiteResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutBucketWebsiteRequest, PutBucketWebsiteResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putBucketWebsiteRequest).withMarshaller(new PutBucketWebsiteRequestMarshaller()));
    }

    /**
     * Adds an object to a bucket.
     *
     * @param putObjectRequest
     * @param requestBody
     *        The content to send to the service. A {@link RequestBody} can be created using one of several factory
     *        methods for various sources of data. For example, to create a request body from a file you can do the
     *        following.
     *
     *        <pre>
     * {@code RequestBody.fromFile(new File("myfile.txt"))}
     * </pre>
     *
     *        See documentation in {@link RequestBody} for additional details and which sources of data are supported.
     *        The service documentation for the request content is as follows 'Object data.'
     * @return Result of the PutObject operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutObject
     */
    @Override
    public PutObjectResponse putObject(PutObjectRequest putObjectRequest, RequestBody requestBody) throws AwsServiceException,
                                                                                                          SdkClientException, S3Exception {

        S3ResponseHandler<PutObjectResponse> responseHandler = new S3ResponseHandler<>(new PutObjectResponseUnmarshaller(),
                                                                                           new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutObjectRequest, PutObjectResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler).withInput(putObjectRequest)
                                         .withMarshaller(new StreamingRequestMarshaller<PutObjectRequest>(new PutObjectRequestMarshaller(), requestBody)));
    }

    /**
     * uses the acl subresource to set the access control list (ACL) permissions for an object that already exists in a
     * bucket
     *
     * @param putObjectAclRequest
     * @return Result of the PutObjectAcl operation returned by the service.
     * @throws NoSuchKeyException
     *         The specified key does not exist.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutObjectAcl
     */
    @Override
    public PutObjectAclResponse putObjectAcl(PutObjectAclRequest putObjectAclRequest) throws NoSuchKeyException,
                                                                                             AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<PutObjectAclResponse> responseHandler = new S3ResponseHandler<>(
            new PutObjectAclResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutObjectAclRequest, PutObjectAclResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putObjectAclRequest).withMarshaller(new PutObjectAclRequestMarshaller()));
    }

    /**
     * Sets the supplied tag-set to an object that already exists in a bucket
     *
     * @param putObjectTaggingRequest
     * @return Result of the PutObjectTagging operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.PutObjectTagging
     */
    @Override
    public PutObjectTaggingResponse putObjectTagging(PutObjectTaggingRequest putObjectTaggingRequest) throws AwsServiceException,
                                                                                                             SdkClientException, S3Exception {

        S3ResponseHandler<PutObjectTaggingResponse> responseHandler = new S3ResponseHandler<>(
            new PutObjectTaggingResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<PutObjectTaggingRequest, PutObjectTaggingResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(putObjectTaggingRequest).withMarshaller(new PutObjectTaggingRequestMarshaller()));
    }

    /**
     * Restores an archived copy of an object back into Amazon S3
     *
     * @param restoreObjectRequest
     * @return Result of the RestoreObject operation returned by the service.
     * @throws ObjectAlreadyInActiveTierErrorException
     *         This operation is not allowed against this storage tier
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.RestoreObject
     */
    @Override
    public RestoreObjectResponse restoreObject(RestoreObjectRequest restoreObjectRequest)
        throws ObjectAlreadyInActiveTierErrorException, AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<RestoreObjectResponse> responseHandler = new S3ResponseHandler<>(
            new RestoreObjectResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<RestoreObjectRequest, RestoreObjectResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(restoreObjectRequest).withMarshaller(new RestoreObjectRequestMarshaller()));
    }

    /**
     * <p>
     * Uploads a part in a multipart upload.
     * </p>
     * <p>
     * <b>Note:</b> After you initiate multipart upload and upload one or more parts, you must either complete or abort
     * multipart upload in order to stop getting charged for storage of the uploaded parts. Only after you either
     * complete or abort multipart upload, Amazon S3 frees up the parts storage and stops charging you for the parts
     * storage.
     * </p>
     *
     * @param uploadPartRequest
     * @param requestBody
     *        The content to send to the service. A {@link RequestBody} can be created using one of several factory
     *        methods for various sources of data. For example, to create a request body from a file you can do the
     *        following.
     *
     *        <pre>
     * {@code RequestBody.fromFile(new File("myfile.txt"))}
     * </pre>
     *
     *        See documentation in {@link RequestBody} for additional details and which sources of data are supported.
     *        The service documentation for the request content is as follows 'Object data.'
     * @return Result of the UploadPart operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.UploadPart
     */
    @Override
    public UploadPartResponse uploadPart(UploadPartRequest uploadPartRequest, RequestBody requestBody)
        throws AwsServiceException, SdkClientException, S3Exception {

        S3ResponseHandler<UploadPartResponse> responseHandler = new S3ResponseHandler<>(new UploadPartResponseUnmarshaller(),
                                                                                            new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler
            .execute(new ClientExecutionParams<UploadPartRequest, UploadPartResponse>()
                         .withResponseHandler(responseHandler)
                         .withErrorResponseHandler(errorResponseHandler)
                         .withInput(uploadPartRequest)
                         .withMarshaller(
                             new StreamingRequestMarshaller<UploadPartRequest>(new UploadPartRequestMarshaller(), requestBody)));
    }

    /**
     * Uploads a part by copying data from an existing object as data source.
     *
     * @param uploadPartCopyRequest
     * @return Result of the UploadPartCopy operation returned by the service.
     * @throws SdkException
     *         Base class for all exceptions that can be thrown by the SDK (both service and client). Can be used for
     *         catch all scenarios.
     * @throws SdkClientException
     *         If any client side error occurs such as an IO related failure, failure to get credentials, etc.
     * @throws S3Exception
     *         Base class for all service exceptions. Unknown exceptions will be thrown as an instance of this type.
     * @sample S3Client.UploadPartCopy
     */
    @Override
    public UploadPartCopyResponse uploadPartCopy(UploadPartCopyRequest uploadPartCopyRequest) throws AwsServiceException,
                                                                                                     SdkClientException, S3Exception {

        S3ResponseHandler<UploadPartCopyResponse> responseHandler = new S3ResponseHandler<>(
            new UploadPartCopyResponseUnmarshaller(), new StaxOperationMetadata().withHasStreamingSuccessResponse(false));

        DefaultErrorResponseHandler errorResponseHandler = new DefaultErrorResponseHandler(exceptionUnmarshallers);

        return clientHandler.execute(new ClientExecutionParams<UploadPartCopyRequest, UploadPartCopyResponse>()
                                         .withResponseHandler(responseHandler).withErrorResponseHandler(errorResponseHandler)
                                         .withInput(uploadPartCopyRequest).withMarshaller(new UploadPartCopyRequestMarshaller()));
    }

    private List<Unmarshaller<AwsServiceException, Node>> init() {
        List<Unmarshaller<AwsServiceException, Node>> unmarshallers = new ArrayList<>();
        unmarshallers.add(new NoSuchUploadExceptionUnmarshaller());
        unmarshallers.add(new ObjectAlreadyInActiveTierErrorExceptionUnmarshaller());
        unmarshallers.add(new BucketAlreadyExistsExceptionUnmarshaller());
        unmarshallers.add(new NoSuchBucketExceptionUnmarshaller());
        unmarshallers.add(new ObjectNotInActiveTierErrorExceptionUnmarshaller());
        unmarshallers.add(new BucketAlreadyOwnedByYouExceptionUnmarshaller());
        unmarshallers.add(new NoSuchKeyExceptionUnmarshaller());
        unmarshallers.add(new StandardS3ExceptionUnmarshaller(S3Exception.class));
        return unmarshallers;
    }

    @Override
    public void close() {
        clientHandler.close();
    }

    private <T extends S3Request> T applyPaginatorUserAgent(T request) {
        Consumer<AwsRequestOverrideConfiguration.Builder> userAgentApplier = b -> b.addApiName(ApiName.builder()
                                                                                                      .version(VersionInfo.SDK_VERSION).name("PAGINATED").build());
        AwsRequestOverrideConfiguration overrideConfiguration = request.overrideConfiguration()
                                                                       .map(c -> c.toBuilder().applyMutation(userAgentApplier).build())
                                                                       .orElse((AwsRequestOverrideConfiguration.builder().applyMutation(userAgentApplier).build()));
        return (T) request.toBuilder().overrideConfiguration(overrideConfiguration).build();
    }
}
