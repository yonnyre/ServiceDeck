package com.example.yonny.servicedesk;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private TextView textView;
    private TextView nombre;
    private Menu menu;
    public String datoRol;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);






        textView=(TextView)findViewById(R.id.textView4);

        nombre=(TextView) navigationView.getHeaderView(0).findViewById(R.id.textView3);

        Intent intent=getIntent();
        Bundle extras =intent.getExtras();
        if (extras != null) {//ver si contiene datos
            String datoUsuario=(String)extras.get("user");//Obtengo el nombre
            String datoNombre=(String)extras.get("nombre");//Obtengo el nombre
            datoRol=(String)extras.get("rol");//Obtengo el nombre

            textView.setText(datoRol);
            nombre.setText(datoNombre);

        }



        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

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
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.

        String  rol3="Técnico";

        int id = item.getItemId();

        FragmentManager fragmentManager=getSupportFragmentManager();

        if(datoRol.equals("Cliente")){

            Menu menu =navigationView.getMenu();


            MenuItem target = menu.findItem(R.id.nav_slideshow);
            MenuItem target1 = menu.findItem(R.id.nav_reporte);
            MenuItem target2 = menu.findItem(R.id.nav_atender);
            target.setVisible(false);
            target1.setVisible(false);
            target2.setVisible(false);



             if (id == R.id.nav_camera) {
                fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment3()).commit();
            } else if (id == R.id.nav_manage) {
            fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment4()).commit();
        }



        }else if(datoRol.equals("Supervisor")){

            if (id == R.id.nav_camera) {
                fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment1()).commit();
            } else if (id == R.id.nav_gallery) {
                fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment2()).commit();
            } else if (id == R.id.nav_slideshow) {
                fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment3()).commit();
            } else if (id == R.id.nav_manage) {
                fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment4()).commit();
            } else if (id == R.id.nav_share) {
                fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment1()).commit();
            } else if (id == R.id.nav_send) {

            }
        } else if(datoRol.equals(rol3)){

            if (id == R.id.nav_camera) {

                fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment1()).commit();
            } else if (id == R.id.nav_gallery) {
                fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment2()).commit();
            } else if (id == R.id.nav_slideshow) {
                fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment3()).commit();
            } else if (id == R.id.nav_manage) {
                fragmentManager.beginTransaction().replace(R.id.contenedor,new Fragment4()).commit();
            }
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

}
