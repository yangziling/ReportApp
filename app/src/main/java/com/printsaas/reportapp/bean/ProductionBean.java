package com.printsaas.reportapp.bean;

import java.io.Serializable;

/**
 * Created by stone on 2018/5/3.
 */

public class ProductionBean implements Serializable{
    private String ProductId;
    private String ProductName;
    private String ProducessName1;
    private String ProducessName2;
    private String StartTime;
    private String EndTime;

    public void setProductId(String productId) {
        ProductId = productId;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setProducessName1(String producessName1) {
        ProducessName1 = producessName1;
    }

    public void setProducessName2(String producessName2) {
        ProducessName2 = producessName2;
    }

    public void setStartTime(String startTime) {
        StartTime = startTime;
    }

    public void setEndTime(String endTime) {
        EndTime = endTime;
    }

    public String getProductId() {
        return ProductId;
    }

    public String getProductName() {
        return ProductName;
    }

    public String getProducessName1() {
        return ProducessName1;
    }

    public String getProducessName2() {
        return ProducessName2;
    }

    public String getStartTime() {
        return StartTime;
    }

    public String getEndTime() {
        return EndTime;
    }
}
