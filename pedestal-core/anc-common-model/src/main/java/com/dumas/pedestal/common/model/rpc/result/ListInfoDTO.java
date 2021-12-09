package com.dumas.pedestal.common.model.rpc.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
import java.util.Objects;

/**
 * 无分页的批量数据返回格式结果
 *
 * @author dumas
 * @date 2021/12/06 11:09 AM
 */
@Getter
@Setter
@ToString
public class ListInfoDTO<T> {
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 分页内容
     */
    private List<T> list;

    /**
     * 是否空
     *
     * @return
     */
    public boolean isEmptyList() {
        return Objects.nonNull(list) && !list.isEmpty();
    }
}
