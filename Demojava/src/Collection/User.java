package Collection;



public class User implements Comparable<User> {
    private String name;
    private Integer age;
    private String addres;

    public User() {
    }

    public User(String name, Integer age, String addres) {
        this.name = name;
        this.age = age;
        this.addres = addres;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    //    @Override
//    public boolean equals(Object obj) {
//        if (this == obj) return true;
//        if (obj == null || getClass() != obj.getClass()) return false;
//        User1 user1 = (User1) obj;
//        return id == user1.id && name.equals(user1.name) && age == user1.age;
//    }
//
//    @Override
//    public int hashCode() {
//        return java.util.Objects.hash(id, name, age);
//    }

    @Override
    public int compareTo(User other) {
        return Integer.compare(this.age, other.age);
    }
//this.name.compareTo(other.name)
    @Override
    public String toString() {
        return "User///" +
                "name='" + name + '\'' +
                "/ age=" + age +
                "/ addres='" + addres + '\'' +
                '/';
    }
}
