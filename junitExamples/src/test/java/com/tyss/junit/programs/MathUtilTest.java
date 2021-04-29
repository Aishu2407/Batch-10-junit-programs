package com.tyss.junit.programs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MathUtilTest {

	@Test
	void testAddNumbers()
	{
		MathUtil m=new MathUtil();
		int exp=10;
		int act=m.addNumbers(5,5);
		assertEquals(exp, act,"actual vale is not matching");
	}

}
