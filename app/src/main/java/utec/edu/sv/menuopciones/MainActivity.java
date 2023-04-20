package utec.edu.sv.menuopciones;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

//import utec.edu.sv.menuopciones.clases.CamFragment;
import utec.edu.sv.menuopciones.clases.AddFragment;
import utec.edu.sv.menuopciones.clases.DeleteFragment;
import utec.edu.sv.menuopciones.clases.SearchFragment;
import utec.edu.sv.menuopciones.clases.UpdateFragment;

public class MainActivity extends AppCompatActivity {
    BottomNavigationView btnNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNav=findViewById(R.id.btnNav);

        btnNav.setOnNavigationItemSelectedListener( (BottomNavigationView.OnNavigationItemSelectedListener) navListener);

    }

    private BottomNavigationView.OnNavigationItemSelectedListener navListener = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            Fragment seleccionFrag = null;

            switch (item.getItemId()){
                case R.id.nav_home:
                    seleccionFrag = new AddFragment();
                    break;
                case R.id.nav_fav:
                    seleccionFrag = new UpdateFragment();
                    break;
                case R.id.nav_camera:
                    seleccionFrag = new DeleteFragment();
                    break;
                /*case R.id.nav_busqeuda:
                    seleccionFrag = new SearchFragment();
                    break;*/
            }
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContent, seleccionFrag).commit();
            return true;
        }

    };
    public boolean onCreateOptionsMenu(Menu menu){
        //return super.onCreateOptionsMenu(menu);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_configuraciones, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem items){
        Intent intent =  new Intent(this, Sumar.class);
        switch (items.getItemId()){
            /*case R.id.opcion1:
                Toast.makeText(this, "Selecciono la opcion 1", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                return true;
            case R.id.opcion2:
                Toast.makeText(this, "Selecciono la opcion 2", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion3:
                Toast.makeText(this, "Selecciono la opcion 3", Toast.LENGTH_SHORT).show();
                return true;
            case R.id.opcion4:
                Toast.makeText(this, "Selecciono la opcion 4", Toast.LENGTH_SHORT).show();
                return true;*/
        }
        return super.onOptionsItemSelected(items);
    }
}