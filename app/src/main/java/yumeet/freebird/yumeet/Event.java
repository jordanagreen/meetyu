package yumeet.freebird.yumeet;

/**
 * Created by Jordan on 5/8/2016.
 */
public class Event {

    private String title;
    private String description;
    private String location;
    private int peopleNeeded;
    private int peopleHave;
    private String startTime;
    private String endTime;

    Event(String name, String description, String location, int peopleNeeded, int peopleHave,
          String startTime){
        this.title = name;
        this.description = description;
        this.location = location;
        this.peopleNeeded = peopleNeeded;
        this.peopleHave = peopleHave;
        this.startTime = startTime;
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

    public String getStartTime() {
        return startTime;
    }

    public String getEndTime() {
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
