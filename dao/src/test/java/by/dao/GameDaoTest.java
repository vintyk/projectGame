package by.dao;

import by.ecp.db.*;
import by.ecp.entity.*;
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
    CompanyDaoImpl companyDao = new CompanyDaoImpl();
    GenreDaoImpl genreDao = new GenreDaoImpl();
    PaymentModelDaoImpl paymentModelDao = new PaymentModelDaoImpl();
    SettingDaoImpl settingDao = new SettingDaoImpl();
    StageDaoImpl stageDao = new StageDaoImpl();
    PlatformDaoImpl platformDao = new PlatformDaoImpl();
    GameDaoImpl gameDao = new GameDaoImpl();

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

