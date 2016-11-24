package cn.sirbox.model;
/**
 * 公告发布的实体类
 * @author  hwc
 *
 */
public class Notice {
    private Integer id;//主键

    private String memberName;//会员名

    private String title;//标题

    private String createTime;//创建时间

    private Integer orderNum;//排序

    private String receiveTerminal;//接收终端

    private String content; //正文

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName == null ? null : memberName.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public String getReceiveTerminal() {
        return receiveTerminal;
    }

    public void setReceiveTerminal(String receiveTerminal) {
        this.receiveTerminal = receiveTerminal == null ? null : receiveTerminal.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}