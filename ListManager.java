package com.osman.homeadmin;

import java.io.IOException;
import java.util.ArrayList;


import com.osman.homeadmin.Work;

//methods
//add() ***
//edit() ***
//delete() ***
//save() ***


public class ListManager {
	private ArrayList<Work> workList;
	private int id;
	
	
	//constructors
	public ListManager() {
		workList = new ArrayList<>();
	}
	
	public ListManager(Storage storage) throws IOException,ClassNotFoundException {
		workList = storage.getList() == null ? new ArrayList<>() : storage.getList();
		id = storage.getId();
	}
	
	public ListManager(ArrayList<Work> list) {
		this.workList = list;
	}
	
	//----------------------------------------
	
	//getter
	public ArrayList<Work> getList(){
		return this.workList;
	}
	
	//setter
	public void setList(ArrayList<Work> list) {
		this.workList = list;
	}
	
	//add new work to list
	public void add(Work work) {
		work.setID(this.id++);
		this.workList.add(work);
	}
	
	//edited(changed) oldWork to newWork
	public void edit(int oldWorkId,Work newWork) {
		if(workList.isEmpty()) {
			System.out.println("WorkList is empty");
			return ;
		}
		newWork.setID(oldWorkId);
		workList.set(findIndexByID(oldWorkId), newWork);
		return;
				
	}
	
	public void delete(int workId) {
		if(workList.isEmpty()) {
			System.out.println("WorkList is empty");
			return;
		}
		if(!isIdExists(workId)) {
			System.out.println("Work with this id does not exists");
			return;
		}
		workList.remove(findIndexByID(workId));
		return;
	}
	
	public void save(Storage storage) throws IOException{
		if(workList.isEmpty()) {
			System.out.println("WorkList is empty");
			return;
		}
		storage.saveList(workList);
		storage.writeId(id);
	}
	
	public void show() {
		if(workList.isEmpty()) {
			System.out.println("WorkList is empty");
			return;
		}
		for(Work work : workList) {
			System.out.println("-----------------------------------");
			work.display();
		}
		
		System.out.println("-----------------------------------");
	}
	
	//checks if there is a record with this ID
	public boolean isIdExists(int ID){
		if(getList()!=null && getList().size()!=0){
			for(Work work : getList()){
					if(work.getID()==ID){
						return true;
					}
				}
		}
		
		return false;
	}
	
	//returns an object of type Work with parameter ID
	 public Work getWorkByID(int ID){
		for (Work tempWork : this.workList) {
			if(tempWork.getID()==ID){
				return tempWork;
			}
		}
		return null;
	}
	 
	//returns specific Work inner index in workList; 
	public int findIndexByID(int workId) {
		for(int i=0;i<workList.size();i++) {
			if(workList.get(i).getID() == workId) return i;			
		}
		return  -1;
	}
	

	
	
	public static void main(String args[]) throws ClassNotFoundException, IOException {
		Storage storage = new Storage();
		storage.init();
		ListManager listManager = new ListManager(storage);
	    listManager.show();

	    

	    
	}
	

}
