package test;

import static org.junit.Assert.*;

import javax.validation.constraints.AssertFalse;

import org.junit.*;

import com.programmeren4.turnahead.shared.FieldVerifier;

public class turnaheadtest {

	@Test
	public void test() {
		
		
		boolean result = FieldVerifier.isValidName("");
		assertFalse("lege string moet false returnen", result);
	}

}
