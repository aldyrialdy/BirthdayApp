package xyz.fatahillah.birthdayapp;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.transition.Scene;
import android.transition.TransitionInflater;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //Definition
    ImageView turbineImageView;
    TextView fromWhoTextView;
    TextView toWhoTextView;
    ImageButton rotateImageButton;
    ImageButton infoImageButton;
    ViewGroup root;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //layout
        setContentView(R.layout.activity_main);

        //initial
        rotateImageButton = (ImageButton) findViewById(R.id.rotate_image_button);
        infoImageButton = (ImageButton) findViewById(R.id.info_image_button);
        turbineImageView = (ImageView) findViewById(R.id.turbine_image_view);
        fromWhoTextView = (TextView) findViewById(R.id.from_who_text_view);
        toWhoTextView = (TextView) findViewById(R.id.to_who_text_view);
        root = (ViewGroup) findViewById(R.id.main_root);


        //action rotate
        rotateImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //animation turbine imageview
                turbineImageView.animate()
                        .rotation(turbineImageView.getRotation() + 15)
                        .start();

                //animation towho textview
                ObjectAnimator
                        .ofObject(toWhoTextView, "backgroundColor",
                                new ArgbEvaluator(), Color.RED, Color.WHITE)
                        .setDuration(250)
                        .start();
            }
        });

        //action info
        infoImageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TransitionManager.go(
                        Scene.getSceneForLayout(
                                (ViewGroup) findViewById(R.id.main_root),
                                R.layout.activity_detail,
                                MainActivity.this
                        ),
                        TransitionInflater.from(MainActivity.this)
                                .inflateTransition(R.transition.from_main_to_detail)
                );
            }
        });

    }
}
