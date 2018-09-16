package com.gaoruanliuban.ssh.Action;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.RequestAware;

import com.gaoruanliuban.ssh.Beans.Department;
import com.gaoruanliuban.ssh.Beans.Employee;
import com.gaoruanliuban.ssh.servlets.DeparmentServlets;
import com.gaoruanliuban.ssh.servlets.EmployeeServlet;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;

public class EmployeeAction extends ActionSupport implements RequestAware,ModelDriven<Employee> ,Preparable{
  /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String lasName;
	private Integer id;
	private Integer empid;
	private Employee employee;
	private EmployeeServlet employeeServlet;
	private DeparmentServlets deparmentServlets;
	private List<Employee> list;
	private Map<String,Object>map;
	private InputStream inputStream;
	public void setLasName(String lasName) {
		this.lasName = lasName;
	}
    public InputStream getInputStream() {
	        return inputStream;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}
	public Employee getEmployee() {
		return employee;
	}
	public void setDeparmentServlets(DeparmentServlets deparmentServlets) {
		this.deparmentServlets = deparmentServlets;
	}
	public void setList(List<Employee> list) {
		this.list = list;
	}
	public List<Employee> getList() {
		return list;
	}
	  public void setEmployeeServlet(EmployeeServlet employeeServlet) {
		this.employeeServlet = employeeServlet;
	  }
	  public String emplist(){
		 System.out.println(employeeServlet.emp_list().size());
		  map.put("list",  list=employeeServlet.emp_list());
		  return "emplist-list";
	  }
	  public String input(){
		  map.put("depar", deparmentServlets.deparAll());
		  return "input-input";
	  }
	  public void prepareInput(){
		  if(empid!=null){
			  employee=employeeServlet.employee(empid);
		  }
		  map.put("empid", empid);
	  }
	 public String saverOrupdate(){
		 employee.setCreateTime(new Date());
		 employeeServlet.saverOruodate(employee);
		 return "saverOrupdate-emplist";
	 }
	 public void prepareSaverOrupdate(){
		 if(id!=null){
			 employee=employeeServlet.employee(id);
		 }else{
			 employee=new Employee();
		 }
	 }
	 public String delete(){
		 try {
			employeeServlet.delete(empid); 
			inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		} catch (Exception e) {
			e.printStackTrace();
			try {
				inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
			} catch (UnsupportedEncodingException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		 return "delete-delete";
	 }
	 public String isEmployee() throws Exception{
		 System.out.println("isEmployee");
		 System.out.println(lasName);
		 System.out.println(employeeServlet.isEmployee(lasName));
		 if(employeeServlet.isEmployee(lasName)){
			 System.out.println("可用");
             inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
		 }else{
			 System.out.println("不可用");
			inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
		 }
		 return "delete-delete";
	 }
	@Override
	public void setRequest(Map<String, Object> arg0) {
		this.map=arg0;
		
	}
	@Override
	public void prepare() throws Exception {
	}
	@Override
	public Employee getModel() {
		// TODO Auto-generated method stub
		return employee;
	}
}
