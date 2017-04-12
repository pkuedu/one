package beans;

import java.util.Set;

/**
 * Created by user on 17-4-1.
 */
public class Country {
    private Integer cid;
    private String cname;
    private Set<Minister> ministers;

    public Country() {
        super();
    }

    public Country(String cname) {
        this.cname = cname;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public Set<Minister> getMinisters() {
        return ministers;
    }

    public void setMinisters(Set<Minister> ministers) {
        this.ministers = ministers;
    }

    @Override
    public String toString() {
        return "Country{" +
                "cid=" + cid +
                ", cname='" + cname + '\'' +
                ", ministers=" + ministers +
                '}';
    }
}
