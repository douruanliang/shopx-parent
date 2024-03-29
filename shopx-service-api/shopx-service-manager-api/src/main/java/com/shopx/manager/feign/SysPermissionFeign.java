package com.shopx.manager.feign;
import com.github.pagehelper.PageInfo;
import com.shopx.manager.pojo.SysPermission;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:dourl
 * @Description:
 * @Date 2019/6/18 13:58
 *****/
@FeignClient(name="manager",path = "/sysPermission")
public interface SysPermissionFeign {

    /***
     * SysPermission分页条件搜索实现
     * @param sysPermission
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@RequestBody(required = false) SysPermission sysPermission, @PathVariable int page, @PathVariable  int size);

    /***
     * SysPermission分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size);

    /***
     * 多条件搜索品牌数据
     * @param sysPermission
     * @return
     */
    @PostMapping(value = "/search" )
    Result<List<SysPermission>> findList(@RequestBody(required = false) SysPermission sysPermission);

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    Result delete(@PathVariable Integer id);

    /***
     * 修改SysPermission数据
     * @param sysPermission
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    Result update(@RequestBody SysPermission sysPermission,@PathVariable Integer id);

    /***
     * 新增SysPermission数据
     * @param sysPermission
     * @return
     */
    @PostMapping
    Result add(@RequestBody SysPermission sysPermission);

    /***
     * 根据ID查询SysPermission数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    Result<SysPermission> findById(@PathVariable Integer id);

    /***
     * 查询SysPermission全部数据
     * @return
     */
    @GetMapping
    Result<List<SysPermission>> findAll();
}