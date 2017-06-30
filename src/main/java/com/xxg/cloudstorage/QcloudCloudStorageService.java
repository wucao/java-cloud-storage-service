package com.xxg.cloudstorage;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.request.UploadFileRequest;
import com.xxg.cloudstorage.config.QcloudConfig;
import org.json.JSONObject;

import java.io.File;
import java.io.InputStream;

/**
 * 腾讯云对象存储服务COS
 * 文档: https://www.qcloud.com/doc/product/430/5944
 */
public class QcloudCloudStorageService implements CloudStorageService {

    private QcloudConfig qcloudConfig;

    public void setQcloudConfig(QcloudConfig qcloudConfig) {
        this.qcloudConfig = qcloudConfig;
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
        if(!path.startsWith("/")) {
            path = "/" + path;
        }
        COSClient cosClient = new COSClient(qcloudConfig.getAppId(), qcloudConfig.getSecretId(), qcloudConfig.getSecretKey());
        UploadFileRequest uploadFileRequest = new UploadFileRequest(qcloudConfig.getBucket(), path, file.getPath());
        String response = cosClient.uploadFile(uploadFileRequest);
        JSONObject jsonObject = new JSONObject(response);
        if(jsonObject.getInt("code") != 0) {
            throw new RuntimeException("上传文件异常: " + jsonObject.getString("message"));
        }
    }

    @Override
    public String getBaseUrl() {
        return qcloudConfig.getHttpBase();
    }
}
