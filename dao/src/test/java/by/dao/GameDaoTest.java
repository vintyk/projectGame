package by.dao;

import by.ecp.db.*;
import by.ecp.entity.*;
import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.hasSize;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

/**
 * Created by User on 16.06.2017.
 */
public class GameDaoTest
{
@Test
    public void saveByExistPlatformsTest(){
    CompanyDao companyDao = new CompanyDao();
    GenreDao genreDao = new GenreDao();
    PaymentModelDao paymentModelDao = new PaymentModelDao();
    SettingDao settingDao = new SettingDao();
    StageDao stageDao = new StageDao();
    PlatformDao platformDao = new PlatformDao();
    GameDao gameDao = new GameDao();

    Company company = new Company();
    company.setNameCompany("Valve");
    companyDao.save(company);
    Genre genre = new Genre();
    genre.setName("Гонки");
    genreDao.save(genre);
    PaymentModel paymentModel = new PaymentModel();
    paymentModel.setName("Подписка");
    paymentModelDao.save(paymentModel);
    Setting setting = new Setting();
    setting.setName("Фэнтези");
    settingDao.save(setting);
    Stage stage = new Stage();
    stage.setName("Ранний доступ");
    stageDao.save(stage);

    Platform platform1 = new Platform();
    platform1.setName("X-Box");
    platformDao.save(platform1);
    Platform platform2 = new Platform();
    platform2.setName("PC");
    platformDao.save(platform2);
    Set<Long> platformLongs = new HashSet<>();
    platformLongs.add(1L);
    platformLongs.add(2L);

    gameDao.saveGameToExistingPlatform(
            "Новая офигенная Игра",
            1L,
            1L,
            1L,
            1L,
            1L,
            platformLongs);
    gameDao.saveGame("Вторая офигенная Игра кросс-платформенная",
            1L,
            1L,
            1L,
            1L,
            1L);
    List<Game> result = gameDao.getGameList();
    System.out.println(result);
    assertNotNull(result);
    assertThat(result, hasSize(2));

    }

}

