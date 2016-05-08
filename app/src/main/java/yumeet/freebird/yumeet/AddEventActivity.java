package yumeet.freebird.yumeet;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;

import java.util.Calendar;

public class AddEventActivity extends AppCompatActivity {

    static final String TITLE_KEY = "title";
    static final String LOCATION_KEY = "location";
    static final String DESC_KEY = "description";
    static final String NEEDED_KEY = "needed";
    static final String HAVE_KEY = "have";

    private EditText titleText;
    private EditText locationText;
    private EditText timeText;
    private EditText descText;
    private EditText neededText;
    private EditText haveText;
    private Button resultButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        titleText = (EditText) findViewById(R.id.addEventTitle);
        locationText = (EditText) findViewById(R.id.addEventLocation);
        timeText = (EditText) findViewById(R.id.addEventTime);
        descText = (EditText) findViewById(R.id.addEventDescription);
        neededText = (EditText) findViewById(R.id.addEventPeopleNeeded);
        haveText = (EditText) findViewById(R.id.addEventPeopleThere);
        resultButton = (Button) findViewById(R.id.addEventButton);

        setResultButton();
        setTimePicker();
    }

    private void setResultButton(){
        resultButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = titleText.getText().toString();
                String location = locationText.getText().toString();
                String startTime = timeText.getText().toString();
                String description = descText.getText().toString();
                int peopleNeeded = Integer.parseInt(neededText.getText().toString());
                int peopleThere = Integer.parseInt(haveText.getText().toString());
                Intent intent = new Intent();
                intent.putExtra(TITLE_KEY, title);
                intent.putExtra(LOCATION_KEY, location);
                intent.putExtra(DESC_KEY, description);
                intent.putExtra(NEEDED_KEY, peopleNeeded);
                intent.putExtra(HAVE_KEY, peopleThere);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }

    private void setTimePicker(){
        timeText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar currentTime = Calendar.getInstance();
                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);
                TimePickerDialog timePickerDialog = new TimePickerDialog(AddEventActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                                String time = hourOfDay + ":" + minute;
                                timeText.setText(time);
                            }
                        }, hour, minute, true);
                timePickerDialog.setTitle("Select Time");
                timePickerDialog.show();
            }
        });
    }
}
