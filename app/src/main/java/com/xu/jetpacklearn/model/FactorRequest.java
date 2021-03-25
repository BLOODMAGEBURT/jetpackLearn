package com.xu.jetpacklearn.model;

import com.google.gson.annotations.SerializedName;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  18:04
 * 类的功能：
 */
public class FactorRequest {

    /**
     * billTypeCode : 501
     * mainId : 1374625007012339713
     * taskId : 2157510
     * unitCode : 003
     * yearly : 2021
     */

    @SerializedName("billTypeCode")
    private String billTypeCode;
    @SerializedName("mainId")
    private String mainId;
    @SerializedName("taskId")
    private String taskId;
    @SerializedName("unitCode")
    private String unitCode;
    @SerializedName("yearly")
    private Integer yearly;

    public String getBillTypeCode() {
        return billTypeCode;
    }

    public void setBillTypeCode(String billTypeCode) {
        this.billTypeCode = billTypeCode;
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public Integer getYearly() {
        return yearly;
    }

    public void setYearly(Integer yearly) {
        this.yearly = yearly;
    }
}
