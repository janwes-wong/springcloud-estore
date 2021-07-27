package com.estore.item.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.estore.item.mapper.ItemMapper;
import com.estore.item.pojo.ItemInfo;
import com.estore.item.service.ItemService;
import org.springframework.stereotype.Service;

/**
 * @author Janwes
 * @version 1.0
 * @package com.estore.item.service.impl
 * @date 2021/7/25 21:54
 * @description
 */
@Service
public class ItemServiceImpl extends ServiceImpl<ItemMapper, ItemInfo> implements ItemService {
}
