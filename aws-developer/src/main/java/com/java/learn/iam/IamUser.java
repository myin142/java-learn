package com.java.learn.iam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class IamUser {
    private String userId;
    private String createDate;
    private String username;
    private String arn;
}
