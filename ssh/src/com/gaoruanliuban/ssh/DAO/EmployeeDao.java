package com.gaoruanliuban.ssh.DAO;

import java.util.List;

import com.gaoruanliuban.ssh.Beans.Employee;
import com.gaoruanliuban.ssh.Uilts.GetSession;

public class EmployeeDao extends GetSession{
	  public List<Employee> getempAll(){
		   return getSession().createQuery("FROM Employee e LEFT OUTER JOIN FETCH e.department").list();
	   }
	   public void sevarOruodate(Employee emp){
		   getSession().saveOrUpdate(emp);
	   }
	   public Employee employee(int id){
		   return (Employee)getSession().get(Employee.class, id);
	   }
	   public void delete(int id){
		   getSession().createQuery("DELETE FROM Employee e WHERE e.id=?").setInteger(0, id).executeUpdate();
	   }
	   public Employee getEmployee(String name){
		   return (Employee)getSession().createQuery("FROM Employee e WHERE e.lastName=?").setString(0, name).uniqueResult();
	   }

}
