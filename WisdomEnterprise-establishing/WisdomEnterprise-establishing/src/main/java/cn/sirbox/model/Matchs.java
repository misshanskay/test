package cn.sirbox.model;

import java.sql.Timestamp;


import cn.sirbox.utils.ExcelResources;

public class Matchs {
	private Integer id;
	
	private String companyName;// 企业名称

	private Timestamp matchTime;// 匹配时间

	private String projectName;// 项目名称

	private String matchDegree;// 匹配度

	 private Integer cooperationMode;// 合作模式

	private String projectBusiness;// 项目所属行业

	private String projectArea;// 项目地区

	private String fundBudget;// 投资总额

	private String projectUnit;// 项目所属单位

	private String address;

	private String linkman;

	private String phone;

	private String email;

	private String faxNumber;// 传真号码

	private Timestamp issueTime;

	private String issuer;

	private Timestamp updateTime;

	private String projectFinancingMode;// 项目融资方式、项目类型

	private String projectContent;
	
	private String city;
	
    private Integer state;

    private String telephone;

    private String area;

    private String detailAddress;
    
    private String money;
    
	public String getMoney() {
		return money;
	}

    public void setMoney(String money) {
        this.money = money == null ? null : money.trim();
    }

	public String getDetailAddress() {
		return detailAddress;
	}

	public void setDetailAddress(String detailAddress) {
		this.detailAddress = detailAddress;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {

		this.city = city == null ? null : city.trim();
	}
	@ExcelResources(title="企业名称",order=1)
	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName == null ? null : companyName.trim();
	}
	@ExcelResources(title="匹配时间",order=16)
	public Timestamp getMatchTime() {
		return matchTime;
	}

	public void setMatchTime(Timestamp matchTime) {
		this.matchTime = matchTime;
	}
	@ExcelResources(title="项目名称",order=2)
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName == null ? null : projectName.trim();
	}
	@ExcelResources(title="匹配度",order=15)
	public String getMatchDegree() {
		return matchDegree;
	}

	public void setMatchDegree(String matchDegree) {
		this.matchDegree = matchDegree == null ? null : matchDegree.trim();
	}
	@ExcelResources(title="合作模式",order=3)
    public Integer getCooperationMode() {
        return cooperationMode;
    }
	
    public void setCooperationMode(Integer cooperationMode) {
        this.cooperationMode = cooperationMode;
    }
	
	@ExcelResources(title="项目所属行业",order=4)
	public String getProjectBusiness() {
		return projectBusiness;
	}

	public void setProjectBusiness(String projectBusiness) {
		this.projectBusiness = projectBusiness == null ? null : projectBusiness
				.trim();
	}
	@ExcelResources(title="项目地区",order=5)
	public String getProjectArea() {
		return projectArea;
	}

	public void setProjectArea(String projectArea) {
		this.projectArea = projectArea == null ? null : projectArea.trim();
	}
	@ExcelResources(title="投资金额",order=6)
	public String getFundBudget() {
		return fundBudget;
	}

	public void setFundBudget(String fundBudget) {
		this.fundBudget = fundBudget == null ? null : fundBudget.trim();
	}
	@ExcelResources(title="项目所属单位",order=7)
	public String getProjectUnit() {
		return projectUnit;
	}

	public void setProjectUnit(String projectUnit) {
		this.projectUnit = projectUnit == null ? null : projectUnit.trim();
	}
	@ExcelResources(title="详细地址",order=14)
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address == null ? null : address.trim();
	}
	@ExcelResources(title="联系人",order=8)
	public String getLinkman() {
		return linkman;
	}

	public void setLinkman(String linkman) {
		this.linkman = linkman == null ? null : linkman.trim();
	}
	@ExcelResources(title="联系电话",order=9)
	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	@ExcelResources(title="联系邮箱",order=10)
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email == null ? null : email.trim();
	}
	@ExcelResources(title="传真号码",order=11)
	public String getFaxNumber() {
		return faxNumber;
	}

	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber == null ? null : faxNumber.trim();
	}
	@ExcelResources(title="发布时间",order=12)
	public Timestamp getIssueTime() {
		return issueTime;
	}

	public void setIssueTime(Timestamp issueTime) {
		this.issueTime = issueTime;
	}
	@ExcelResources(title="发布人",order=13)
	public String getIssuer() {
		return issuer;
	}

	public void setIssuer(String issuer) {
		this.issuer = issuer == null ? null : issuer.trim();
	}

	public Timestamp getUpdateTime() {
		return updateTime;
	}

	public void setUpdateTime(Timestamp updateTime) {
		this.updateTime = updateTime;
	}
	@ExcelResources(title="项目类型",order=17)
	public String getProjectFinancingMode() {
		return projectFinancingMode;
	}

	public void setProjectFinancingMode(String projectFinancingMode) {
		this.projectFinancingMode = projectFinancingMode == null ? null
				: projectFinancingMode.trim();
	}
	@ExcelResources(title="项目主要内容",order=18)
	public String getProjectContent() {
		return projectContent;
	}

	public void setProjectContent(String projectContent) {
		this.projectContent = projectContent == null ? null : projectContent
				.trim();
	}
	
	   public Integer getState() {
	        return state;
	    }

	    public void setState(Integer state) {
	        this.state = state;
	    }

	    public String getTelephone() {
	        return telephone;
	    }

	    public void setTelephone(String telephone) {
	        this.telephone = telephone == null ? null : telephone.trim();
	    }

	    public String getArea() {
	        return area;
	    }

	    public void setArea(String area) {
	        this.area = area == null ? null : area.trim();
	    }
}