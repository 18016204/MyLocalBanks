package sg.edu.rp.c346.id18016204.mylocalbanks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button dbs;
Button ocbc;
Button uob;
    String click;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dbs =findViewById(R.id.dbs);
        ocbc = findViewById(R.id.ocbc);
        uob = findViewById(R.id.uob);

        registerForContextMenu(dbs);
        registerForContextMenu(ocbc);
        registerForContextMenu(uob);
        click = "";
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here.
        int id = item.getItemId();

        if (id == R.id.EnglishSelection) {
            dbs.setText("DBS");
            ocbc.setText("OCBC");
            uob.setText("UOB");
            return true;
        } else if (id == R.id.chineseSelection) {
            dbs.setText("展银行");
            ocbc.setText("华侨银行");
            uob.setText("大华银行");
            return true;
        } else {
            dbs.setText("Please select language");
            ocbc.setText("Please select language");
            uob.setText("Please select language");
        }

        return super.onOptionsItemSelected(item);
    }
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);

        menu.add(0,0,0,"Website");
        menu.add(0,1,1,"Contact the bank");
        if (v.getId() == dbs.getId()){
            click = "DBS";
        } else if (v.getId() == ocbc.getId()){
            click = "OCBC";
        } else if (v.getId() == uob.getId()){
            click = "UOB";
        } else {
            click = "";
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        if (item.getItemId() == 0) { //check whether the selected menu item ID is 0
            //code for action
            if (click.equals("DBS")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.dbs.com.sg"));
                startActivity(intent);
                return true;
            } else if (click.equals("OCBC")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ocbc.com"));
                startActivity(intent);
                return true;
            } else if (click.equals("UOB")) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.uob.com.sg"));
                startActivity(intent);
                return true;
            }
        } else if (item.getItemId() == 1) { //check if the selected menu item ID is 1
            if (click.equals("DBS")) {
                long DBSTel = Long.parseLong("18001111111");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + DBSTel));
                startActivity(intentCall);
                return true;
            } else if (click.equals("OCBC")) {
                long OCBCTel = Long.parseLong("18003633333");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + OCBCTel));
                startActivity(intentCall);
                return true;
            } else if (click.equals("UOB")) {
                long UOBTel = Long.parseLong("18002222121");
                Intent intentCall = new Intent(Intent.ACTION_DIAL, Uri.parse("tel: " + UOBTel));
                startActivity(intentCall);
                return true;
            }
        }
        return super.onContextItemSelected(item); //pass menu item to the superclass implementation
    }
}


