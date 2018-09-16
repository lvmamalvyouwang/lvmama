package com.gaoruanliuban.ssh.Uilts;

import org.hibernate.Session;
import org.hibernate.SessionFactory;


public class GetSession {
   private SessionFactory factory;
   public void setFactory(SessionFactory factory) {
	this.factory = factory;
   }
   public Session getSession(){
	   return factory.getCurrentSession();
   }
}
