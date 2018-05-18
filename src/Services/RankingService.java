package Services;

import Configs.Paths;
import Entities.Ranking;
import Exceptions.RankingStorageNotFoundException;
import Interfaces.Serializable;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RankingService {
    private static File storage = new File(Paths.PATH_TO_ROOT_AFTER_BUILD + "storage/ranking.txt");

    public static void replaceOldRanking(Ranking ranking) {
        try {
            String output = ranking.serialize();
            FileWriter fw = new FileWriter(storage);
            fw.write(output);
            fw.close();
        } catch (IOException e) {
            ExceptionHandler.handle(e);
        }
    }

    public static Ranking readRankingFromStorage() {
        if (storage.length() == 0) {
            RankingService.replaceOldRanking(new Ranking());
            return readRankingFromStorage();
        }
        StringBuilder fileContents = new StringBuilder((int) storage.length());
        Scanner scanner = null;
        try {
            scanner = new Scanner(storage);
        } catch (FileNotFoundException e) {
            ExceptionHandler.handle(new RankingStorageNotFoundException());
        }
        fileContents.append(scanner.nextLine());
        scanner.close();

        return (Ranking) Serializable.deserialize(fileContents.toString());
    }

}
