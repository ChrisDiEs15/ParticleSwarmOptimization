/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psobasico; // Paquete donde se encuentra la clase

import net.sourceforge.jswarm_pso.Particle; // Importa la clase Particle de la librería jSwarm PSO

/**
 * Clase que representa una partícula en el algoritmo de optimización por enjambre de partículas (PSO).
 * Esta clase extiende la clase Particle de jSwarm PSO.
 */
public class ParticulaMuestra extends Particle {
    
    /**
     * Constructor de la clase ParticulaMuestra.
     * Inicializa una partícula con un número específico de dimensiones.
     */
    public ParticulaMuestra() {
        // Número de dimensiones en la función que se va a optimizar
        super(4); // Llama al constructor de la clase padre (Particle) con 4 dimensiones
    }
}
