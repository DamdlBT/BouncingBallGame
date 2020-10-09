package cegepst.engine;

public class GameTime {

    private static final int SLEEP = 25;
    private long before;

    public static long getCurrenctTime() {
        return System.currentTimeMillis();
    }

    public GameTime() {
        updateSyncTime();

    }
    public void sleep() {
        try {
            Thread.sleep(getSleepTIme());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        updateSyncTime();
    }

    private void updateSyncTime() {
        before = System.currentTimeMillis();
    }

    private long getSleepTIme() {
        long sleep = SLEEP - (System.currentTimeMillis() - before);
        if (sleep < 0) {
            sleep = 4;
        }
        return sleep;
    }
}
