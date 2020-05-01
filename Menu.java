package com.osman.homeadmin;

/**
 * 
 * @author Osman
 * class for navigate in app
 *
 */
public class Menu {
	//show menu
	void show() {
		System.out.println("\t\tMenu");
		System.out.println("-----------------------------------");
		System.out.println("1-Show");
		System.out.println("2-Add");
		System.out.println("3-Edit");
		System.out.println("4-Delete");
		System.out.println("5-Save");
		System.out.println("6-Exit");
		System.out.println("-----------------------------------");
	}
	
	
	//return submenu of param
	String getOperation(int what) {
		String result = "none";
		switch(what) {
		case 1:
			result = "Show";
			break;
		case 2:
			result = "Add";
			break;
		case 3:
			result = "Edit";
			break;
		case 4:
			result = "Delete";
			break;
		case 5:
			result = "Save";
			break;
		case 6:
			result = "Exit";
			break;
		default:
			result = "Repeate enter";
			break;
		}
		
		return result;
	
	}

}
