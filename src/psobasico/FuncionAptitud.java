/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psobasico; // Paquete donde se encuentra la clase

import net.sourceforge.jswarm_pso.FitnessFunction; // Importa la clase FitnessFunction de la librería jSwarm PSO

/**
 * Clase que representa una función de aptitud para el algoritmo de optimización por enjambre de partículas (PSO).
 * Extiende la clase FitnessFunction para definir cómo se evalúan las soluciones.
 */
public class FuncionAptitud extends FitnessFunction {
    
    /**
     * Evalúa la aptitud de una solución dada.
     * 
     * @param x Un arreglo de doubles que representa la solución a evaluar.
     * @return El valor de la función de aptitud si las restricciones se cumplen; de lo contrario, devuelve 
     *         Double.NEGATIVE_INFINITY.
     */
    @Override
    public double evaluate(double[] x) {
        // Función a maximizar: z = 6*x[0] + 5*x[1] + 3*x[2] + 7*x[3]
        double z = 6 * x[0] + 5 * x[1] + 3 * x[2] + 7 * x[3];
        
        // Restricciones
        boolean r1 = (x[0] + x[1] + x[3] <= 50); // Restricción 1
        boolean r2 = (2 * x[0] + x[1] + 2 * x[2] + x[3] <= 150); // Restricción 2
        boolean r3 = (x[0] + x[1] + x[2] + 4 * x[3] <= 80); // Restricción 3
        boolean r4 = (x[0] >= 0 && x[1] >= 0 && x[2] >= 0 && x[3] >= 0); // Restricción 4
        
        // Si se cumplen todas las restricciones
        if (r1 && r2 && r3 && r4) {
            return z; // Retorna el valor de la función a maximizar
        } else {
            return Double.NEGATIVE_INFINITY; // Si no se cumplen las restricciones, se penaliza la solución
        }
    }
}

