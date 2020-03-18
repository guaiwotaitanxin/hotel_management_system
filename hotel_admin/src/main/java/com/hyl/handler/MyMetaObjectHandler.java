package com.hyl.handler;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author 韩宇龙
 * @create 2020-02-28 14:33
 */
@Component  //实例化注解
public class MyMetaObjectHandler implements MetaObjectHandler {
    //insertFill方法会在mp执行添加操作的时候运行
    @Override
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("createDate",new Date(),metaObject);

    }

    //updateFill方法在mp执行修改操作的时候运行
    @Override
    public void updateFill(MetaObject metaObject) {


    }
}
