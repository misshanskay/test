package cn.sirbox.model;

public class UserPartKey {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_part.uid
     *
     * @mbggenerated
     */
    private Integer uid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column user_part.pid
     *
     * @mbggenerated
     */
    private Integer pid;

   

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_part.uid
     *
     * @return the value of user_part.uid
     *
     * @mbggenerated
     */
    public Integer getUid() {
        return uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_part.uid
     *
     * @param uid the value for user_part.uid
     *
     * @mbggenerated
     */
    public void setUid(Integer uid) {
        this.uid = uid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column user_part.pid
     *
     * @return the value of user_part.pid
     *
     * @mbggenerated
     */
    public Integer getPid() {
        return pid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column user_part.pid
     *
     * @param pid the value for user_part.pid
     *
     * @mbggenerated
     */
    public void setPid(Integer pid) {
        this.pid = pid;
    }
}