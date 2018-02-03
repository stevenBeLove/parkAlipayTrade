package com.qt.sales.model;

public class ParkLicense {
    private String outParkingId;

    private String parkMac;

    public String getOutParkingId() {
        return outParkingId;
    }

    public void setOutParkingId(String outParkingId) {
        this.outParkingId = outParkingId == null ? null : outParkingId.trim();
    }

    public String getParkMac() {
        return parkMac;
    }

    public void setParkMac(String parkMac) {
        this.parkMac = parkMac == null ? null : parkMac.trim();
    }
}