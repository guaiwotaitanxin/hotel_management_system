package com.hyl.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;


@Data
@AllArgsConstructor  //有参构造
@NoArgsConstructor  //无参构造
public class User {
    /** 主键 */
    private Long id;

    /** 账号 */
    private String username;

    /** 密码 */
    private String pwd;

    /** 创建时间 */
    @TableField(fill = FieldFill.INSERT)//自动填充
    private Date createDate;

    /** 启用状态：1删除，0未删除 */
    @TableLogic//逻辑删除注解
    private String useStatus;

    /** 1超级管理员，0普通管理员 */
    private String isAdmin;

    /** 角色id */
    private Integer roleId;


}