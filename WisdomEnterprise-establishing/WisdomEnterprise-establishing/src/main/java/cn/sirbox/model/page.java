package cn.sirbox.model;

import net.sf.json.JSONArray;

/**
 * Created by X201 on 2016/8/30 0030.
 */
public class page {
    private Integer thispage;
    private Integer count;
    private Integer status;
    private String msg;
    private Integer startPos; // 开始位置，从0开始
    private Integer totalPageCount; // 总的页数
    
    private Integer page;
    public static Integer pagenumber=20;
    private Object data;
    
    public page (){
    }
    
    public page (Integer thispage, Integer count){
		this.thispage = thispage;
		this.count = count;
    }
    
	public Integer getStartPos() {
		return (thispage - 1) * pagenumber;
	}
	
	public Integer getTotalPageCount() {
		totalPageCount = getCount() / getPagenumber();
		return (count % pagenumber == 0) ? totalPageCount
				: totalPageCount + 1;
	}

	public void setTotalPageCount(Integer totalPageCount) {
		this.totalPageCount = totalPageCount;
	}
	
	public void setStartPos(Integer startPos) {
		this.startPos = startPos;
	}
    
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

   
    public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getThispage() {
        return thispage;
    }

    public void setThispage(Integer thispage) {
        this.thispage = thispage;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPagenumber() {
        return pagenumber;
    }

    public void setPagenumber(Integer pagenumber) {
        this.pagenumber = pagenumber;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }
}
