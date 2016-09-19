package com.xxg.cloudstorage;

import com.aliyun.oss.OSSClient;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/**
 * 阿里云对象存储OSS
 * 文档: https://help.aliyun.com/document_detail/32008.html?spm=5176.doc32008.3.3.3YkvaP
 */
public class AliyunCloudStorageService implements CloudStorageService {

    private String endpoint;
    private String accessKeyId;
    private String accessKeySecret;
    private String bucket;

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    @Override
    public void upload(byte[] data, String path) throws Exception {
        upload(new ByteArrayInputStream(data), path);
    }

    @Override
    public void upload(InputStream inputStream, String path) throws Exception {
        OSSClient client = new OSSClient(endpoint, accessKeyId, accessKeySecret);
        try {
            client.putObject(bucket, path, inputStream);
        } finally {
            client.shutdown();
        }
    }

    @Override
    public void upload(File file, String path) throws Exception {
        upload(new FileInputStream(file), path);
    }
}
