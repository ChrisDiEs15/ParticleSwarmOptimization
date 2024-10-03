/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package psobasico;

import net.sourceforge.jswarm_pso.Swarm;

/**
 *
 * @author Chris
 */
public class PSOBasico {

    public PSOBasico() {
        //disminuye las generaciones aumentan el numero de corridas
        int corridas = 25000;
        final int nParticulas = 20;
        final int nGeneraciones = 100;
        double valMaximo[] = {900, 900};
        double valMinimo[] = new double[]{-1, -1};
        double mejorPunto[] = null;

        System.out.println("====Particle Swarm Optimization====");
        System.out.println("Maximizar la funcion z=1200x+1400y");
        System.out.print("\nNumero de particulas " + nParticulas);
        //Inicializacion
        for (int i = 0; i < valMinimo.length; i++) {
            System.out.printf("\nrango %d, [%f, %f]", i, valMinimo[i], valMaximo[i]);
        }
        //encabezado
        System.out.println("\n\nRun Aptitud[mejor]   MejorParticula");
        System.out.println("----- ----------- ----------");
        //Crea el cumulo de particulas
        ParticulaMuestra muestra = new ParticulaMuestra();
        FuncionAptitud funcion = new FuncionAptitud();
        Swarm swarm = new Swarm(nParticulas, muestra, funcion);
        swarm.getFitnessFunction().setMaximize(true);
        swarm.setMaxPosition(valMaximo);
        swarm.setMinPosition(valMinimo);
        //
        for (int nCorrida = 1; nCorrida < corridas; nCorrida++) {
            swarm.evolve();
            double mejorAptitud = swarm.getBestFitness();
            double mejorPosicion[] = swarm.getBestPosition();
            System.out.printf("\n%3d %4.3f", nCorrida, mejorAptitud);
            //
            for (double d : mejorPosicion) {
                System.out.printf("%3.3f", d);
            }
        }
    }

    public static void main(String[] args) {
        PSOBasico basico = new PSOBasico();
    }

}
