package com.faramarz.tictacdev.multilanguage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.MenuBuilder;
import androidx.appcompat.view.menu.MenuPopupHelper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btn_change_lang;
    int item_selection = 0;
    Context context;
    private String fLanguageCode = "fa";
    private String eLanguageCode = "en";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        btn_change_lang = findViewById(R.id.btn_change_lang);

        btn_change_lang.setOnClickListener(new View.OnClickListener() {

            @SuppressWarnings("RestrictedApi")
            @Override
            public void onClick(View v) {
                registerForContextMenu(btn_change_lang);
                openContextMenu(btn_change_lang);

                MenuBuilder menuBuilder = new MenuBuilder(MainActivity.this);
                MenuInflater inflater = new MenuInflater(MainActivity.this);

                inflater.inflate(R.menu.item, menuBuilder);
                MenuPopupHelper popupHelper = new MenuPopupHelper(MainActivity.this, menuBuilder, v);
                menuBuilder.setCallback(new MenuBuilder.Callback() {
                    @Override
                    public boolean onMenuItemSelected(MenuBuilder menuBuilder, MenuItem menuItem) {
                        switch (menuItem.getItemId()) {
                            case R.id.item_fa:
                                LocaleHelper.setLocale(MainActivity.this, fLanguageCode);
                                recreate();
                                menuItem.setChecked(true);
                                item_selection = 1;
                                return true;


                            case R.id.item_en:
                                LocaleHelper.setLocale(MainActivity.this, eLanguageCode);
                                recreate();
                                menuItem.setChecked(true);
                                item_selection = 2;
                                return true;
                        }

                        return false;
                    }

                    @Override
                    public void onMenuModeChange(MenuBuilder menuBuilder) {

                    }
                });

                popupHelper.show();
            }
        });

    }


}
