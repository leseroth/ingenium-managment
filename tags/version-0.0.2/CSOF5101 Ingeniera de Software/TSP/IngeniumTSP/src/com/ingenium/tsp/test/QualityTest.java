package com.ingenium.tsp.test;

import com.ingenium.tsp.annotations.Loc;
import com.ingenium.tsp.annotations.LocList;
import com.ingenium.tsp.control.ManagePropertyFile;
import com.ingenium.tsp.model.*;
import com.ingenium.tsp.util.Constants;

import junit.framework.TestCase;

/*
 * Clase usada para verificar los métodos de la clase Quality
 * */
public class QualityTest extends TestCase {
    /*
     * Objeto Quality usado para casos de prueba
     */
    private Quality quality1;
    /*
     * Objeto Quality usado para casos de prueba
     */
    private Quality quality2;
    
    /*
     * Objeto para manejar el archivo de plan de calidad.
     * */
    private ManagePropertyFile qualityFile1;
    
    /*
     * Configuración del escenario de pruebas
     * */
    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 12, responsible = "201110544") })
    private void setupEscene1() {
	quality1 = new Quality();
	quality1.setId("etapaprueba1");
	quality1.setDefectosInyectados("2");
	quality1.setDefectosInyectadosReal("3");
	quality1.setDefectosRemovidos("4");
	quality1.setDefectosRemovidosReal("5");
	
	quality2 = new Quality();
	quality2.setId("etapaprueba2");
	quality2.setDefectosInyectados("6");
	quality2.setDefectosInyectadosReal("7");
	quality2.setDefectosRemovidos("8");
	quality2.setDefectosRemovidosReal("9");	
	
	
    }
    
    /*
     * Verifica la creación de un plan de calidad en el archivo de propiedades
     * Objetivo: Crear un plan de calidad en el archivo de propiedades y verificarlo
     * Resultados esperados: Al cargar el plan de calidad desde el archivo, debe
     * coincidir con la que se acaba de ingresar.
     */
    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 10, responsible = "201110544") })
    public void testQualityAdd() {
	// Configura el objeto quality para la prueba
	setupEscene1();

	// Carga el objeto personFile1
	qualityFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.QUALITY_FILE);

	// Guarda el objeto persona en el archivo
	qualityFile1.put(quality1);
	qualityFile1.persist();

	// Carga de nuevo el objeto quality1
	qualityFile1 = null;
	qualityFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.QUALITY_FILE);

	// Busca el código del sujeto creado en el archivo
	String codeToFind = qualityFile1.getProperty("etapaprueba1");
	codeToFind = codeToFind == null ? null : codeToFind.split("]")[0];

	// Confirma la existencia del código en el archivo de propiedades
	assertEquals("El código del plan de calidad es inválido.No se guardó el plan de calidad correctamente.", codeToFind, quality1.getId());

	qualityFile1 = null;
    }
    
    
    /*
     * Verifica la eliminación de un plan de calidad en el archivo de propiedades
     * Objetivo: Eliminar un plan de calidad en el archivo de propiedades y verificarlo
     * Resultados esperados: Al cargar el plan de calidad desde el archivo, el resultado
     * debe ser vacio
     */
    @LocList({ @Loc(cycle = Constants.CYCLE_3, size = 14, responsible = "201110544") })
    public void testPersonRemove() {
	// Configura el objeto persona para la prueba
	setupEscene1();

	// Carga el objeto personFile1
	qualityFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.QUALITY_FILE);

	// Guarda el objeto quality2 en el archivo, objeto q será eliminado
	qualityFile1.put(quality2);
	qualityFile1.persist();

	// Carga de nuevo el objeto qualityFile1
	qualityFile1 = null;
	qualityFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.QUALITY_FILE);

	// elimina el objeto del archivo
	qualityFile1.remove(quality2);
	qualityFile1.persist();

	// Carga de nuevo el objeto personFile1
	qualityFile1 = null;
	qualityFile1 = ManagePropertyFile.getInstance(ManagePropertyFile.QUALITY_FILE);

	String codeToFind = qualityFile1.getProperty("etapaprueba2");
	codeToFind = codeToFind == null ? null : codeToFind.split("]")[0];

	// Confirma la existencia del código en el archivo de propiedades
	assertEquals("No se eliminó el registro", codeToFind, null);

	qualityFile1 = null;
    }
}
