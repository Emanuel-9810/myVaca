package com.myandroidhello.myvaca;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Random;

public class TripPlanner extends AppCompatActivity implements View.OnClickListener {

    private CalendarView calendarView;
    private Button homeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_trip_planner);

        calendarView = findViewById(R.id.calendarView);
        homeBtn = (Button) findViewById(R.id.homeBtn);

        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(TripPlanner.this, ProfileActivity.class));

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.homeBtn:
                startActivity(new Intent(this, ProfileActivity.class));
                break;
        }
    }


//    private int presCounter = 0;
//    private int maxPresCounter = 4;
//    private String[] keys = {"Summer", "Winter", "Fall", "Spring"};
//
//    TextView textScreen, textQuestion, textTitle;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_trip_planner);
//
//        keys = shuffleArray(keys);
//
//        for (String key:keys){
//            addView(((LinearLayout) findViewById(R.id.outerLayout)), key, ((EditText) findViewById(R.id.editText)));
//        }
//        maxPresCounter = 4;
//    }
//
//
//    private String[] shuffleArray(String[] ar) {
//        Random rnd = new Random();
//        for(int i = ar.length -1; i>0; i--){
//            int index = rnd.nextInt(i+1);
//            String a = ar[index];
//            ar[index] = ar[i];
//            ar[i] = a;
//        }
//        return ar;
//    }
//
//    private void addView(LinearLayout viewParent, final String text, final EditText editText){
//        LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(
//                LinearLayout.LayoutParams.WRAP_CONTENT,
//                LinearLayout.LayoutParams.WRAP_CONTENT
//        );
//        linearLayoutParams.rightMargin = 20;
//
//        final TextView textView = new TextView(this);
//
//        textView.setLayoutParams(linearLayoutParams);
////        textView.setBackground(this.getResources().getDrawable(R.id.quesbg));
//        textView.setGravity(Gravity.CENTER);
//        textView.setText(text);
//        textView.setClickable(true);
//        textView.setFocusable(true);
//        textView.setTextSize(32);
//
//        textQuestion = (TextView) findViewById(R.id.textQuestion);
//        textScreen = (TextView) findViewById(R.id.textScreen);
//        textTitle = (TextView) findViewById(R.id.textTitle);
//
//        textView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                if(presCounter < maxPresCounter){
//                    if(presCounter == 0)
//                        editText.setText("");
//                        editText.setText(editText.getText().toString() + text);
////                        textView.startAnimation(bigsmallforth);
//                        textView.animate().alpha(0).setDuration(200);
//                        presCounter++;
//
//                        if(presCounter == maxPresCounter){
//                            doValidate();
//                        }
//                    }
//                    else{
//
//                    }
//                }
//
//        });
//
//        viewParent.addView(textView);
//
//    }
//
//    private void doValidate(){
//        presCounter = 0;
//        EditText editText = findViewById(R.id.editText);
//        LinearLayout linearLayout = findViewById(R.id.outerLayout);
//
//        if(editText.getText().toString().equals(editText)){
//            Toast.makeText(TripQuestionnaire.this, "Answer selected", Toast.LENGTH_SHORT).show();
//            editText.setText("");
//        }else{
//            editText.setText("");
//        }
//
//        keys = shuffleArray(keys);
//        linearLayout.removeAllViews();
//        for(String key:keys){
//            addView(linearLayout, key, editText);
//        }
//    }
}