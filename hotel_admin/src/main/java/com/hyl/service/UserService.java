package com.hyl.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.hyl.entity.User;
import com.hyl.entity.query.QueryUser;

/**
 *   用户业务层对象
 */
public interface UserService extends IService<User> {

    //条件查询带分页
    void pageListCondtion(Page<User> userpage, QueryUser queryUser);
}
