# java-cloud-storage-service
七牛云、又拍云、阿里云对象存储OSS、腾讯云对象存储服务COS，Java文件上传客户端。

## Maven依赖使用方式
首先加入java-cloud-storage-service依赖包:
```
<repositories>
    <repository>
        <id>xxg-repository</id>
        <url>http://repo.maven.xxgblog.com/</url>
    </repository>
</repositories>
```
```
<dependency>
    <groupId>com.xxg</groupId>
    <artifactId>cloudstorage</artifactId>
    <version>1.0.0</version>
</dependency>
```
再根据实际所使用的云存储提供商加入对应的依赖:

七牛:
```
<dependency>
    <groupId>com.qiniu</groupId>
    <artifactId>qiniu-java-sdk</artifactId>
    <version>[7.0.0, 7.0.99]</version>
</dependency>
```
阿里云对象存储OSS:
```
<dependency>
    <groupId>com.aliyun.oss</groupId>
    <artifactId>aliyun-sdk-oss</artifactId>
    <version>2.3.0</version>
</dependency>
```
又拍云:
```
<dependency>
    <groupId>com.upyun</groupId>
    <artifactId>java-sdk</artifactId>
    <version>3.10</version>
</dependency>
```
腾讯云对象存储服务COS:
```
<dependency>
    <groupId>com.qcloud</groupId>
    <artifactId>cos_api</artifactId>
    <version>3.3</version>
</dependency>
```

## 七牛云
### 文档
http://developer.qiniu.com/code/v7/sdk/java.html

### 文件上传代码
```
String httpBase = "http://o8sw7lrki.bkt.clouddn.com/"; // 云存储HTTP地址
String target = "your/path/test.png"; // 上传到云存储的目标路径
String filePath = "/Users/wucao/Desktop/test.png"; // 本地文件

QiniuCloudStorageService cloudStorageService = new QiniuCloudStorageService();
cloudStorageService.setAccessKey("<your accessKey>");
cloudStorageService.setSecretKey("<your secretKey>");
cloudStorageService.setBucket("<your bucket>");

cloudStorageService.upload(new File(filePath), target);
System.out.println("文件HTTP地址: " + httpBase + target);
```
### 使用Spring
```
<bean class="com.xxg.cloudstorage.QiniuCloudStorageService">
    <property name="accessKey" value="<your accessKey>" />
    <property name="secretKey" value="<your secretKey>" />
    <property name="bucket" value="<your bucket>" />
</bean>
```

## 阿里云对象存储OSS
### 文档
https://help.aliyun.com/document_detail/32008.html?spm=5176.doc32008.3.3.3YkvaP

### 文件上传代码
```
String httpBase = "http://vsgames.oss-cn-beijing.aliyuncs.com/"; // 云存储HTTP地址
String target = "your/path/test.png"; // 上传到云存储的目标路径
String filePath = "/Users/wucao/Desktop/test.png"; // 本地文件

AliyunCloudStorageService cloudStorageService = new AliyunCloudStorageService();
cloudStorageService.setEndpoint("<your endpoint>"); // 根据文档配置: https://help.aliyun.com/document_detail/32010.html?spm=5176.doc32010.6.304.uVKI6q
cloudStorageService.setAccessKeyId("<your endpoint>");
cloudStorageService.setAccessKeySecret("<your accessKeySecret>");
cloudStorageService.setBucket("<your bucket>");

cloudStorageService.upload(new File(filePath), target);
System.out.println("文件HTTP地址: " + httpBase + target);
```
### 使用Spring
```
<bean class="com.xxg.cloudstorage.AliyunCloudStorageService">
    <property name="endpoint" value="<your endpoint>" />
    <property name="accessKeyId" value="<your endpoint>" />
    <property name="accessKeySecret" value="<your accessKeySecret>" />
    <property name="bucket" value="<your bucket>" />
</bean>
```

## 又拍云
### 文档
https://github.com/upyun/java-sdk

### 文件上传代码
```
String httpBase = "http://wyuca.b0.upaiyun.com/"; // 云存储HTTP地址
String target = "your/path/test.png"; // 上传到云存储的目标路径
String filePath = "/Users/wucao/Desktop/test.png"; // 本地文件

UpyunCloudStorageService cloudStorageService = new UpyunCloudStorageService();
cloudStorageService.setUsername("<操作员用户名>");
cloudStorageService.setPassword("<操作员密码>");
cloudStorageService.setBucket("<your bucket>");

cloudStorageService.upload(new File(filePath), target);
System.out.println("文件HTTP地址: " + httpBase + target);
```

### 使用Spring
```
<bean class="com.xxg.cloudstorage.UpyunCloudStorageService">
    <property name="username" value="<操作员用户名>" />
    <property name="password" value="<操作员密码>" />
    <property name="bucket" value="<your bucket>" />
</bean>
```

## 腾讯云对象存储服务COS
### 文档
https://www.qcloud.com/doc/product/430/5944

### 文件上传代码
```
String httpBase = "http://xxg-10066313.cos.myqcloud.com"; // 云存储HTTP地址
String target = "/your/path/test.png"; // 上传到云存储的目标路径
String filePath = "/Users/wucao/Desktop/test.png"; // 本地文件

QcloudCloudStorageService cloudStorageService = new QcloudCloudStorageService();
cloudStorageService.setAppId(<your appId>);
cloudStorageService.setSecretId("<your secretId>");
cloudStorageService.setSecretKey("<your secretKey>");
cloudStorageService.setBucket("<your bucket>");

cloudStorageService.upload(new File(filePath), target);
System.out.println("文件HTTP地址: " + httpBase + target);
```

### 使用Spring
```
<bean class="com.xxg.cloudstorage.QcloudCloudStorageService">
    <property name="appId" value="<your appId>" />
    <property name="secretId" value="<your secretId>" />
    <property name="secretKey" value="<your secretKey>" />
    <property name="bucket" value="<your bucket>" />
</bean>
```

## 不重复文件名上传工具

该工具通过UUID生成唯一不重复的文件名，上传文件成功时返回对应的HTTP地址。

### 文件上传代码
```
XxxCloudStorageService cloudStorageService = new XxxCloudStorageService();
...

UniqueFileUploader uniqueFileUploader = new UniqueFileUploader();
uniqueFileUploader.setCloudStorageService(cloudStorageService);
uniqueFileUploader.setHttpBase("http://wyuca.b0.upaiyun.com");
String httpUrl1 = uniqueFileUploader.upload(new File("/Users/wucao/Desktop/test.png"), "png");
String httpUrl2 = uniqueFileUploader.upload(new FileInputStream("/Users/wucao/Desktop/test.png"), "png");
System.out.println(httpUrl1);
System.out.println(httpUrl2);
```

### 使用Spring
```
<bean id="cloudStorageService" class="com.xxg.cloudstorage.XxxCloudStorageService">
    ...
</bean>

<bean class="com.xxg.cloudstorage.UniqueFileUploader">
    <property name="cloudStorageService" ref="cloudStorageService" />
    <property name="httpBase" value="http://xxg-10066313.cos.myqcloud.com/" />
</bean>
```
