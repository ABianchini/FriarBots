package org.serviterobotics.friarbots;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class FriarBotsActivity extends BotsActivity {
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
    	Toast toast = Toast.makeText(this, "Where\'s the code?", Toast.LENGTH_SHORT);
    	toast.show();
    }
    public void onBalanceButtonClick(View view) {
    	Toast toast = Toast.makeText(this, "Hop on one foot!", Toast.LENGTH_SHORT);
    	toast.show();
    }
    public void onShooterButtonClick(View view) {
    	Toast toast = Toast.makeText(this, "Bang!", Toast.LENGTH_SHORT);
    	toast.show();
    }
    public void onDriveSystemsButtonClick(View view) {
    	Toast toast = Toast.makeText(this, "Drive to Michigan", Toast.LENGTH_SHORT);
    	toast.show();
    }
}