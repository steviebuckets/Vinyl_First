package com.example.android.vinylfirst;

import android.app.Dialog;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.app.AlertDialog;
import android.app.DialogFragment;
import android.view.ViewGroup;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the button is clicked.
     */

    public void alertUser(final java.lang.String url){
        new AlertDialog.Builder(this)
                .setTitle("Leaving App")
                .setMessage("Are you sure you want to leave?")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        goToUrl(url);
                    }
                })
                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener(){
                    public void onClick(DialogInterface dialog, int which){
                        /* do nothing */
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }

    public void advancedDialog(java.lang.String url){
        FragmentManager fm = getFragmentManager();
        MyDialogFragment dialogFragment = new MyDialogFragment ();
        dialogFragment.setUrl(url);
        dialogFragment.show(fm, "Sample Fragment");
    }

    public void clickHere(View view) {
        advancedDialog("http://djtechtools.com/2015/03/05/why-new-djs-should-start-on-vinyl///");
    }

    public void learnHow(View view) {

        advancedDialog("http://www.youtube.com/watch?v=bBsLR3DyFQg//");

    }

    public void focusOn(View view) {
        advancedDialog("http://www.youtube.com/watch?v=rCrnk-4Jiw4//");
    }

    public void artOf(View view) {
        advancedDialog("http://www.youtube.com/watch?v=ddm9-tvtw8E//");
    }

    public void dedicationTo(View view) {
        advancedDialog("http://www.youtube.com/watch?v=oREpUjxUiOs//");
    }

    public void respectThe(View view) {
        advancedDialog("http://www.youtube.com/watch?v=Kz6RQV3X8sQ//");
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

    public class MyDialogFragment extends DialogFragment {

        public String url = "";

        public void setUrl(java.lang.String newUrl){
            this.url = newUrl;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_sample_dialog, container, false);
            getDialog().setTitle("Simple Dialog");
            Button dismiss = (Button) rootView.findViewById(R.id.dismiss);
            Button okay = (Button) rootView.findViewById(R.id.okay);
            dismiss.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dismiss();
                }
            });
            okay.setOnClickListener(new View.OnClickListener() {

                @Override
                public void onClick(View v) {
                    goToUrl(url);
                    dismiss();
                }
            });
            return rootView;
        }
    }


}

