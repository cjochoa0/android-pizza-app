package com.ualr.pizzaappcarlosochoa;

import androidx.appcompat.app.AppCompatActivity;



import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioGroup;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.chip.ChipGroup;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;


public class MainActivity extends AppCompatActivity {

    private MaterialButtonToggleGroup pizzaGroup;
    private ImageView pizzaImg;
    private MaterialButton roundBtn;
    private MaterialButton squareBtn;

    private CheckBox pepperoniCheck;
    private CheckBox mushroomCheck;
    private CheckBox veggiesCheck;
    private CheckBox anchoviesCheck;
    private RadioGroup radioGroup;
    private ChipGroup pizzaIngredientsCG;

    private TextInputLayout textInputNameLayout;
    private TextInputEditText textInputNameEdit;
    private TextInputLayout textInputPhoneLayout;
    private TextInputEditText textInputPhoneEdit;
    private MaterialButton buttonPlaceOrder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Setting variables with appropriate values
        //Pizza variables
        pizzaGroup = findViewById(R.id.pizzaShapeToggleGroup);
        pizzaImg = findViewById(R.id.pizzaImage);
        roundBtn = findViewById(R.id.round);
        squareBtn = findViewById(R.id.square);

        //Ingredient variables
        pepperoniCheck = findViewById(R.id.pepperoni_box);
        mushroomCheck = findViewById(R.id.mushrooms);
        veggiesCheck = findViewById(R.id.veggies);
        anchoviesCheck = findViewById(R.id.anchovies);
        radioGroup = findViewById(R.id.cheese_radio);
        pizzaIngredientsCG = findViewById(R.id.chipGroup);

        //Contact variables
        textInputNameLayout = findViewById(R.id.nameEditText);
        textInputNameEdit = findViewById(R.id.inputName);
        textInputPhoneLayout = findViewById(R.id.phoneEditText);
        textInputPhoneEdit = findViewById(R.id.inputPhone);
        buttonPlaceOrder = findViewById(R.id.placeOrder);

        //starting functionality of Pizza Shape
        pizzaGroup.check(R.id.round);
        pizzaGroup.addOnButtonCheckedListener(new MaterialButtonToggleGroup.OnButtonCheckedListener() {
            @Override
            public void onButtonChecked(MaterialButtonToggleGroup group, int checkedId, boolean isChecked) {
                if(roundBtn.isChecked()){
                    pizzaImg.setImageResource(R.drawable.ic_round_pizza);
                }
                else if(squareBtn.isChecked()){
                    pizzaImg.setImageResource(R.drawable.ic_squared_pizza);
                }
                else{
                    pizzaImg.setImageResource(R.drawable.ic_not_selected_pizza);
                }
            }
        });

        //Starting functionality of Ingredient card view
        final Chip cheeseChip = new Chip(findViewById(R.id.chipGroup).getContext());
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                String text;

                switch (radioGroup.getCheckedRadioButtonId()){
                    case R.id.cheeseRadioBtn:
                        text = getResources().getString(R.string.cheese);
                        cheeseChip.setText(text);
                        cheeseChip.setChipBackgroundColorResource(R.color.primaryLightColor);
                        cheeseChip.setTextColor(getResources().getColor(R.color.primaryTextColor));
                        pizzaIngredientsCG.removeView(cheeseChip);
                        pizzaIngredientsCG.addView(cheeseChip);
                        break;
                    case R.id.xCheeseRadioBtn:
                        text = getResources().getString(R.string.xCheese);
                        cheeseChip.setText(text);
                        cheeseChip.setChipBackgroundColorResource(R.color.primaryLightColor);
                        cheeseChip.setTextColor(getResources().getColor(R.color.primaryTextColor));
                        pizzaIngredientsCG.removeView(cheeseChip);
                        pizzaIngredientsCG.addView(cheeseChip);
                        break;
                    case R.id.noCheeseRadioBtn:
                        text = getResources().getString(R.string.noCheese);
                        cheeseChip.setText(text);
                        cheeseChip.setChipBackgroundColorResource(R.color.primaryLightColor);
                        cheeseChip.setTextColor(getResources().getColor(R.color.primaryTextColor));
                        pizzaIngredientsCG.removeView(cheeseChip);
                        pizzaIngredientsCG.addView(cheeseChip);
                        break;
                    default:
                        pizzaIngredientsCG.removeView(cheeseChip);
                        break;
                }
            }
        });

        pepperoniCheck.setOnClickListener(new View.OnClickListener() {
            final Chip toppingChip = new Chip(findViewById(R.id.chipGroup).getContext());
            String text;
            @Override
            public void onClick(View view) {

                if(pepperoniCheck.isChecked()){
                    text = getResources().getString(R.string.pepperoni);
                    toppingChip.setText(text);
                    toppingChip.setChipBackgroundColorResource(R.color.primaryLightColor);
                    toppingChip.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    pizzaIngredientsCG.addView(toppingChip);
                }else{
                    pizzaIngredientsCG.removeView(toppingChip);
                }
            }
        });

        mushroomCheck.setOnClickListener(new View.OnClickListener() {
            final Chip toppingChip = new Chip(findViewById(R.id.chipGroup).getContext());
            String text;
            @Override
            public void onClick(View view) {

                if(mushroomCheck.isChecked()){
                    text = getResources().getString(R.string.mushrooms);
                    toppingChip.setText(text);
                    toppingChip.setChipBackgroundColorResource(R.color.primaryLightColor);
                    toppingChip.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    pizzaIngredientsCG.addView(toppingChip);
                }else{
                    pizzaIngredientsCG.removeView(toppingChip);
                }
            }
        });

        veggiesCheck.setOnClickListener(new View.OnClickListener() {
            final Chip toppingChip = new Chip(findViewById(R.id.chipGroup).getContext());
            String text;
            @Override
            public void onClick(View view) {

                if(veggiesCheck.isChecked()){
                    text = getResources().getString(R.string.veggies);
                    toppingChip.setText(text);
                    toppingChip.setChipBackgroundColorResource(R.color.primaryLightColor);
                    toppingChip.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    pizzaIngredientsCG.addView(toppingChip);
                }else{
                    pizzaIngredientsCG.removeView(toppingChip);
                }
            }
        });

        anchoviesCheck.setOnClickListener(new View.OnClickListener() {
            final Chip toppingChip = new Chip(findViewById(R.id.chipGroup).getContext());
            String text;
            @Override
            public void onClick(View view) {

                if(anchoviesCheck.isChecked()){
                    text = getResources().getString(R.string.anchovies);
                    toppingChip.setText(text);
                    toppingChip.setChipBackgroundColorResource(R.color.primaryLightColor);
                    toppingChip.setTextColor(getResources().getColor(R.color.primaryTextColor));
                    pizzaIngredientsCG.addView(toppingChip);
                }else{
                    pizzaIngredientsCG.removeView(toppingChip);
                }
            }
        });

        //starting functionality of Place Order button
        textInputPhoneEdit.addTextChangedListener(new PhoneNumberFormattingTextWatcher());
        buttonPlaceOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(textInputNameEdit.length() == 0){
                    textInputNameLayout.setError(getString(R.string.empty));
                }
                else{
                    textInputNameLayout.setError(null);
                }
                if(textInputPhoneEdit.length() == 0){
                    textInputPhoneLayout.setError(getString(R.string.empty));
                }
                else if(textInputPhoneEdit.length() != 14){
                    textInputPhoneLayout.setError(getString(R.string.invalidPhoneFormat));
                }
                else{
                    textInputPhoneLayout.setError(null);
                }
            }
        });
    }
}

