package mccool.michelle.weather.models;

public class Clouds {
    private Integer all;

    public Clouds() {
    }

    public Clouds(Integer all) {
        this.all = all;
    }

    public Integer getAll() {
        return all;
    }

    public void setAll(Integer all) {
        this.all = all;
    }

    @Override
    public String toString() {
        return "Clouds{" +
                "all=" + all +
                '}';
    }
}
