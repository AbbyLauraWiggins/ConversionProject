package com.degree.abbylaura.conversionproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.lang.reflect.Array;

public class MainActivity extends AppCompatActivity {

    private Spinner unitTypeSpinner;
    private EditText amountTextView;

    TextView tspTV, tbspTV, cupTV, ozTV, pintTV, quartTV, gallonTV, poundTV, mlTV, litreTV, mgTV, kgTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        addItemsToUnitTypeSpinner();

        addListenerToUnitTypeSpinner();

        amountTextView = (EditText) findViewById(R.id.amount_text_view);

        initializeTextView();
    }

    public void initializeTextView(){

        tspTV = (TextView) findViewById(R.id.tsp_text_view);
        tbspTV = (TextView) findViewById(R.id.tbsp_text_view);
        cupTV = (TextView) findViewById(R.id.cup_text_view);
        ozTV = (TextView) findViewById(R.id.oz_text_view);
        pintTV = (TextView) findViewById(R.id.pint_text_view);
        quartTV = (TextView) findViewById(R.id.quart_text_view);
        gallonTV = (TextView) findViewById(R.id.gallon_text_view);
        poundTV = (TextView) findViewById(R.id.pound_text_view);
        mlTV = (TextView) findViewById(R.id.ml_text_view);
        litreTV = (TextView) findViewById(R.id.litre_text_view);
        mgTV = (TextView) findViewById(R.id.mg_text_view);
        kgTV = (TextView) findViewById(R.id.kg_text_view);

    }

    public void addItemsToUnitTypeSpinner(){
        unitTypeSpinner = (Spinner)
                findViewById(R.id.unit_type_spinner);

        ArrayAdapter<CharSequence> unitTypeSpinnerAdapter =
                ArrayAdapter.createFromResource(this,
                        R.array.conversion_types,
                        android.R.layout.simple_spinner_item);

        unitTypeSpinnerAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        unitTypeSpinner.setAdapter(unitTypeSpinnerAdapter);
    }

    public void addListenerToUnitTypeSpinner(){
        unitTypeSpinner = (Spinner)
                findViewById(R.id.unit_type_spinner);

        unitTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long l) {
                String itemSelectedInSpinner = parent.getItemAtPosition(position).toString();

                checkIfConvertingFromTsp(itemSelectedInSpinner);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                //TODO maybe add later
            }
        });
    }

    public void checkIfConvertingFromTsp(String currentUnit){

        if(currentUnit.equals("tsp")){
            updateUnitTypeUsingTsp(Quantity.Unit.tsp);
        } else {
            if(currentUnit.equals("tablespoon")){

                updateUnitTypesUsingOther(Quantity.Unit.tbsp);

            } else if(currentUnit.equals("cup")){

                updateUnitTypesUsingOther(Quantity.Unit.cup);

            } else if(currentUnit.equals("ounce")){

                updateUnitTypesUsingOther(Quantity.Unit.oz);

            } else if(currentUnit.equals("pint")){

                updateUnitTypesUsingOther(Quantity.Unit.pint);

            } else if(currentUnit.equals("quart")){

                updateUnitTypesUsingOther(Quantity.Unit.quart);

            } else if(currentUnit.equals("gallon")){

                updateUnitTypesUsingOther(Quantity.Unit.gallon);

            } else if(currentUnit.equals("pound")){

                updateUnitTypesUsingOther(Quantity.Unit.pound);

            } else if(currentUnit.equals("milliliter")){

                updateUnitTypesUsingOther(Quantity.Unit.ml);

            } else if(currentUnit.equals("liter")){

                updateUnitTypesUsingOther(Quantity.Unit.litre);

            } else if(currentUnit.equals("milligram")){

                updateUnitTypesUsingOther(Quantity.Unit.mg);

            } else {

                updateUnitTypesUsingOther(Quantity.Unit.kg);

            }
        }
    }

    public void updateUnitTypeUsingTsp(Quantity.Unit currentUnit){

        double doubleToConvert=
               Double.parseDouble(amountTextView.getText().toString());

        String tspValueAndUnit = doubleToConvert + " tsp";

        tspTV.setText(tspValueAndUnit);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.tbsp, tbspTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.cup, cupTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.oz, ozTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.pint, pintTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.quart, quartTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.gallon, gallonTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.pound, poundTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.ml, mlTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.litre, litreTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.mg, mgTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, Quantity.Unit.kg, kgTV);

    }



    public void updateUnitTextFieldUsingTsp(double doubleToConvert, Quantity.Unit unitConvertingTo, TextView theTV){

        Quantity unitQuantity = new Quantity(doubleToConvert, Quantity.Unit.tsp);

        String tempUnit =
                unitQuantity.to(unitConvertingTo).toString();

        theTV.setText(tempUnit);
    }





    public void updateUnitTypesUsingOther(Quantity.Unit currentUnit){

        double doubleToConvert =
                Double.parseDouble(amountTextView.getText().toString());

        Quantity currentQuantitySelected = new Quantity(doubleToConvert, currentUnit);

        String valueInTsp =
                currentQuantitySelected.to(Quantity.Unit.tsp).toString();

        tspTV.setText(valueInTsp);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.tbsp, tbspTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.cup, cupTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.oz, ozTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.pint, pintTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.quart, quartTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.gallon, gallonTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.pound, poundTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.ml, mlTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.litre, litreTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.mg, mgTV);

        updateUnitTextFieldUsingTsp(doubleToConvert, currentUnit, Quantity.Unit.kg, kgTV);


        if(currentUnit.name().equals(currentQuantitySelected.unit.name())){
           String currentUnitTextViewText =
                   doubleToConvert + " " + currentQuantitySelected.unit.name();

           //to communicate with .xml file
           String currentTextViewName = currentQuantitySelected.unit.name() +
                   "_text_view";

           int currentId =
                   getResources().getIdentifier(currentTextViewName, "id",
                           MainActivity.this.getPackageName());

           TextView currentTextView = (TextView)
                   findViewById(currentId);

           currentTextView.setText(currentUnitTextViewText);
        }
    }

    public void updateUnitTextFieldUsingTsp(double doubleToConvert,
                                            Quantity.Unit currentUnit,
                                            Quantity.Unit prefferedUnit,
                                            TextView targetTextView){
        //update txt field using tsp
        Quantity currentQuantitySelected = new
                Quantity(doubleToConvert, currentUnit);

        String tempTVtext =
                currentQuantitySelected.to(Quantity.Unit.tsp).to(prefferedUnit).toString();

        targetTextView.setText(tempTVtext);
    }


}
