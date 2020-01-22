package com.example.lambda;

import com.example.AwsCredentialsLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.lambda.LambdaClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("lambda")
public class LambdaExample {

    private AwsCredentialsLoader loader;
    private LambdaMapper mapper;

    public LambdaExample(AwsCredentialsLoader loader,
                         LambdaMapper mapper) {
        this.loader = loader;
        this.mapper = mapper;
    }

    private LambdaClient getClient() {
        return LambdaClient.builder()
                .credentialsProvider(loader.getCredentialsProvider())
                .region(Region.EU_CENTRAL_1)
                .build();
    }

    @GetMapping("list")
    public List<LambdaFunction> listFunctions() {
        return getClient().listFunctions()
                .functions()
                .stream()
                .map(mapper::toLambdaFunction)
                .collect(Collectors.toList());
    }

}
