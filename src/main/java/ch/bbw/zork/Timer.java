package ch.bbw.zork;

public class Timer {

    private long starttime;
    private long endtime;

    public String caluculateTime() {
        String time = Long.toString(this.endtime - this.starttime);
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
