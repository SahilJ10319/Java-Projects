package ca.cmpt213.as2;

import com.google.gson.*;
import java.io.*;
import java.util.ArrayList;

/**
 * This read JSON data and stored it into array list of type Tokimon
 * This class perform rescursive file read function and some other
 * utilities function
 */
public class JSONReader {

    static int teamCounter = 1;

    public void ReadJsonFile(File file, ArrayList<Tokimon> tokimon_information) throws FileNotFoundException {
        Tokimon tempTokimon = new Tokimon();
        JsonParser parser = new JsonParser();
        JsonObject obj = (JsonObject) parser.parse(new FileReader(file));
        JsonArray arr = (JsonArray) obj.get("team");
        String extra_comments = obj.get("extra_comments").getAsString();
        int count = 0;
        String teamLead = "";
        String teamName = "";
        tempTokimon.teamName = "";
        for (Object toki : arr) {
            tempTokimon = new Tokimon();
            tempTokimon.extra_comments = extra_comments;

            JsonObject tokimon = (JsonObject) toki;
            tempTokimon.name = tokimon.get("name").getAsString();
            if (count == 0) {
                tempTokimon.from = tokimon.get("id").getAsString();
                tempTokimon.teamLead = tokimon.get("id").getAsString();
                teamLead = tempTokimon.teamLead;
                tempTokimon.to = "-";
                {
                    tempTokimon.teamName = checkTeamNameExistance(tokimon_information, tempTokimon.from);
                    teamName = tempTokimon.teamName;
                }

            } else {
                tempTokimon.from = teamLead;
                tempTokimon.to = tokimon.get("id").getAsString();
                tempTokimon.extra_comments = "";
                tempTokimon.teamName = teamName;
                 tempTokimon.teamLead=teamLead;
            }
            JsonObject compatibility = (JsonObject) tokimon.get("compatibility");
            tempTokimon.score = compatibility.get("score").getAsString();
            if (Double.parseDouble(tempTokimon.score) < 0) {
                System.out.println("Score Should be greater than 0");
                System.exit(0);
            }
            tempTokimon.comment = compatibility.get("comment").getAsString();
            tokimon_information.add(tempTokimon);
            count++;
        }
        this.checkTeamAndNameDifference(tokimon_information);
    }

    public String checkTeamNameExistance(ArrayList<Tokimon> tokimon_information, String from) {
        for (Tokimon dat : tokimon_information) {
            if (from.compareTo(dat.getTo()) == 0) {
                return dat.getTeamName();
            }
        }
        return "Team " + (teamCounter++);
    }

    public void checkTeamAndNameDifference(ArrayList<Tokimon> tokimon_information) {
        for (Tokimon dat : tokimon_information) {
            for (Tokimon dat1 : tokimon_information) {
                if (dat.getFrom().compareTo(dat.getFrom()) == 0) {
                    if (dat1.getTeamName().compareTo(dat1.getTeamName()) != 0) {
                        System.out.println("Team Name Should be same");
                        System.exit(0);
                    }
                    if (dat1.getName().compareTo(dat1.getName()) != 0) {
                        System.out.println("Name Should be same");
                        System.exit(0);
                    }

                }
            }
        }
    }

    public File findJsonRecursively(File file, ArrayList<File> jsonFiles) {
        if (file.isDirectory()) {
            File[] newFiles = file.listFiles();
            for (File test : newFiles) {
                File found = findJsonRecursively(test, jsonFiles);
                if (test.getAbsolutePath().toLowerCase().endsWith("json")) {
                    jsonFiles.add(found);
                    return found;
                }
            }
        } else {
            if (file.getAbsolutePath().toLowerCase().endsWith("json")) {
                return file;
            }
        }
        return null;
    }
}
