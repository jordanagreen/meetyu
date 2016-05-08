package yumeet.freebird.yumeet;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;

public class EventActivity extends FragmentActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);


        FragmentManager fm = getSupportFragmentManager();
        Fragment eventFragmentList = fm.findFragmentById(R.id.EventListFragment);

        if (eventFragmentList == null) {
            eventFragmentList = new EventFragmentList();
            fm.beginTransaction()
                    .add(R.id.EventListFragment, eventFragmentList)
                    .commit();
        }
    }

}
