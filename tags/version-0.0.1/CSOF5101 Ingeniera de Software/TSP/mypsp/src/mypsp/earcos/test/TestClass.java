package mypsp.earcos.test;

import mypsp.earcos.annotations.Loc;
import mypsp.earcos.annotations.Plan;

@Plan(size = 10, time = 20)
public class TestClass {
	
	@Loc(size = 1)
	public void testMethod(){
	}
}