package com.dumas.pedestal.framework.mybatis.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dumas.pedestal.common.model.api.vo.PageVO;
import com.dumas.pedestal.common.model.param.PageParam;

/**
 * 分页工具
 *
 * @author dumas
 * @date 2021/12/06 2:58 PM
 */
public class PageUtil {
    public static <T> PageVO<T> toPageVO(IPage<T> page) {
        return PageVO.ofPage(page.getTotal(), page.getRecords(), page.getCurrent(), page.getSize());
    }

    public static <T> IPage<T> fromPageParam(PageParam param) {
        IPage<T> page = new Page<>(param.getPageNo(), param.getPageSize());
        return page;
    }
}
