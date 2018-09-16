package com.gaoruanliuban.ssh.servlets;

import java.util.List;

import com.gaoruanliuban.ssh.Beans.Department;
import com.gaoruanliuban.ssh.DAO.DeparmentDao;

public class DeparmentServlets {
  private DeparmentDao dao;
  public void setDao(DeparmentDao dao) {
	this.dao = dao;
  }
  public List<Department> deparAll(){
	  return dao.deparmentAll();
  }
}
