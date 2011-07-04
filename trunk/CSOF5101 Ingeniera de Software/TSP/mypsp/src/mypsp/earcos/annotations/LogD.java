package mypsp.earcos.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author Erik
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(value = { ElementType.TYPE, ElementType.METHOD, ElementType.CONSTRUCTOR })
public @interface LogD {

	public static enum STAGE {
		PLANNING("planeacion"), DESIGN("diseno"), CODING("codificacion"), TESTING("pruebas"), POSTMORTEM("postmortem"), INSPECTION("inspeccion");
		
		private String value;
		
	    STAGE(String v){
			value = v;
		}
	    public String getValue(){return value;}
	};

	String stage() default "";

	String type() default "";
}