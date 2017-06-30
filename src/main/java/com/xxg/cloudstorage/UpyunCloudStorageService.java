package com.xxg.cloudstorage;

import com.xxg.cloudstorage.config.UpyunConfig;
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

    private UpyunConfig upyunConfig;

    public void setUpyunConfig(UpyunConfig upyunConfig) {
        this.upyunConfig = upyunConfig;
    }

    @Override
    public void upload(byte[] data, String path) throws Exception {
        UpYun upyun = new UpYun(upyunConfig.getBucket(), upyunConfig.getUsername(), upyunConfig.getPassword());
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

    @Override
    public String getBaseUrl() {
        return upyunConfig.getHttpBase();
    }
}
