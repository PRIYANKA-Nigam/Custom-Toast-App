package com.example.customtoast;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
private TextView textView;private EditText editText;private Button button1,button2; private Switch aSwitch;public static final String shared="sharedPrefs";
public static final String text="text"; public static final String switch1= "switch"; private String text1; private Boolean switchOnOff;@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.button);textView=(TextView)findViewById(R.id.textView2);editText=(EditText)findViewById(R.id.editTextTextPersonName);
        button1=(Button)findViewById(R.id.button2);button2=(Button)findViewById(R.id.button3); aSwitch=(Switch)findViewById(R.id.switch1);
        button1.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) { textView.setText(editText.getText().toString()); }});
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveData();
            }
        });
        loadData(); updateViews();
        b.setOnClickListener(new View.OnClickListener() { @Override
            public void onClick(View v) {
                LayoutInflater inflater=getLayoutInflater();View view=inflater.inflate(R.layout.toast,null);
                TextView t=(TextView) view.findViewById(R.id.textView); t.setText("this is custom Toast");
                Toast to=new Toast(MainActivity.this); to.setView(view);
                to.setGravity(Gravity.LEFT |Gravity.TOP,150,150); to.show(); }}); }
                public void saveData() { SharedPreferences sharedPreferences=getSharedPreferences(shared,MODE_PRIVATE);SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString(text,textView.getText().toString()); editor.putBoolean(switch1,aSwitch.isChecked()); editor.apply();
        Toast.makeText(this,"Data Saved",Toast.LENGTH_LONG).show(); }
    public void loadData(){
        SharedPreferences sharedPreferences=getSharedPreferences(shared,MODE_PRIVATE);text1=sharedPreferences.getString(text,"");
       switchOnOff=sharedPreferences.getBoolean(switch1,false); }
    public void updateViews(){ textView.setText(text1); aSwitch.setChecked(switchOnOff); }}