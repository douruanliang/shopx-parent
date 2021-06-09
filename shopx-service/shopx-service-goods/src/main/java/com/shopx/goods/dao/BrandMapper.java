package com.shopx.goods.dao;

import com.shopx.goods.pojo.Brand;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;


/**
 * Mapper<Brand>  指定通用的mapper的父接口:封装了所有的CRUD的操作
 * T  指定操作的表对应的POJO
 */
public interface BrandMapper extends Mapper<Brand> {
    @Select(value="select tb.* from tb_brand tb ,tb_category_brand tbc where tb.id = tbc.brand_id and tbc.category_id=#{categoryid}")
    List<Brand> findByCategory(Integer categoryid);
}
