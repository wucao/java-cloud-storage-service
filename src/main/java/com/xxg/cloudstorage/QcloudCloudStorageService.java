package com.xxg.cloudstorage;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.request.UploadFileRequest;

import java.io.File;
import java.io.InputStream;

/**
 * 腾讯云对象存储服务COS
 * 文档: https://www.qcloud.com/doc/product/430/5944
 */
public class QcloudCloudStorageService implements CloudStorageService {

    private int appId;
    private String secretId;
    private String secretKey;
    private String bucket;

    public void setAppId(int appId) {
        this.appId = appId;
    }

    public void setSecretId(String secretId) {
        this.secretId = secretId;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    @Override
    public void upload(byte[] data, String path) throws Exception {
        throw new IllegalArgumentException("不支持的方法, 请使用upload(File file, String format)");
    }

    @Override
    public void upload(InputStream inputStream, String path) throws Exception {
        throw new IllegalArgumentException("不支持的方法, 请使用upload(File file, String format)");
    }

    @Override
    public void upload(File file, String path) throws Exception {
        COSClient cosClient = new COSClient(appId, secretId, secretKey);
        UploadFileRequest uploadFileRequest = new UploadFileRequest(bucket, path, file.getPath());
        String uploadFileRet = cosClient.uploadFile(uploadFileRequest);
        System.out.println(uploadFileRet);
    }
}
