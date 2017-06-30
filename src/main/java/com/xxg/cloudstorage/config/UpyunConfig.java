package com.xxg.cloudstorage.config;

/**
 * Created by wucao on 2017/6/29.
 */
public class UpyunConfig extends BaseConfig {

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

    public String getBucket() {
        return bucket;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
