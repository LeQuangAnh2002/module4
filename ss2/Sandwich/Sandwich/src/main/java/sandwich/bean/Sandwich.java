package sandwich.bean;

public class Sandwich {
    private String spice;

    public Sandwich(String spice) {
        this.spice = spice;
    }

    public Sandwich() {
    }

    public String getSpice() {
        return spice;
    }

    public void setSpice(String spice) {
        this.spice = spice;
    }
}
