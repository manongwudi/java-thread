package cn.wudimanong.thread.join;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;

/**
 * @author Joe
 */
public class FightQueryTask extends Thread implements FightQuery {

    private final String origin;
    private final String destination;
    private final List<String> flightList = new ArrayList<>();

    public FightQueryTask(String airline, String origin, String destination) {
        super("[" + airline + "]");
        this.origin = origin;
        this.destination = destination;
    }

    public void run() {
        System.out.printf("s-query from %s to %s \n", getName(), origin, destination);
        int randomVal1 = ThreadLocalRandom.current().nextInt(10);
        try {
            TimeUnit.SECONDS.sleep(randomVal1);
            this.flightList.add(getName() + "-" + randomVal1);
            System.out.printf("The Fight:%s list query successful\n", getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    @Override
    public List<String> get() {
        return this.flightList;
    }
}
