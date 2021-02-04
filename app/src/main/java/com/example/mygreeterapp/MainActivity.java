package com.example.mygreeterapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String KEY_COUNT = "counter";
    String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(KEY_COUNT, name);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        name = savedInstanceState.getString(KEY_COUNT);
        displaysendGreet(name);
    }

    private void displaysendGreet(String name) {
        TextView dtextView =(TextView)
                findViewById(R.id.text);
               dtextView.setText("Hello, "+ name);

    }

    public void  sendGreet(View view){
        EditText editText = findViewById(R.id.editName);
        name = editText.getText().toString();

        if (name.isEmpty()) {

         Toast toast = Toast.makeText(this,"Name field can not be empty ",Toast.LENGTH_SHORT);
          toast.show();

       }
        displaysendGreet(name);
    }
}