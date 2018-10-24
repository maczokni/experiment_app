package uk.ac.manchester.solymosi.reka.experiment_app;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.Snackbar;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.app.Activity;
import android.widget.Button;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Calendar;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    private static final int MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Activity mActivity = this;

        if (ContextCompat.checkSelfPermission(this,
                Manifest.permission.WRITE_EXTERNAL_STORAGE)
                != PackageManager.PERMISSION_GRANTED) {

            // Permission is not granted
            // Should we show an explanation?
            if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                    Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                // Show an explanation to the user *asynchronously* -- don't block
                // this thread waiting for the user's response! After the user
                // sees the explanation, try again to request the permission.
            } else {
                // No explanation needed; request the permission
                ActivityCompat.requestPermissions(this,
                        new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE},
                        MY_PERMISSIONS_REQUEST_WRITE_EXTERNAL_STORAGE);

                // MY_PERMISSIONS_REQUEST_READ_CONTACTS is an
                // app-defined int constant. The callback method gets the
                // result of the request.
            }
        } else {
            // Permission has already been granted
        }

        Button button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                String worry = "WORRY";
                long currentTime = Calendar.getInstance().getTimeInMillis();
                String msg = worry + "," + getDate(currentTime, "dd/MM/yyyy hh:mm:ss.SSS") + "\n";
                System.out.println("MSG IS: " + msg);

                try {
                    String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                    String FILENAME =path + "/External.txt"; // External is the text file name

                    File myFile = new File(path , "External.txt");

                    if(myFile.exists())
                    {
                        try
                        {
                            FileOutputStream fOut = new FileOutputStream(myFile, true);
                            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                            myOutWriter.append(msg);
                            myOutWriter.close();
                            fOut.close();

                            Snackbar.make(v, String.format(worry), Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                          //  System.out.println(String.format("wrote file here: %s", getFilesDir().getAbsolutePath()));

                        } catch(Exception e)
                        {

                        }
                    }
                    else
                    {
                        myFile.createNewFile();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                    Snackbar.make(v, "NOPE", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }

            }
        });

//        Button button2 = (Button) findViewById(R.id.button2);
//        button2.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v2) {
//                String worry = "Fairly worried";
//                long currentTime = Calendar.getInstance().getTimeInMillis();
//                String msg = worry + "," + getDate(currentTime, "dd/MM/yyyy hh:mm:ss.SSS") + "\n";
//                System.out.println("MSG IS: " + msg);
//
//                try {
//                    String path = Environment.getExternalStorageDirectory().getAbsolutePath();
//                    String FILENAME =path + "/External.txt"; // External is the text file name
//
//                    File myFile = new File(path , "External.txt");
//
//                    if(myFile.exists())
//                    {
//                        try
//                        {
//                            FileOutputStream fOut = new FileOutputStream(myFile, true);
//                            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
//                            myOutWriter.append(msg);
//                            myOutWriter.close();
//                            fOut.close();
//
//                            Snackbar.make(v2, String.format(worry), Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                            //  System.out.println(String.format("wrote file here: %s", getFilesDir().getAbsolutePath()));
//
//                        } catch(Exception e)
//                        {
//
//                        }
//                    }
//                    else
//                    {
//                        myFile.createNewFile();
//                    }
//
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    Snackbar.make(v2, "NOPE", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                }
//            }
//        });
//
//
//        Button button3 = (Button) findViewById(R.id.button3);
//        button3.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v3) {
//                String worry = "Very worried";
//                long currentTime = Calendar.getInstance().getTimeInMillis();
//                String msg = worry + "," + getDate(currentTime, "dd/MM/yyyy hh:mm:ss.SSS") + "\n";
//                System.out.println("MSG IS: " + msg);
//
//                try {
//                    String path = Environment.getExternalStorageDirectory().getAbsolutePath();
//                    String FILENAME =path + "/External.txt"; // External is the text file name
//
//                    File myFile = new File(path , "External.txt");
//
//                    if(myFile.exists())
//                    {
//                        try
//                        {
//                            FileOutputStream fOut = new FileOutputStream(myFile, true);
//                            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
//                            myOutWriter.append(msg);
//                            myOutWriter.close();
//                            fOut.close();
//
//                            Snackbar.make(v3, String.format(worry), Snackbar.LENGTH_LONG)
//                                    .setAction("Action", null).show();
//                            //  System.out.println(String.format("wrote file here: %s", getFilesDir().getAbsolutePath()));
//
//                        } catch(Exception e)
//                        {
//
//                        }
//                    }
//                    else
//                    {
//                        myFile.createNewFile();
//                    }
//
//
//                } catch (IOException e) {
//                    e.printStackTrace();
//                    Snackbar.make(v3, "NOPE", Snackbar.LENGTH_LONG)
//                            .setAction("Action", null).show();
//                }
//            }
//        });

        Button startButton = (Button) findViewById(R.id.startButton);
        startButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v4) {
                String worry = "START";
                long currentTime = Calendar.getInstance().getTimeInMillis();
                String msg = worry + "," + getDate(currentTime, "dd/MM/yyyy hh:mm:ss.SSS") + "\n";
                System.out.println("MSG IS: " + msg);

                try {
                    String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                    String FILENAME =path + "/External.txt"; // External is the text file name

                    File myFile = new File(path , "External.txt");

                    if(myFile.exists())
                    {
                        try
                        {
                            FileOutputStream fOut = new FileOutputStream(myFile, true);
                            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                            myOutWriter.append(msg);
                            myOutWriter.close();
                            fOut.close();

                            Snackbar.make(v4, String.format(worry), Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            //  System.out.println(String.format("wrote file here: %s", getFilesDir().getAbsolutePath()));

                        } catch(Exception e)
                        {

                        }
                    }
                    else
                    {
                        myFile.createNewFile();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                    Snackbar.make(v4, "NOPE", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });

        Button finishButton = (Button) findViewById(R.id.finishButton);
        finishButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v5) {
                String worry = "FINISH";
                long currentTime = Calendar.getInstance().getTimeInMillis();
                String msg = worry + "," + getDate(currentTime, "dd/MM/yyyy hh:mm:ss.SSS") + "\n";
                System.out.println("MSG IS: " + msg);

                try {
                    String path = Environment.getExternalStorageDirectory().getAbsolutePath();
                    String FILENAME =path + "/External.txt"; // External is the text file name

                    File myFile = new File(path , "External.txt");

                    if(myFile.exists())
                    {
                        try
                        {
                            FileOutputStream fOut = new FileOutputStream(myFile, true);
                            OutputStreamWriter myOutWriter = new OutputStreamWriter(fOut);
                            myOutWriter.append(msg);
                            myOutWriter.close();
                            fOut.close();

                            Snackbar.make(v5, String.format(worry), Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                            //  System.out.println(String.format("wrote file here: %s", getFilesDir().getAbsolutePath()));

                        } catch(Exception e)
                        {

                        }
                    }
                    else
                    {
                        myFile.createNewFile();
                    }


                } catch (IOException e) {
                    e.printStackTrace();
                    Snackbar.make(v5, "NOPE", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            }
        });



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

    public static String getDate(long milliSeconds, String dateFormat)
    {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }


}
