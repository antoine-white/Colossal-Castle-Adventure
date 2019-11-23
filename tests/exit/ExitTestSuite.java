package exit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({exit.DoorIT.class,
    exit.DoorKeyIT.class,
    exit.ExitIT.class,
    exit.LockedDoorIT.class,
    exit.LockedWindowIT.class,
    exit.OneWayDoorIT.class,
    exit.OneWayLockedDoorIT.class,
    exit.SecretExitIT.class,
    exit.StairsIT.class,
    exit.WindowIT.class})
public class ExitTestSuite {

}
