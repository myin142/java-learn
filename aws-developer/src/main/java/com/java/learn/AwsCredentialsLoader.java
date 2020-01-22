package com.java.learn;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import software.amazon.awssdk.auth.credentials.*;
import software.amazon.awssdk.core.exception.SdkClientException;

@Component
@Slf4j
@PropertySource("application-aws.properties")
public class AwsCredentialsLoader {

    @Value("${accessKey}")
    private String accessKey;

    @Value("${secretAccessKey}")
    private String secretAccessKey;

    /**
     * Default Credential Provider Chain of AWS
     *      Java System Properties:
     *          aws.accessKeyId and aws.secretAccessKey, loaded using
     *          @see software.amazon.awssdk.auth.credentials.SystemPropertyCredentialsProvider
     *      Environment Variables:
     *          AWS_ACCESS_KEY_ID and AWS_SECRET_ACCESS_KEY, loaded using
     *          @see software.amazon.awssdk.auth.credentials.EnvironmentVariableCredentialsProvider
     *      Default Credential Profiles File:
     *          Location varies, typically ~/.aws/credentials, loaded using
     *          @see software.amazon.awssdk.auth.credentials.ProfileCredentialsProvider
     *      Amazon ECS container credentials:
     *          Loaded from AWS_CONTAINER_CREDENTIALS_RELATIVE_URI using
     *          @see software.amazon.awssdk.auth.credentials.ContainerCredentialsProvider
     *      Instance Profile Credentials:
     *          Used inside EC2, retrieved from EC2 metadata service using
     *          @see software.amazon.awssdk.auth.credentials.InstanceProfileCredentialsProvider
     *
     * Environment Variables:
     *      AWS_PROFILE - change profile loaded from SDK
     *      AWS_CREDENTIALS_PROFILES_FILE - change credentials file (full path)
     */

    public AwsCredentials getCredentials() {
        AwsCredentials credentials;

        try {
            credentials = DefaultCredentialsProvider.create().resolveCredentials();
        } catch (SdkClientException ex) {
            log.info("Using credentials from properties file");
            credentials = AwsBasicCredentials.create(accessKey, secretAccessKey);
        }

        log.info("Access Key: " + credentials.accessKeyId());
        log.info("Secret Access Key: " + credentials.secretAccessKey());

        return credentials;
    }

    public AwsCredentialsProvider getCredentialsProvider() {
        return StaticCredentialsProvider.create(getCredentials());
    }
}
