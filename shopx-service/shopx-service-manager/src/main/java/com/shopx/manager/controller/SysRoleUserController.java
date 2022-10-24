package com.shopx.manager.controller;

import com.github.pagehelper.PageInfo;
import com.shopx.manager.pojo.SysRoleUser;
import com.shopx.manager.service.SysRoleUserService;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/****
 * @Author:dourl
 * @Description:
 * @Date 2019/6/14 0:18
 *****/

@RestController
@RequestMapping("/sysRoleUser")
@CrossOrigin
public class SysRoleUserController {

    @Autowired
    private SysRoleUserService sysRoleUserService;

    /***
     * SysRoleUser分页条件搜索实现
     * @param sysRoleUser
     * @param page
     * @param size
     * @return
     */
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false)  SysRoleUser sysRoleUser, @PathVariable  int page, @PathVariable  int size){
        //调用SysRoleUserService实现分页条件查询SysRoleUser
        PageInfo<SysRoleUser> pageInfo = sysRoleUserService.findPage(sysRoleUser, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * SysRoleUser分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用SysRoleUserService实现分页查询SysRoleUser
        PageInfo<SysRoleUser> pageInfo = sysRoleUserService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param sysRoleUser
     * @return
     */
    @PostMapping(value = "/search" )
    public Result<List<SysRoleUser>> findList(@RequestBody(required = false)  SysRoleUser sysRoleUser){
        //调用SysRoleUserService实现条件查询SysRoleUser
        List<SysRoleUser> list = sysRoleUserService.findList(sysRoleUser);
        return new Result<List<SysRoleUser>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Integer id){
        //调用SysRoleUserService实现根据主键删除
        sysRoleUserService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改SysRoleUser数据
     * @param sysRoleUser
     * @param id
     * @return
     */
    @PutMapping(value="/{id}")
    public Result update(@RequestBody  SysRoleUser sysRoleUser,@PathVariable Integer id){
        //设置主键值
        sysRoleUser.setUserId(id);
        //调用SysRoleUserService实现修改SysRoleUser
        sysRoleUserService.update(sysRoleUser);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增SysRoleUser数据
     * @param sysRoleUser
     * @return
     */
    @PostMapping
    public Result add(@RequestBody   SysRoleUser sysRoleUser){
        //调用SysRoleUserService实现添加SysRoleUser
        sysRoleUserService.add(sysRoleUser);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询SysRoleUser数据
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result<SysRoleUser> findById(@PathVariable Integer id){
        //调用SysRoleUserService实现根据主键查询SysRoleUser
        SysRoleUser sysRoleUser = sysRoleUserService.findById(id);
        return new Result<SysRoleUser>(true,StatusCode.OK,"查询成功",sysRoleUser);
    }

    /***
     * 查询SysRoleUser全部数据
     * @return
     */
    @GetMapping
    public Result<List<SysRoleUser>> findAll(){
        //调用SysRoleUserService实现查询所有SysRoleUser
        List<SysRoleUser> list = sysRoleUserService.findAll();
        return new Result<List<SysRoleUser>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
