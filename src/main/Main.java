
import storage.*;

public class Main {

    public static void main(String[] args) {
        Storage s = new LockableTrunk();
        System.out.println(s.getCAPACITY());
    }

}