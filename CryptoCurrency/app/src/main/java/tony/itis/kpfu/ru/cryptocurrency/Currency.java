package tony.itis.kpfu.ru.cryptocurrency;

/**
 * Created by Bulat Murtazin on 24.12.2017.
 * KPFU ITIS 11-601
 */

public class Currency {

    private String name;

    private String value;

    private String picUrl;

    public Currency(String name, String value) {
        this.name = name;
        this.value = value;
        this.picUrl = "https://news.bitcoin.com/wp-content/uploads/2016/06/standard_coin_full_color_M.png";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getPicUrl() {
        return picUrl;
    }

    public void setPicUrl(String picUrl) {
        this.picUrl = picUrl;
    }
}
