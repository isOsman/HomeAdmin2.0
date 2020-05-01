package com.osman.homeadmin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;


//class for save and get workList
public class Storage {
	
	//paths for storage
	private static final String DIR = "./HomeAdmin"; //directory for files
	private static final String WORKLIST = DIR+"/WorkList.HA"; //file for storage work list
	private static final String ID = DIR+"/ID"; //file for storage last id
	
	
	
	//initialize dir and files
	public void init() throws IOException {
		File checkFile;
		
		//if not exists,create new file
		
		checkFile = new File(DIR);
		if(!checkFile.exists()) checkFile.mkdir();
		
		checkFile = new File(WORKLIST);
		if(!checkFile.exists()) checkFile.createNewFile();
		
		checkFile = new File(ID);
		if (!checkFile.exists()) {
			checkFile.createNewFile();
			writeId(1);
		}

		
	}
	
	//write id to file,id need for Work obj
	public void writeId(int id) throws IOException{
		FileWriter fWriter = new FileWriter(ID);
		fWriter.write(id+"");
		fWriter.close();
	}
	
	//read id num from file Id
	public int getId() throws IOException {
		Scanner scan = new Scanner(new File(ID));
		int i = scan.nextInt();
		scan.close();
		return i;
	}
	
	
	//write list with works to file(save workList)
	public void saveList(ArrayList<Work> workList) throws IOException {
		FileOutputStream fos = new FileOutputStream(WORKLIST);
		ObjectOutputStream ois = new ObjectOutputStream(fos);
		ois.writeObject(workList);
		ois.close();
		fos.close();
			
	}
	
	
	//return saved list
	@SuppressWarnings("unchecked")
	public ArrayList<Work> getList() throws IOException,ClassNotFoundException {
		if(new File(WORKLIST).length()==0) return null;//if file is emty then return null
		//else...
		ArrayList<Work> list=null;
		FileInputStream fis = new FileInputStream(WORKLIST);
		ObjectInputStream ois = new ObjectInputStream(fis);
		list = (ArrayList<Work>) ois.readObject();
		ois.close();
		fis.close();
		return list;
	}
	
	public static void main(String args[]) throws IOException,ClassNotFoundException  {
		//test class Storage
		Storage storage = new Storage();
		storage.init();
		ArrayList<Work> list = storage.getList();
		if(list == null) {
			System.out.println("No records");
			return ;
		}
		for(Work w : list) {
			w.display();
		}
	}
	
}
