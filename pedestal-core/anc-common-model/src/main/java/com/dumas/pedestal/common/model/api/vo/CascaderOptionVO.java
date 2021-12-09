package com.dumas.pedestal.common.model.api.vo;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.util.List;

/**
 * 级联选项
 *
 * @author dumas
 * @date 2021/12/06 10:59 AM
 */
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class CascaderOptionVO {
    String value;

    String label;

    List<CascaderOptionVO> children;
}
