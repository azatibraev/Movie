package Ultimate.models;

import java.util.Comparator;
import java.util.Objects;

public class Director implements Comparator<Director> {

    private String fullName;

    public  String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }


    @Override
    public int compare(Director o1, Director o2) {
        return o1.fullName.compareTo(o2.fullName);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Director director = (Director) o;
        return Objects.equals(fullName, director.fullName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(fullName);
    }

    @Override
    public String toString() {
        return "Director{" +
                "fullName='" + fullName + '\'' +
                '}';
    }

}
