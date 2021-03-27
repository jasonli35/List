import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection; 
import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class TestLists {

	public static Collection<Object[]> LISTNUMS =
			Arrays.asList(new Object[][] { {"Linked"}, {"Array"} });
	private String listType;

	public TestLists(String listType) {
		super();
		this.listType = listType;
	}

	@Parameterized.Parameters(name = "{0}List")
	public static Collection<Object[]> bags() {
		return LISTNUMS;
	}

	private <E> MyList<E> makeList(E[] contents) {
		switch (this.listType) {
		case "Linked":
			return new LinkedGL<E>(contents);
		case "Array":
			return new ArrayGL<E>(contents);
		}
		return null;
	}

  // Don't change code above this line, it ensures the autograder works as
  // expected


  // This is a sample test; you can keep it, change it, or remove it as you like.
  // Note that it uses the method `assertArrayEquals`, which you should use to
  // test equality of arrays in this PA.
	@Test
	public void testSimpleToArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {1, 2, 3};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
		// Using the generic list to create a String list
		String[] string_input = {"a", "b", "c"};
		MyList<String> string_s = makeList(string_input);
		assertArrayEquals(string_input, string_s.toArray());
	}
	@Test
	public void testToEmptyArray() {
		// Using the generic list to create an Integer list
		Integer[] int_input = {};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
		
	}
	//This method test if constructor can pass empty list and test toArray of empty list
	@Test
	public void testConstructor() {
		
		Integer[] int_input = {};
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(new Integer[0], int_s.toArray());
	}
	//Test max size of Linked list
	@Test
	public void testToArray() {
		
		Integer[] int_input = new Integer[1000];
		for(int i = 0; i < 1000; i++) {
			int_input[i] = i;
		}
		MyList<Integer> int_s = makeList(int_input);
		assertArrayEquals(int_input, int_s.toArray());
	}
	//test if isEmpty method work properly for multiple value
	@Test
	public void testIsEmpty() {
		Integer[] int_input = {1, 2, 3, 6, 8, 10};
		MyList<Integer> linkedList = makeList(int_input);
		assertEquals(false, linkedList.isEmpty());
	}
	//test if isEmpty method work properly for 1 input
		@Test
		public void testIsEmpty2() {
			Integer[] int_input = {1};
			MyList<Integer> linkedList = makeList(int_input);
			assertEquals(false, linkedList.isEmpty());
		}
	//test if isEmpty method work properly for empty list
		@Test
		public void testIsEmpty1() {
			Integer[] int_input = {};
			MyList<Integer> linkedList = makeList(int_input);
			assertEquals(true, linkedList.isEmpty());
		}
	//test if isEmpty method work properly for null list
		@Test
		public void testIsEmpty3() {
			Integer[] int_input = {null, null, null};
			MyList<Integer> linkedList = makeList(int_input);
			assertEquals(false, linkedList.isEmpty());
		}
		
	//test if chooseAll work with choose long
		@Test
		public void testChooseAll() {
			String[] contents = {"longword", "longerword", "short"};
			MyList<String> agl = makeList(contents);
			agl.chooseAll(new LongWordChooser());
			String[] expected = {"longword", "longerword"};
			assertArrayEquals(expected, agl.toArray());
		}
		
		//This method test if chooseAll choose only long string when implement the right class
		@Test
		public void testChooseAllRemoveNull() {
			String[] contents = {"longword", "short","shor","sho", null};
			MyList<String> agl = makeList(contents);
			agl.chooseAll(new LongWordChooser());
			String[] expected = {"longword"};
			assertArrayEquals(expected, agl.toArray());
		}


		//This method test if chooseAll work for empty list
		@Test
		public void testChooseAll3() {
			String[] contents = {};
			MyList<String> agl = makeList(contents);
			agl.chooseAll(new ChooseAllChooser());
			String[] expected = {};
			assertArrayEquals(expected, agl.toArray());
		}

		//Test ChooseAll for integer type
		@Test
		public void testChooseAll5() {
			Integer[] contents = {33, 4443, 44422, 442244};
			MyList<Integer> agl = makeList(contents);
			agl.chooseAll(new ChooseAllChooser());
			Integer[] expected = {33, 4443, 44422, 442244};
			assertArrayEquals(expected, agl.toArray());
		}		
	//test the normal case of transformer from lower to uppercase
		@Test
		public void testTransformerString() {
			String[] contents = {"a", "b"};
			String[] expected = {"A", "B"};
			MyList<String> agl = makeList(contents);
			
			agl.transformAll(new UpperCaseTransformer());
			
			assertArrayEquals(expected, agl.toArray());

		}
		
		public void testTransformerToCap() {
			String[] contents = {"a", "b"};
			String[] expected = {"A", "B"};
			
			MyList<String> agl = makeList(contents);
			
			agl.transformAll(new UpperCaseTransformer());

			assertArrayEquals(expected, agl.toArray());
		}
		
	//test the transformer from lower to uppercase for null object
		@Test
		public void testTransformer1() {
			String[] contents = {"a", null, null};
			String[] expected = {"A", null, null};
			MyList<String> agl = makeList(contents);
			agl.transformAll(new UpperCaseTransformer());
			assertArrayEquals(expected, agl.toArray());
		
		}

		@Test
		public void testTransformer8() {
			String[] contents = {"A", "B"};
			String[] expected = {"A", "B"};
			MyList<String> agl = makeList(contents);
			agl.transformAll(new UpperCaseTransformer());
			assertArrayEquals(expected, agl.toArray());
		}
		//test transformer for large list
		@Test
		public void testTransformer3() {
			String[] contents = new String[1000];
			String[] expected = new String[1000];
			for(int i = 0; i < 1000; i++) {
				contents[i] = "a";
				expected[i] = "A";
			}
			MyList<String> agl = makeList(contents);
			agl.transformAll(new UpperCaseTransformer());
			assertArrayEquals(expected, agl.toArray());
		
		}
	//test transformer for empty list
		@Test
		public void testTransformer2() {
			String[] contents = {};
			String[] expected = {};
			MyList<String> agl = makeList(contents);
			agl.transformAll(new UpperCaseTransformer());
			assertArrayEquals(expected, agl.toArray());
		
		}

		//test if transform method in the ToPalindrome return the corrent value
		@Test
		public void testTransformerToPalindrome() {
			String[] contents = {"0123", "257552"};
			String[] expected = {"01233210", "257552255752"};
			MyList<String> agl = makeList(contents);
			agl.transformAll(new ToPalindrome());
			assertArrayEquals(expected, agl.toArray());
		
		}
		//test if transform method in the ToPalindrome return the corrent value
				@Test
				public void testTransformerToOpposite() {
					Double[] contents = {0123.12, 257552.0, -2.0};
					Double[] expected = {-0123.12, -257552.0, 2.0};
					MyList <Double> agl = makeList(contents);
					agl.transformAll(new ToOpposite());
					assertArrayEquals(expected, agl.toArray());
				
				}
		//test if transform method for empty list
				@Test
				public void testTransformerToOpposite2() {
					Double[] contents = {};
					Double[] expected = {};
					MyList <Double> agl = makeList(contents);
					agl.transformAll(new ToOpposite());
					assertArrayEquals(expected, agl.toArray());
				
				}
		
		
		

}