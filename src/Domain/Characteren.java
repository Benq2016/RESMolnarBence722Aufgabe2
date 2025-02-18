package src.Domain;

import java.util.List;

public class Characteren implements HasName{
    Integer id;
    String name;
    String region;
    List<Produkte> produkteList;

    public Characteren(Integer id, String name, String region, List<Produkte> produkteList) {
        this.id = id;
        this.name = name;
        this.region = region;
        this.produkteList = produkteList;
    }

    @Override
    public String getName() {
        return name;
    }

    public String getRegion() {
        return region;
    }

    public List<Produkte> getProdukteList() {
        return produkteList;
    }

    public String toString() {
        return id + " " + name +  " " + region + " " + produkteList;
    }
}
