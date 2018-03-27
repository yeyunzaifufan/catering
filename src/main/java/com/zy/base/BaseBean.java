package com.zy.base;

import java.io.Serializable;
import java.util.Objects;

public class BaseBean implements Serializable {

    private static final long serialVersionUID = 1880270714923798776L;

    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (int) (id ^ (id >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        BaseBean other = (BaseBean) obj;
        return Objects.equals(id, other.id);
    }
}
