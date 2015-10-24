package com.example.android.vinylfirst;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    /**
     * This method is called when the button is clicked.
     */

    public void clickHere(View view) {
        goToUrl("http://djtechtools.com/2015/03/05/why-new-djs-should-start-on-vinyl//");
    }

    public void learnHow(View view) {
        goToUrl("http://www.youtube.com/watch?v=bBsLR3DyFQg//");
    }

    public void focusOn(View view) {
        goToUrl("http://www.youtube.com/watch?v=rCrnk-4Jiw4//");
    }

    public void artOf(View view) {
        goToUrl("http://www.youtube.com/watch?v=ddm9-tvtw8E//");
    }

    public void dedicationTo(View view) {
        goToUrl("http://www.youtube.com/watch?v=oREpUjxUiOs//");
    }

    public void respectThe(View view) {
        goToUrl("http://www.youtube.com/watch?v=Kz6RQV3X8sQ//");
    }

    private void goToUrl (String url) {
        Uri uriUrl = Uri.parse(url);
        Intent launchBrowser = new Intent(Intent.ACTION_VIEW, uriUrl);
        startActivity(launchBrowser);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
