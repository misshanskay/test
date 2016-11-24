package cn.sirbox.model;

import java.util.Date;

public class UserU {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_u.uid
     *
     * @mbggenerated
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_u.uname
     *
     * @mbggenerated
     */
    private String uname;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_u.upassword
     *
     * @mbggenerated
     */
    private String upassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_u.downpassword
     *
     * @mbggenerated
     */
    private String downpassword;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_u.status
     *
     * @mbggenerated
     */
    private String status;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_u.enabled
     *
     * @mbggenerated
     */
    private Integer enabled;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_u.createtime
     *
     * @mbggenerated
     */
    private Date createtime;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_u.updatetime
     *
     * @mbggenerated
     */
    private Date updatetime;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_u.uid
     *
     * @return the value of user_u.uid
     *
     * @mbggenerated
     */
    
    private UserExtend userExtend;
    private UserDeptKey userDeptKey;
    
    
    
    public UserExtend getUserExtend() {
        return userExtend;
    }

    public void setUserExtend(UserExtend userExtend) {
        this.userExtend = userExtend;
    }

    public UserDeptKey getUserDeptKey() {
        return userDeptKey;
    }

    public void setUserDeptKey(UserDeptKey userDeptKey) {
        this.userDeptKey = userDeptKey;
    }

    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_u.uid
     *
     * @param uid the value for user_u.uid
     *
     * @mbggenerated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_u.uname
     *
     * @return the value of user_u.uname
     *
     * @mbggenerated
     */
    public String getUname() {
        return uname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_u.uname
     *
     * @param uname the value for user_u.uname
     *
     * @mbggenerated
     */
    public void setUname(String uname) {
        this.uname = uname;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_u.upassword
     *
     * @return the value of user_u.upassword
     *
     * @mbggenerated
     */
    public String getUpassword() {
        return upassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_u.upassword
     *
     * @param upassword the value for user_u.upassword
     *
     * @mbggenerated
     */
    public void setUpassword(String upassword) {
        this.upassword = upassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_u.downpassword
     *
     * @return the value of user_u.downpassword
     *
     * @mbggenerated
     */
    public String getDownpassword() {
        return downpassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_u.downpassword
     *
     * @param downpassword the value for user_u.downpassword
     *
     * @mbggenerated
     */
    public void setDownpassword(String downpassword) {
        this.downpassword = downpassword;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_u.status
     *
     * @return the value of user_u.status
     *
     * @mbggenerated
     */
    public String getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_u.status
     *
     * @param status the value for user_u.status
     *
     * @mbggenerated
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_u.enabled
     *
     * @return the value of user_u.enabled
     *
     * @mbggenerated
     */
    public Integer getEnabled() {
        return enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_u.enabled
     *
     * @param enabled the value for user_u.enabled
     *
     * @mbggenerated
     */
    public void setEnabled(Integer enabled) {
        this.enabled = enabled;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_u.createtime
     *
     * @return the value of user_u.createtime
     *
     * @mbggenerated
     */
    public Date getCreatetime() {
        return createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_u.createtime
     *
     * @param createtime the value for user_u.createtime
     *
     * @mbggenerated
     */
    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_u.updatetime
     *
     * @return the value of user_u.updatetime
     *
     * @mbggenerated
     */
    public Date getUpdatetime() {
        return updatetime;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_u.updatetime
     *
     * @param updatetime the value for user_u.updatetime
     *
     * @mbggenerated
     */
    public void setUpdatetime(Date updatetime) {
        this.updatetime = updatetime;
    }
}