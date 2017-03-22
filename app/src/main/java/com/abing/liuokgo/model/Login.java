package com.abing.liuokgo.model;

/**
 * 项目名称：Liu_okgo
 * 类描述：
 * 创建人：liubing
 * 创建时间：2017/3/22 14:58
 * 修改人：Administrator
 * 修改时间：2017/3/22 14:58
 * 修改备注：
 */
public class Login {


    /**
     * isD0 : 0
     * agentName : 潍坊友钱（B）
     * userId : 2
     * agentId : 89777
     * userName : 17321436171
     * jsessionid : a88a78d7-0ea8-43c1-8b1c-3706336a2c81
     */

    private int isD0;
    private String agentName;
    private int userId;
    private int agentId;
    private String userName;
    private String jsessionid;

    public int getIsD0() {
        return isD0;
    }

    public void setIsD0(int isD0) {
        this.isD0 = isD0;
    }

    public String getAgentName() {
        return agentName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getAgentId() {
        return agentId;
    }

    public void setAgentId(int agentId) {
        this.agentId = agentId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJsessionid() {
        return jsessionid;
    }

    public void setJsessionid(String jsessionid) {
        this.jsessionid = jsessionid;
    }

    @Override
    public String toString() {
        return "Login{" +
                "isD0=" + isD0 +
                ", agentName='" + agentName + '\'' +
                ", userId=" + userId +
                ", agentId=" + agentId +
                ", userName='" + userName + '\'' +
                ", jsessionid='" + jsessionid + '\'' +
                '}';
    }
}
