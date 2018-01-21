package rohitkadam.jsondemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class JsonList extends ArrayAdapter {
    List list = new ArrayList();
    Context context;
    JsonList(Context context,int resource){
        super(context,resource);

    }
    public void add(Object obj){
        super.add(obj);
        list.add(obj);
    }
    @Override
    public int getCount() {
        return  list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        JSON json = (JSON) list.get(position);

        View row;
        row = view;
        Holder holder;
        if(row == null){
            LayoutInflater layoutInflater= (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = layoutInflater.inflate(R.layout.row_layout,parent,false);
            holder = new Holder();
           // holder.user_id = row.findViewById(R.id.tx_id);
            holder.user_title = row.findViewById(R.id.tx_title);
            //holder.user_discription = row.findViewById(R.id.tx_discription);
            holder.user_imageView = row.findViewById(R.id.imageView);
            row.setTag(holder);
        }
        else {
            holder = (Holder) row.getTag();
        }


        JSON json1 = (JSON) this.getItem(position);
        String imageName = json1.getImg();
        int imgId = getContext().getResources().getIdentifier(imageName,"drawable",getContext().getPackageName());


        holder.user_imageView.setImageResource(imgId);
       // holder.user_id.setText(json1.getId());
        holder.user_title.setText(json1.getName());
        //holder.user_discription.setText(json1.getDiscription());

        return row;
    }

    static class Holder{
        TextView user_id,user_title,user_discription;
        ImageView user_imageView;
    }
}