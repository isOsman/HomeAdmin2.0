package com.osman.homeadmin;

import java.io.IOException;

//main class
public class Main {

	public static void main(String[] args) {
		Menu menu = new Menu();
		Storage storage = new Storage();
		ListManager listManager = null;
		UserInput userInput = new UserInput();
		int userNum;
		int id = -1;
		
		//init files and worklist
		try {
			storage.init();
			listManager = new ListManager(storage);
		}catch(IOException e) {
			System.out.println("Error creating files,try again.");
		}catch(ClassNotFoundException e) {
			System.out.println("Unknown error,try again");
		}
			
		//main loop
		do {
			menu.show();
			userNum = userInput.getUserNum("");
			switch (userNum) {
			case 1:
				System.out.println(menu.getOperation(userNum));
				System.out.println("-----------------------------------");
				listManager.show();
				break;
			case 2:
				System.out.println(menu.getOperation(userNum));
				System.out.println("-----------------------------------");
				Work work = new Work(userInput.getScanner());
				listManager.add(work);
				break;
			case 3:
				System.out.println(menu.getOperation(userNum));
				System.out.println("-----------------------------------");
				int oldWorkId = userInput.getUserNum("the id of the edited work");
				if(!listManager.isIdExists(oldWorkId)) {
					System.out.println("Work with this id does not exists");
				}else {
					Work newWork = new Work(userInput.getScanner());
					listManager.edit(oldWorkId, newWork);
				}
				break;
			case 4:
				int deleteWorkId = userInput.getUserNum("the id of the work to be deleted");
				listManager.delete(deleteWorkId);
				break;
			case 5:
				System.out.println(menu.getOperation(userNum));
				System.out.println("-----------------------------------");
				try {
					listManager.save(storage);//if I throw this exception in top try/catch,then I dont know where thwo
				}catch(IOException e) {
					System.out.println("Eror saving data");
				}
			default:
				break;
			}
		}while(userNum!=6);
		
		
		
		//save and close files
		try {
			listManager.save(storage);
			userInput.closeScan();
		}catch(IOException e) {
			System.out.println("Eror saving data");
		}

	}

}
