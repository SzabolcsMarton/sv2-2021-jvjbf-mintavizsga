package owlcounter;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class OwlCounter {

    private List<String> owlsInCounties;
    private Path path;

    public void readFromFile(Path path) {
        try {
            List<String> owls = Files.readAllLines(path);
            owlsInCounties = owls;
        } catch (IOException ioe) {
            throw new IllegalStateException("Can not read file.", ioe);
        }
    }

    public int getNumberOfOwls(String county) {
        int numberOfOwls = 0;
        int countyCounter = 0;
        for (String actual : owlsInCounties) {
            String[] datas = actual.split("=");
            if (datas[0].equals(county)) {
                numberOfOwls = Integer.parseInt(datas[1]);
                countyCounter++;
            }
        }
        if (countyCounter == 0) {
            throw new IllegalArgumentException("No such county in Hungary!");
        }
        return numberOfOwls;
    }


    public int getNumberOfAllOwls() {
        int sumOfOwls = 0;
        for (String actual : owlsInCounties) {
            String[] datas = actual.split("=");
            int numberOfOwls = Integer.parseInt(datas[1]);
            sumOfOwls += numberOfOwls;
        }
        return sumOfOwls;
    }

}
