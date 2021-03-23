package com.xu.jetpacklearn.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author 许剑波
 * 创建时间：2021/3/23  18:11
 * 类的功能：
 */
public class ExpenseBean {


    /**
     * id : 1372073090137288705
     * mainId : 1372072907257245697
     * billType : 301
     * expendCode : 328
     * expendName : 取暖费
     * expendItemType : 002
     * componentType : -1
     * amount : 200.0
     * remark :
     * orderNum : null
     */

    @SerializedName("id")
    private String id;
    @SerializedName("mainId")
    private String mainId;
    @SerializedName("billType")
    private Integer billType;
    @SerializedName("expendCode")
    private String expendCode;
    @SerializedName("expendName")
    private String expendName;
    @SerializedName("expendItemType")
    private String expendItemType;
    @SerializedName("componentType")
    private String componentType;
    @SerializedName("amount")
    private Double amount;
    @SerializedName("remark")
    private String remark;
    @SerializedName("orderNum")
    private Object orderNum;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public Integer getBillType() {
        return billType;
    }

    public void setBillType(Integer billType) {
        this.billType = billType;
    }

    public String getExpendCode() {
        return expendCode;
    }

    public void setExpendCode(String expendCode) {
        this.expendCode = expendCode;
    }

    public String getExpendName() {
        return expendName;
    }

    public void setExpendName(String expendName) {
        this.expendName = expendName;
    }

    public String getExpendItemType() {
        return expendItemType;
    }

    public void setExpendItemType(String expendItemType) {
        this.expendItemType = expendItemType;
    }

    public String getComponentType() {
        return componentType;
    }

    public void setComponentType(String componentType) {
        this.componentType = componentType;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Object getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Object orderNum) {
        this.orderNum = orderNum;
    }

}
