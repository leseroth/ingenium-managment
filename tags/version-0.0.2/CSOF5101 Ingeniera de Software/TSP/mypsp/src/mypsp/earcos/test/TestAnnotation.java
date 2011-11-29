package mypsp.earcos.test;

import java.io.File;
import java.util.List;

import mypsp.earcos.annotations.Loc;
import mypsp.earcos.annotations.LogD;
import mypsp.earcos.annotations.LogDList;
import mypsp.earcos.control.Analizer;
import junit.framework.TestCase;

public class TestAnnotation extends TestCase {

	private Analizer analizer;
	
	@Loc(size = 2)
	protected void setUp() throws Exception {
		super.setUp();
		
		analizer = new Analizer();		
	}

	@Loc(size = 2)
	protected void tearDown() throws Exception {
		super.tearDown();
		
		analizer = null;
	}
	
	@Loc(size = 7)
	@LogDList({
		@LogD(stage = "inspeccion", type = "0211" ) })
	public void testOneClassAnnotation(){
		File file = new File("/mypsp/earcos/test/TestClass.java");
		analizer.analizeFile(file);
		List<String[]> outcome = analizer.getDescription().get(Analizer.PLAN);
		assertTrue("El tamano es 10",outcome.get(0)[1].equals("10"));
		assertTrue("El tiempo es 20",outcome.get(0)[2].equals("20"));
	}
	
	@Loc(size = 6)
	@LogDList({
		@LogD(stage = "inspeccion", type = "0211" ) })
	public void testOneMethodAnnotation(){
		File file = new File("/mypsp/earcos/test/TestClass.java");
		analizer.analizeFile(file);
		List<String[]> outcome = analizer.getDescription().get(Analizer.LOC);
		assertTrue("LOC = 1",outcome.get(0)[2].equals("1"));
	}
}
