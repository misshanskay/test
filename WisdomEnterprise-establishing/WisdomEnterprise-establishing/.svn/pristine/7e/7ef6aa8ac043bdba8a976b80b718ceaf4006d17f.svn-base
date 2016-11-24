package cn.sirbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sirbox.dao.PartMapper;
import cn.sirbox.dao.UserPartMapper;
import cn.sirbox.model.Part;
import cn.sirbox.model.PartExample;
import cn.sirbox.model.UserPartExample;
import cn.sirbox.model.UserPartKey;


@Service
public class PartService {
	@Autowired
	private PartMapper partMapper;
	@Autowired
	private UserPartMapper userPartMapper;

	public List<Part> getAllPart() {
		// TODO Auto-generated method stub
		PartExample pe=new PartExample();
		pe.createCriteria().andEnabledEqualTo(1);
	    return partMapper.selectByExample(pe);
	}
	public Part getPartByName(String pname){
	    PartExample pe=new PartExample();
	    
        pe.createCriteria().andEnabledEqualTo(1).andPnameEqualTo(pname);
        return partMapper.selectByExample(pe).get(0);
	}
	
	public void insertUserUPart(Integer uid, Integer pid) {
        // TODO Auto-generated method stub
	    UserPartKey up=new UserPartKey();
	    up.setPid(pid);
	    up.setUid(uid);
	    userPartMapper.insert(up);
    }
	/*public Part getPartById(Integer pid){
		//return partMapper.getPartById(pid);
	    return null;
	}
	public void addPart(Part part) {
		// TODO Auto-generated method stub
		//partMapper.addPart(part);
	}
	public void addPartRole(String pname, String rname) {
		// TODO Auto-generated method stub
		//partMapper.addPartRole(pname,rname);
	}
	public List<String> getRole(String pname) {
		// TODO Auto-generated method stub
		//return partMapper.getRole(pname);
	    return null;
	}
	
	public void deleteRole(String pname) {
		// TODO Auto-generated method stub
		//partMapper.deleteRole(pname);
	}
	public void updataPart(Part part) {
		// TODO Auto-generated method stub
		//partMapper.updataPart(part);
	}
    
    public void updateUserUPart(Integer uid, Integer pid) {
        // TODO Auto-generated method stub
       // partMapper.updateUserUPart(uid,pid);
        
    }*/
    public Part getPartById(Integer id) {
        // TODO Auto-generated method stub
        PartExample pe=new PartExample();
        pe.createCriteria().andPidEqualTo(id);
        return partMapper.selectByExample(pe).get(0);
    }
    public void updateUserUPart(Integer uid, Integer pid) {
        // TODO Auto-generated method stub
        UserPartKey up=new UserPartKey();
        up.setPid(pid);
        up.setUid(uid);
        UserPartExample upe=new UserPartExample();
        upe.createCriteria().andUidEqualTo(uid);
        userPartMapper.updateByExampleSelective(up, upe);
    }
}
