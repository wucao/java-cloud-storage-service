package com.xxg.cloudstorage;

import main.java.com.UpYun;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.InputStream;

/**
 * 又拍云
 * 文档: https://github.com/upyun/java-sdk
 */
public class UpyunCloudStorageService implements CloudStorageService {

    private String bucket;
    private String username;
    private String password;

    public void setBucket(String bucket) {
        this.bucket = bucket;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public void upload(byte[] data, String path) throws Exception {
        UpYun upyun = new UpYun(bucket, username, password);
        boolean success = upyun.writeFile(path, data, true);
        if(!success) {
            throw new RuntimeException("上传又拍云出错");
        }
    }

    @Override
    public void upload(InputStream inputStream, String path) throws Exception {
        upload(IOUtils.toByteArray(inputStream), path);
    }

    @Override
    public void upload(File file, String path) throws Exception {
        upload(FileUtils.readFileToByteArray(file), path);
    }
}
