package ch.bbw.zork;

public class Timer {

    private long starttime;
    private long endtime;

    public String caluculateTime() {
        long checkVar = (endtime - starttime) / 1000;
        int h = (int) checkVar / 3600;
        int m = (int) (checkVar / 60) % 60;
        int s = (int) (checkVar % 60);

        String time = String.format("%02d:%02d:%02d", h, m, s);

        return time;
    }

    public long getStarttime() {
        return starttime;
    }

    public void setStarttime(long starttime) {
        this.starttime = starttime;
    }

    public long getEndtime() {
        return endtime;
    }

    public void setEndtime(long endtime) {
        this.endtime = endtime;
    }

}
