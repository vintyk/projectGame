package by.dao;

import by.ecp.db.*;
import by.ecp.entity.*;
import org.junit.Test;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Created by Vinty on 18.06.2017.
 */
public class PublicationDaoTest {
    @Test
    public void findAllOrderDateDescTest(){

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
        gameDao.saveGameToExistingPlatform(
                "Третья офигенная Игра",
                1L,
                1L,
                1L,
                1L,
                1L,
                platformLongs);
        List<Game> result = gameDao.getGameList();
        System.out.println(result);

        PublicationDao publicationDao = new PublicationDao();
        LocalDate localDate1 = LocalDate.now();
        publicationDao.savePublication(
                "Состоялся софт-запуск Star Wars",
                "На Android и iOS пробно запущена новая мобильная " +
                        "игра по известной вселенной «Звездных войн». ",
                1L,
                localDate1);


        LocalDate localDate2 = LocalDate.now();
        publicationDao.savePublication(
                "Фанаты полностью перевели дополнение Morrowind",
                "Тем, кто уже давно играет в MMORPG The Elder Scrolls Online известно, " +
                        "что существует частичная локализация от фанатов. Проект называется RuESO.",
                2L,
                localDate2);

        List<Publication> result2 = publicationDao.findAllOrderDateDesc();
        System.out.println(result2);
        assertNotNull(result2);
    }
}
