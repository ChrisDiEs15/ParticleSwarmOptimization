/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psobasico; // Paquete donde se encuentra la clase

import net.sourceforge.jswarm_pso.Swarm; // Importa la clase Swarm de la librería jSwarm PSO

/**
 * Clase principal para ejecutar el algoritmo de optimización por enjambre de partículas (PSO).
 */
public class PSOBasico {

    /**
     * Constructor de la clase PSOBasico que inicializa y ejecuta el algoritmo PSO.
     */
    public PSOBasico() {
        // Número de corridas del algoritmo
        int corridas = 5000; // Disminuir las generaciones aumenta el número de corridas
        final int nParticulas = 20; // Número de partículas en el enjambre
        final int nGeneraciones = 100; // Número de generaciones (no utilizado en el algoritmo)
        
        // Rangos máximo y mínimo para las variables de la función
        double valMaximo[] = {50, 50, 30, 20}; // Valores máximos para las variables
        double valMinimo[] = new double[]{0, 0, 0, 0}; // Valores mínimos para las variables
        double mejorPunto[] = null; // Variable para almacenar el mejor punto (no utilizada)

        // Mensaje de inicio
        System.out.println("====Particle Swarm Optimization====");
        System.out.println("Maximizar la funcion z=6x+5y+3z+7w");
        System.out.print("\nNumero de particulas " + nParticulas);
        
        // Inicialización de los rangos
        for (int i = 0; i < valMinimo.length; i++) {
            System.out.printf("\nrango %d, [%f, %f]", i, valMinimo[i], valMaximo[i]); // Imprime los rangos
        }
        
        // Encabezado para los resultados
        System.out.println("\n\nRun Aptitud[mejor]   MejorParticula");
        System.out.println("----- ----------- ----------");
        
        // Crea una instancia de ParticulaMuestra y FuncionAptitud
        ParticulaMuestra muestra = new ParticulaMuestra(); // Partícula de ejemplo
        FuncionAptitud funcion = new FuncionAptitud(); // Función de aptitud para maximizar
        
        // Crea el enjambre con las partículas y la función de aptitud
        Swarm swarm = new Swarm(nParticulas, muestra, funcion);
        
        // Configura el enjambre para maximizar la función de aptitud
        swarm.getFitnessFunction().setMaximize(true);
        swarm.setMaxPosition(valMaximo); // Establece los límites superiores
        swarm.setMinPosition(valMinimo); // Establece los límites inferiores
        
        // Bucle principal para ejecutar el algoritmo
        for (int nCorrida = 1; nCorrida < corridas; nCorrida++) {
            swarm.evolve(); // Evoluciona el enjambre
            
            // Obtiene la mejor aptitud y posición
            double mejorAptitud = swarm.getBestFitness(); // Mejor aptitud encontrada
            double mejorPosicion[] = swarm.getBestPosition(); // Mejor posición encontrada
            
            // Imprime el resultado de la corrida actual
            System.out.printf("\n%3d %4.3f", nCorrida, mejorAptitud);
            
            // Imprime la mejor posición encontrada
            for (double d : mejorPosicion) {
                System.out.printf("%3.3f", d); // Imprime cada dimensión de la mejor posición
            }
        }
    }

    /**
     * Método principal para ejecutar la clase PSOBasico.
     * 
     * @param args Argumentos de la línea de comandos (no utilizados).
     */
    public static void main(String[] args) {
        PSOBasico basico = new PSOBasico(); // Crea una instancia de PSOBasico para ejecutar el algoritmo
    }
}
