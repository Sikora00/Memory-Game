package Repositories;

import Entities.Ranking;
import Exceptions.RankingStorageNotFoundException;
import Interfaces.Serializable;
import Services.ExceptionHandler;
import Services.RankingService;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RankingRepository {
    public static Ranking getRanking() {
        File storage = ResourceRepository.getRankingStorage();
        if (storage.length() == 0) {
            RankingService.replaceOldRanking(new Ranking());
            return getRanking();
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
