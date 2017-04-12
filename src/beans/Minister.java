package beans;

/**
 * Created by user on 17-4-1.
 */
public class Minister {
    private Integer mid;
    private String mname;
    private Country country;

    public Minister() {
        super();
    }

    public Minister(String mname) {
        this.mname = mname;
    }

    public Integer getMid() {
        return mid;
    }

    public void setMid(Integer mid) {
        this.mid = mid;
    }

    public String getMname() {
        return mname;
    }

    public void setMname(String mname) {
        this.mname = mname;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Override
    public String toString() {
        return "Minister{" +
                "mid=" + mid +
                ", mname='" + mname + '\'' +
                '}';
    }
}
