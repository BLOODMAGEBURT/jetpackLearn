package com.xu.jetpacklearn.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  18:05
 * 类的功能：
 */
public class FactorBean {

    /**
     * id : null
     * mainId : null
     * type : 2
     * processId : contract_manager:4:890130
     * taskId : sid-EBE85AB5-3691-4976-8A7D-3A1CC72DA4CB
     * approveFactorId : 1317037179650809858
     * factorContent : 核对基本信息---冀志红
     * isSelect : 0
     */

    @SerializedName("id")
    private Object id;
    @SerializedName("mainId")
    private Object mainId;
    @SerializedName("type")
    private Integer type;
    @SerializedName("processId")
    private String processId;
    @SerializedName("taskId")
    private String taskId;
    @SerializedName("approveFactorId")
    private String approveFactorId;
    @SerializedName("factorContent")
    private String factorContent;
    @SerializedName("isSelect")
    private Integer isSelect;

    public Object getId() {
        return id;
    }

    public void setId(Object id) {
        this.id = id;
    }

    public Object getMainId() {
        return mainId;
    }

    public void setMainId(Object mainId) {
        this.mainId = mainId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getProcessId() {
        return processId;
    }

    public void setProcessId(String processId) {
        this.processId = processId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public String getApproveFactorId() {
        return approveFactorId;
    }

    public void setApproveFactorId(String approveFactorId) {
        this.approveFactorId = approveFactorId;
    }

    public String getFactorContent() {
        return factorContent;
    }

    public void setFactorContent(String factorContent) {
        this.factorContent = factorContent;
    }

    public Integer getIsSelect() {
        return isSelect;
    }

    public void setIsSelect(Integer isSelect) {
        this.isSelect = isSelect;
    }

}
