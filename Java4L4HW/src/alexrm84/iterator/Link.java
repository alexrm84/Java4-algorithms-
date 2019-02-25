package alexrm84.iterator;

import java.util.Objects;

public class Link {
    public String name;
    public int age;

    public Link next;

    public Link(String name, int age){
        this.name = name;
        this.age = age;
    }

    public void display(){
        System.out.println("Name: "+this.name+", age: "+this.age);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Link link = (Link) o;
        return age == link.age &&
                Objects.equals(name, link.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, next);
    }
}
