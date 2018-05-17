package fauzi.hilmy.app21;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Online> arrayList;
    RecyclerAdapter recyclerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));

        arrayList = new ArrayList<>();
        arrayList.addAll(OnlineData.getDataWeb());

        recyclerAdapter = new RecyclerAdapter(this);
        recyclerAdapter.setOnlines(arrayList);

        recyclerView.setAdapter(recyclerAdapter);
    }
}
