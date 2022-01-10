package com.dumas.pedestal.ms.crawler.orm.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @author dumas
 * @date 2022/01/10 2:25 PM
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("cms_content")
public class CmsContentDO implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "content_id", type = IdType.AUTO)
    private String contentId;

    private String title;

    private String content;

    private LocalDateTime releaseDate;
}
