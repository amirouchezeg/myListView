package www.techdip.com.listviewadapter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ArrayList<listItem> items=new ArrayList<listItem>();
        items.add(new listItem("azer","sdfgsdfg"));
        items.add(new listItem("azer","sdfgxcvb"));
        items.add(new listItem("azer","tersdfg"));
        items.add(new listItem("qsdf","sdfg"));
        items.add(new listItem("qsdf","qsdfhdf"));
        items.add(new listItem("qsdf","zertdv"));
        items.add(new listItem("xcv","sdfgze"));
        myCustomAdapter myCustomAdapter=new myCustomAdapter(items);

        ListView listView=findViewById(R.id.mlist);
        listView.setAdapter(myCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                TextView textname=(TextView)view.findViewById(R.id.txt_name);
                TextView textdes=(TextView)view.findViewById(R.id.txt_detais);
                Toast.makeText(MainActivity.this, textname.getText()    , Toast.LENGTH_SHORT).show();
            }
        });
    }

    class myCustomAdapter extends BaseAdapter{
        ArrayList<listItem> items=new ArrayList<listItem>();

        myCustomAdapter(ArrayList<listItem> items){
            this.items=items;
        }

        @Override
        public int getCount() {
            return items.size();
        }

        @Override
        public Object getItem(int i) {
            return items.get(i).Name;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater=getLayoutInflater();
            View view1=inflater.inflate(R.layout.row_view,null);

            TextView textname=(TextView)view1.findViewById(R.id.txt_name);
            TextView textdes=(TextView)view1.findViewById(R.id.txt_detais);
            Button button=(Button)view1.findViewById(R.id.button);

            final listItem temp = items.get(i);

            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Toast.makeText(MainActivity.this,temp.Desc , Toast.LENGTH_SHORT).show();
                }
            });
            textname.setText(temp.Name);
            textdes.setText(temp.Desc);
            return view1;
        }
    }
}
