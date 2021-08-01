package Design_pattern;

public class Singleton {
    //1.线程不安全的懒汉式
//    private static Singleton instance;
//    private Singleton(){}
//    public static Singleton getInstance(){
//        if(instance==null){
//            instance=new Singleton();
//        }
//        return instance;
//    }

    //2.线程安全的懒汉式
//    private static Singleton instance;
//    private Singleton(){}
//
//    public static synchronized Singleton getInstance() {
//        if(instance==null){
//            instance=new Singleton();
//        }
//        return instance;
//    }

    //3.饿汉式
//    private static Singleton instance=new Singleton();
//    private Singleton(){};
//
//    public static Singleton getInstance() {
//        return instance;
//    }

    //4.双重校验锁
    private static volatile Singleton instance;
    private Singleton(){}
    public static Singleton getInstance(){
        if(instance==null){
            synchronized (Singleton.class){
                if(instance==null){
                    instance=new Singleton();
                }
            }
        }
        return instance;
    }
}
