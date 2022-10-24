package com.shopx.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopx.manager.dao.SysRoleUserMapper;
import com.shopx.manager.pojo.SysRoleUser;
import com.shopx.manager.service.SysRoleUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:dourl
 * @Description:SysRoleUser业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysRoleUserServiceImpl implements SysRoleUserService {

    @Autowired
    private SysRoleUserMapper sysRoleUserMapper;


    /**
     * SysRoleUser条件+分页查询
     * @param sysRoleUser 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysRoleUser> findPage(SysRoleUser sysRoleUser, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysRoleUser);
        //执行搜索
        return new PageInfo<SysRoleUser>(sysRoleUserMapper.selectByExample(example));
    }

    /**
     * SysRoleUser分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysRoleUser> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysRoleUser>(sysRoleUserMapper.selectAll());
    }

    /**
     * SysRoleUser条件查询
     * @param sysRoleUser
     * @return
     */
    @Override
    public List<SysRoleUser> findList(SysRoleUser sysRoleUser){
        //构建查询条件
        Example example = createExample(sysRoleUser);
        //根据构建的条件查询数据
        return sysRoleUserMapper.selectByExample(example);
    }


    /**
     * SysRoleUser构建查询对象
     * @param sysRoleUser
     * @return
     */
    public Example createExample(SysRoleUser sysRoleUser){
        Example example=new Example(SysRoleUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysRoleUser!=null){
            // 
            if(!StringUtils.isEmpty(sysRoleUser.getUserId())){
                    criteria.andEqualTo("userId",sysRoleUser.getUserId());
            }
            // 
            if(!StringUtils.isEmpty(sysRoleUser.getRoleId())){
                    criteria.andEqualTo("roleId",sysRoleUser.getRoleId());
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
        sysRoleUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysRoleUser
     * @param sysRoleUser
     */
    @Override
    public void update(SysRoleUser sysRoleUser){
        sysRoleUserMapper.updateByPrimaryKey(sysRoleUser);
    }

    /**
     * 增加SysRoleUser
     * @param sysRoleUser
     */
    @Override
    public void add(SysRoleUser sysRoleUser){
        sysRoleUserMapper.insert(sysRoleUser);
    }

    /**
     * 根据ID查询SysRoleUser
     * @param id
     * @return
     */
    @Override
    public SysRoleUser findById(Integer id){
        return  sysRoleUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysRoleUser全部数据
     * @return
     */
    @Override
    public List<SysRoleUser> findAll() {
        return sysRoleUserMapper.selectAll();
    }
}
