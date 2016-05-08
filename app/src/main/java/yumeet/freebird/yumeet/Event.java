package yumeet.freebird.yumeet;

import java.util.Date;

/**
 * Created by Jordan on 5/8/2016.
 */
public class Event {

    private String title;
    private String description;
    private String location;
    private int peopleNeeded;
    private int peopleHave;
    private Date startTime;
    private Date endTime;

    Event(String name, String description, String location, int peopleNeeded, int peopleHave){
        this.title = name;
        this.description = description;
        this.location = location;
        this.peopleNeeded = peopleNeeded;
        this.peopleHave = peopleHave;
//        this.startTime = startTime;
//        this.endTime = endTime;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getLocation() {
        return location;
    }

    public int getPeopleNeeded(){
        return peopleNeeded;
    }

    public int getPeopleHave(){
        return  peopleHave;
    }

    public Date getStartTime() {
        return startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public String toString(){
        return title;
    }

    void joinEvent(){
        if (peopleHave < peopleNeeded){
            peopleHave++;
        }
    }
}
