package org.serviterobotics.friarbots;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class FriarBotsActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
    }
    public void onStatusButtonClick(View view) {
    	startActivity(new Intent(FriarBotsActivity.this, StatusActivity.class));
    }
    public void onCodeButtonClick(View view) {
    	startActivity(new Intent(FriarBotsActivity.this, CodeActivity.class));
    }
    public void onDriveSystemsButtonClick(View view) {
    	startActivity(new Intent(FriarBotsActivity.this, DriveSystemsActivity.class));
    }
    public void onBalanceButtonClick(View view) {
    	startActivity(new Intent(FriarBotsActivity.this, BalanceActivity.class));
    }
    public void onShooterButtonClick(View view) {
    	startActivity(new Intent(FriarBotsActivity.this, ShooterActivity.class));
    }
    public void onScoutingButtonClick(View view) {
    	startActivity(new Intent(FriarBotsActivity.this, ScoutingActivity.class));
    }
    public void onPostsButtonClick(View view) {
    	startActivity(new Intent(FriarBotsActivity.this, PostsActivity.class));
    }
    public void onGalleryButtonClick(View view) {
    	startActivity(new Intent(FriarBotsActivity.this, GalleryActivity.class));
    }
    public void onAboutButtonClick(View view) {
    	startActivity(new Intent(FriarBotsActivity.this, AboutActivity.class));
    }
    public void onCalendarButtonClick(View view) {
    	startActivity(new Intent(FriarBotsActivity.this, CalendarActivity.class));
    }
    
}