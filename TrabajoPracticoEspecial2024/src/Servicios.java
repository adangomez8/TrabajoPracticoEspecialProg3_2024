package ProgramacionIII.tpe;

import ProgramacionIII.tpe.utils.CSVReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * NO modificar la interfaz de esta clase ni sus métodos públicos.
 * Sólo se podrá adaptar el nombre de la clase "Tarea" según sus decisiones
 * de implementación.
 */
public class Servicios {

	private Map<String, Tarea> tareas;
	private Map<String, Procesador> procesadores;


	/*
     * Expresar la complejidad temporal del constructor.
     *
     * La complejidad computacional del constructor es de O(n+m), ya que debe recorrer cada linea
     * de los archivos de tareas y procesadores.
     */
	public Servicios(String pathProcesadores, String pathTareas)
	{
		this.tareas = new HashMap<>();
		this.procesadores = new HashMap<>();

		CSVReader reader = new CSVReader();
		reader.readProcessors(pathProcesadores, procesadores);
		reader.readTasks(pathTareas, tareas);
	}
	
	/*
     * Expresar la complejidad temporal del servicio 1.
     *
     * La complejidad computacional del servicio 1 es de O(1). Ya que al utilizar HashMap al buscar las tareas con el id,
     * el cual la clave de cada tarea es una complejidad constante.
     */
	public Tarea servicio1(String ID) {

		return tareas.get(ID);
	}
    
    /*
     * Expresar la complejidad temporal del servicio 2.
     *
     * La complejidad computacional del servicio 2 es de O(n) ya que para obtener todas las tareas que son críticas es necesario recorrer
     * cada una de todas las tareas.
	 */
	public List<Tarea> servicio2(boolean esCritica) {

		List<Tarea> result = new ArrayList<>();
		for (Tarea tarea : tareas.values()) {
			if (tarea.getEs_critica() == esCritica) {
				result.add(tarea);
			}
		}
		return result;
	}

    /*
     * Expresar la complejidad temporal del servicio 3.
     *
     * Al igual que el servicio anterior la complejidad computacional del servicio 3 es de O(n) ya que para obtener todas las tareas
     * que tengan cierto margen de nivel de prioridad es necesario recorrer cada una de todas las tareas.
     */
	public List<Tarea> servicio3(int prioridadInferior, int prioridadSuperior) {

		List<Tarea> result = new ArrayList<>();
		for (Tarea tarea : tareas.values()) {
			if (tarea.getNivel_prioridad() >= prioridadInferior && tarea.getNivel_prioridad() <= prioridadSuperior) {
				result.add(tarea);
			}
		}
		return result;
	}

}
