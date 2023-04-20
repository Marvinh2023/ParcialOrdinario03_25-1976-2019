package utec.edu.sv.menuopciones.clases;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import utec.edu.sv.menuopciones.Helper.AdminSQLiteOpenHelper;
import utec.edu.sv.menuopciones.R;


public class AddFragment extends Fragment {
    EditText txtNombre, txtApellido,txtTelefono,txtEmail;
    Button btnInsert;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmento_add,container,false);
        txtNombre = view.findViewById(R.id.edtNombre);
        txtApellido = view.findViewById(R.id.edtApellido);
        txtTelefono = view.findViewById(R.id.edtTelefono);
        txtEmail = view.findViewById(R.id.edtEmail);
        btnInsert = view.findViewById(R.id.btnEliminar);

        btnInsert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AdminSQLiteOpenHelper admin = new AdminSQLiteOpenHelper(getActivity().getApplicationContext(), "parcial", null,1);
                SQLiteDatabase bd =  admin.getWritableDatabase();
                String nombre = txtNombre.getText().toString();
                String apellido = txtApellido.getText().toString();
                String telefono = txtTelefono.getText().toString();
                String email = txtEmail.getText().toString();

                ContentValues informacion  = new ContentValues();
                informacion.put("nombre",nombre);
                informacion.put("apellido",apellido);
                informacion.put("telefono",telefono);
                informacion.put("email",email);
                try {
                    bd.insert("contactos",null,informacion);
                    bd.close();
                    Toast.makeText(getActivity().getApplicationContext(), "Se inserto el registro", Toast.LENGTH_LONG).show();
                }catch (Exception e){
                    Toast.makeText(getActivity().getApplicationContext(), ""+e.getCause(), Toast.LENGTH_LONG).show();
                }
            }
        });
        return view;
    }
}
