package org.kzcw.common.utils;

import java.util.ArrayList;
import java.util.List;

import org.kzcw.model.Breakhistory;
import org.kzcw.model.Status;

public class SystemData {
	//系统数据

	private static SystemData instance=new SystemData();
	public List<String> locklist;//锁子列表
	public List<Status> statuslist;//数据上报状态表
	public List<Breakhistory> breaklist;//数据上报状态表
	public String name = "李环宇";  //控制用户名
	public String passwd = "xz86512121"; //控制密码
	
	public SystemData() {
		// TODO Auto-generated constructor stub
	    locklist=new ArrayList<String>();
	    statuslist=new ArrayList<Status>();
	    breaklist=new ArrayList<Breakhistory>();
	}
	public static SystemData getInstance() {
		return instance;
	}
}
