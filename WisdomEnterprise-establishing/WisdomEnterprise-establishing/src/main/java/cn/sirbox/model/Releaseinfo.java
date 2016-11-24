package cn.sirbox.model;

import cn.sirbox.utils.ExcelResources;

public class Releaseinfo {
    private Integer id;

    private String projectName;//项目名称

    private String projectType;//项目类型

    private String cooperationMode;//合作方式

    private String projectFinancingMode;//ppp项目融资方式

    private String projectBusiness;//项目所属行业

    private String projectArea;// 项目地区

    private String city;// 项目地区城市

    private String parkArea;//所属园区

    private String projectAddress;//项目详细地址

    private String releasePosition;//发布位置

    private Integer fundBudget;//投资总额

    private Integer planBudget;//拟引投资总金额

    private Integer expectedReturn;//预计年销售收入

    private Integer expectedYear;// 预计投资收回期

    private Integer expectedPeople;//预计就业人数

    private Integer limitedTime;//有限期限

    private String projectLabel;//项目标注

    private String projectNature;//项目性质

    private String issuer;//发布人

    private Integer state;//状态  1：未审批、2：审批通过 3：审批不通过

    private String projectUnit;//项目所属单位

    private String address;//详细地址

    private String linkman;//联 系 人

    private String phone;//联系电话

    private String email;//联系邮箱

    private String faxNumber;//传真号码

    private String createTime;//创建时间

    private String updateTime;//更改时间
    
    private String projectContent;//项目主要内容

    private String projectAdvantage;//项目主要优势

    private String projectProtection;//项目环保简述

    private String investorCondition;//投资者条件简述

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    @ExcelResources(title="项目名称",order=1)
    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName == null ? null : projectName.trim();
    }
    @ExcelResources(title="项目类型",order=2)
    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType == null ? null : projectType.trim();
    }
    @ExcelResources(title="合作方式",order=4)
    public String getCooperationMode() {
        return cooperationMode;
    }

    public void setCooperationMode(String cooperationMode) {
        this.cooperationMode = cooperationMode == null ? null : cooperationMode.trim();
    }
    @ExcelResources(title="ppp项目融资方式",order=5)
    public String getProjectFinancingMode() {
        return projectFinancingMode;
    }

    public void setProjectFinancingMode(String projectFinancingMode) {
        this.projectFinancingMode = projectFinancingMode == null ? null : projectFinancingMode.trim();
    }
    @ExcelResources(title="项目所属行业",order=6)
    public String getProjectBusiness() {
        return projectBusiness;
    }

    public void setProjectBusiness(String projectBusiness) {
        this.projectBusiness = projectBusiness == null ? null : projectBusiness.trim();
    }
    @ExcelResources(title="项目地区",order=7)
    public String getProjectArea() {
        return projectArea;
    }

    public void setProjectArea(String projectArea) {
        this.projectArea = projectArea == null ? null : projectArea.trim();
    }
    @ExcelResources(title="项目所属城市",order=8)
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }
    @ExcelResources(title="项目所属园区",order=9)
    public String getParkArea() {
        return parkArea;
    }

    public void setParkArea(String parkArea) {
        this.parkArea = parkArea == null ? null : parkArea.trim();
    }
    @ExcelResources(title="项目详细地址",order=10)
    public String getProjectAddress() {
        return projectAddress;
    }

    public void setProjectAddress(String projectAddress) {
        this.projectAddress = projectAddress == null ? null : projectAddress.trim();
    }
    @ExcelResources(title="项目发布位置",order=11)
    public String getReleasePosition() {
        return releasePosition;
    }

    public void setReleasePosition(String releasePosition) {
        this.releasePosition = releasePosition == null ? null : releasePosition.trim();
    }
    @ExcelResources(title="项目投资总额",order=12)
    public Integer getFundBudget() {
        return fundBudget;
    }

    public void setFundBudget(Integer fundBudget) {
        this.fundBudget = fundBudget;
    }
    @ExcelResources(title="拟引投资总额",order=13)
    public Integer getPlanBudget() {
        return planBudget;
    }

    public void setPlanBudget(Integer planBudget) {
        this.planBudget = planBudget;
    }
    @ExcelResources(title="预计年销售收入",order=14)
    public Integer getExpectedReturn() {
        return expectedReturn;
    }

    public void setExpectedReturn(Integer expectedReturn) {
        this.expectedReturn = expectedReturn;
    }
    @ExcelResources(title="预计投资回收期",order=15)
    public Integer getExpectedYear() {
        return expectedYear;
    }

    public void setExpectedYear(Integer expectedYear) {
        this.expectedYear = expectedYear;
    }
    @ExcelResources(title="预计就业人数",order=16)
    public Integer getExpectedPeople() {
        return expectedPeople;
    }

    public void setExpectedPeople(Integer expectedPeople) {
        this.expectedPeople = expectedPeople;
    }
    @ExcelResources(title="有效期限",order=17)
    public Integer getLimitedTime() {
        return limitedTime;
    }

    public void setLimitedTime(Integer limitedTime) {
        this.limitedTime = limitedTime;
    }
    @ExcelResources(title="项目标注",order=18)
    public String getProjectLabel() {
        return projectLabel;
    }

    public void setProjectLabel(String projectLabel) {
        this.projectLabel = projectLabel == null ? null : projectLabel.trim();
    }
    @ExcelResources(title="项目性质",order=19)
    public String getProjectNature() {
        return projectNature;
    }

    public void setProjectNature(String projectNature) {
        this.projectNature = projectNature == null ? null : projectNature.trim();
    }
    @ExcelResources(title="发布人",order=20)
    public String getIssuer() {
        return issuer;
    }

    public void setIssuer(String issuer) {
        this.issuer = issuer == null ? null : issuer.trim();
    }
    @ExcelResources(title="状态",order=21)
    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }
    @ExcelResources(title="项目所属单位",order=22)
    public String getProjectUnit() {
        return projectUnit;
    }

    public void setProjectUnit(String projectUnit) {
        this.projectUnit = projectUnit == null ? null : projectUnit.trim();
    }
    @ExcelResources(title="详细地址",order=23)
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }
    @ExcelResources(title="联系人",order=24)
    public String getLinkman() {
        return linkman;
    }

    public void setLinkman(String linkman) {
        this.linkman = linkman == null ? null : linkman.trim();
    }
    @ExcelResources(title="联系电话",order=25)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }
    @ExcelResources(title="联系邮箱",order=26)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }
    @ExcelResources(title="传真号码",order=27)
    public String getFaxNumber() {
        return faxNumber;
    }

    public void setFaxNumber(String faxNumber) {
        this.faxNumber = faxNumber == null ? null : faxNumber.trim();
    }
    @ExcelResources(title="发布时间",order=28)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }
    @ExcelResources(title="修改时间",order=29)
    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime == null ? null : updateTime.trim();
    }
    @ExcelResources(title="项目主演内容",order=30)
    public String getProjectContent() {
        return projectContent;
    }

    public void setProjectContent(String projectContent) {
        this.projectContent = projectContent == null ? null : projectContent.trim();
    }
    @ExcelResources(title="项目主要优势",order=31)
    public String getProjectAdvantage() {
        return projectAdvantage;
    }

    public void setProjectAdvantage(String projectAdvantage) {
        this.projectAdvantage = projectAdvantage == null ? null : projectAdvantage.trim();
    }
    @ExcelResources(title="项目环保简述",order=32)
    public String getProjectProtection() {
        return projectProtection;
    }

    public void setProjectProtection(String projectProtection) {
        this.projectProtection = projectProtection == null ? null : projectProtection.trim();
    }
    @ExcelResources(title="投资者条件简述",order=33)
    public String getInvestorCondition() {
        return investorCondition;
    }

    public void setInvestorCondition(String investorCondition) {
        this.investorCondition = investorCondition == null ? null : investorCondition.trim();
    }
}