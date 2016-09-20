# java-cloud-storage-service
七牛云、又拍云、阿里云对象存储OSS、腾讯云对象存储服务COS，Java文件上传客户端。

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
String target = "/your/path/test.png"; // 上传到云存储的目标路径, 腾讯云必须是'/'开头
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