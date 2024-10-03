/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package psobasico;
import net.sourceforge.jswarm_pso.FitnessFunction;
/**
 *
 * @author Chris
 */
public class FuncionAptitud extends FitnessFunction {
    @Override
    public double evaluate(double[]x){
    //Funcion a maximizar
    double z=1200*x[0]+1400*x[1];
    //Resticciones
    boolean r1=(x[0]+2*x[1]<=800);
    boolean r2=(2*x[0]+x[1]<=800);
    boolean r3=(x[0]+x[1]<=500);
    boolean r4=(x[0]>=0 && x[1]>=0);
    //Si se cumple con las condiciones
    if(r1&&r2&&r3&&r4){
    return z;
    }else{
    return Double.NEGATIVE_INFINITY;
    }
    }
    
}
