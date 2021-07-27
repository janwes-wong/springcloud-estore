package com.estore.order.feign;

import com.estore.common.model.Result;
import com.estore.order.feign.fallback.ItemInfoFallback;
import com.estore.order.pojo.ItemInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author Janwes
 * @version 1.0
 * @package com.estore.order.feign
 * @date 2021/7/27 14:53
 * @description
 */
@FeignClient(name = "estore-service-item", path = "/item", fallback = ItemInfoFallback.class)
public interface ItemInfoFeign {

    @PostMapping("/itemInfo")
    Result<ItemInfo> findItemInfo(@RequestParam("itemId") String itemId);
}
