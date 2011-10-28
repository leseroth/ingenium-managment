package com.ingenium.tsp.test;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.control.ManagePropertyFile;
import com.ingenium.tsp.model.*;
import com.ingenium.tsp.util.Constants;

import junit.framework.TestCase;

/*
 * Clase usada para verificar los métodos de la clase Task
 * */
public class PlanTest extends TestCase {
    /*
     * Objeto para realizar los casos de prueba
     * */
    private Task task1;
    /*
     * Objeto para manejar el archivo de las tareas
     * */
    private ManagePropertyFile taskFile1;
    
    /*
     * Construye el objeto task1 para las pruebas
     */
    private void setupEscene1() {
    }
    
    /*
     * Verifica la actualización de una tarea en el archivo de propiedades
     * Objetivo: Actualizar una tarea en el archivo de propiedades y verificarlo
     * Resultados esperados: Al cargar la tarea desde el archivo, debe
     * coincidir con la que se acaba de actualizar.
     * Nota: Esta prueba modifica el archivo de propiedades de tareas.
     */
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 14, responsible = "201110544") })
    public void testUpdateTask()
    {
	// Carga el objeto taskFile1
	taskFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.TASK_FILE);
	
	// Busca el código de la tarea creado en el archivo
	String codeToFind = taskFile1.getProperty("1.3.2.1");
	

	//Es prerrequisito que la tarea exista para realizar la prueba de actulización	
	if(codeToFind!=null)
	{
	    String [] objectAsString = codeToFind.split("]");
	    
	    //Construir el objeto task1
	    task1 = new Task();
	    task1.decodeData(codeToFind);
	    
	    //Modificar el nombre del objeto
	    task1.setName("nombredeprueba1");
	    
	    //Persistir el objeto
	    taskFile1.put(task1);
	    taskFile1.persist();
	    
	    //Volver a cargar el archivo
	    taskFile1 = null;
	    taskFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.TASK_FILE);
	    
	    //Comparar con el valor guardado
	    String taskToCompare = taskFile1.getProperty("1.3.2.1");
	    task1.decodeData(taskToCompare);
	    assertEquals("Error al actualizar", "nombredeprueba1", task1.getName());
	}
    }
    
    
    /*
     * Verifica la eliminación de una tarea en el archivo de propiedades
     * Objetivo: Eliminar una tarea en el archivo de propiedades y verificarlo
     * Resultados esperados: Al cargar la tarea desde el archivo, el resultado
     * debe ser vacio
     */
    @LocList({ @Loc(cycle = Constants.CYCLE_2, size = 12, responsible = "201110544") })
    public void testTaskRemove() {
	// Carga el objeto taskFile1
	taskFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.TASK_FILE);
	String codeToFind = taskFile1.getProperty("1.3.2.4");
	
	if(codeToFind != null)
	{
	    task1 = new Task();
	    task1.decodeData(codeToFind);
		
	    // elimina el objeto del archivo
	    taskFile1.remove(task1);
	    taskFile1.persist();
	
	    // Carga de nuevo el objeto personFile1
	    taskFile1 = null;
	    taskFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.TASK_FILE);

	    String codeToCompare = taskFile1.getProperty("1.3.2.4");

	    // Confirma la existencia del código en el archivo de propiedades
	    assertTrue(codeToCompare==null);
	}
	taskFile1 = null;
    }
    
}
