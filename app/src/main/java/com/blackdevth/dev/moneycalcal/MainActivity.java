package com.blackdevth.dev.moneycalcal;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

import com.blackdevth.dev.moneycalcal.model.calcal;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = "MainActivity";
    private AdView mAdView;


    void settext(EditText a, double b) {
        a.setText(String.format("%.2f", b))
        ;
    }

    void calculatePrice() {
        EditText price_n = (EditText) findViewById(R.id.price);
        EditText price_vat = (EditText) findViewById(R.id.price_vat);
        EditText price_sc = (EditText) findViewById(R.id.price_sc);
        EditText vat = (EditText) findViewById(R.id.editText_vat);
        EditText sc = (EditText) findViewById(R.id.editText_sc);
        double price_n_value = Double.parseDouble(price_n.getText().toString());
        double vat_value = Double.parseDouble(vat.getText().toString());
        double sc_value = Double.parseDouble(sc.getText().toString());


        if (price_n.getText().toString().isEmpty()) price_n.setText("0");

        price_sc.setText((int) (price_n_value * sc_value * vat_value));
        price_vat.setText((int) (price_n_value * vat_value));


//        if (price <= 0 && pricev <= 0 && pricescv <= 0) {
//            Toast.makeText(getBaseContext(), "ERROR: 111! , Please input the prices", Toast.LENGTH_LONG).show();
//            clear();
//        } else if (pricev <= 0 && pricescv <= 0) {
//            pricev = price * 1.07;
//            //            pv.setText(pricev + "");
//            settext(pv, pricev);
//            pricescv = price * 1.07 * 1.1;
//            //            pscv.setText(pricescv + "");
//            settext(pscv, pricescv);
//        } else if (price <= 0 && pricescv <= 0) {
//            price = pricev / 1.07;
////            p.setText(price + "");
//            settext(p, price);
//            pricescv = pricev * 1.1;
////            pscv.setText(pricescv + "");
//            settext(pscv, pricescv);
//        } else if (price <= 0 && pricev <= 0) {
//            pricev = pricescv / 1.1;
////            pv.setText(pricescv + "");
//            settext(pv, pricev);
//            price = pricescv / 1.07 / 1.1;
////            p.setText(price + "");
//            settext(p, price);
//        } else {
//            Toast.makeText(getBaseContext(), "ERROR: 101! , Please input only one price at a time", Toast.LENGTH_LONG).show();
//            clear();
//        }
//        pricev = price * 1.07;
//        //            pv.setText(pricev + "");
//        settext(pv, pricev);
//        pricescv = price * 1.07 * 1.1;
//        //            pscv.setText(pricescv + "");
//        settext(pscv, pricescv);

    }

//    void clear() {
//        EditText textp = (EditText) findViewById(R.id.price);
//        EditText textpv = (EditText) findViewById(R.id.price_vat);
//        EditText textpscv = (EditText) findViewById(R.id.price_sc);
//        textp.setText("");
//        textpv.setText("");
//        textpscv.setText("");
//
//    }

    void help() {
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage("1.please input PRICE \n2.input VAT and Service Charge\n3.Calculated prices will be showed.");
        dlgAlert.setTitle("instruction");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
//        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
//                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
//        drawer.setDrawerListener(toggle);
//        toggle.syncState();
//
//        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
//        navigationView.setNavigationItemSelectedListener(this);

//        Button button_cal = (Button) findViewById(R.id.button_cal);
//        button_cal.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                calculatePrice();
//            }
//        });

//        Button button_clear = (Button) findViewById(R.id.button_clear);
//        button_clear.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                clear();
//            }
//        });

        Button button_help = (Button) findViewById(R.id.button_help);
        button_help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                help();
            }
        });


        mAdView = (AdView) findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        EditText price_n = (EditText) findViewById(R.id.price);
        price_n.setSelection(3);
        price_n.addTextChangedListener(tw);
        EditText vat = (EditText) findViewById(R.id.editText_vat);
        vat.addTextChangedListener(tw);
        EditText sc = (EditText) findViewById(R.id.editText_sc);
        sc.addTextChangedListener(tw);
    }

    TextWatcher tw = new TextWatcher() {

        @Override
        public void afterTextChanged(Editable arg0) {
//            EditText price_n = (EditText) findViewById(R.id.price);
//            EditText price_vat = (EditText) findViewById(R.id.price_vat);
//            EditText price_sc = (EditText) findViewById(R.id.price_sc);
//            EditText vat = (EditText) findViewById(R.id.editText_vat);
//            EditText sc = (EditText) findViewById(R.id.editText_sc);
//            if (price_n.getText().toString().length()==2 && price_n.getText().toString().startsWith("0")){
//                price_n.setText(price_n.getText().toString().replace("0", ""));
//            }

        }

        @Override
        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {


        }

        @Override
        public void onTextChanged(CharSequence s, int a, int b, int c) {
            EditText price_n = (EditText) findViewById(R.id.price);
            EditText price_vat = (EditText) findViewById(R.id.price_vat);
            EditText price_sc = (EditText) findViewById(R.id.price_sc);
            EditText vat = (EditText) findViewById(R.id.editText_vat);
            EditText sc = (EditText) findViewById(R.id.editText_sc);
            if (price_n.getText().toString().length() == 0||vat.getText().toString().length() == 0||sc.getText().toString().length() == 0) {
                settext(price_sc,0);
                settext(price_vat,0);
                return;
            }


            double price_n_value = Double.parseDouble(price_n.getText().toString());
            double vat_value = (100 + Double.parseDouble(vat.getText().toString())) / 100;
            double sc_value = (100 + Double.parseDouble(sc.getText().toString())) / 100;

            settext(price_sc, price_n_value * sc_value * vat_value);
            settext(price_vat, price_n_value * vat_value);

//            price_n.setText(""+(Double.parseDouble(price_n.getText().toString())));

//            for(int i=0;i<10;i++) {
//                if (price_n.getText().toString().equals("0"+i)) price_n.setText("i");
//                if (vat.getText().toString().equals("0"+i)) vat.setText("i");
//                if (sc.getText().toString().equals("0"+i)) sc.setText("i");
//            }

        }
    };


    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            onMenuSettingClicked(item);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onMenuSettingClicked(MenuItem item) {
        Resources res = getResources();
        AlertDialog.Builder dlgAlert = new AlertDialog.Builder(this);
        dlgAlert.setMessage("Version " + res.getString(R.string.app_versionName) + "\n\n" + "-Blackdev.th" + "\n" + "Thank you for using!");
        dlgAlert.setTitle("About");
        dlgAlert.setPositiveButton("OK", null);
        dlgAlert.setCancelable(true);
        dlgAlert.create().show();
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            Toast.makeText(getBaseContext(), "ERROR: 101! , กำลังพัฒนา", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_gallery) {
            Toast.makeText(getBaseContext(), "ERROR: 101! , กำลังพัฒนา", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_slideshow) {
            Toast.makeText(getBaseContext(), "ERROR: 101! , กำลังพัฒนา", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_manage) {
            Toast.makeText(getBaseContext(), "ERROR: 101! , กำลังพัฒนา", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_share) {
            Toast.makeText(getBaseContext(), "ERROR: 101! , กำลังพัฒนา", Toast.LENGTH_LONG).show();
        } else if (id == R.id.nav_send) {
            Toast.makeText(getBaseContext(), "ERROR: 101! , กำลังพัฒนา", Toast.LENGTH_LONG).show();
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }


}
