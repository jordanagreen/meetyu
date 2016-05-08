package yumeet.freebird.yumeet;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class JoinEventActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_event);
    }

    public void goBackToMenu(View v){
        Intent intent = new Intent(this, EventListActivity.class);
        startActivity(intent);
    }
}
