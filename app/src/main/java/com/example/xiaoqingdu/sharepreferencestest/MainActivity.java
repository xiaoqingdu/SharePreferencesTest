package com.example.xiaoqingdu.sharepreferencestest;

import android.content.SharedPreferences;
import android.icu.text.SimpleDateFormat;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

public class MainActivity extends AppCompatActivity {

    private final static String SharedPreferencesFileName = "Information";
    private final static String Key_UserName="UserName";
    private final static String Key_UserNum="UserNum";
    private final static String Key_UserType = "UserType";

    SharedPreferences preferences;
    SharedPreferences.Editor editor;
    /**
     * ATTENTION: This was auto-generated to implement the App Indexing API.
     * See https://g.co/AppIndexing/AndroidStudio for more information.
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getSharedPreferences(SharedPreferencesFileName,
                MODE_PRIVATE);
        editor = preferences.edit();

        Button btn_put = (Button) findViewById(R.id.btn_put);
        Button btn_read = (Button) findViewById(R.id.btn_read);

        final EditText edit_num = (EditText) findViewById(R.id.edit_num);
        final EditText edit_name = (EditText) findViewById(R.id.edit_name);

        btn_put.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String Key_Usernum = edit_num.getText().toString();
                final String Key_Username = edit_name.getText().toString();
                editor.putString(Key_UserName,Key_Username);
                editor.putString(Key_UserNum,Key_Usernum);
                editor.putInt(Key_UserType,1);

                editor.apply();
                Toast.makeText(MainActivity.this,"提交成功",Toast.LENGTH_LONG).show();
            }
        });

        btn_read.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strUserName=preferences.getString(Key_UserName,null);
                String strUserNum=preferences.getString(Key_UserNum,null);
                int nUserType=preferences.getInt(Key_UserType,0);
                if(strUserName!=null&&strUserNum!=null){
                    Toast.makeText(MainActivity.this,"学生姓名"+strUserName+"学号"+strUserNum+"用户类型"
                            +nUserType, Toast.LENGTH_LONG).show();
                }else {
                    Toast.makeText(MainActivity.this,"无数据",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
