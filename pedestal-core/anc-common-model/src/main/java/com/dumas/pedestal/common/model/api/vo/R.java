package com.dumas.pedestal.common.model.api.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

/**
 * NormalR 基类
 *
 * @author dumas
 * @date 2021/12/06 10:40 AM
 */
@Getter
@Setter
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@ApiModel("ResponseVO")
public class R<T> {
    /**
     * 错误码
     */
    @ApiModelProperty(name = "code", value = "错误码[0: 成功]", required = true)
    String code;
    /**
     * 错误信息
     */
    @ApiModelProperty(name = "msg", value = "错误信息", required = true)
    String msg;
    /**
     * 是否调用成功
     */
    @ApiModelProperty(name = "success", value = "是否调用成功", required = true)
    Boolean success;

    /**
     * 返回的数据
     */
    @ApiModelProperty(name = "data", value = "返回的数据[调用失败时，为空]")
    T data;
}
