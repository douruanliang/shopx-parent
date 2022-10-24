package com.shopx.manager.pojo;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 用户和角色关联边表
 *
 * @author linSir
 */

@Table(name="sys_role_user")
public class SysRoleUser {
    @Id
    @Column(name = "userId")
    private Integer userId;
    @Id
    @Column(name = "roleId")
    private Integer roleId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }
}
