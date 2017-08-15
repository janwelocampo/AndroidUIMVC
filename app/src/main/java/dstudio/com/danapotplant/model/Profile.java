
package dstudio.com.danapotplant.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Profile {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("files")
    @Expose
    private Object files;
    @SerializedName("attachments")
    @Expose
    private Object attachments;
    @SerializedName("bidperiod")
    @Expose
    private Integer bidperiod;
    @SerializedName("skills")
    @Expose
    private List<Skill> skills = null;
    @SerializedName("exams")
    @Expose
    private List<Exam> exams = null;
    @SerializedName("avatar")
    @Expose
    private String avatar;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Object getFiles() {
        return files;
    }

    public void setFiles(Object files) {
        this.files = files;
    }

    public Object getAttachments() {
        return attachments;
    }

    public void setAttachments(Object attachments) {
        this.attachments = attachments;
    }

    public Integer getBidperiod() {
        return bidperiod;
    }

    public void setBidperiod(Integer bidperiod) {
        this.bidperiod = bidperiod;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Exam> getExams() {
        return exams;
    }

    public void setExams(List<Exam> exams) {
        this.exams = exams;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

}
