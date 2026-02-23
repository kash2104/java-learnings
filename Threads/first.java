import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;


class Runner implements Runnable{
    private String name;
    private int position;
    private LeaderBoard board;
    private Random rand;
    
    public Runner(String s, LeaderBoard b){
        this.name = s;
        this.board = b;
        this.rand = new Random();

        board.updateBoard(name, 0);
    }

    public String getName(){
        return name;
    }

    @Override
    public void run(){
        while(!Thread.currentThread().isInterrupted() && position < board.getFinishLine()){
            try {
                Thread.sleep(rand.nextInt(100)+200);
                
            } catch (InterruptedException e) {
                // TODO: handle exception
                Thread.currentThread().interrupt();
                // e.printStackTrace();
                break;
            }

            position += rand.nextInt(5);
            position = Math.min(position, board.getFinishLine());

            board.updateBoard(name, position);
            board.printBoard();
            System.out.println();
            System.out.println();

        }
    }
}

class LeaderBoard{
    private Map<String, Integer>board;
    private final int finishLine;
    private final ReentrantLock lock;

    public LeaderBoard(int n){
        board = new HashMap<>();
        this.finishLine = n;
        lock = new ReentrantLock();
    }


    public Integer getFinishLine(){
        return finishLine;
    }

    public void updateBoard(String key, Integer value){
        lock.lock();
        try {
            board.put(key, value);
        }finally{
            lock.unlock();
        }
    }

    public void printBoard(){
        lock.lock();
        try{
            board.forEach((key,value) -> System.out.println(key + "=".repeat(value) +" "+ value));

        }finally{
            lock.unlock();
        }
    }
}

class Gunner{
    private List<Thread>runners;
    private Random random = new Random();
    private int range;

    public Gunner(List<Thread>rs){
        this.runners = rs;
        this.range = rs.size();
    }

    public void kill(){
       int index = random.nextInt(range);
       Thread t = runners.get(index);
       if(t.isAlive()){
        System.out.println(t.getName()+" is INJURED");
        System.out.println();
        t.interrupt();
       }
    }
}


public class first{
    public static void main(String[] args) {
        LeaderBoard leaderBoard = new LeaderBoard(20);

        Runner r1 = new Runner("first", leaderBoard);
        Runner r2 = new Runner("second", leaderBoard);
        Runner r3 = new Runner("third", leaderBoard);
        Runner r4 = new Runner("fourth", leaderBoard);


        
        List<Thread>runners = new ArrayList<>();
        runners.add(new Thread(r1, r1.getName()));
        runners.add(new Thread(r2, r2.getName()));
        runners.add(new Thread(r3, r3.getName()));
        runners.add(new Thread(r4, r4.getName()));
        
        Gunner g = new Gunner(runners);

        runners.forEach(r -> r.start());

        try {
           Random random = new Random();
           Thread.sleep(random.nextInt(2000) + 500); 
           g.kill();
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        for (Thread t : runners){
            try {
                t.join();
            } catch (Exception e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }

        System.out.println("completed");
    }
}


