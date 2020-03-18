package com.hyl.entity.query;

import lombok.Data;

/**
 * @author 韩宇龙
 * @create 2020-03-15 20:36
 */

@Data
public class QueryUser {
    private String username;
    private String useStatus;
    private String isAdmin;
    private String roleId;
}
