package com.bawei.yangyakai.bean;

import com.stx.xhb.xbanner.entity.SimpleBannerInfo;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/29 19:40
 * @Description：描述信息
 */
public class ParticuImageBean extends SimpleBannerInfo {
    private String IagemeUrl;

    public String getIagemeUrl() {
        return IagemeUrl;
    }

    public void setIagemeUrl(String iagemeUrl) {
        IagemeUrl = iagemeUrl;
    }

    @Override
    public Object getXBannerUrl() {
        return null;
    }
}
