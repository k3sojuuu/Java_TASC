package Collection;

import java.util.*;

public class SetCollection {
    HashSet<User> users1 = new HashSet<>();
    TreeSet<User> users2 = new TreeSet<>();
     public void addHashSet(User user){
         users1.add(user);
     }

     public void loopHashSet(){
         System.out.println("Danh sách:");
         for (User user:users1) {
             System.out.println(user.toString());
         }
     }

     public void addTreeSet(User user){
         users2.add(user);
     }

    public void loopTreeSet(){
        System.out.println("Danh sách:");
        for (User user:users2) {
            System.out.println(user.toString());
        }
    }

    enum Day {
        MONDAY, TUESDAY, WEDNESDAY, THURSDAY, FRIDAY, SATURDAY, SUNDAY
    }

    public static void main(String[] args) {
        SetCollection setCollection = new SetCollection();
        setCollection.addHashSet(new User("Tan",22,"Ha Noi"));
        setCollection.addHashSet(new User("Dat",23,"Ha Noi"));
        setCollection.addHashSet(new User("Nhung",24,"Ha Noi"));

        setCollection.addTreeSet(new User("Tan",22,"Ha Noi"));
        setCollection.addTreeSet(new User("Dat",24,"Ha Noi"));
        setCollection.addTreeSet(new User("Nhung",21,"Ha Noi"));

        EnumSet<Day> allDays = EnumSet.allOf(Day.class);

        setCollection.loopHashSet();
        setCollection.loopTreeSet();

        System.out.println("Tất cả các ngày: " + allDays);

        EnumSet<Day> workDays = EnumSet.range(Day.MONDAY, Day.FRIDAY);
        System.out.println("Các ngày làm việc: " + workDays);

        if (workDays.contains(Day.SATURDAY)) {
            System.out.println("Thứ Bảy là ngày làm việc.");
        } else {
            System.out.println("Thứ Bảy không phải là ngày làm việc.");
        }
    }
}
