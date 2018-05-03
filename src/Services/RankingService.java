package Services;

import Configs.Paths;
import Entities.Ranking;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class RankingService {
    private static File storage = new File(Paths.PATH_TO_ROOT_AFTER_BUILD + "storage/ranking.txt");

    public static void replaceOldRanking(Ranking ranking) throws IOException {
        String output = ranking.serialize();
        FileWriter fw = new FileWriter(storage);
        fw.write(output);
        fw.close();
    }
}
