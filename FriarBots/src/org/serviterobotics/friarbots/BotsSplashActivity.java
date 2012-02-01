package org.serviterobotics.friarbots;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class BotsSplashActivity extends BotsActivity {
    /** Called when the activity is first created. */
	public static final String FIRST_BOOT = "boot";
    
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.begin);
        SharedPreferences bootPref = getSharedPreferences(FIRST_BOOT, MODE_PRIVATE);
        SharedPreferences.Editor editor = bootPref.edit();
        if (bootPref.getBoolean(FIRST_BOOT, true)) {
        	Animate();
        	editor.putBoolean("boot", false);
            editor.commit();
        } else {
        	startActivity(new Intent(BotsSplashActivity.this, FriarBotsActivity.class));
    		BotsSplashActivity.this.finish();
        }
    }
    private void Animate() {
    	TextView FRC = (TextView) findViewById(R.id.TextView_SplashTeam);
    	Animation fade1 = AnimationUtils.loadAnimation(this, R.anim.fade_in);
    	FRC.startAnimation(fade1);
    	ImageView logo = (ImageView) findViewById(R.id.ImageView_SplashLogo);
    	Animation fade2 = AnimationUtils.loadAnimation(this, R.anim.fade_in2);
    	logo.startAnimation(fade2);
    	fade2.setAnimationListener(new AnimationListener() {
        	public void onAnimationEnd(Animation animation) {
        		try {
					Thread.sleep(500);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
        		startActivity(new Intent(BotsSplashActivity.this, FriarBotsActivity.class));
        		BotsSplashActivity.this.finish();
        	}
        	public void onAnimationRepeat(Animation animation) {
        	}
        	public void onAnimationStart(Animation animation) {
        	}
        });
    }
    protected void onPause() {
    	super.onPause();
    	TextView logo1 = (TextView) findViewById(R.id.TextView_SplashTeam);
    	logo1.clearAnimation();
    	ImageView logo3 = (ImageView) findViewById(R.id.ImageView_SplashLogo);
    	logo3.clearAnimation();
    }
    protected void onResume() {
    	super.onResume();
    	Animate();
    }
}