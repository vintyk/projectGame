package by.ecp.services;

import by.ecp.entity.Game;
import by.ecp.entity.Platform;

import java.util.Set;

/**
 * Created by Vinty on 07.07.2017.
 */
public interface GameService {

    void saveGameToExistingPlatform(String nameGame,
              Long company,
              Long genre,
              Long paymentModel,
              Long setting,
              Long stage,
              Set<Long> platformId
              );
}
