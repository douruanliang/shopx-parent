package com.shopx.goods.dao;
import com.shopx.goods.pojo.Sku;
import com.shopx.order.pojo.OrderItem;
import org.apache.ibatis.annotations.Update;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Description:Sku的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface SkuMapper extends Mapper<Sku> {
    /**
     * 库存递减
     * @param orderItem
     * @return
     */
    @Update(value="update tb_sku set num=num-#{num},sale_num=sale_num+#{num} where id =#{skuId} and num >=#{num}")
    public int decrCount(OrderItem orderItem);
}
