package com.xu.jetpacklearn.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * @Author 许剑波
 * 创建时间：2021/3/25  15:48
 * 类的功能： 审批节点JavaBean
 */
public class ApproveNode {


    /**
     * nodeId : sid-4236601A-56A4-446E-B884-7F05E0C0DBD5
     * nodeName : 经办人
     * procInstId : 2157501
     * procDefId : contract_manager:4:890130
     * taskId : 2157506
     * extendId : null
     * taskType : 0
     * taskStatus : 101
     * taskStatusDesc : 已提交
     * taskUser : [{"userId":"fff40e2ecc1e4b0f8eecec449ea158a0","userName":"文艳","avatar":null}]
     * comment : []
     * startTime : 2021-03-24 15:34
     * checkTime : 2021-03-24 15:34
     * subNode : []
     * extendNode : []
     * subNodeTotalNum : 0
     * subNodeDoneNum : 0
     * handlerSelfCheck : 0
     */

    @SerializedName("nodeId")
    private String nodeId;
    @SerializedName("nodeName")
    private String nodeName;
    @SerializedName("procInstId")
    private String procInstId;
    @SerializedName("procDefId")
    private String procDefId;
    @SerializedName("taskId")
    private String taskId;
    @SerializedName("extendId")
    private Object extendId;
    @SerializedName("taskType")
    private Integer taskType;
    @SerializedName("taskStatus")
    private Integer taskStatus;
    @SerializedName("taskStatusDesc")
    private String taskStatusDesc;
    @SerializedName("taskUser")
    private List<TaskUserDTO> taskUser;
    @SerializedName("comment")
    private List<?> comment;
    @SerializedName("startTime")
    private String startTime;
    @SerializedName("checkTime")
    private String checkTime;
    @SerializedName("subNode")
    private List<?> subNode;
    @SerializedName("extendNode")
    private List<?> extendNode;
    @SerializedName("subNodeTotalNum")
    private Integer subNodeTotalNum;
    @SerializedName("subNodeDoneNum")
    private Integer subNodeDoneNum;
    @SerializedName("handlerSelfCheck")
    private Integer handlerSelfCheck;

    public String getNodeId() {
        return nodeId;
    }

    public void setNodeId(String nodeId) {
        this.nodeId = nodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public String getProcInstId() {
        return procInstId;
    }

    public void setProcInstId(String procInstId) {
        this.procInstId = procInstId;
    }

    public String getProcDefId() {
        return procDefId;
    }

    public void setProcDefId(String procDefId) {
        this.procDefId = procDefId;
    }

    public String getTaskId() {
        return taskId;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public Object getExtendId() {
        return extendId;
    }

    public void setExtendId(Object extendId) {
        this.extendId = extendId;
    }

    public Integer getTaskType() {
        return taskType;
    }

    public void setTaskType(Integer taskType) {
        this.taskType = taskType;
    }

    public Integer getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(Integer taskStatus) {
        this.taskStatus = taskStatus;
    }

    public String getTaskStatusDesc() {
        return taskStatusDesc;
    }

    public void setTaskStatusDesc(String taskStatusDesc) {
        this.taskStatusDesc = taskStatusDesc;
    }

    public List<TaskUserDTO> getTaskUser() {
        return taskUser;
    }

    public void setTaskUser(List<TaskUserDTO> taskUser) {
        this.taskUser = taskUser;
    }

    public List<?> getComment() {
        return comment;
    }

    public void setComment(List<?> comment) {
        this.comment = comment;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getCheckTime() {
        return checkTime;
    }

    public void setCheckTime(String checkTime) {
        this.checkTime = checkTime;
    }

    public List<?> getSubNode() {
        return subNode;
    }

    public void setSubNode(List<?> subNode) {
        this.subNode = subNode;
    }

    public List<?> getExtendNode() {
        return extendNode;
    }

    public void setExtendNode(List<?> extendNode) {
        this.extendNode = extendNode;
    }

    public Integer getSubNodeTotalNum() {
        return subNodeTotalNum;
    }

    public void setSubNodeTotalNum(Integer subNodeTotalNum) {
        this.subNodeTotalNum = subNodeTotalNum;
    }

    public Integer getSubNodeDoneNum() {
        return subNodeDoneNum;
    }

    public void setSubNodeDoneNum(Integer subNodeDoneNum) {
        this.subNodeDoneNum = subNodeDoneNum;
    }

    public Integer getHandlerSelfCheck() {
        return handlerSelfCheck;
    }

    public void setHandlerSelfCheck(Integer handlerSelfCheck) {
        this.handlerSelfCheck = handlerSelfCheck;
    }

    public static class TaskUserDTO {
        /**
         * userId : fff40e2ecc1e4b0f8eecec449ea158a0
         * userName : 文艳
         * avatar : null
         */

        @SerializedName("userId")
        private String userId;
        @SerializedName("userName")
        private String userName;
        @SerializedName("avatar")
        private Object avatar;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public Object getAvatar() {
            return avatar;
        }

        public void setAvatar(Object avatar) {
            this.avatar = avatar;
        }
    }

}
