<<<<<<< HEAD
package hust.soict.dsai.aims.utils.DVDUtils;
import java.util.Arrays;
import java.util.Comparator;

import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class DVDUtils {
	public static boolean compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
		if (dvd1.getCost() != dvd2.getCost()) {
			return false;		
		}
		else {
			return true;
		}
	}
	public static boolean compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
		if (dvd1.getTitle() != dvd2.getTitle()) {
			return false;		
		}
		else {
			return true;
		}
	}
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc [] dvdList){
		Comparator<DigitalVideoDisc> nameSort = Comparator.comparing(DigitalVideoDisc::getTitle); 
		Arrays.sort(dvdList, nameSort); 
		return dvdList;
	}
		
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc [] dvdList){
		Comparator<DigitalVideoDisc> costSort = Comparator.comparing(DigitalVideoDisc::getCost); 
		Arrays.sort(dvdList, costSort); 
		return dvdList;
	}
	
}
=======
package hust.soict.dsai.aims.utils.DVDUtils;
import java.util.Arrays;
import java.util.Comparator;

import hust.soict.dsai.aims.disc.DigitalVideoDisc.DigitalVideoDisc;

public class DVDUtils {
	public static boolean compareByCost(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
		if (dvd1.getCost() != dvd2.getCost()) {
			return false;		
		}
		else {
			return true;
		}
	}
	public static boolean compareByTitle(DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
		if (dvd1.getTitle() != dvd2.getTitle()) {
			return false;		
		}
		else {
			return true;
		}
	}
	public static DigitalVideoDisc[] sortByTitle(DigitalVideoDisc [] dvdList){
		Comparator<DigitalVideoDisc> nameSort = Comparator.comparing(DigitalVideoDisc::getTitle); 
		Arrays.sort(dvdList, nameSort); 
		return dvdList;
	}
		
	public static DigitalVideoDisc[] sortByCost(DigitalVideoDisc [] dvdList){
		Comparator<DigitalVideoDisc> costSort = Comparator.comparing(DigitalVideoDisc::getCost); 
		Arrays.sort(dvdList, costSort); 
		return dvdList;
	}
	
}
>>>>>>> 72acdd27e81236a6775ba922af00d451ad39b784
