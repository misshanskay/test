package cn.sirbox.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.sirbox.dao.DeptMapper;
import cn.sirbox.dao.UserDeptMapper;
import cn.sirbox.model.Dept;
import cn.sirbox.model.DeptExample;
import cn.sirbox.model.UserDeptExample;
import cn.sirbox.model.UserDeptKey;

@Service
public class DeptService {
@Autowired
private DeptMapper deptMapper;

@Autowired
private UserDeptMapper userDeptMapper;

public List<Dept> getAllDept() {
	DeptExample de=new DeptExample();
	de.createCriteria().andStatusEqualTo("1");
    return deptMapper.selectByExample(de);
}
public Dept getDeptByName(String dname) {
    // TODO Auto-generated method stub
    // return deptMapper.getDeptByName(dname);
    DeptExample de=new DeptExample();
    de.createCriteria().andStatusEqualTo("1").andDnameEqualTo(dname);
    return deptMapper.selectByExample(de).get(0);
}
public void updateDeptById(Integer did, Integer pid) {
	// TODO Auto-generated method stub
    Dept dept=getDeptById(did);
    dept.setPid(pid);
    DeptExample de=new DeptExample();
    de.createCriteria().andStatusEqualTo("1").andDidEqualTo(did);
   deptMapper.updateByExample(dept, de);
}

public void deleteDeptById(Integer did) {
	// TODO Auto-generated method stub
	deptMapper.deleteByPrimaryKey(did);
}

public Integer addDeptGov(Dept dept) {
	// TODO Auto-generated method stub
    dept.setStatus("1");
    dept.setCreatetime(new Date());
    dept.setUpdatetime(new Date());
	deptMapper.insertSelective(dept);
	return deptMapper.insertLastId();
}

public void updateDept(Dept dept) {
	// TODO Auto-generated method stub
	//deptMapper.updateDept(dept);
    deptMapper.updateByPrimaryKeySelective(dept);
}




public Dept getDeptById(int i) {
    // TODO Auto-generated method stub
    DeptExample de=new DeptExample();
    de.createCriteria().andStatusEqualTo("1").andDidEqualTo(i);
    return deptMapper.selectByExample(de).get(0);
}
public List<UserDeptKey> getUidByDid(Integer id) {
    // TODO Auto-generated method stub
    UserDeptExample ude=new UserDeptExample();
    ude.createCriteria().andDidEqualTo(id);
    return userDeptMapper.selectByExample(ude);
}
public List<Dept> getDeptByPid(Integer id) {
    // TODO Auto-generated method stub
    DeptExample de=new DeptExample();
    de.createCriteria().andPidEqualTo(id);
    return deptMapper.selectByExample(de);
}

}
