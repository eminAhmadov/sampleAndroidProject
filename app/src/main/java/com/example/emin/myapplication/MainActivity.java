package com.example.emin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button plus;
    Button minus;
    TextView number;
    EditText addValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        plus = findViewById(R.id.buttonPlus);
        minus = findViewById(R.id.buttonMinus);
        number = findViewById(R.id.numberLabel);
        addValue = findViewById(R.id.addValue);

        View.OnClickListener OnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int numberValue = Integer.parseInt(number.getText().toString());
                int addValueInt = Integer.parseInt(addValue.getText().toString());

                Toast toast = Toast.makeText(MainActivity.this, "def", Toast.LENGTH_SHORT);

                switch (view.getId()) {
                    case R.id.buttonPlus:
                        number.setText(String.valueOf(numberValue+addValueInt));
                        toast.setText("added");
                        toast.show();
                        break;
                    case R.id.buttonMinus:
                        number.setText(String.valueOf(numberValue-addValueInt));
                        toast.setText("subtracted");
                        toast.show();
                        break;
                }
            }
        };

        plus.setOnClickListener(OnClickListener);
        minus.setOnClickListener(OnClickListener);

    }
}
