package edu.escuelaing.arep;

import com.google.gson.Gson;
import edu.escuelaing.arep.Statistics.StatisticsModule;
import edu.escuelaing.arep.utilities.LinkedList;

import static spark.Spark.*;

public class SparkWebApp {
    /**
     *  Función encargada de inicializar la aplicación, contiene la implementación de dos endpoints usando el micro
     *  framework Spark, los endpoints mencionados son "Get /" que se encarga de retornar el archivo index.html con la
     *  interfaz gráfica de la aplicación y "Post /calcular" que calcula la media y la desviación estándar a partir
     *  de un conjunto de datos recibido
     * @param args args
     */
    public static void main(String[] args) {
        port(getPort());
        staticFileLocation("/public");

        get("/", (req, res) -> {
            res.redirect("index.html");
            return null;
        });
        post("/calcular",(request, response) -> {
            response.status(200);
            response.type("application/json");
            LinkedList<Double> values= StatisticsModule.buildList(request.body().split(","));
            double media=StatisticsModule.mean(values);
            double std= StatisticsModule.standardDeviation(values);
            return new Gson().toJson("{\"media\": \""+media+"\", \"std\": \""+std+"\"}") ;
        });
    }

    /**
     *
     * @return Retorna el puerto indicado por el entorno, en caso de no encontrarlo retorna el puerto 4567 por defecto
     */
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
