package yumeet.freebird.yumeet;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Jordan on 5/8/2016.
 */
public class EventManager {

    private static EventManager instance;
    private List<Event> events;

    private Event[] testEvents = {
            new Event("Basketball", "A game of basketball", "Rubin Gym"),
            new Event("Jamming", "Jamming with some friends", "Heights Lounge"),
            new Event("Movie", "Watching a movie", "My dorm room"),
            new Event("Quidditch", "A game of Quidditch", "Central park"),
            new Event("DND", "Dungeons and Dragons", "Parents' basement")
    };

    private EventManager(){
//        events = new ArrayList<>();
        events = Arrays.asList(testEvents);
    }

    static EventManager getManager(){
        if (instance == null){
            instance = new EventManager();
        }
        return instance;
    }

    List<Event> getEvents(){
        return events;
    }

    Event getEvent(int i){
        return events.get(i);
    }

    void addEvent(Event event){
        events.add(event);
    }

    Event removeEvent(int i){
        return events.remove(i);
    }

}
