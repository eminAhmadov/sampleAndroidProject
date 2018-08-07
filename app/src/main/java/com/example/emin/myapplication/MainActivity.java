package com.example.emin.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
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
    TextView balanceType;

    final int MENU_CARD_LABEL = 1;
    final int MENU_CASH_LABEL = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        plus = findViewById(R.id.buttonPlus);
        minus = findViewById(R.id.buttonMinus);
        number = findViewById(R.id.numberLabel);
        addValue = findViewById(R.id.addValue);
        balanceType = findViewById(R.id.balanceType);

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

        plus.setEnabled(false);
        minus.setEnabled(false);

        addValue.addTextChangedListener(new TextWatcher() {

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                if(s.toString().trim().length()==0){
                    plus.setEnabled(false);
                    minus.setEnabled(false);
                } else {
                    plus.setEnabled(true);
                    minus.setEnabled(true);
                }
            }

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count,
                                          int after) {
                // TODO Auto-generated method stub

            }

            @Override
            public void afterTextChanged(Editable s) {
                // TODO Auto-generated method stub

            }
        });

        registerForContextMenu(balanceType);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menu_clear){
            number.setText("0");
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        if(v.getId() == R.id.balanceType){
            menu.add(0, MENU_CARD_LABEL, 0, "Card");
            menu.add(0, MENU_CASH_LABEL, 0, "Cash");
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case MENU_CARD_LABEL:
                balanceType.setText("Card");
                break;
            case MENU_CASH_LABEL:
                balanceType.setText("Cash");
                break;
        }

        return super.onContextItemSelected(item);
    }
}
