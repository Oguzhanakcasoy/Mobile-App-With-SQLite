package com.example.finalproje3;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private static final int DIALOG_HAKKINDA=1;
    EditText et_adsoyad, et_mail, et_adres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //3 satır.
        setContentView(R.layout.activity_main);


        et_adsoyad = (EditText) findViewById(R.id.et_adsoyad);
        et_mail = (EditText) findViewById(R.id.et_mail);
        et_adres = (EditText) findViewById(R.id.et_adres);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
       switch (id){

           case R.id.hakkinda:
               showDialog(DIALOG_HAKKINDA);
           return true;

           default:
               return super.onOptionsItemSelected(item);

       }

    }

    @Override
    protected Dialog onCreateDialog(int id){
        Dialog dialog = null;
        switch (id){
            case DIALOG_HAKKINDA:
                dialog=new Dialog(MainActivity.this);
                dialog.setTitle("Hakkında");
                dialog.setContentView(R.layout.hakkinda);
                break;
            default:
                dialog=null;
        }
        return dialog;
    }

    public void butonaDokunuldu(View view) {

        switch (view.getId()) {

            case R.id.btn_kaydet:

                String adsoyad = et_adsoyad.getText().toString();
                String mail = et_mail.getText().toString();
                String adres = et_adres.getText().toString();

                Ogrenci ogrenci = new Ogrenci(adsoyad, mail, adres);

                Veritabani db= new Veritabani(getApplicationContext());
                long id=db.KayıtEkle(ogrenci);
                if(id==-1){
                    Toast.makeText(MainActivity.this, "Hay aksi! Kayıt işleminde bir hata oluştu..", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getApplicationContext(),"Kayıt işlemi başarılı",Toast.LENGTH_LONG).show();
                }

                et_adres.setText("");
                et_adsoyad.setText("");
                et_mail.setText("");
                break;

            case R.id.btn_listele:

                Intent intent = new Intent(getApplicationContext(),Listele.class);
                startActivity(intent);
        }
    }
}