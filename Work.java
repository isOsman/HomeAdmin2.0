package com.osman.homeadmin;

import java.io.Serializable;
import java.util.Scanner;

//implements Serializable for write to file
public class Work implements Serializable {
	//for serialization(id for object)
	private static final long serialVersionUID = 6512754042407963762L;
	private int ID;
	private String name;
	private String work;
	private String date;
	
	//getters
	public int getID(){
		return this.ID;
	}
	
	public String getName(){
		return this.name;
	}
	
	public String getWork(){
		return this.work;
	}
	
	public String getDate(){
		return this.date;
	}
	
	//setters
	public void setID(int ID){
		this.ID = ID;
	}
	
	public void setName(String name){
		this.name = name;
	}
	
	public void setWork(String work){
		this.work = work;
	}
	
	public void setDate(String date){
		this.date = date;
	}
	
	//constructor
	public Work(){
		
	}
//	constructor with param,param is Scanner which already open
	public Work(Scanner scan){
		fillWork(scan);
	}
	//constructor
	public Work(int ID,String name,String work,String date){
		this.ID = ID;
		this.name = name;
		this.work = work;
		this.date = date;
	}
	
	//fill works
	//param is Scanner which already open
	void fillWork(Scanner scan) {
		UserInput userInput = new UserInput(scan);
		this.ID = 1;//as default;
		this.name = userInput.getUserLine("Name");
		this.work = userInput.getUserLine("Work");
		this.date = DateUtils.getLocalizedDate();
	}
	
	//displays information about the object (record)
	public void display(){
		System.out.println("ID:"+this.ID);
		System.out.println("Name:"+this.name);
		System.out.println("Work:"+this.work);
		System.out.println("Date:"+this.date);
	}
	
	//return String contains info about this object(Work)
	public String toString() {
		String workInfo = 
				"ID:" + this.ID
				+"\nName:" + this.name
				+"\nWork:" + this.work
				+"\nDate:" + this.date;
		
		return workInfo;
	}
	
	
	public static void main(String args[]) {
		Work work = new Work(new UserInput().getScanner());
		System.out.println(work.toString());
	}
	

	
}