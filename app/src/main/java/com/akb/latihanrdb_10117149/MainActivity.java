package com.akb.latihanrdb_10117149;

/*
Tanggal Pengerjaan : 30 April 2020
Deskripsi Pengerjaan : Membuat awal project sampai selesai =
- MainActivity, AktivisDao, AktivisEntity, AppDatabase
NIM : 10117149
NAMA : M NIZAR MIFTAHUL ULYA
KELAS : IF4
 */

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    private AktivisEntity aktivisEntity;
    public static AppDatabase db;

    //Atribut untuk mendisplay hasil data
    List<AktivisEntity> aktivisEntities = new ArrayList<>();
    List<AktivisEntity> aktivisEntityListByZone = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class,"aktivis")
                .allowMainThreadQueries().build();

        //TAMBAH DATA
        aktivisEntity = new AktivisEntity();
        aktivisEntity.setNamaAktivis("M Nizar Miftahul Ulya");
        aktivisEntity.setEmailAktivis("nizarmu7@gmail.com");
        aktivisEntity.setZonaTugas("Majalengka");

        Log.d("TAMBAH","Tambah Data Aktivis");
        Log.d("TAMBAH","===================");
        Log.d("TAMBAH","Nama : "+aktivisEntity.getNamaAktivis());
        Log.d("TAMBAH","Email : "+aktivisEntity.getEmailAktivis());
        Log.d("TAMBAH","Zona : "+aktivisEntity.getZonaTugas());

        db.aktivisDao().tambahAktivis(aktivisEntity);

        //TAMPIL SELURUH DATA
        Log.d("TAMPIL","Tampil seluruh data aktivis");
        Log.d("TAMPIL","===========================");

        aktivisEntities = db.aktivisDao().tampilSeluruhAktivis();

        for (int i = 0; i<aktivisEntities.size(); i++){

            Log.d("TAMPIL","Data Ke-"+(i+1));
            Log.d("TAMPIL","Nama : "+aktivisEntities.get(i).getNamaAktivis());
            Log.d("TAMPIL","Email : "+aktivisEntities.get(i).getEmailAktivis());
            Log.d("TAMPIL","Zona : "+aktivisEntities.get(i).getZonaTugas());
            Log.d("TAMPIL","========================");
        }

        //TAMPIL BERDASARKAN ZONA
        Log.e("ZONE","Data Aktivis berdasarkan Zona");
        Log.e("ZONE","===================");
        aktivisEntityListByZone = db.aktivisDao().findByZone("Majalengka");
        for (int i = 0 ;i <aktivisEntityListByZone.size();i++){
            Log.e("ZONE","Data Aktivis Ke-"+(i+1));
            Log.e("ZONE",aktivisEntityListByZone.get(i).getNamaAktivis());
            Log.e("ZONE",aktivisEntityListByZone.get(i).getEmailAktivis());
            Log.e("ZONE",aktivisEntityListByZone.get(i).getZonaTugas());
            Log.e("ZONE","===================");
        }
    }
}
