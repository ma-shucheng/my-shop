package com.shuke.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shuke.my.shop.commons.persistence.BaseEntity;
import lombok.Data;

/**
 * <p>
 * 分类管理
 * </p>
 *
 * @author shuke
 * @version v1.0.0
 * @see com.shuke.my.shop.domain
 * @since 2020-03-04 11:21:02
 */
@Data
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    @JsonProperty(value = "isParent")
    private Boolean isParent;
}
