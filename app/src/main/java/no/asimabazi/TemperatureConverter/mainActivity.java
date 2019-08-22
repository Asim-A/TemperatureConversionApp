package no.asimabazi.TemperatureConverter;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import no.asimabazi.TemperatureConverter.TemperatureConversion.CTOF;
import no.asimabazi.TemperatureConverter.TemperatureConversion.FTOC;

public class mainActivity extends AppCompatActivity {

    EditText temperature_input;
    Switch converter_switch;
    TextView tempature_info_textview;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);

        temperature_input = (EditText) findViewById(R.id.temperature_input);
        converter_switch = (Switch) findViewById(R.id.converter_switch);
        tempature_info_textview = (TextView) findViewById(R.id.tempature_info_textview);


    }

    @Override
    protected void onStart() {
        super.onStart();

        temperature_input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {

                celsius_to_fahrenheit();

                fahrenheit_to_celsius();


            }
        });

        converter_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
                celsius_to_fahrenheit();
                fahrenheit_to_celsius();
            }
        });

    }

    void celsius_to_fahrenheit(){
        if(!converter_switch.isChecked() && !isEditTextEmpty(temperature_input)){
            Double result = Double.valueOf
                    (
                    temperature_input.getText().toString()
            );

            String conversion = new CTOF().convert(result);

            Log.d("Result", conversion);

            tempature_info_textview.setText(conversion + " °F");
        }
    }

    void fahrenheit_to_celsius(){
        if(converter_switch.isChecked() && !isEditTextEmpty(temperature_input)){
            String conversion = new FTOC()
                    .convert(Double.valueOf(temperature_input.getText().toString()));

            Log.d("Result", conversion);

            tempature_info_textview.setText(conversion + " °C");

        }
    }

    boolean isEditTextEmpty(EditText et){
        String editTextString = et.getText().toString();

        if(TextUtils.isEmpty(editTextString)){
            et.setError("Input cannot be empty.");
            tempature_info_textview.setText("");
            return true;
        }
        return false;
    }

}
