package com.xxg.cloudstorage;

import com.aliyun.oss.OSSClient;
import com.xxg.cloudstorage.config.AliyunConfig;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 阿里云对象存储OSS
 * 文档: https://help.aliyun.com/document_detail/32008.html?spm=5176.doc32008.3.3.3YkvaP
 */
public class AliyunCloudStorageService implements CloudStorageService {

    private AliyunConfig aliyunConfig;

    public void setAliyunConfig(AliyunConfig aliyunConfig) {
        this.aliyunConfig = aliyunConfig;
    }

    @Override
    public void upload(byte[] data, String path) throws Exception {
        upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public void upload(InputStream inputStream, String path) throws Exception {
        if(path.startsWith("/")) {
            path = path.substring(1);
        }
        OSSClient client = new OSSClient(aliyunConfig.getEndpoint(), aliyunConfig.getAccessKeyId(), aliyunConfig.getAccessKeySecret());
        try {
            client.putObject(aliyunConfig.getBucket(), path, inputStream);
        } finally {
            client.shutdown();
        }
    }

    @Override
    public void upload(File file, String path) throws Exception {
        upload(new FileInputStream(file), path);
    }

    @Override
    public String getBaseUrl() {
        return aliyunConfig.getHttpBase();
    }
}
