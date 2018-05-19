package Services;

import Entities.Ranking;
import Repositories.ResourceRepository;

import java.io.FileWriter;
import java.io.IOException;

public class RankingService {

    public static void replaceOldRanking(Ranking ranking) {
        try {
            String output = ranking.serialize();
            FileWriter fw = new FileWriter(ResourceRepository.getRankingStorage());
            fw.write(output);
            fw.close();
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }
    }

}
