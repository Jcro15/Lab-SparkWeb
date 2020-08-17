package edu.escuelaing.arep.Statistics;

import edu.escuelaing.arep.utilities.LinkedList;

/**
 * Modulo de estadisticas que provee el calculo de algunas funciones estadisticas fundamentales como la media
 * y la desviacion estandar
 */
public class StatisticsModule {
    /**
     * Calcula la media de un conjunto de valores almacenado en una LinkedList
     * @param linkedList la lista que almacena los valores
     * @return la media de los valores almacenados en la lista redondeado a 2 decimales
     */
    public static Double mean(LinkedList<Double> linkedList){
        Double sum=0.0;
        for (Double i: linkedList) {
            sum+=i;
        }
        double mean=sum/ linkedList.size();
        mean= Math.round(mean * 100.0) / 100.0;

        return mean ;
    }

    /**
     * Calcula la desviación estándar de un conjunto de valores almacenado en una LinkedList
     * @param linkedList la lista que almacena los valores
     * @return la desviación estándar de los valores almacenados en la lista redondeado a 2 decimales
     */
    public static Double standardDeviation(LinkedList<Double>linkedList){
        double sum=0.0;
        double mean=mean(linkedList);
        for (Double i:linkedList) {
            sum+=Math.pow(i-mean,2);
        }
        double standardDeviation=Math.sqrt(sum/(linkedList.size()-1));
        standardDeviation=Math.round(standardDeviation * 100.0) / 100.0;
        return standardDeviation ;
    }

    /**
     * Construye una linked list a partir de un arreglo de caracteres que representan números reales
     * @param values una lista de caracteres que representan números reales
     * @return una linkedlist de doubles correspondientes a los caracteres de entrada
     */
    public static LinkedList<Double> buildList(String[] values){
        LinkedList<Double> linkedList=new LinkedList<>();
        for(int i=0;i< values.length;i++){
            linkedList.add(Double.parseDouble(values[i]));
        }
        return linkedList;
    }
}
