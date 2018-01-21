package rohitkadam.jsondemo;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {
    ListView listView;

    JsonList jsonList;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        listView = findViewById(R.id.userList);
        jsonList = new JsonList(this,R.layout.row_layout);
        listView.setAdapter(jsonList);

        loadGrades(savedInstanceState);


    }
    public void loadGrades(Bundle view){
        Resources res = getResources();
        InputStream is = res.openRawResource(R.raw.info);
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
            JSONArray student = root.getJSONArray("title");
            int count  = 0;
            String title , discription,id,image;
            while(count<student.length()){
                JSONObject  name = student.getJSONObject(count);
                    //id = name.getString("id");
                    title = name.getString("name");
                   // discription = name.getString("discription");
                    image = name.getString("photo");
                    //JSON json = new JSON(id,title,discription,image);
                    //JSON json = new JSON(title,discription,image);
                    JSON json = new JSON(title,image);
                    jsonList.add(json);

                    count++;
            }
        } catch (JSONException e) {

        }
    }
}
