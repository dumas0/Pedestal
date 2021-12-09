package com.dumas.pedestal.common.model.api.vo;

import com.dumas.pedestal.common.model.constant.enums.CommonResponseCode;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * api 成功返回 工厂类
 * 当执行成功时，调用该工程，创建返回结构
 *
 * @author dumas
 * @date 2021/12/06 10:52 AM
 */
public final class Ok {
    private Ok() {
        throw new AssertionError();
    }

    /**
     * 列表返回
     *
     * @param list
     * @param <T>
     * @return
     */
    public static <T> R<ListVO<T>> list(List<T> list) {
        ListVO<T> listVO = new ListVO<>();
        if (Objects.isNull(list) || list.isEmpty()) {
            listVO.ofEmpty();
        } else {
            listVO.setTotal(list.size());
            listVO.setList(list);
        }

        R<ListVO<T>> response = RFactory.fromResponseCode(CommonResponseCode.SUCCESS);
        response.setData(listVO);
        return response;
    }

    /**
     * 列表返回：带数据转换
     *
     * @param eleList
     * @param covert
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T, S> R<ListVO<T>> list(List<S> eleList, Function<S, T> covert) {
        ListVO<T> listVO = new ListVO<>();
        if (Objects.isNull(eleList) || eleList.isEmpty()) {
            listVO.ofEmpty();
        }
        if (Objects.nonNull(covert)) {
            List<T> tList = eleList.stream().filter(Objects::nonNull).map(covert).collect(Collectors.toList());
            listVO.setList(tList);
            listVO.setTotal(tList.size());
        }

        R<ListVO<T>> response = RFactory.fromResponseCode(CommonResponseCode.SUCCESS);
        response.setData(listVO);
        return response;
    }

    public static <T> R<T> empty() {
        R<T> response = RFactory.fromResponseCode(CommonResponseCode.SUCCESS);
        response.setData(null);
        return response;
    }

    public static <T> R<T> data(T vo) {
        R<T> response = RFactory.fromResponseCode(CommonResponseCode.SUCCESS);
        response.setData(vo);
        return response;
    }

    public static <T> R<PageVO<T>> page(PageVO<T> page) {
        if (Objects.isNull(page)) {
            page = new PageVO<>();
            page.setList(Collections.emptyList());
            page.setTotal(0L);
            page.setPageNo(0L);
            page.setPageSize(0L);
        }
        R<PageVO<T>> response = RFactory.fromResponseCode(CommonResponseCode.SUCCESS);
        response.setData(page);
        return response;
    }

    /**
     * 分页返回
     */
    public static <T> R page(Long total, List<T> rowList) {
        PageVO<T> pageVO = new PageVO<>();
        pageVO.setList(rowList);
        pageVO.setTotal(total);

        R<PageVO<T>> response = RFactory.fromResponseCode(CommonResponseCode.SUCCESS);
        response.setData(pageVO);
        return response;
    }

    /**
     * <pre>
     * {@code
     *      // 原始 人员列表
     *      List<Person> personList = new ArrayList<>();
     *      // 转化成 以人员ID 为key ,人员 为 value 的 map
     *      R<Map<Long, Person>> personMap = Ok.map(Person::getId(), p -> p);
     * }
     * </pre>
     * <p>
     * Map返回：带数据转换
     *
     * @param eleList
     * @param covert
     * @param <T>
     * @param <S>
     * @return
     */
    public static <T, S> R<Map<S, T>> map(Function<T, S> covert, List<T> eleList) {
        Map<S, T> mapVO = new HashMap<>();
        if (Objects.isNull(eleList) || eleList.isEmpty()) {
            // do nothing
        } else {
            mapVO = eleList.stream().collect(Collectors.toMap(covert, t -> t));
        }

        R<Map<S, T>> response = RFactory.fromResponseCode(CommonResponseCode.SUCCESS);
        response.setData(mapVO);
        return response;
    }
}
