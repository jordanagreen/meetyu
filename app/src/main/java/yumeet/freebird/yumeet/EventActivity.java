package yumeet.freebird.yumeet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class EventActivity extends AppCompatActivity {

//    private TextView titleText;
    private TextView descText;
    private TextView locationText;
    private TextView startText;
    private TextView peopleText;
//    private TextView currentPeopleText;

    private Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Intent intent = getIntent();

        descText = (TextView) findViewById(R.id.eventDescription);
        locationText = (TextView) findViewById(R.id.eventLocation);
        startText = (TextView) findViewById(R.id.eventStartTime);
        peopleText = (TextView) findViewById(R.id.eventPeopleNeeded);
//        currentPeopleText = (TextView) findViewById(R.id.eventCurrentPeople);

        int eventId = intent.getIntExtra(EventFragmentList.EVENT_ID_KEY, 0);

        event = EventManager.getManager().getEvent(eventId);
        setEventText();

        if (event.getPeopleHave() == event.getPeopleNeeded()){
            Button button = (Button) findViewById(R.id.joinButton);
            button.setClickable(false);
            button.setAlpha(.3f);
        }
    }

    private void setEventText(){
        setTitle(event.getTitle());
//        titleText.setText(event.getTitle());
        descText.setText(event.getDescription());
        locationText.setText(event.getLocation());
        String people = event.getPeopleHave() + "/" + event.getPeopleNeeded();
        peopleText.setText(people);
//        currentPeopleText.setText(Integer.toString(event.getPeopleHave()));
        startText.setText(event.getStartTime().toString());
    }

    public void joinEvent(View v){
        event.joinEvent();
        Toast.makeText(EventActivity.this, "See you there!", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, JoinEventActivity.class);
        startActivity(intent);
//        finish();
    }

    public void deleteEvent(View v){
        EventManager.getManager().removeEvent(event);
        finish();
    }

}
