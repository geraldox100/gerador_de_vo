package br.com.geraldoferraz.geradordevo;

import junit.framework.Assert;
import net.vidageek.mirror.dsl.Mirror;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.runners.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BaseTest {
	
	protected Mirror mirror;
	
	@Before
	public void beforeBaseTet(){
		mirror = new Mirror();
	}
	
	@Test
	public void testePraPassar(){
		Assert.assertTrue(true);
	}

}
