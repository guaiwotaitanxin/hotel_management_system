package com.hyl.common;

/**
 * @author 韩宇龙
 * @create 2020-03-15 13:44
 */

/*

* 定义返回数据使用的状态码
* */
public interface ResultCode {

    int SUCCESS = 20000;//成功的状态码

    int ERROR = 20001;//失败的状态码

    int AUTH = 30000;//没有操作权限状态码
}
