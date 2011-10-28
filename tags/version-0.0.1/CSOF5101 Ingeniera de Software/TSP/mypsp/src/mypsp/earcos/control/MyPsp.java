package mypsp.earcos.control;

import mypsp.earcos.annotations.Loc;

/**
 *
 * @author Erik
 */
public class MyPsp {
	@Loc(size = 2)
    public static void main(String... args) {
        Control control = new Control();
        control.validateCommand(args);
    }
}
