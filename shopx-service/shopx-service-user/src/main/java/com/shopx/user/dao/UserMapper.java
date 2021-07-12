package com.shopx.user.dao;
import com.shopx.user.pojo.User;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:admin
 * @Description:User的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface UserMapper extends Mapper<User> {

    @Update(value="update tb_user set points = points+#{points} where username=#{username}")
    void addPoints(Integer points, String username);
}
