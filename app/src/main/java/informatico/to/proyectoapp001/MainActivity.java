package informatico.to.proyectoapp001;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
public class MainActivity extends AppCompatActivity {
    //creamos las variables de las clases EditText y TextView
    EditText num1, num2;
    TextView resultado;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //para el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //llamamo a la imagen por su nombre que tiene que estar en drawable
        getSupportActionBar().setIcon(R.drawable.ic_action_name);
        //inicilizamos a las variables locales con los Id de los Xml
        num1 = (EditText) findViewById(R.id.edtnum1);
        num2 = (EditText) findViewById(R.id.edtnum2);
        btnCalcular = (Button) findViewById(R.id.btncalcular);
        resultado = (TextView) findViewById(R.id.TxVresultado);
        /*esta vez creamos un evento listener que estara
         escuchando cada vez que hagamos click en el button*/
        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //contatenamos las variables inicilizadas para que ese conviertan en string
                String num01 = num1.getText().toString();
                String num02 = num2.getText().toString();
                /*en esta parte verificaremos para que nuestra
                 aplicacion no se caiga cuando este en vacio los EditText
                 utilizamos la condicion if para preguntar si esta vacio */
                if (num01.equals("") && num02.equals("")){
                    //si se cumple la condicion
                    //bottamos los errores
                    num1.setError(null);
                    //Indicamos que las cajas de texto envie un mensaje
                    num1.setError("Introduce un número");
                    num2.setError("Introduce un número");
                    //muestra el Foco
                    num1.requestFocus();
                    num2.requestFocus();
                    //Mostramos un toast
                    Toast.makeText(getApplicationContext(), "Ingrese Datos Numericos"   , Toast.LENGTH_SHORT).show();
                    //retornamos
                    return;
                }
                else {
                    //si la condicion if no se cumple entonces pasa al else entonces:
                    //creamos dos variables int y concatenamos los variables cadena a numerico
                    int nro1 = Integer.parseInt(num01);
                    int nro2 = Integer.parseInt(num02);
                    //creamos otra variable llamada suma donde realizamos la operacion suma +
                    int suma = nro1 + nro2;
                    //creamos nuevamente una variable y concatenamos las suma para que sea cadena string
                    String resul = String.valueOf(suma);
                    //lo pintamos en el TextView mediante el metodo setText
                    resultado.setText(resul);
                   //limpiamos las cajas de texto o EditText
                    num1.setText("");
                    num2.setText("");
                    //Mostramos un toast
                    Toast.makeText(getApplicationContext(), "La Suma es : " + resul, Toast.LENGTH_SHORT).show();
                }

            }
        });


    }
    /*public void Calcular(View v) {
        String num01 = num1.getText().toString();
        String num02 = num2.getText().toString();
        int nro1 = Integer.parseInt(num01);
        int nro2 = Integer.parseInt(num02);
        int suma = nro1 + nro2;
        String resul = String.valueOf(suma);
        resultado.setText(resul);
        num1.setText("");
        num2.setText("");
        Toast.makeText(getApplicationContext(), "La Suma es : " + resul, Toast.LENGTH_SHORT).show();
    }*/
}