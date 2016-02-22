package org.pondar.firstapp;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Person> persons = new ArrayList<Person>();


    //The onCreate method will be called EVERY time
    //our app comes into the foreground view for the user
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //LD Lesson 2: TESTING new Class. Outside of methods are just declarations. Cannot call functions also not println()
        Person p1 = new Person("martin",37);
        System.out.println(p1.toString());
        //Exercise 2

        persons.add(new Person("Martin", 37));
        persons.add(new Person("Alice", 42));
        persons.add(new Person("Georg", 15));
        persons.add(new Person("Theodor", 60));

        for(Person person : persons){
            System.out.println(person.toString());
            System.out.print("; ");
        }


        //This line sets the xml file "activity_main" in the layout folder as our main layout
        setContentView(R.layout.activity_main);
        //we find our toolbar (defined in the activity_main.xml file)
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //we set this as our toolbar
        setSupportActionBar(toolbar);

/* FLOATING BUTTON fab Actions:
        //We find our floating action button - again defined in the activity_main
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        //we also need to set a listener, so something happens, when the user
        //clicks the button.

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //you can read about what the Snackbar does or
                //simple try the app on your device or on your emulator.
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/


    }
/*CUSTOM METHOD*/

    public void onLoveButtonClicked(View view){
        TextView textView = (TextView) findViewById(R.id.haikuTextView);


        String personsText = "";
        for(Person person : persons){
            personsText += person.toString();
            personsText += "; \n";
        }

        //Exercise 3 Creating Toast
        Context context = getApplicationContext();
        CharSequence text = personsText;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        //toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        toast.show();
    }

    //Exercise 7 Creating Second Button
    public void onSimpleButtonClicked(View view){

        String buttonText = " Button 2 Clicked";

        Context context = getApplicationContext();
        CharSequence text = buttonText;
        int duration = Toast.LENGTH_SHORT;

        Toast toast = Toast.makeText(context, text, duration);
        //toast.setGravity(Gravity.TOP|Gravity.LEFT, 0, 0);
        toast.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        // it will look for the menu_main.xml file in the menu folder.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //did somebody press the settings?
        if (id == R.id.action_settings) {
            //well, actually we will just display a message to the user here.
            Toast toast = Toast.makeText(this,"Settings Pressed",Toast.LENGTH_LONG);
            toast.show();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
