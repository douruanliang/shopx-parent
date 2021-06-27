package com.shopx.user.feign;
import com.shopx.user.pojo.User;
import entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 描述
 *
 * @version 1.0
 * @since 1.0
 */
@FeignClient(name="user")
@RequestMapping("/user")
public interface UserFeign {
    /**
     *
     * @param id
     * @return
     */
    @GetMapping("/load/{id}")
    public Result<User> findByUsername(@PathVariable(name="id") String id);
}
