package com.hyl.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.hyl.entity.User;
import com.hyl.entity.query.QueryUser;
import com.hyl.mapper.UserMapper;
import com.hyl.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *   用户业务层实现类
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {

    //条件查询带分页
    @Override
    public void pageListCondtion(Page<User> userpage, QueryUser queryUser) {
        //关键点  queryUser 传递过来的条件值，判断，如果有条件值，拼接条件
        if (queryUser==null){
            //直接查询分页，不进行条件操作
            baseMapper.selectPage(userpage,null);
            return;
        }
       /*如果queryUser不为空
       * 从queryUser对象里面获取条件值*/
        String username = queryUser.getUsername();
        String useStatus = queryUser.getUseStatus();
        String isAdmin = queryUser.getIsAdmin();
        String roleId = queryUser.getRoleId();
        //判断条件是否有，有就拼接条件
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(username)){
            //拼接条件
            wrapper.like("username",username);
        }

        if (!StringUtils.isEmpty(useStatus)){
            //拼接条件
            wrapper.like("use_status",useStatus);
        }
        if (!StringUtils.isEmpty(isAdmin)){
            //拼接条件
            wrapper.like("is_admin",isAdmin);
        }
        if (!StringUtils.isEmpty(roleId)){
            //拼接条件
            wrapper.like("role_id",roleId);
        }
        //条件查询带分页
        baseMapper.selectPage(userpage,wrapper);
    }
}
