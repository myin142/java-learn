package com.java.learn.aws.lambda;

import org.mapstruct.Mapper;
import software.amazon.awssdk.services.lambda.model.FunctionConfiguration;

@Mapper(componentModel = "spring")
public interface LambdaMapper {

    default LambdaFunction toLambdaFunction(FunctionConfiguration configuration) {
        return LambdaFunction.builder()
                .functionArn(configuration.functionArn())
                .functionName(configuration.functionName())
                .build();
    }
}
