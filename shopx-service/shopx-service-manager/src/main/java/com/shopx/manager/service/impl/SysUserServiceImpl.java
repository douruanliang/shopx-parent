package com.shopx.manager.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shopx.manager.dao.SysUserMapper;
import com.shopx.manager.pojo.SysUser;
import com.shopx.manager.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/****
 * @Author:dourl
 * @Description:SysUser业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class SysUserServiceImpl implements SysUserService {

    @Autowired
    private SysUserMapper sysUserMapper;


    /**
     * SysUser条件+分页查询
     * @param sysUser 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<SysUser> findPage(SysUser sysUser, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(sysUser);
        //执行搜索
        return new PageInfo<SysUser>(sysUserMapper.selectByExample(example));
    }

    /**
     * SysUser分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<SysUser> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<SysUser>(sysUserMapper.selectAll());
    }

    /**
     * SysUser条件查询
     * @param sysUser
     * @return
     */
    @Override
    public List<SysUser> findList(SysUser sysUser){
        //构建查询条件
        Example example = createExample(sysUser);
        //根据构建的条件查询数据
        return sysUserMapper.selectByExample(example);
    }


    /**
     * SysUser构建查询对象
     * @param sysUser
     * @return
     */
    public Example createExample(SysUser sysUser){
        Example example=new Example(SysUser.class);
        Example.Criteria criteria = example.createCriteria();
        if(sysUser!=null){
            // 
            if(!StringUtils.isEmpty(sysUser.getId())){
                    criteria.andEqualTo("id",sysUser.getId());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getUsername())){
                    criteria.andLike("username","%"+sysUser.getUsername()+"%");
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getPassword())){
                    criteria.andEqualTo("password",sysUser.getPassword());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getNickname())){
                    criteria.andLike("nickname","%"+sysUser.getNickname()+"%");
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getHeadImgUrl())){
                    criteria.andEqualTo("headImgUrl",sysUser.getHeadImgUrl());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getPhone())){
                    criteria.andEqualTo("phone",sysUser.getPhone());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getTelephone())){
                    criteria.andEqualTo("telephone",sysUser.getTelephone());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getEmail())){
                    criteria.andEqualTo("email",sysUser.getEmail());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getBirthday())){
                    criteria.andEqualTo("birthday",sysUser.getBirthday());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getSex())){
                    criteria.andEqualTo("sex",sysUser.getSex());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getStatus())){
                    criteria.andEqualTo("status",sysUser.getStatus());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getCreated())){
                    criteria.andEqualTo("createTime",sysUser.getCreated());
            }
            // 
            if(!StringUtils.isEmpty(sysUser.getUpdated())){
                    criteria.andEqualTo("updateTime",sysUser.getUpdated());
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
        sysUserMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改SysUser
     * @param sysUser
     */
    @Override
    public void update(SysUser sysUser){
        sysUserMapper.updateByPrimaryKey(sysUser);
    }

    /**
     * 增加SysUser
     * @param sysUser
     */
    @Override
    public void add(SysUser sysUser){
        sysUserMapper.insert(sysUser);
    }

    /**
     * 根据ID查询SysUser
     * @param id
     * @return
     */
    @Override
    public SysUser findById(Integer id){
        return  sysUserMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询SysUser全部数据
     * @return
     */
    @Override
    public List<SysUser> findAll() {
        return sysUserMapper.selectAll();
    }
}
