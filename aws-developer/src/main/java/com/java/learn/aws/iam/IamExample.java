package com.java.learn.aws.iam;

import com.java.learn.aws.AwsCredentialsLoader;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.iam.IamClient;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("iam")
public class IamExample {

    private AwsCredentialsLoader loader;
    private IamMapper mapper;

    public IamExample(AwsCredentialsLoader loader,
                      IamMapper mapper) {
        this.loader = loader;
        this.mapper = mapper;
    }

    private IamClient getClient() {
        return IamClient.builder()
                .credentialsProvider(loader.getCredentialsProvider())
                .region(Region.AWS_GLOBAL)
                .build();
    }

    @GetMapping("list")
    public List<IamUser> listUsers() {
        return getClient().listUsers().users()
                .stream()
                .map(mapper::toIamUser)
                .collect(Collectors.toList());
    }

}
