package com.example.vivek.assignment103;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by vivek on 11-06-2016.
 */
public class ListFragment extends Fragment{

    ArrayList<String> listItems  = new ArrayList<>();

    public ListFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.list_frament,container,false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Log.d("TAG:", "Inside onViewCreated ListFrag");
        super.onViewCreated(view, savedInstanceState);
        listItems.add("Circle");
        listItems.add("Square");
        listItems.add("Rectangle");
        listItems.add("Triangle");
        listItems.add("Pentagon");

        ListView listView = (ListView)view.findViewById(R.id.listView);
        ArrayAdapter<String> listAdapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_selectable_list_item,listItems);
        Log.d("TAG:", "Setting data to ListView");
        listView.setAdapter(listAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                if (getResources().getConfiguration().orientation== Configuration.ORIENTATION_PORTRAIT)
                {
                    Log.d("TAG:", "Resource in portrait");
                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();

                    switch (position) {
                        case 0:
                            CircleFragment circleFragment = new CircleFragment();
                            ft.replace(R.id.singleFrame, circleFragment);
                            ft.commit();
                            break;
                        case 1:
                            SquareFragment squareFragment = new SquareFragment();
                            ft.replace(R.id.singleFrame, squareFragment);
                            ft.commit();
                            break;
                        case 2:
                            RecFragment recFragment = new RecFragment();
                            ft.replace(R.id.singleFrame, recFragment);
                            ft.commit();
                            break;
                        case 3:
                            TriangleFragment triangleFragment = new TriangleFragment();
                            ft.replace(R.id.singleFrame, triangleFragment);
                            ft.commit();
                            break;
                        case 4:
                            PentagonFragment pentagonFragment = new PentagonFragment();
                            ft.replace(R.id.singleFrame, pentagonFragment);
                            ft.commit();
                            break;
                    }
                }
                else if (getResources().getConfiguration().orientation==Configuration.ORIENTATION_LANDSCAPE)
                {
                    Log.d("TAG:", "Resource in landscape");

                    FragmentManager fm = getFragmentManager();
                    FragmentTransaction ft = fm.beginTransaction();
                    switch (position) {
                        case 0:
                            CircleFragment circleFragment = new CircleFragment();
                            ft.replace(R.id.detailFrame, circleFragment);
                            ft.commit();
                            break;
                        case 1:
                            SquareFragment squareFragment = new SquareFragment();
                            ft.replace(R.id.detailFrame, squareFragment);
                            ft.commit();
                            break;
                        case 2:
                            RecFragment recFragment = new RecFragment();
                            ft.replace(R.id.detailFrame, recFragment);
                            ft.commit();
                            break;
                        case 3:
                            TriangleFragment triangleFragment = new TriangleFragment();
                            ft.replace(R.id.detailFrame, triangleFragment);
                            ft.commit();
                            break;
                        case 4:
                            PentagonFragment pentagonFragment = new PentagonFragment();
                            ft.replace(R.id.detailFrame, pentagonFragment);
                            ft.commit();
                            break;
                    }
                }
            }
        });
    }
}
