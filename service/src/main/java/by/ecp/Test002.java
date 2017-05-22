package by.ecp;

/**
 * Created by Vinty on 19.05.2017.
 */
public class Test002 {
    private static final Object LOCK = new Object();
    private static Test002 INSTANCE = null;

    public static Test002 getInstance() {
        if (INSTANCE == null) {
            synchronized (LOCK) {
                if (INSTANCE == null) {
                    INSTANCE = new Test002();
                }
            }
        }
        return INSTANCE;
    }

  public Test001 getNameTest(String name){
      return new Test001(name);
  }
}