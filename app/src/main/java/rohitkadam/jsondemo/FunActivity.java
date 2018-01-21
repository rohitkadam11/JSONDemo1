package rohitkadam.jsondemo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class FunActivity extends AppCompatActivity {
    ListView listView;
    JsonList jsonList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fun);

        listView = findViewById(R.id.funList);
        jsonList = new JsonList(this,R.layout.row_layout);
        listView.setAdapter(jsonList);

        loadGrades(savedInstanceState);
    }
    public void loadGrades(Bundle view){
        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.funactivity);
        Scanner scanner = new Scanner(is);
        StringBuilder builder = new StringBuilder();

        while ( scanner.hasNextLine()){
            builder.append(scanner.nextLine());

        }
        parseJson(builder.toString());
    }

    private void parseJson(String s) {
        StringBuilder builder = new StringBuilder();

        try {
            JSONObject root = new JSONObject(s);
            JSONArray student = root.getJSONArray("activity");
            int count  = 0;
            String title , discription,id,img;
            while(count<student.length()){
                JSONObject  name = student.getJSONObject(count);
               // id = name.getString("id");
                title = name.getString("title");
                //discription = name.getString("discription");
                img = name.getString("photo");
                //JSON json = new JSON(id,title,discription,img);
                //JSON json = new JSON(title,discription,img);
                JSON json = new JSON(title,img);
                jsonList.add(json);
                count++;
            }
        } catch (JSONException e) {

        }
    }
}
