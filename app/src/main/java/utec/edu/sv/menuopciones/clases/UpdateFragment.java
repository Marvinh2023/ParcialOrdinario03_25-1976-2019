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


public class UpdateFragment extends Fragment {
    EditText txtNombre, txtApellido,txtTelefono,txtEmail;
    Button btnUpdate;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragmento_update,container,false);

        txtNombre = view.findViewById(R.id.edtNombre);
        txtApellido = view.findViewById(R.id.edtApellido);
        txtTelefono = view.findViewById(R.id.edtTelefono);
        txtEmail = view.findViewById(R.id.edtEmail);
        btnUpdate = view.findViewById(R.id.btnEliminar);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
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

                int cat = bd.update("contactos",informacion,"email= '"+email+"'",null);
                bd.close();
                if(cat == 1){
                    Toast.makeText(getActivity().getApplicationContext(), "Se modifico el registro", Toast.LENGTH_LONG).show();
                }
                else
                {
                    Toast.makeText(getActivity().getApplicationContext(), "No se modifico el registro", Toast.LENGTH_LONG).show();
                }
            }
        });

        return view;
    }
}
