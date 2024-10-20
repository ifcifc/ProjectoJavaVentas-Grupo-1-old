package com.ventas.models;

import java.io.Serializable;

public abstract class BaseModel implements Serializable {
    protected boolean isDelete;

    public BaseModel(long ID) {
        this.isDelete = false;
    }

    public BaseModel() {
        this(0);
    }

    public abstract long getID();

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public abstract String toString();
}
