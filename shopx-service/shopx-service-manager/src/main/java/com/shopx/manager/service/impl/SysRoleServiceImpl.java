package com.shopx.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopx.manager.dao.SysRoleMapper;
import com.shopx.manager.pojo.SysRole;
import com.shopx.manager.service.SysRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:dourl
 * @Description:SysRole业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysRoleServiceImpl implements SysRoleService {

    @Autowired
    private SysRoleMapper sysRoleMapper;


    /**
     * SysRole条件+分页查询
     * @param sysRole 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysRole> findPage(SysRole sysRole, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysRole);
        //执行搜索
        return new PageInfo<SysRole>(sysRoleMapper.selectByExample(example));
    }

    /**
     * SysRole分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysRole> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysRole>(sysRoleMapper.selectAll());
    }

    /**
     * SysRole条件查询
     * @param sysRole
     * @return
     */
    @Override
    public List<SysRole> findList(SysRole sysRole){
        //构建查询条件
        Example example = createExample(sysRole);
        //根据构建的条件查询数据
        return sysRoleMapper.selectByExample(example);
    }


    /**
     * SysRole构建查询对象
     * @param sysRole
     * @return
     */
    public Example createExample(SysRole sysRole){
        Example example=new Example(SysRole.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysRole!=null){
            // 
            if(!StringUtils.isEmpty(sysRole.getId())){
                    criteria.andEqualTo("id",sysRole.getId());
            }
            // 
            if(!StringUtils.isEmpty(sysRole.getName())){
                    criteria.andLike("name","%"+sysRole.getName()+"%");
            }
            // 
            if(!StringUtils.isEmpty(sysRole.getDescription())){
                    criteria.andEqualTo("description",sysRole.getDescription());
            }
            // 
            if(!StringUtils.isEmpty(sysRole.getCreated())){
                    criteria.andEqualTo("createTime",sysRole.getCreated());
            }
            // 
            if(!StringUtils.isEmpty(sysRole.getUpdated())){
                    criteria.andEqualTo("updateTime",sysRole.getUpdated());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Integer id){
        sysRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysRole
     * @param sysRole
     */
    @Override
    public void update(SysRole sysRole){
        sysRoleMapper.updateByPrimaryKey(sysRole);
    }

    /**
     * 增加SysRole
     * @param sysRole
     */
    @Override
    public void add(SysRole sysRole){
        sysRoleMapper.insert(sysRole);
    }

    /**
     * 根据ID查询SysRole
     * @param id
     * @return
     */
    @Override
    public SysRole findById(Integer id){
        return  sysRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysRole全部数据
     * @return
     */
    @Override
    public List<SysRole> findAll() {
        return sysRoleMapper.selectAll();
    }
}
