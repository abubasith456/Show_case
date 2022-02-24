package com.example.taptargetprompt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.getkeepsafe.taptargetview.TapTarget;
import com.getkeepsafe.taptargetview.TapTargetSequence;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import uk.co.deanwild.materialshowcaseview.MaterialShowcaseSequence;
import uk.co.deanwild.materialshowcaseview.MaterialShowcaseView;
import uk.co.deanwild.materialshowcaseview.ShowcaseConfig;

//import com.getkeepsafe.taptargetview.TapTarget;
//import com.getkeepsafe.taptargetview.TapTargetSequence;
//import com.getkeepsafe.taptargetview.TapTargetView;
//import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class secondActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5, btn6;
    EditText editText;
    FloatingActionButton floatingActionButton;
    private static final String SHOWCASE_ID = "examplesForrrrr";
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);
        editText=findViewById(R.id.editText);

        floatingActionButton = findViewById(R.id.floatingBtn);
        prefs = getSharedPreferences("ToolTipActivity2", MODE_PRIVATE);
        String check = prefs.getString("checkActivity2", "");
        if (check.equals("")) {
//            modelShowcaseSequence();
        } else {
            Toast.makeText(this, "Welcome", Toast.LENGTH_SHORT).show();
        }
        presentShowcaseSequence();
//        modelShowcaseSequence();
    }


    private void modelShowcaseSequence(){

        new TapTargetSequence(this)
                .targets(
                        TapTarget.forView(btn5,"Button 1","This is Button 1")
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
                                .targetRadius(60),
                        TapTarget.forView(btn6,"Button 2","This is Button 2")
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
                                .targetRadius(60),
                        TapTarget.forView(editText,"Button 3","This is Button 3")
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
                                .targetRadius(60))
//                        TapTarget.forView(btn4,"Button 3","This is Button 3")
//                                .outerCircleColor(R.color.teal_200)
//                                .outerCircleAlpha(0.96f)
//                                .targetCircleColor(R.color.white)
//                                .titleTextSize(20)
//                                .titleTextColor(R.color.white)
//                                .descriptionTextSize(10)
//                                .descriptionTextColor(R.color.black)
//                                .textColor(R.color.black)
//                                .textTypeface(Typeface.SANS_SERIF)
//                                .dimColor(R.color.black)
//                                .drawShadow(true)
//                                .cancelable(false)
//                                .tintTarget(true)
//                                .transparentTarget(true)
//                                .targetRadius(60),
//                        TapTarget.forView(floatingActionButton,"Button 3","This is Button 3")
//                                .outerCircleColor(R.color.Red)
//                                .outerCircleAlpha(0.96f)
//                                .targetCircleColor(R.color.white)
//                                .titleTextSize(20)
//                                .titleTextColor(R.color.white)
//                                .descriptionTextSize(10)
//                                .descriptionTextColor(R.color.black)
//                                .textColor(R.color.black)
//                                .textTypeface(Typeface.SANS_SERIF)
//                                .dimColor(R.color.black)
//                                .drawShadow(true)
//                                .cancelable(false)
//                                .tintTarget(true)
//                                .transparentTarget(true)
//                                .targetRadius(60))
                .listener(new TapTargetSequence.Listener() {
                    @Override
                    public void onSequenceFinish() {

                        Toast.makeText(secondActivity.this,"Sequence Finished",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSequenceStep(TapTarget lastTarget, boolean targetClicked) {

                        Toast.makeText(secondActivity.this,"GREAT!",Toast.LENGTH_SHORT).show();

                    }

                    @Override
                    public void onSequenceCanceled(TapTarget lastTarget) {

                    }
                }).start();
        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("checkActivity2", "showed");
        editor.apply();
    }

    private void presentShowcaseSequence() {

        ShowcaseConfig config = new ShowcaseConfig();
        config.setDelay(100); // half second between each showcase view

        MaterialShowcaseSequence sequence = new MaterialShowcaseSequence(this, SHOWCASE_ID);

        sequence.setOnItemShownListener(new MaterialShowcaseSequence.OnSequenceItemShownListener() {
            @Override
            public void onShow(MaterialShowcaseView itemView, int position) {
                Toast.makeText(itemView.getContext(), "Item #" + position, Toast.LENGTH_SHORT).show();
            }
        });

        sequence.setConfig(config);

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setSkipText("SKIP")
                        .setTarget(btn1)
                        .setDismissText("GOT IT")
                        .setContentText("This is button three")
                        .withRectangleShape()
                        .build()
        );

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setSkipText("SKIP")
                        .setDismissTextColor(Color.WHITE)
                        .setTarget(btn2)
                        .setDismissText("GOT IT")
                        .setContentText("This is button two")
                        .withRectangleShape(true)
                        .build()
        );

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setSkipText("SKIP")
                        .setDismissTextColor(Color.WHITE)
                        .setTarget(editText)
                        .setDismissText("GOT IT")
                        .setContentText("This is button two")
                        .withRectangleShape(true)
                        .build()
        );

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setTarget(btn3)
                        .setSkipText("SKIP")
                        .setDismissTextColor(Color.WHITE)
                        .setDismissText("GOT IT")
                        .setContentText("This is button three")
                        .withRectangleShape()
                        .build()
        );
        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setTarget(btn4)
                        .setDismissText("GOT IT")
                        .setSkipText("SKIP")
                        .setContentText("This is button three")
                        .withRectangleShape()
                        .build()
        );

        sequence.addSequenceItem(
                new MaterialShowcaseView.Builder(this)
                        .setTarget(floatingActionButton)
                        .setDismissText("GOT IT")
                        .setSkipText("SKIP")
                        .setDismissTextColor(Color.WHITE)
                        .setContentText("This is button three")
                        .withRectangleShape()
                        .withCircleShape()
                        .setShapePadding(30)
                        .build()
        );

        sequence.start();

    }
}