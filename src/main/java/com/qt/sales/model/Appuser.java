package com.qt.sales.model;

import java.math.BigDecimal;

public class Appuser {
    private BigDecimal id;

    private String name;

    private String description;

    private Short status;

    private BigDecimal lastVersion;

    private String partnerid;

    public BigDecimal getId() {
        return id;
    }

    public void setId(BigDecimal id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public Short getStatus() {
        return status;
    }

    public void setStatus(Short status) {
        this.status = status;
    }

    public BigDecimal getLastVersion() {
        return lastVersion;
    }

    public void setLastVersion(BigDecimal lastVersion) {
        this.lastVersion = lastVersion;
    }

    public String getPartnerid() {
        return partnerid;
    }

    public void setPartnerid(String partnerid) {
        this.partnerid = partnerid == null ? null : partnerid.trim();
    }
}