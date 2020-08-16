package edu.escuelaing.arep;

import com.google.gson.Gson;
import edu.escuelaing.arep.Statistics.StatisticsModule;
import edu.escuelaing.arep.utilities.LinkedList;

import static spark.Spark.*;

public class SparkWebApp {

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
    static int getPort() {
        if (System.getenv("PORT") != null) {
            return Integer.parseInt(System.getenv("PORT"));
        }
        return 4567;
    }
}
