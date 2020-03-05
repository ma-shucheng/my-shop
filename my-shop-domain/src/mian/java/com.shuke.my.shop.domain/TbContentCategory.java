package com.shuke.my.shop.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.shuke.my.shop.commons.persistence.BaseEntity;

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
public class TbContentCategory extends BaseEntity {
    private Long parentId;
    private String name;
    private Integer status;
    private Integer sortOrder;
    @JsonProperty(value = "isParent")
    private Boolean isParent;

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public Boolean getParent() {
        return isParent;
    }

    public void setParent(Boolean parent) {
        isParent = parent;
    }
}
