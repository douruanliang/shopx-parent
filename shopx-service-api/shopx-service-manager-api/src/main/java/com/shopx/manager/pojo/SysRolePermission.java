package com.shopx.manager.pojo;


import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 角色和权限关联表\
 *
 * */
@Table(name="sys_role_permission")
public class SysRolePermission {
    @Id
    @Column(name = "roleId")
    private Integer roleId;
    @Id
    @Column(name = "permissionId")
    private Integer permissionId;

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}
