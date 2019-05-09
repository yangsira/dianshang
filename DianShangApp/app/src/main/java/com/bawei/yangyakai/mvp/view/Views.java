package com.bawei.yangyakai.mvp.view;

/**
 * @Author：杨
 * @E-mail： 15001194794@163.com
 * @Date：2019/4/15 13:51
 * @Description：描述信息
 */
public interface Views {
    void success(int type, String data);

    void fail(int type, String error);
}
