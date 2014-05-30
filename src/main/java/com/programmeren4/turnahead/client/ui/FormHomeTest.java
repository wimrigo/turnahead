package com.programmeren4.turnahead.client.ui;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertFalse;

import org.junit.*;

public class FormHomeTest {

	@Test
    public void testadduser() {
		FormHome user = new FormHome("Wim");
		Assert.assertTrue(user, condition);
    }

}
