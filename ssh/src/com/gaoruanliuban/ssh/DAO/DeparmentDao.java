package com.gaoruanliuban.ssh.DAO;

import java.util.List;

import com.gaoruanliuban.ssh.Beans.Department;
import com.gaoruanliuban.ssh.Uilts.GetSession;

public class DeparmentDao extends GetSession{
   public List<Department> deparmentAll(){
	   return getSession().createQuery("FROM Department d").list();
   }
}
