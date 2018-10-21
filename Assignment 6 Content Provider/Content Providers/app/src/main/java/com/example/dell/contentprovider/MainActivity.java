package com.example.dell.contentprovider;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.provider.ContactsContract;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import java.util.ArrayList;


public class MainActivity extends AppCompatActivity implements View.OnClickListener, LoaderManager.LoaderCallbacks<Cursor>
{

    ListView listView1;

    private boolean firstTimeLoaded=false;

    private TextView textViewQueryResult;
    private Button buttonLoadData;
    int count=0;


    private String[] mColumnProjection = new String[]{
            ContactsContract.Contacts.DISPLAY_NAME_PRIMARY,
            ContactsContract.Contacts.CONTACT_STATUS,
            ContactsContract.Contacts.HAS_PHONE_NUMBER};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        textViewQueryResult = (TextView) findViewById(R.id.textViewQueryResult);


        buttonLoadData = (Button) findViewById(R.id.buttonLoadData);
        buttonLoadData.setOnClickListener(this);


    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        if (id == 1) {
            return new CursorLoader(MainActivity.this, ContactsContract.Contacts.CONTENT_URI,
                    mColumnProjection, null, null, null);
        }
        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && cursor.getCount() > 0)
        {

            ArrayList<String> info = new ArrayList<>();
            String str;

            while (cursor.moveToNext()) {

                str=cursor.getString(0);
                str+="\n";
                info.add(str);
                count+=1;
            }

            textViewQueryResult.setText("Total Contacts :  " + count);

            listView1=(ListView) findViewById(R.id.myContentList);
            ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,info);
            listView1.setAdapter(adapter);

        } else {
            textViewQueryResult.setText("No Contacts in device");
        }
        cursor.close();
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonLoadData: if(firstTimeLoaded==false){
                getLoaderManager().initLoader(1, null, this);
                firstTimeLoaded=true;
            }else{
                getLoaderManager().restartLoader(1,null,this);
            }

                break;
            default:
                break;
        }
    }

}

