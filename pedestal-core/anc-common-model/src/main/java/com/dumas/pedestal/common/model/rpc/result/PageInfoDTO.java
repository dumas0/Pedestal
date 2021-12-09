package com.dumas.pedestal.common.model.rpc.result;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * 分页数据
 *
 * @author dumas
 * @date 2021/12/06 11:06 AM
 */
@Setter
@Getter
@ToString
public class PageInfoDTO<T> {
    /**
     * 总条数
     */
    private Integer total;
    /**
     * 当前分页记录数
     */
    private Integer pageSize;
    /**
     * 当前页
     */
    private Integer pageNo;
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
        return Objects.nonNull(list) && list.isEmpty();
    }

    public <R> PageInfoDTO<R> map(Function<? super T, ? extends R> converter) {
        PageInfoDTO<R> newPage = new PageInfoDTO<>();
        newPage.setTotal(this.total);
        newPage.setPageSize(this.pageSize);
        newPage.setPageNo(this.pageNo);
        if (Objects.nonNull(converter) && !isEmptyList()) {
            newPage.setList(list.stream().map(converter).collect(Collectors.toList()));
        } else {
            newPage.setList(new ArrayList<>());
        }
        return newPage;
    }
}
