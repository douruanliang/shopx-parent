package com.shopx.manager.feign;
import com.github.pagehelper.PageInfo;
import com.shopx.manager.pojo.SysRoleUser;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:dourl
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="manager",path = "/sysRoleUser")
public interface SysRoleUserFeign {

    /***
     * SysRoleUser分页条件搜索实现
     * @param sysRoleUser
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysRoleUser sysRoleUser, @PathVariable int page, @PathVariable  int size);

    /***
     * SysRoleUser分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysRoleUser
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysRoleUser>> findList(@RequestBody(required = false) SysRoleUser sysRoleUser);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改SysRoleUser数据
     * @param sysRoleUser
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysRoleUser sysRoleUser,@PathVariable Integer id);

    /***
     * 新增SysRoleUser数据
     * @param sysRoleUser
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysRoleUser sysRoleUser);

    /***
     * 根据ID查询SysRoleUser数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysRoleUser> findById(@PathVariable Integer id);

    /***
     * 查询SysRoleUser全部数据
     * @return
     */
    @GetMapping
    Result<List<SysRoleUser>> findAll();
}