package com.shopx.manager.service;

import com.github.pagehelper.PageInfo;
import com.shopx.manager.pojo.SysRoleUser;

import java.util.List;

/****
 * @Author:dourl
 * @Description:SysRoleUser业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysRoleUserService {

    /***
     * SysRoleUser多条件分页查询
     * @param sysRoleUser
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysRoleUser> findPage(SysRoleUser sysRoleUser, int page, int size);

    /***
     * SysRoleUser分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysRoleUser> findPage(int page, int size);

    /***
     * SysRoleUser多条件搜索方法
     * @param sysRoleUser
     * @return
     */
    List<SysRoleUser> findList(SysRoleUser sysRoleUser);

    /***
     * 删除SysRoleUser
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改SysRoleUser数据
     * @param sysRoleUser
     */
    void update(SysRoleUser sysRoleUser);

    /***
     * 新增SysRoleUser
     * @param sysRoleUser
     */
    void add(SysRoleUser sysRoleUser);

    /**
     * 根据ID查询SysRoleUser
     * @param id
     * @return
     */
     SysRoleUser findById(Integer id);

    /***
     * 查询所有SysRoleUser
     * @return
     */
    List<SysRoleUser> findAll();
}
