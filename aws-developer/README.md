## AWS Developer Associate (2020)

 - [Information](https://aws.amazon.com/certification/certified-developer-associate/)
 - [Exam Guide](https://d1.awsstatic.com/training-and-certification/docs-dev-associate/AWS_Certified_Developer_Associate-Exam_Guide_EN_1.4.pdf)
 - [Certification Preparation](https://aws.amazon.com/certification/certification-prep/)
 
#### Table of Contents
 - [Deployment (22%)](#deployment)
    - [Elastic Beanstalk](#elastic-beanstalk)
    - [Cloud Formation](#cloud-formation)
    - [Serverless Application Model](#serverless-application-model-sam)
    - [Code](#code)
 - [Security (26%)](#security)
    - [Identity Access Management](#identity-access-management-iam)
    - [Security Token Service](#security-token-service-sts)
    - [Cognito](#cognito)
    - [Key Management Service](#key-management-service-kms)
    - [CloudHSM](#cloudhsm-hardware-security-modules)
    - [Virtual Private Cloud](#virtual-private-cloud-vpc)
    - [Encryption](#encryption)
 - [Development with AWS Services (30%)](#development-with-aws-services)
 - [Refactoring (10%)](#refactoring)
 - [Monitoring and Troubleshooting (12%)](#monitoring-and-troubleshooting)

#### Deployment
 - Deploy written code in AWS using CI/CD pipelines, processes and patterns
 - Deploy applications using AWS Elastic Beanstalk
 - Prepare the application package to be deployed to AWS
 - Deploy serverless applications
 
##### Axioms
 - Elastic Load Balancing and Auto Scaling are designed to work together
 - Scaling out is better than scaling up
 - AWS Elastic Beanstalk allows you to focus on building your application
 - CloudFormation templates allow you to have a definition of resources to create
 - A serverless application is typically a combination of Lamba + other AWS services

##### Elastic Beanstalk
 - For deploying and scaling web applications
    - In Java, .NET, PHP, Node.js, Python, Ruby, Go and Docker
    - On Apache Tomcat, Nginx, Passenger and IIS
 - Configure using `.config` file inside `.ebextensions` folder on top level
 - Handles
    - Deployment
    - Capacity Provisioning
    - Load Balancing
    - Auto-scaling
    - Application Health
 - Deployment Policies
    - All at once
    - Rolling
    - Rolling with additional batch
    - Immutable
 - RDB instance can be launched within Elastic Beanstalk
    - Useful for Dev and Test systems
    - Not for production, database tied to application lifecycle

##### Cloud Formation
 - Manage AWS infrastructure as code
 - Resulting resources called stack
 - Intrinsic Functions - start with (Fn:: or !) + Ref
 - Template
    - AWSTemplateFormatVersion: "2010-09-09"
    - Description
    - Metadata
    - Parameters - input custom values
    - Mappings - set values based on region, ...
    - Conditions - provision based on environment
    - Transform - include snippets of code
    - Resources (only required) - AWS resources to create
    - Outputs
 - Nested Stacks
    - Stacks create other stacks
    - Allow re-use of CloudFormation code for common use cases
    - Templates stores in S3 and referenced in resources
    - Type: `AWS::CloudFormation::Stack`
    
##### Serverless Application Model (SAM)
 - Extension of CloudFormation for serverless applications
 - Simplified syntax
 - SAM CLI
 - Template - same as CloudFormation plus:
    - Transform: AWS::Serverless-2016-10-31 (required)
    - Globals - properties common to all serverless functions and APIs
    
##### Code
 - CodeCommit - source control service
 - CodeBuild - build service
    - Configure using `buildspec.yml`
 - CodeDeploy - deployment service
    - Configure using `appspec.yml` or `appspec.json` (Lambda only)
    - Deploy to EC2, on-premise and lambda
    - Deployment Approaches
        - In-Place
            - stop and update, rolling update
            - only EC2 and on-premise
        - Blue/Green
            - Blue active deployment
            - Green new release
            - Elastic Load Balancer re-routes traffic
 - CodePipeline - CI and CD service

#### Security
 - Make authenticated calls to AWS services
 - Implement encryption using AWS services
 - Implement application authentication and authorization
 
##### Axioms
 - Lock down Master Account
 - Security groups only allow, NACLs allow explicit deny
 - Prefer IAM Roles to Access Keys
 
![Shared Responsibility](./img/shared-responsibility.jpg)
 
##### Identity Access Management (IAM)
 - User: represents person or service
    - When creating own user instead of using root
    - When other people need access, but no other identity mechanism
    - When want to use CLI
 - Group: collection of IAM users
 - Role: set of permissions for users, applications or services
    - When application on EC2 needs access
    - When creating mobile apps
    - When company users want access AWS without sign in again
 - Policy: defines authorization
    - Managed Policies: managed by AWS
    - Customer Managed Policies: standalone policy, managed by ourselves
    - Inline Policies: embedded within user, group or role
 - Features
    - Identity Federation - grant access without IAM users
    - Password Rotation Policy
    - Temporary Access
    - Multi Factor Authentication
    - Analyze Access
    
##### Security Token Service (STS)
 - Temporary Security Credentials
 - Configurable Credential Lifetime
 - IAM Policies to control permissions
 
##### Cognito
 - User Pools - Identity Pools
 - For Web and Mobile Applications
 - Web Identity Federation (Amazon, Facebook, Google)
 - SAML 2.0-based Federation (Microsoft Active Directory, LDAPS, Open LDAP)
 
##### Key Management Service (KMS)
 - AWS managed keys
 - Customer managed keys
 - Customer Master key
 - KMS Envelope Encryption: KMS Master Key encrypts envelope key

##### CloudHSM (Hardware Security Modules)
 - Generate and use own encryption keys
 
##### Virtual Private Cloud (VPC)
 - Security Group: firewall for EC2, controlling in/out traffic
 - Network Access Control List (NACLs): firewall for subnets, controlling in/out traffic
 - Flow Logs: capture information about IP in/out traffic
 
| Security Group                        | Network Access Control List                           |
|---------------------------------------|-------------------------------------------------------|
|At instance level                      | At subnet level                                       |
|Allow rules only                       | Allow rules and deny rules                            |
|Stateful: return traffic auto. allowed | Stateless: return traffic must be explicit allowed    |
|Evaluate all rules before deciding     | Process rules in number order when deciding           |
|Applies only to instance if set        | Auto. applies to all instances of subnet              |

![VPC Security Diagram](./img/security-diagram.png)

##### Encryption
 - Encryption on transit
    - Using SSL/TLS
    - AWS Certificate Manager (ACM)
        - Use in Load Balancing, CloudFront distributions
 - S3
    - Server-Side Encryption (AES-256) - using AWS or customer provided keys
        - Amazon S3-managed keys (SSE-S3)
        - KMS-managed keys (SSE-KMS)
        - Customer-provided keys (SSE-C)
    - Client-Side Encryption on Upload: **x-amz-server-side-encryption**
        - AES256 - SSE-S3
        - ams:kms - SSE-KMS
 - RDS
    - Encryption using AWS KMS for instance, backups and snapshots
    - Encryption on existing DB instances not supported

#### Development with AWS Services

#### Refactoring

#### Monitoring and Troubleshooting


