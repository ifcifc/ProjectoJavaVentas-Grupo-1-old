package com.articulos.models;

public abstract class BaseModel {
    protected long ID;
    protected boolean isDelete;

    public BaseModel(long ID) {
        this.ID = ID;
        this.isDelete = false;
    }

    public BaseModel() {
        this(0);
    }

    public long getID() {
        return ID;
    }

    public boolean setID(long ID) {
        if(this.ID!=0)return false;
        this.ID = ID;
        return true;
    }

    public boolean isDelete() {
        return isDelete;
    }

    public void setDelete(boolean delete) {
        isDelete = delete;
    }

    public abstract String toString();
}
