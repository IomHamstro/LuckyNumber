package viewobject;

/**
 * Created by Ольга on 12.08.2014.
 */
public class UserVO {
    private Long id;
    private String fio;
    private String bdate;
    private Integer first;
    private Integer second;
    private Integer third;

    private Integer luckyNumber;

    public UserVO() {
    }

    public UserVO(String fio, String bdate, Integer first, Integer second, Integer third) {
        this.fio = fio;
        this.bdate = bdate;
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFio() {
        return fio;
    }

    public void setFio(String fio) {
        this.fio = fio;
    }

    public String getBdate() {
        return bdate;
    }

    public void setBdate(String bdate) {
        this.bdate = bdate;
    }

    public Integer getFirst() {
        return first;
    }

    public void setFirst(Integer first) {
        this.first = first;
    }

    public Integer getSecond() {
        return second;
    }

    public void setSecond(Integer second) {
        this.second = second;
    }

    public Integer getThird() {
        return third;
    }

    public void setThird(Integer third) {
        this.third = third;
    }

    public Integer getLuckyNumber() {
        return luckyNumber;
    }

    public void setLuckyNumber(Integer luckyNumber) {
        this.luckyNumber = luckyNumber;
    }

}
