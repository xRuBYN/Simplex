package it.ssc;

import java.util.ArrayList;
import it.ssc.log.SscLogger;
import it.ssc.pl.milp.*;

public class Example {

    public static void main(String[] args) throws Exception {

        ArrayList< String > constraints = new ArrayList< String >();
//        constraints.add("max:  10X1 + 50X2 + 80X3 + 85X4 ");
//        constraints.add("      10X1 + 30X2 <= 3000");
//        constraints.add("      30X2 + 50X3 <= 7000");
//        constraints.add("      50X3 + 55X4 <= 5000");
//        constraints.add("       55X4 <= 2500");

        constraints.add("min: 5X1 + 6X2 + 3X3 + 4X4 ");
        constraints.add("      90X1 + 35X2 + 50X3 + 100X4 >= 400");
        constraints.add("      60X1 + 2X2 + 30X3 + 40X4 >= 850");
        constraints.add("      15X1 + 60X2 + 20X3 + 60X4 >= 600");
        constraints.add("      80X1 + 105X2 + 85X3 + 25X4  >= 400");


        LP lp = new LP(constraints);
        SolutionType solution_type=lp.resolve();

        if(solution_type==SolutionType.OPTIMUM) {
            Solution soluzione=lp.getSolution();
            for(Variable var:soluzione.getVariables()) {
                SscLogger.log("Variable Name :"+var.getName() + " value :"+var.getValue());
            }
            SscLogger.log("Value:"+soluzione.getOptimumValue());
        }
    }
}