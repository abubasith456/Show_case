package com.example.taptargetprompt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetView;

public class MainActivity extends AppCompatActivity {

    Button secondActivity,buttonTest;
    SharedPreferences prefs;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prefs = getSharedPreferences("ToolTipActivity2", MODE_PRIVATE);
        secondActivity = findViewById(R.id.secondActivity);
        buttonTest=findViewById(R.id.buttonTest);

        String check = prefs.getString("checkActivity1", "");
        if (check.equals("")) {
            showcaseView();
        } else {
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
        }

        secondActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, secondActivity.class);
                startActivity(i);
//                finish();
            }
        });
    }

    void showcaseView() {
        TapTargetView.showFor(this,
                TapTarget.forView(secondActivity, "This is A Button", "You will be redirected to sescond activity")
                        .outerCircleColor(R.color.teal_200)
                        .outerCircleAlpha(0.96f)
                        .targetCircleColor(R.color.white)
                        .titleTextSize(20)
                        .titleTextColor(R.color.white)
                        .descriptionTextSize(10)
                        .descriptionTextColor(R.color.black)
                        .textColor(R.color.black)
                        .textTypeface(Typeface.SANS_SERIF)
                        .dimColor(R.color.black)
                        .drawShadow(true)
                        .cancelable(false)
                        .tintTarget(true)
                        .transparentTarget(true)
                        .targetRadius(60));
//                new TapTargetView.Listener() {
//
//                    @Override
//                    public void onTargetClick(TapTargetView view) {
//                        super.onTargetClick(view);
//                        Intent i = new Intent(MainActivity.this, com.example.taptargetprompt.secondActivity.class);
//                        startActivity(i);
//                        finish();
//                    }
//                });
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("checkActivity1", "showed");
        editor.apply();
    }
}