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
    <version>1.2.2</version>
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

QiniuConfig qiniuConfig = new QiniuConfig();
qiniuConfig.setAccessKey("<your accessKey>");
qiniuConfig.setSecretKey("<your secretKey>");
qiniuConfig.setBucket("<your bucket>");
QiniuCloudStorageService cloudStorageService = new QiniuCloudStorageService();
cloudStorageService.setQiniuConfig(qiniuConfig);

cloudStorageService.upload(new File(filePath), target);
System.out.println("文件HTTP地址: " + httpBase + target);
```
### 使用Spring
```
<bean id="qiniuConfig" class="com.xxg.cloudstorage.config.QiniuConfig">
    <property name="accessKey" value="<your accessKey>" />
    <property name="secretKey" value="<your secretKey>" />
    <property name="bucket" value="<your bucket>" />
</bean>
<bean class="com.xxg.cloudstorage.QiniuCloudStorageService">
    <property name="qiniuConfig" ref="qiniuConfig" />
</bean>
```

## 阿里云对象存储OSS
### 文档
https://help.aliyun.com/document_detail/32008.html?spm=5176.doc32008.3.3.3YkvaP

### 文件上传代码
待补充
### 使用Spring
待补充

## 又拍云
### 文档
https://github.com/upyun/java-sdk

### 文件上传代码
待补充

### 使用Spring
待补充

## 腾讯云对象存储服务COS
### 文档
https://www.qcloud.com/doc/product/430/5944

### 文件上传代码
待补充

### 使用Spring
待补充

## 不重复文件名上传工具

该工具通过UUID生成唯一不重复的文件名，上传文件成功时返回对应的HTTP地址。

### 文件上传代码
待补充

### 使用Spring
待补充
