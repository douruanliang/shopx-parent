package com.shopx.manager.feign;
import com.github.pagehelper.PageInfo;
import com.shopx.manager.pojo.SysRole;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:dourl
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="manager",path = "/sysRole")
public interface SysRoleFeign {

    /***
     * SysRole分页条件搜索实现
     * @param sysRole
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysRole sysRole, @PathVariable int page, @PathVariable  int size);

    /***
     * SysRole分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysRole
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysRole>> findList(@RequestBody(required = false) SysRole sysRole);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改SysRole数据
     * @param sysRole
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysRole sysRole,@PathVariable Integer id);

    /***
     * 新增SysRole数据
     * @param sysRole
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysRole sysRole);

    /***
     * 根据ID查询SysRole数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysRole> findById(@PathVariable Integer id);

    /***
     * 查询SysRole全部数据
     * @return
     */
    @GetMapping
    Result<List<SysRole>> findAll();
}