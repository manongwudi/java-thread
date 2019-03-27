package cn.wudimanong.thread.join;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author Joe
 */
public class FightQueryExample {

    //合作的各大航空公司
    public static List<String> fightCompany = Arrays.asList("CSA", "CEA", "HNA");

    public static void main(String[] args) {
        List<String> results = search("SH", "BJ");
        System.out.println("###########result###########");
        results.forEach(System.out::println);
    }

    private static List<String> search(String original, String dest) {
        final List<String> result = new ArrayList<>();
        //创建查询航班信息的线程列表
        List<FightQueryTask> tasks = fightCompany.stream().map(f -> creatSearchTask(f, original, dest))
                .collect(Collectors.toList());
        tasks.forEach(Thread::start);
        tasks.forEach(t -> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        //在此之前，当前线程会阻塞住，获取每一个查询线程的结果，并且加入到result中
        tasks.stream().map(FightQuery::get).forEach(result::addAll);
        return result;
    }

    private static FightQueryTask creatSearchTask(String fight, String original, String dest) {
        return new FightQueryTask(fight, original, dest);
    }
}
