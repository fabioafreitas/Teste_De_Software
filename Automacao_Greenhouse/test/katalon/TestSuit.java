package katalon;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({
        GH3.class,  GH4.class,  GH6.class,  GH13.class,
        GH15.class, GH16.class, GH20.class, GH23.class,
        GH24.class, GH27.class, GH38.class, GH41.class
                })
public class TestSuit {

}
