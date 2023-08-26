package tests;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import listClasses.BasicLinkedList;
import listClasses.SortedLinkedList;

/**
 * 
 * You need student tests if you are looking for help during office hours about
 * bugs in your code.
 * 
 * @author UMCP CS Department
 *
 */
public class StudentTests {

	@Test
	public void test1() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd​("Red").addToFront​("Yellow").addToFront​("Blue").addToEnd​("Green").addToFront​("Purple");
		basicList.getReverseList();
		String a="";
		String answer="5\n"
				+ "\" Green Red Yellow Blue Purple \"";
		a+=basicList.getSize()+"\n";
		a+=basicList.toString();
		System.out.println(a);
		assertTrue(a.equals(answer));
	}
	@Test
	public void test2() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd​("Red").addToFront​("Yellow").addToFront​("Blue").addToEnd​("Green").addToFront​("Purple");
		ArrayList<String> arr1=basicList.getReverseArrayList(); 
		String a="";
		String answer="GreenRedYellowBluePurple";
		for(String i:arr1) {
			a+=i;
		}
		System.out.println(a);
		assertTrue(a.equals(answer));
	}
	@Test
	public void test3() {
		SortedLinkedList<String> basicList = new SortedLinkedList<String>(String.CASE_INSENSITIVE_ORDER);
		basicList.add​("Red").add​("Yellow").add​("Blue").add​("Red").add​("Green").add​("Purple").add​("Red");
		String a="";
		basicList.remove​("Yellow").remove​("Red");
		a+=basicList.toString();
		System.out.println(a);
		String answer="\" Blue Green Purple \"";
		assertTrue(a.equals(answer));
	}
	@Test
	public void test4() {
		BasicLinkedList<String> basicList = new BasicLinkedList<String>();
		basicList.addToEnd​("Red").addToFront​("Yellow").addToFront​("Blue").addToEnd​("Green").addToFront​("Purple");
		basicList.retrieveFirstElement();
		basicList.retrieveLastElement();
		String a="";
		a+=basicList.toString();
		System.out.println(a);
		String answer="\" Blue Yellow Red \"";
		assertTrue(a.equals(answer));
	}
	

}
