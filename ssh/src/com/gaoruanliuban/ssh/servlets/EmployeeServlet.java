package com.gaoruanliuban.ssh.servlets;

import java.util.List;

import com.gaoruanliuban.ssh.Beans.Employee;
import com.gaoruanliuban.ssh.DAO.EmployeeDao;
import com.gaoruanliuban.ssh.Uilts.GetSession;

public class EmployeeServlet {
   private EmployeeDao dao;
   public void setDao(EmployeeDao dao) {
	this.dao = dao;
   }

  public List<Employee> emp_list(){
	   return dao.getempAll();
   }
   public void saverOruodate(Employee emp){
	   dao.sevarOruodate(emp);
   }
   public Employee employee(int id){
	   return dao.employee(id);
   }
   public void delete(int id){
	   dao.delete(id);
   }
   public boolean isEmployee(String name){
	  return  dao.getEmployee(name)==null;
   }
}
