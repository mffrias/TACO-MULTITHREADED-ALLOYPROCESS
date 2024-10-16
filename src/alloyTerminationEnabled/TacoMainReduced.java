package alloyTerminationEnabled;

import ar.edu.taco.TacoAnalysisResult;
import ar.edu.taco.engine.AlloyStage;
import ar.uba.dc.rfm.dynalloy.analyzer.AlloyAnalysisResult;

import java.io.File;  // Import the File class
import java.io.FileWriter;
import java.io.IOException;  // Import the IOException class to handle errors

public class TacoMainReduced {


    public static void main(String[] args) {
        // Starts dynalloy to alloy tranlation and alloy verification

        String alsFileName = args[0];
//
        AlloyStage alloy_stage = new AlloyStage(alsFileName);
        alloy_stage.execute();


        AlloyAnalysisResult alloy_analysis_result = null;

        alloy_analysis_result = alloy_stage.get_analysis_result();
        /**/
        alloy_stage = null;


        TacoAnalysisResult tacoAnalysisResult = new TacoAnalysisResult(alloy_analysis_result);

        String tacoAnalysisResultString = tacoAnalysisResult.get_alloy_analysis_result().getAlloy_solution().toString();

        File verdictFile;

        if (tacoAnalysisResult.get_alloy_analysis_result().isSAT()) {
            alsFileName = alsFileName.replace("output.als", "verdictSAT.txt");
            verdictFile = new File(alsFileName);
            try {
                if (verdictFile.createNewFile()) {
                    FileWriter myWriter = new FileWriter(alsFileName);
                    myWriter.write("-THE OUTCOME WAS SAT- ");
                    myWriter.write(tacoAnalysisResultString);
                    myWriter.close();
                } else {
                    System.out.println("File already exists.");
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        } else {
            if (tacoAnalysisResult.get_alloy_analysis_result().isUNSAT()) {
                alsFileName = alsFileName.replace("output.als", "verdictUNSAT.txt");
                verdictFile = new File(alsFileName);
                try {
                    if (verdictFile.createNewFile()) {
                        FileWriter myWriter = new FileWriter(alsFileName);
                        myWriter.write("-THE OUTCOME WAS UNSAT-");
                        myWriter.close();
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            } else {
                alsFileName = alsFileName.replace("output.als", "TO.txt");
                verdictFile = new File(alsFileName);
                try {
                    if (verdictFile.createNewFile()) {
                        FileWriter myWriter = new FileWriter(alsFileName);
                        myWriter.write("TO");
                        myWriter.close();
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }

    }
}
