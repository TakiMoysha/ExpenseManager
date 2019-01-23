package com.takimoysha.expense_manager;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddMenuActivity extends AppCompatActivity {

    private static final String TAG = "AddMenuActivity";
    
    private EditText title;
    private EditText price;
    private Button add_price;
    private Button subtract_price;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_menu);

        title = findViewById(R.id.inputTitle);
        price = findViewById(R.id.inputPrice);
        add_price = findViewById(R.id.add_price);

        title.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                add_price.setEnabled(!TextUtils.isEmpty(s));
                subtract_price.setEnabled(!TextUtils.isEmpty(s));
            }
        });

        add_price.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String checkName = title.getText().toString();
                String checkPrice = price.getText().toString();

                Toast toast = Toast.makeText(getApplicationContext(),
                        "Click!",
                        Toast.LENGTH_SHORT);
                toast.show();
            }
        });
    }
}
