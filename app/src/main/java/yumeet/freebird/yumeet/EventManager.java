package yumeet.freebird.yumeet;

import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Jordan on 5/8/2016.
 */
public class EventManager {

    private static final String TAG = "EventManager";

    private static EventManager instance;
    private List<Event> events;
    private ArrayAdapter<Event> adapter;

    private Event[] testEvents = {
            new Event("Basketball", "A game of basketball", "Rubin Gym"),
            new Event("Jamming", "Jamming with some friends", "Heights Lounge"),
            new Event("Movie", "Watching a movie", "My dorm room"),
            new Event("Quidditch", "A game of Quidditch", "Central park"),
            new Event("DND", "Dungeons and Dragons", "Parents' basement")
    };

    private EventManager(){
        events = new ArrayList<>();
        events.addAll(Arrays.asList(testEvents));
    }

    void setAdapter(ArrayAdapter<Event> adapter){
        if (this.adapter == null){
            this.adapter = adapter;
        }
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
        return adapter.getItem(i);
    }

    void addEvent(Event event){
        events.add(event);
        adapter.notifyDataSetChanged();
        Log.d(TAG, "Event added");
    }

    Event removeEvent(int i){
        Event event = adapter.getItem(i);
        adapter.remove(event);
        adapter.notifyDataSetChanged();
        return event;
    }

}
