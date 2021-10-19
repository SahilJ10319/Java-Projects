package ca.cmpt213.as2;
import com.opencsv.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * This class is responsible for generating csv file 
 * and sorting the data in arraylist
 */
public class CSVCreator {

    public void outputCsv(File file, ArrayList<Tokimon> tokimon_information) throws IOException {

        FileWriter outputFile = new FileWriter(file);
        CSVWriter writer = new CSVWriter(outputFile);
        String[] header = {"Team#", "From Toki", "To Toki", "", "Score", "Comment", "", "Extra"};
        writer.writeNext(header);
        String[] teamName = {"Team 1"};
        writer.writeNext(teamName);
        for (Tokimon s : tokimon_information) {
            if (s.teamName.compareTo(teamName[0]) != 0) {
                teamName[0] = s.teamName;
                writer.writeNext(new String[]{""});
                writer.writeNext(teamName);
            }
            s.setTeamName( "");
            s.setName( "");

            writer.writeNext(s.toArrayString());
        }
        writer.close();
    }

    Comparator<Tokimon> sortByTeamName = new Comparator<Tokimon>() {
        @Override
        public int compare(Tokimon o1, Tokimon o2) {
            int teamSortion = (o1.getTeamName().compareTo(o2.getTeamName()));
            return teamSortion;
        }
    };

    Comparator<Tokimon> sortByTo = new Comparator<Tokimon>() {
        @Override
        public int compare(Tokimon o1, Tokimon o2) {
            int result;
            int fromRes = (o1.getFrom().compareTo(o2.getFrom()));
            int team = (o1.getTeamName().compareTo(o2.getTeamName()));
            if (team == 0) {
                if (fromRes == 0) {

                    if (o1.getTo().compareTo("-") == 0) {
                        result = 1;
                    } else if (o2.getTo().compareTo("-") == 0) {
                        result = -1;
                    } else {
                        result = (o1.getTo().compareTo(o2.getTo()));
                    }

                    return result;
                }
            }
            return 0;
        }
    };

}
