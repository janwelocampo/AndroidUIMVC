package dstudio.com.danapotplant.model;

/**
 * Created by janwelcris on 8/16/2017.
 */

public class AddMore {
    String addMore;
    int id;

    public AddMore(String addMore, int id){
        this.addMore = addMore;
        this.id = id;
    }

    public String getAddMore() {
        return addMore;
    }

    public void setAddMore(String addMore) {
        this.addMore = addMore;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
