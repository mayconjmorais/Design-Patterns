package datastructure.doublylinkedlist;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;

/**
*
* @author Maycon Morais
*/

public class TestDoublyLinkedList {
	
	private static DoublyLinkedList<String> list;
	private static final String VARIABLE_TEST = "TEST";

	@BeforeEach
	public void setUp() {
		list = new DoublyLinkedList<String>();
	}

	@Test
	public void testSize() {
		// edge
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		// normal
		assertTrue(list.add(VARIABLE_TEST));
		assertEquals(1, list.size());
		assertTrue(list.add(VARIABLE_TEST + "_ADD"));
		assertEquals(2, list.size());
		list.clear();
		assertEquals(0, list.size());

	}

	@Test
	public void testClear() {
		// edge
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());

		for (int i = 0; i < 10; i++) {
			list.add(VARIABLE_TEST + i);
		}
		// normal
		assertEquals(10, list.size());
		assertFalse(list.isEmpty());

		list.clear();
		assertEquals(0, list.size());
	}

	@Test
	public void testContains() {
		// edge
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());

		for (int i = 0; i < 5; i++) {
			list.add(VARIABLE_TEST + i);
		}

		// normal
		assertEquals(5, list.size());
		list.contains(VARIABLE_TEST + 1);
		assertTrue(list.contains(VARIABLE_TEST + 1));
		assertTrue(list.contains(VARIABLE_TEST + 3));
		System.out.println(list.contains(VARIABLE_TEST + 1));
		assertFalse(list.contains(VARIABLE_TEST + 6));
		assertFalse(list.contains(null));
	}

	@Test
	public void testAdd() {
		// edge
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		// normal
		assertTrue(list.add(VARIABLE_TEST));
		assertFalse(list.isEmpty());
		assertEquals(1, list.size());

		assertTrue(list.add(VARIABLE_TEST + list.size()));
		assertEquals(2, list.size());
		assertFalse(list.isEmpty());
		// error
		assertThrows(IndexOutOfBoundsException.class, () -> list.add(10, VARIABLE_TEST));
	}

	@Test
	public void testRemove() {
		// edge
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());

		for (int i = 0; i < 5; i++) {
			list.add(VARIABLE_TEST + i);
		}
		// normal
		assertFalse(list.isEmpty());
		assertEquals(5, list.size());
		assertTrue(list.contains(VARIABLE_TEST + 1));

		list.remove(1);

		assertFalse(list.isEmpty());
		assertEquals(4, list.size());
		assertFalse(list.contains(VARIABLE_TEST + 1));
		// error
		assertThrows(IndexOutOfBoundsException.class, () -> list.remove(5));

	}

	@Test
	public void testAddIndexElementDoublyLinkedList() {
		// edge
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		// normal
		list.add(0, VARIABLE_TEST + 0);
		list.add(1, VARIABLE_TEST + 1);
		list.add(2, VARIABLE_TEST + 2);

		assertFalse(list.isEmpty());
		assertEquals(3, list.size());
		assertTrue(list.contains(VARIABLE_TEST + 1));
		// error
		assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, VARIABLE_TEST + "_FAIL"));
		assertThrows(IndexOutOfBoundsException.class, () -> list.add(5, VARIABLE_TEST + "_FAIL"));
	}

	@Test
	public void testSetDoublyLinkedList() {
		// edge
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		// normal
		list.add(0, VARIABLE_TEST + 0);
		list.add(1, VARIABLE_TEST + 1);
		list.add(2, VARIABLE_TEST + 2);

		assertFalse(list.isEmpty());
		assertEquals(3, list.size());
		assertTrue(list.contains(VARIABLE_TEST + 1));

		list.set(1, VARIABLE_TEST + 3);

		assertEquals(3, list.size());
		assertFalse(list.contains(VARIABLE_TEST + 1));
		assertTrue(list.contains(VARIABLE_TEST + 3));
		// error
		assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, VARIABLE_TEST + "_FAIL"));
		assertThrows(IndexOutOfBoundsException.class, () -> list.set(5, VARIABLE_TEST + "_FAIL"));
	}

	/**
	 * BONUS
	 */

//	@Test
//	public void testListIterator() {
//		// edge
//		assertTrue(list.isEmpty());
//		assertEquals(0, list.size());
//
//		for (int i = 0; i < 4; i++) {
//			list.add(VARIABLE_TEST + i);
//		}
//		// normal
//		assertFalse(list.isEmpty());
//		assertEquals(4, list.size());
//
//		ListIterator<String> iterator = list.listIterator(0);
//
//		assertTrue(iterator.hasNext());
//		assertEquals(VARIABLE_TEST + 0, iterator.next());
//		assertEquals(VARIABLE_TEST + 1, iterator.next());
//		assertEquals(VARIABLE_TEST + 2, iterator.next());
//		assertEquals(VARIABLE_TEST + 3, iterator.next());
//		assertTrue(!iterator.hasNext());
//
//	}

	@Test
	public void testSubList() {
		// edge
		assertTrue(list.isEmpty());
		assertEquals(0, list.size());
		
		for (int i = 0; i < 4; i++) {
			list.add(VARIABLE_TEST + i);
		}
		// normal
		List<String> subList = list.subList(0, 3);
		assertEquals(3, subList.size());
		
		subList.remove(2);
		assertEquals(2, subList.size());
		assertFalse(subList.contains(2));
		
		assertEquals(VARIABLE_TEST + 0 , subList.get(0));
		
		subList.clear();
		assertEquals( 0, subList.size());
		// error
		assertThrows( IndexOutOfBoundsException.class, () -> subList.add( 5, VARIABLE_TEST+"_FAIL" ));
		assertThrows( IndexOutOfBoundsException.class, () -> subList.add( -5, VARIABLE_TEST+"_FAIL" ));
	}

	@Test
	public void testLastIndexOf() {
		assertTrue( list.isEmpty());
		assertEquals( 0, list.size());

		for ( int i = 0; i < 100; i++) {
			list.add( VARIABLE_TEST + i);
		}

		assertFalse( list.isEmpty());
		assertEquals( 100, list.size());

		assertEquals( 99, list.lastIndexOf( VARIABLE_TEST + 99));

		assertEquals( -1, list.lastIndexOf( VARIABLE_TEST + 101));
	}
//
//	@AfterEach
//    void tearDown(TestInfo testInfo) {
//    	System.out.println("Finished..." + testInfo.getDisplayName());
//    }   
}