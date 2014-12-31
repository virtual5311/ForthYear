package com.zumba.claudiuapp;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends Activity {
	public static final String loggedUser = "loggedUser";
	private SharedPreferences loggedUserFile;
	
	private boolean checkIfWasLoggedIn() {
		return loggedUserFile.getBoolean(loggedUserFile.getString("username", ""), false);
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		
		
		// ************************************************************************* Test contact
		Intent intent = new Intent(this, ContactInstructorActivity.class);
		startActivity(intent);
		
		
		
	//	loggedUserFile = getSharedPreferences(loggedUser, Context.MODE_PRIVATE);
	}
	
	
	public void clicked(View view) {
		EditText eUserName = (EditText)findViewById(R.id.eUserName);
		EditText ePassword = (EditText)findViewById(R.id.ePassword);
		
		String userName = eUserName.getText().toString().trim();
		String password = ePassword.getText().toString().trim();
		
		if (userName.isEmpty() || password.isEmpty()) {
			Toast.makeText(this, 
					       "Please enter both username and password", 
					       Toast.LENGTH_LONG).show();
		}
		
		//password = DigestUtils.sha256Hex(password);
		
		switch (view.getId()) {
			case R.id.bRegister :
				doRegister(userName, password);
			case R.id.bLogin:
				doLogin(userName, password);
			default:
				Toast.makeText(this, 
							   "Something went wrong, please try again later!", 
							   Toast.LENGTH_LONG).show();
		}
	}

	private void doRegister(String userName, String password) {
		/*
		 *  invoke ioana's script
		 */
		
		
	}

	private void doLogin(String userName, String password) {
		/*
		 *  invoke ioan's script
		 */
		
		boolean loggedIn = true;
		boolean isAdmin = false;
		
		if (loggedIn) {
			loggedUserFile.edit().putString("username", userName);
			loggedUserFile.edit().putBoolean(userName, true);
			loggedUserFile.edit().commit();
			
			if (isAdmin) {
				Intent i = new Intent(this, AdminActivity.class);
				startActivity(i);
				
			}
			else {
				Intent i = new Intent(this, UserActivity.class);
				startActivity(i);
			}
		}
		else {
			Toast.makeText(this, 
					   	  "Invalid username or password!", 
					      Toast.LENGTH_LONG).show();
		}
		
	}
}