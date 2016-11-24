package cn.sirbox.service;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import cn.sirbox.model.Matchs;

public interface MatchsService {

	public List<Matchs> findAll(String thispage);

	public List<Matchs> query(Matchs matchs,String thispage);

	public void delete(Integer id);

	public Matchs check(Integer id);
	
	public Matchs deductMoney(Integer id);
	
	public void update(Matchs matchs);

	public void exportFile(String ids, HttpServletResponse response);
	
	public void edit(Matchs matchs);

}
