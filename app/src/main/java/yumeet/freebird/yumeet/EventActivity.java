package yumeet.freebird.yumeet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class EventActivity extends AppCompatActivity {

//    private TextView titleText;
    private TextView descText;
    private TextView locationText;
    private TextView startText;
    private TextView peopleText;
    private TextView currentPeopleText;

//    private int eventId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Intent intent = getIntent();


//        titleText = (TextView) findViewById(R.id.eventTitle);
        descText = (TextView) findViewById(R.id.eventDescription);
        locationText = (TextView) findViewById(R.id.eventLocation);
        startText = (TextView) findViewById(R.id.eventStartTime);
        peopleText = (TextView) findViewById(R.id.eventPeopleNeeded);
        currentPeopleText = (TextView) findViewById(R.id.eventCurrentPeople);

        int eventId = intent.getIntExtra(EventFragmentList.EVENT_ID_KEY, 0);

        Event event = EventManager.getManager().getEvent(eventId);
        setEventText(event);

//        TextView titleTextView = (TextView) findViewById(R.id.eventTitle);
//        Event event = EventManager.getManager().getEvent(eventId);
//        titleTextView.setText(event.getDescription());
    }

    private void setEventText(Event event){
        setTitle(event.getTitle());
//        titleText.setText(event.getTitle());
        descText.setText(event.getDescription());
        locationText.setText(event.getLocation());

    }



}
