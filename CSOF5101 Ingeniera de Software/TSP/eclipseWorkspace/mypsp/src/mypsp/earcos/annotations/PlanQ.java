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
public @interface PlanQ {
	int[] planificacion();

	int[] diseno();

	int[] codificacion();

	int[] pruebas();

	int[] postmortem();

	int[] inspeccion();
}
