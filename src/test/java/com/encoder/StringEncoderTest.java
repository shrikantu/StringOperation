/**
 * 
 */
package com.encoder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

/**
 * @author Shrikant
 *
 */
@RunWith(JUnit4.class)
public class StringEncoderTest {

	@Test(expected = RuntimeException.class)
	public final void whenEmptyStringWithValidOffsetIsUsedThenRuntimeExceptionIsThrown() {
		StringEncoder.encode(1,"");
		StringEncoder.encode(-1,"");
	}
	
	@Test(expected = RuntimeException.class)
	public final void whenNullAsStringWithValidOffsetIsUsedThenRuntimeExceptionIsThrown() {
		StringEncoder.encode(1,null);
		StringEncoder.encode(-1,null);
	}
	
	@Test(expected = RuntimeException.class)
	public final void whenInvalidOffsetIsUsedThenRuntimeExceptionIsThrown() {
		StringEncoder.encode(2,"");
		StringEncoder.encode(-2,"");
	}
	
	@Test(expected = RuntimeException.class)
	public final void whenNonCharAsStringWithInvaliOffsetIsUsedThenReturnValueAsItIs() {
		StringEncoder.encode(2,"@");
		StringEncoder.encode(-2,"!");
		StringEncoder.encode(-2,"10");
		StringEncoder.encode(2," ");
	}
	
	@Test
	public final void whenUpperCaseLastCharAsStringWithValidOffsetIsUsedThenReturnValueIsNextUpperCaseIsFirstChar() {
		assertEquals("A", StringEncoder.encode(1,"Z"));
	}
	
	@Test
	public final void whenUpperCaseFirstCharAsStringWithValidOffsetIsUsedThenReturnValueIsPreviousUpperCaseIsLastChar() {
		assertEquals("Z", StringEncoder.encode(-1,"A"));
	}
	
	@Test
	public final void whenLowerCaseLastCharAsStringWithValidOffsetIsUsedThenReturnValueIsNextLowerCaseIsFirstChar() {
		assertEquals("a", StringEncoder.encode(1,"z"));
	}
	
	@Test
	public final void whenLowerCaseFirstCharAsStringWithValidOffsetIsUsedThenReturnValueIsPreviousLowerCaseIsLastChar() {
		assertEquals("z", StringEncoder.encode(-1,"a"));
	}
	
	@Test
	public final void whenUpperCaseCharAsStringWithValidOffsetIsUsedThenReturnValueIsNextUpperCaseChar() {
		assertEquals("B", StringEncoder.encode(1,"A"));
		assertEquals("C", StringEncoder.encode(1,"B"));
		assertEquals("Q", StringEncoder.encode(1,"P"));
	}
	
	@Test
	public final void whenUpperCaseCharAsStringWithValidOffsetIsUsedThenReturnValueIsPreviousUpperCaseChar() {
		assertEquals("A", StringEncoder.encode(-1,"B"));
		assertEquals("O", StringEncoder.encode(-1,"P"));
		assertEquals("Y", StringEncoder.encode(-1,"Z"));
	}
	
	@Test
	public final void whenLowerCaseCharAsStringWithValidOffsetIsUsedThenReturnValueIsNextLowerCaseChar() {
		assertEquals("b", StringEncoder.encode(1,"a"));
		assertEquals("c", StringEncoder.encode(1,"b"));
		assertEquals("q", StringEncoder.encode(1,"p"));
	}
	
	@Test
	public final void whenLowerCaseCharAsStringWithValidOffsetIsUsedThenReturnValueIsPreviousLowerCaseChar() {
		assertEquals("a", StringEncoder.encode(-1,"b"));
		assertEquals("o", StringEncoder.encode(-1,"p"));
		assertEquals("y", StringEncoder.encode(-1,"z"));
	}
	
	@Test
	public final void whenNonCharAsStringWithValidOffsetIsUsedThenReturnValueAsItIs() {
		assertEquals("@", StringEncoder.encode(1,"@"));
		assertEquals("!", StringEncoder.encode(-1,"!"));
		assertEquals("10", StringEncoder.encode(-1,"10"));
		assertEquals(" ", StringEncoder.encode(-1," "));
	}
	
	
	
	
}
