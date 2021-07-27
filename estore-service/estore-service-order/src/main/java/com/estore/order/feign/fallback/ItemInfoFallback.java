package com.estore.order.feign.fallback;

import com.estore.common.model.Result;
import com.estore.order.feign.ItemInfoFeign;
import com.estore.order.pojo.ItemInfo;
import org.springframework.stereotype.Component;

/**
 * @author Janwes
 * @version 1.0
 * @package com.estore.order.feign.fallback
 * @date 2021/7/27 15:02
 * @description 容错降级 实现feign接口服务降级，也可在feign接口创建内部类并实现feign接口
 */
@Component
public class ItemInfoFallback implements ItemInfoFeign {

    @Override
    public Result<ItemInfo> findItemInfo(String itemId) {
        // 演示 当被调用方服务 mall-item服务宕机或关闭时，则被触发并返回该实现类的数据(或者直接返回null也可以)
        return Result.ok(new ItemInfo(null, "hello,message：" + itemId + " send failed", null, null, null, 0));
    }
}
