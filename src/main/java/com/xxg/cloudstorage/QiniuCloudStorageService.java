package com.xxg.cloudstorage;

import com.qiniu.http.Response;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import com.xxg.cloudstorage.config.QiniuConfig;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.File;
import java.io.InputStream;

/**
 * 七牛云存储
 * 文档: http://developer.qiniu.com/code/v7/sdk/java.html
 */
public class QiniuCloudStorageService implements CloudStorageService {

    private QiniuConfig qiniuConfig;

    public void setQiniuConfig(QiniuConfig qiniuConfig) {
        this.qiniuConfig = qiniuConfig;
    }

    @Override
    public void upload(byte[] data, String path) throws Exception {
        Auth auth = Auth.create(qiniuConfig.getAccessKey(), qiniuConfig.getSecretKey());
        UploadManager uploadManager = new UploadManager();
        Response res = uploadManager.put(data, path, auth.uploadToken(qiniuConfig.getBucket()));
        if (!res.isOK()) {
            throw new RuntimeException("上传七牛出错：" + res.toString());
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
        return qiniuConfig.getHttpBase();
    }
}
