/*
Jonathan Carbonneau
I pledge my honor that I have abided by the Stevens Honor System.
 */

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreapTest {

	/**
	 * Test method for {@link Treap#Treap()}.
	 */
	@Test
	void testTreap() {
		Treap < Integer  > testTree = new Treap < Integer > ();
		assertEquals(testTree != null, true);
	}

	/**
	 * Test method for {@link Treap#Treap(long)}.
	 */
	@Test
	void testTreapLong() {
		Treap < Integer  > testTree = new Treap < Integer > (10);
		assertEquals(testTree != null, true);
	}

	/**
	 * Test method for {@link Treap#add(java.lang.Comparable)}.
	 */
	@Test
	void testAddE() {
	    Treap < Integer  > testTree = new Treap < Integer > ();
	    assertEquals(testTree.add(4, 19), true);
	    assertEquals(testTree.add(2, 31), true);
	    assertEquals(testTree.add(6, 70), true);
	    assertEquals(testTree.add(1, 84), true);
	    assertEquals(testTree.add(3, 12), true);
	    assertEquals(testTree.add(5, 83), true);
	    assertEquals(testTree.add(7, 26), true);
	    assertEquals(testTree.add(4, 19), false);
	    assertEquals(testTree.add(2, 31), false);
	    assertEquals(testTree.add(6, 70), false);
	    assertEquals(testTree.add(1, 84), false);
	    assertEquals(testTree.add(3, 12), false);
	    assertEquals(testTree.add(5, 83), false);
	    assertEquals(testTree.add(7, 26), false);
	    // add a tree checker
	}

	/**
	 * Test method for {@link Treap#add(java.lang.Comparable, int)}.
	 */
	@Test
	void testAddEInt() {
	    Treap < Integer  > testTree = new Treap < Integer > ();
	    assertEquals(testTree.add(4), true);
	    assertEquals(testTree.add(2), true);
	    assertEquals(testTree.add(6), true);
	    assertEquals(testTree.add(1), true);
	    assertEquals(testTree.add(3), true);
	    assertEquals(testTree.add(5), true);
	    assertEquals(testTree.add(7), true);
	    assertEquals(testTree.add(4), false);
	    assertEquals(testTree.add(2), false);
	    assertEquals(testTree.add(6), false);
	    assertEquals(testTree.add(1), false);
	    assertEquals(testTree.add(3), false);
	    assertEquals(testTree.add(5), false);
	    assertEquals(testTree.add(7), false);
	}

	/**
	 * Test method for {@link Treap#find(java.lang.Comparable)}.
	 */
	@Test
	void testFindE() {
	    Treap < Integer  > testTree = new Treap < Integer > ();
	    testTree.add(4, 19);
	    testTree.add(2, 31);
	    testTree.add(6, 70);
	    testTree.add(1, 84);
	    testTree.add(3, 12);
	    testTree.add(5, 83);
	    testTree.add(7, 26);
	    assertEquals(testTree.find(1), true);
	    assertEquals(testTree.find(10), false);
	}

	/**
	 * Test method for {@link Treap#find(Treap.Node, java.lang.Comparable)}.
	 */
	@Test
	void testFindNodeOfEE() {
	    Treap < Integer  > testTree = new Treap < Integer > ();
	    testTree.add(4, 19);
	    testTree.add(2, 31);
	    testTree.add(6, 70);
	    testTree.add(1, 84);
	    testTree.add(3, 12);
	    testTree.add(5, 83);
	    testTree.add(7, 26);
	    assertEquals(testTree.find(1), true);
	    assertEquals(testTree.find(10), false);
	}

	/**
	 * Test method for {@link Treap#delete(java.lang.Comparable)}.
	 */
	@Test
	void testDelete() {
	    Treap < Integer  > testTree = new Treap < Integer > ();
	    String initalTree = testTree.toString();
	    testTree.add(4, 19);
	    testTree.add(2, 31);
	    testTree.add(6, 70);
	    testTree.add(1, 84);
	    testTree.add(3, 12);
	    testTree.add(5, 83);
	    testTree.add(7, 26);
	    assertEquals(testTree.find(1), true);
	    testTree.delete(1);
	    assertEquals(testTree.find(1), false);
	    assertEquals(testTree.delete(1), false);
	    assertEquals(testTree.toString(),"(key=5, priority =83)\n (key=2, priority =31)\n  null\n  (key=4, priority =19)\n   (key=3, priority =12)\n    null\n    null\n   null\n (key=6, priority =70)\n  null\n  (key=7, priority =26)\n   null\n   null\n");
	    testTree.delete(2);
	    testTree.delete(3);
	    assertEquals(testTree.delete(4), true);
	    testTree.delete(5);
	    assertEquals(testTree.delete(6), true);
	    testTree.delete(7);
	    assertEquals(testTree.delete(6), false);
	    assertEquals(testTree.toString(), initalTree);    
	}

	/**
	 * Test method for {@link Treap#toString()}.
	 */
	@Test
	void testToString() {
	    Treap < Integer  > testTree = new Treap < Integer > ();
	    String initalTree = testTree.toString();
	    assertEquals(testTree.toString() == initalTree , false);
	    testTree.add(4, 19);
	    testTree.add(2, 31);
	    testTree.add(6, 70);
	    testTree.add(1, 84);
	    testTree.add(3, 12);
	    testTree.add(5, 83);
	    testTree.add(7, 26);
	    assertEquals(testTree.toString() != initalTree , true);
	    assertEquals(testTree.toString(), "(key=1, priority =84)\n null\n (key=5, priority =83)\n  (key=2, priority =31)\n   null\n   (key=4, priority =19)\n    (key=3, priority =12)\n     null\n     null\n    null\n  (key=6, priority =70)\n   null\n   (key=7, priority =26)\n    null\n    null\n");
	}


}
