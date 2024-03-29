package com.shopx.goods.feign;

import com.shopx.goods.pojo.Category;
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
@FeignClient(value="goods")
@RequestMapping("/category")
public interface CategoryFeign {
    @GetMapping("/{id}")
    public Result<Category> findById(@PathVariable(name = "id") Integer id);
}
