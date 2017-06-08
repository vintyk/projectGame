package by.ecp.db;

/**
 * Created by User on 07.06.2017.
 */
public class GamePlatformDao {
    private static final Object LOCK = new Object();
    private static GamePlatformDao INSTANCE = null;

    public static GamePlatformDao getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new GamePlatformDao();
                }
            }
        }
        return INSTANCE;
    }
}
