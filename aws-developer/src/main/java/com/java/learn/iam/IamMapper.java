package com.example.iam;

import org.mapstruct.Mapper;
import software.amazon.awssdk.services.iam.model.User;

@Mapper(componentModel = "spring")
public interface IamMapper {

    default IamUser toIamUser(User user) {
        return IamUser.builder()
                .userId(user.userId())
                .username(user.userName())
                .arn(user.arn())
                .createDate(user.createDate().toString())
                .build();
    }
}
