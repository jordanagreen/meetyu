package yumeet.freebird.yumeet;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class EventFragmentList extends Fragment {
    private String[] events = {"Event 1", "Event 2", "Event 3", "Event 4"};
    private ListView eventList;


    public EventFragmentList() {
        // Required empty public constructor
    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v  = inflater.inflate(R.layout.fragment_event_list, container, false);

        eventList = (ListView)v.findViewById(R.id.eventListView);

        eventList.setAdapter(new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, events));


        return v;
    }
}
