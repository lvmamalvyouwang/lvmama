package com.gaoruanliuban.ssh.Uilts;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.struts2.util.StrutsTypeConverter;

public class DataSrting extends StrutsTypeConverter {
    private DateFormat dateFormat;
    {
    	dateFormat=new SimpleDateFormat("yyyy-MM-dd");
    }
    
	@Override
	public Object convertFromString(Map arg0, String[] arg1, Class arg2) {
		if(arg2==Date.class){
			try {
				return dateFormat.parse(arg1[0]);
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public String convertToString(Map arg0, Object arg1) {
		if(arg1 instanceof Date){
			return dateFormat.format((Date)arg1);
		}
		return null;
	}

}
