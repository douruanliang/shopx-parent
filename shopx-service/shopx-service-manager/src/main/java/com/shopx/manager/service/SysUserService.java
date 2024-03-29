package com.shopx.manager.service;

import com.github.pagehelper.PageInfo;
import com.shopx.manager.pojo.SysUser;

import java.util.List;

/****
 * @Author:dourl
 * @Description:SysUser业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface SysUserService {

    /***
     * SysUser多条件分页查询
     * @param sysUser
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysUser> findPage(SysUser sysUser, int page, int size);

    /***
     * SysUser分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<SysUser> findPage(int page, int size);

    /***
     * SysUser多条件搜索方法
     * @param sysUser
     * @return
     */
    List<SysUser> findList(SysUser sysUser);

    /***
     * 删除SysUser
     * @param id
     */
    void delete(Integer id);

    /***
     * 修改SysUser数据
     * @param sysUser
     */
    void update(SysUser sysUser);

    /***
     * 新增SysUser
     * @param sysUser
     */
    void add(SysUser sysUser);

    /**
     * 根据ID查询SysUser
     * @param id
     * @return
     */
     SysUser findById(Integer id);

    /***
     * 查询所有SysUser
     * @return
     */
    List<SysUser> findAll();
}
