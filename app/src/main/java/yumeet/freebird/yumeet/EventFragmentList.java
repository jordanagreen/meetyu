package yumeet.freebird.yumeet;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class EventFragmentList extends Fragment {

    private EventManager eventManager = EventManager.getManager();
    static final String EVENT_ID_KEY = "eventId";

//    private Event[] events = new Event[]{new Event("Basketball", null, null, null, null)};
    private ListView eventList;


    public EventFragmentList() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    private void showEvent(int i){
        Intent intent = new Intent(getActivity(), EventActivity.class);
        intent.putExtra(EVENT_ID_KEY, i);
        startActivity(intent);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_event_list, container, false);
        eventList = (ListView)v.findViewById(R.id.eventListView);
        eventList.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1,
                eventManager.getEvents()));
        eventList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                showEvent(position);
            }
        });
        return v;
    }
}
