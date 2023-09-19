package com.example.geodic;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.firebase.ui.auth.AuthUI;
import com.firebase.ui.database.FirebaseListAdapter;
import com.github.library.bubbleview.BubbleTextView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

public class chat extends AppCompatActivity {
    private static  int SIGN_IN_CODE=1;
    private RelativeLayout main;
    private FloatingActionButton exitbutton;
    private FirebaseListAdapter<Message> adapter;
    private FloatingActionButton sendButton;

    @Override
    protected void  onActivityResult(int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode,resultCode,data);
        FirebaseApp.initializeApp(this);
        if(requestCode==SIGN_IN_CODE){
            if(resultCode==RESULT_OK){

                displayMessages();
            }else {

                finish();
            }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);
        main=findViewById(R.id.main);
        sendButton=findViewById(R.id.sendbutton);
        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                EditText editText=findViewById(R.id.mesfield);
                if(editText.getText().toString()=="")
                    return;
                FirebaseDatabase.getInstance().getReference("messages").push().setValue(
                        new Message(FirebaseAuth.getInstance().getCurrentUser().getDisplayName(),
                                editText.getText().toString())
                );
                editText.setText("");
            }
        });
        exitbutton=findViewById(R.id.exitbutton);
        exitbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(chat.this,MainActivity.class);
                startActivity(intent);
            }
        });

        if(FirebaseAuth.getInstance().getCurrentUser()==null)
            startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder().build(),SIGN_IN_CODE);
        else{
            displayMessages();
        }


    }
    private void displayMessages() {
        ListView listoflists=findViewById(R.id.listoflists);
        adapter=new FirebaseListAdapter<Message>(this,Message.class,R.layout.message_design, FirebaseDatabase.getInstance().getReference("messages")) {
            @Override
            protected void populateView(View v, Message model, int position) {
                TextView user,time;
                BubbleTextView text;
                user=v.findViewById(R.id.user);
                time=v.findViewById(R.id.time) ;
                text=v.findViewById(R.id.messae);
                user.setText(model.getNik());
                text.setText(model.getText());
                time.setText(DateFormat.format("dd-MMM-yyyy HH:mm",model.getTiming()));
            }
        };
        listoflists.setAdapter(adapter);
    }
}