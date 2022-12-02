package com.example.finalproje3;

import android.os.Bundle;
import android.view.ActionMode;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import java.util.ArrayList;
import java.util.List;

public class Listele extends AppCompatActivity {

   // private ActionMode actionMode;
    private Long id;

    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listele);

        try{
            tv= (TextView) findViewById(R.id.tv);
            Veritabani db=new Veritabani(getApplicationContext());
            List<Ogrenci> ogrenciList=new ArrayList<Ogrenci>();

            ogrenciList=db.TumKayitlariGetir();

            StringBuilder stringBuilder=new StringBuilder();
            for(final Ogrenci ogrenci:ogrenciList){
                stringBuilder.append(ogrenci.getAdSoyad()+"\n"+ogrenci.getMail()+"\n"+ogrenci.getAdres()+"\n\n");


       /*     tv.setOnLongClickListener(new View.OnLongClickListener(){
                @Override
                public boolean onLongClick(View v){
                        id=ogrenci.getId();
                        if(actionMode!=null){
                            return false;
                        }
                        ActionModeCallback callback = new MyActionModeCallback();
                        actionMode=startActionMode(callback);
                        v.setSelected(true);
                         return true;
                    }
                });*/

            }
            tv.setText(stringBuilder);
        }
        catch (Exception e){
            tv.setText("Herhangi bir kayıt bulunamadı..");


        }
    }
}

       /* class MyActionModeCallback implements ActionMode.Callback {
            @Override
            public boolean onCreateActionMode(ActionMode mode, Menu menu) {
                mode.getMenuInflater().inflate(R.menu.contex_menu,menu);
                return true;
            }

            @Override
            public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
                return false;
            }

            @Override
            public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
                switch (item.getItemId()){
                    case R.id.sil:
                        Veritabani db=new Veritabani(getApplicationContext());
                        db.Sil(id);
                        new Listele();
                        mode.finish();
                        return true;

                    case R.id.düzenle:
                        mode.finish();
                        return true;
                    default:
                        return false;
                }

            }

            @Override
            public void onDestroyActionMode(ActionMode mode) {

                actionMode=null;
            }*/
