package ca.cmpt213.as2;
import java.util.*;
import java.io.*;

/**
 * This class read data from json files
 * and generate csv depending upon the data
 * in the file for this purpose it use arraylist of tyoe
 * tokimon and saved data in that file from JSONReader and 
 * create csv
 */

public class TokimonProcessor {


    public static void main(String[] args) throws FileNotFoundException,IOException{
        if(args.length != 2){
            System.out.println("Exactly 2 arguments required: \n 1) .json file directory. \n 2)  .csv file  generated path.");
            System.exit(0);
        }

        File input = new File(args[0]);
        File initial_output = new File(args[1]);



        if (!input.isDirectory()){
            System.out.println("The input file path do not exist");
            System.exit(0);
        }
        if(!initial_output.isDirectory()){
            System.out.println("The output directory do not exist");
            System.exit(0);
        }
        File output = new File(initial_output+"/team_info.csv");

        ArrayList<File> allFiles = new ArrayList<File>();

        JSONReader test1 = new JSONReader();
        test1.findJsonRecursively(input,allFiles);
        if (allFiles.size()==0){
            System.out.println("No Json Fil"
                    + "es are found!!");
            System.exit(0);
        }
        ArrayList<Tokimon> tokimon_information = new ArrayList<Tokimon>();
        for(File x : allFiles){
            test1.ReadJsonFile(x,tokimon_information);
        }
        CSVCreator outputCsv = new CSVCreator();
        Collections.sort(tokimon_information,outputCsv.sortByTeamName);
        Collections.sort(tokimon_information,outputCsv.sortByTo);
        outputCsv.outputCsv(output,tokimon_information);
    }
}