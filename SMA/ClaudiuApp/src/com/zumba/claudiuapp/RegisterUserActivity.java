package com.zumba.claudiuapp;

import database.BDUtilizatori;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterUserActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register_user);
		
		Button b = (Button)findViewById(R.id.register);
		
		b.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				EditText txtName      = (EditText)findViewById(R.id.profileName);
				EditText txtForname   = (EditText)findViewById(R.id.profileForname);
				EditText txtEMail     = (EditText)findViewById(R.id.profileMail);
				EditText txtPass      = (EditText)findViewById(R.id.profilePassword);
				EditText txtTelephone = (EditText)findViewById(R.id.profileTelephone);
				
				String name = "", forName = "", email = "", password = "", telephone = "";
				try {
					name = txtName.getText().toString().trim();
					forName = txtForname.getText().toString().trim();
					email = txtEMail.getText().toString().trim();
					password = txtPass.getText().toString().trim();
					telephone = txtTelephone.getText().toString().trim();
				} catch (NullPointerException e) {
					
				}
				
				if (name.isEmpty() || forName.isEmpty() || email.isEmpty() || telephone.isEmpty()) {
					Toast.makeText(RegisterUserActivity.this,
								   "Please fill in all the entries!", 
								   Toast.LENGTH_LONG
								  ).show();
				}
				else if (password.length() < 8) {
					Toast.makeText(RegisterUserActivity.this,
							   "The password should be at least 8 characters long!", 
							   Toast.LENGTH_LONG
							  ).show();
					
				}
				else {
					Log.d("claudiuapp", "name: " + name);
					Log.d("claudiuapp", "forname: " + forName);
					Log.d("claudiuapp", "email: " + email);
					Log.d("claudiuapp", "password: " + password);
					Log.d("claudiuapp", "telephone: " + telephone);
					BDUtilizatori utilizatori = new BDUtilizatori();
					utilizatori.introducereUtilizator(name, 
													  forName, 
													  email, 
													  password, 
													  telephone, 
													  0
													 );
					Toast.makeText(RegisterUserActivity.this,
							   	   "You were register. Now please log in", 
							   	   Toast.LENGTH_SHORT
							  	  ).show();
					
					Intent i = new Intent(RegisterUserActivity.this, LoginActivity.class);
					startActivity(i);
				}
				
			}
			
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.register_user, menu);
		return true;
	}

}
