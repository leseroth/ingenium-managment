package com.ingenium.tsp.test;

import junit.framework.TestCase;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.model.*;
import com.ingenium.tsp.control.ManagePropertyFile;
import com.ingenium.tsp.util.Constants;

/*
 * Clase usada para verificar los m�todos de la clase Persona
 * */
public class PersonTest extends TestCase {

    /*
     * Persona usada para casos de prueba
     */
    private Person person1;
    /*
     * Persona usada para casos de prueba
     */
    private Person person2;
    private ManagePropertyFile personFile1;

    /*
     * Construye el objeto person1 para las pruebas
     */
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 8, responsible = "201110544") })
    private void setupEscene1() {
	person1 = new Person();
	person1.setId("201110599");
	person1.setName("Sujeto de prueba 1");
	person1.setRole("L�der de Grupo");

	person2 = new Person();
	person2.setId("201110600");
	person2.setName("Sujeto de prueba 2");
	person2.setRole("L�der de Desarrollo");
    }

    /*
     * Verifica la creaci�n de una persona en el archivo de propiedades
     * Objetivo: Crear una persona en el archivo de propiedades y verificarlo
     * Resultados esperados: Al cargar la persona desde el archivo, debe
     * coincidir con la que se acaba de ingresar.
     */
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 10, responsible = "201110544") })
    public void testPersonAdd() {
	// Configura el objeto persona para la prueba
	setupEscene1();

	// Carga el objeto personFile1
	personFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.PERSON_FILE);

	// Guarda el objeto persona en el archivo
	personFile1.put(person1);
	personFile1.persist();

	// Carga de nuevo el objeto personFile1
	personFile1 = null;
	personFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.PERSON_FILE);

	// Busca el c�digo del sujeto creado en el archivo
	String codeToFind = personFile1.getProperty("201110599");
	codeToFind = codeToFind == null ? null : codeToFind.split("]")[0];

	// Confirma la existencia del c�digo en el archivo de propiedades
	assertEquals("El c�digo de la pesona es erroneo. No se guard� el sujeto correctamente.", codeToFind, person1.getId());

	personFile1 = null;
    }

    /*
     * Verifica la eliminaci�n de una persona en el archivo de propiedades
     * Objetivo: Eliminar una persona en el archivo de propiedades y verificarlo
     * Resultados esperados: Al cargar la persona desde el archivo, el resultado
     * debe ser vacio
     */
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 14, responsible = "201110949") })
    public void testPersonRemove() {
	// Configura el objeto persona para la prueba
	setupEscene1();

	// Carga el objeto personFile1
	personFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.PERSON_FILE);

	// Guarda el objeto persona en el archivo, objeto q ser� eliminado
	personFile1.put(person2);
	personFile1.persist();

	// Carga de nuevo el objeto personFile1
	personFile1 = null;
	personFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.PERSON_FILE);

	// elimina el objeto del archivo
	personFile1.remove(person2);
	personFile1.persist();

	// Carga de nuevo el objeto personFile1
	personFile1 = null;
	personFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.PERSON_FILE);

	String codeToFind = personFile1.getProperty("201110600");
	codeToFind = codeToFind == null ? null : codeToFind.split("]")[0];

	// Confirma la existencia del c�digo en el archivo de propiedades
	assertEquals("No se elimin� el registro de la persona.", codeToFind, null);

	personFile1 = null;
    }
}
