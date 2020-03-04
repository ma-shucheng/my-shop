package com.shuke.my.shop.commons.persistence;

import java.io.Serializable;
import java.util.Date;


/**
 * 
 * <p>
 * 实体类的基类
 * </p>
 * 
 * @author shuke
 * @version v1.0.0
 * @since 2020-03-04 09:53:24
 * @see com.shuke.my.shop.commons.persistence
 *
 */
public abstract class BaseEntity implements Serializable {
    private Long id;
    private Date created;
    private Date updated;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
