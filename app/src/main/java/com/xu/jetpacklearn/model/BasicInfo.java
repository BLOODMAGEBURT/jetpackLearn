package com.xu.jetpacklearn.model;

import com.google.gson.annotations.SerializedName;

/**
 * @Author 许剑波
 * 创建时间：2021/3/23  17:49
 * 类的功能：
 */
public class BasicInfo {

    /**
     * id : 1372072907257245697
     * yearly : 2021
     * unitCode : 003
     * unitName : 广西区政府办公厅
     * billTypeCode : 301
     * applyDeptCode : 003029
     * applyDeptName : 测试部门
     * billCode : 3012021031709866
     * createDate : 2021-03-17
     * handlerUserId : 02125429b24d421aaea8e6bc064bbab7
     * handlerUserName : 许剑波
     * reimbursePersionId : 02125429b24d421aaea8e6bc064bbab7
     * reimbursePersionName : 许剑波
     * phoneNum : 15245412541
     * applyReason : 直接报销
     * paybackPlan : null
     * title : null
     * content : null
     * reimburseAmount : 200.0
     * status : 2
     * actexBusinessBillId : 1372072978178732034
     * actexResultStatus : 2
     * expendItemCode :
     * procDefId : test:27:545030
     * procInstId : 1975031
     * remark : null
     */

    @SerializedName("id")
    private String id;
    @SerializedName("yearly")
    private Integer yearly;
    @SerializedName("unitCode")
    private String unitCode;
    @SerializedName("unitName")
    private String unitName;
    @SerializedName("billTypeCode")
    private String billTypeCode;
    @SerializedName("applyDeptCode")
    private String applyDeptCode;
    @SerializedName("applyDeptName")
    private String applyDeptName;
    @SerializedName("billCode")
    private String billCode;
    @SerializedName("createDate")
    private String createDate;
    @SerializedName("handlerUserId")
    private String handlerUserId;
    @SerializedName("handlerUserName")
    private String handlerUserName;
    @SerializedName("reimbursePersionId")
    private String reimbursePersionId;
    @SerializedName("reimbursePersionName")
    private String reimbursePersionName;
    @SerializedName("phoneNum")
    private String phoneNum;
    @SerializedName("applyReason")
    private String applyReason;
    @SerializedName("paybackPlan")
    private Object paybackPlan;
    @SerializedName("title")
    private Object title;
    @SerializedName("content")
    private Object content;
    @SerializedName("reimburseAmount")
    private Double reimburseAmount;
    @SerializedName("status")
    private Integer status;
    @SerializedName("actexBusinessBillId")
    private String actexBusinessBillId;
    @SerializedName("actexResultStatus")
    private Integer actexResultStatus;
    @SerializedName("expendItemCode")
    private String expendItemCode;
    @SerializedName("procDefId")
    private String procDefId;
    @SerializedName("procInstId")
    private String procInstId;
    @SerializedName("remark")
    private Object remark;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getYearly() {
        return yearly;
    }

    public void setYearly(Integer yearly) {
        this.yearly = yearly;
    }

    public String getUnitCode() {
        return unitCode;
    }

    public void setUnitCode(String unitCode) {
        this.unitCode = unitCode;
    }

    public String getUnitName() {
        return unitName;
    }

    public void setUnitName(String unitName) {
        this.unitName = unitName;
    }

    public String getBillTypeCode() {
        return billTypeCode;
    }

    public void setBillTypeCode(String billTypeCode) {
        this.billTypeCode = billTypeCode;
    }

    public String getApplyDeptCode() {
        return applyDeptCode;
    }

    public void setApplyDeptCode(String applyDeptCode) {
        this.applyDeptCode = applyDeptCode;
    }

    public String getApplyDeptName() {
        return applyDeptName;
    }

    public void setApplyDeptName(String applyDeptName) {
        this.applyDeptName = applyDeptName;
    }

    public String getBillCode() {
        return billCode;
    }

    public void setBillCode(String billCode) {
        this.billCode = billCode;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getHandlerUserId() {
        return handlerUserId;
    }

    public void setHandlerUserId(String handlerUserId) {
        this.handlerUserId = handlerUserId;
    }

    public String getHandlerUserName() {
        return handlerUserName;
    }

    public void setHandlerUserName(String handlerUserName) {
        this.handlerUserName = handlerUserName;
    }

    public String getReimbursePersionId() {
        return reimbursePersionId;
    }

    public void setReimbursePersionId(String reimbursePersionId) {
        this.reimbursePersionId = reimbursePersionId;
    }

    public String getReimbursePersionName() {
        return reimbursePersionName;
    }

    public void setReimbursePersionName(String reimbursePersionName) {
        this.reimbursePersionName = reimbursePersionName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason;
    }

    public Object getPaybackPlan() {
        return paybackPlan;
    }

    public void setPaybackPlan(Object paybackPlan) {
        this.paybackPlan = paybackPlan;
    }

    public Object getTitle() {
        return title;
    }

    public void setTitle(Object title) {
        this.title = title;
    }

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public Double getReimburseAmount() {
        return reimburseAmount;
    }

    public void setReimburseAmount(Double reimburseAmount) {
        this.reimburseAmount = reimburseAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getActexBusinessBillId() {
        return actexBusinessBillId;
    }

    public void setActexBusinessBillId(String actexBusinessBillId) {
        this.actexBusinessBillId = actexBusinessBillId;
    }

    public Integer getActexResultStatus() {
        return actexResultStatus;
    }

    public void setActexResultStatus(Integer actexResultStatus) {
        this.actexResultStatus = actexResultStatus;
    }

    public String getExpendItemCode() {
        return expendItemCode;
    }

    public void setExpendItemCode(String expendItemCode) {
        this.expendItemCode = expendItemCode;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public Object getRemark() {
        return remark;
    }

    public void setRemark(Object remark) {
        this.remark = remark;
    }
}

