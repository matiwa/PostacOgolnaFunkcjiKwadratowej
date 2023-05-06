package com.example.postaoglnafunkcjikwadratowej;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText ea,eb,ec;
    TextView tv;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ea=findViewById(R.id.ea);
        eb=findViewById(R.id.eb);
        ec=findViewById(R.id.ec);
        tv=findViewById(R.id.tv);
        btn=findViewById(R.id.btn);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String bufor="";
                try{
                    double a,b,c,x1,x2,d,p,q;

                    a=Double.parseDouble(ea.getText().toString());
                    b=Double.parseDouble(eb.getText().toString());
                    c=Double.parseDouble(ec.getText().toString());
                    bufor="Postać kanoniczna funkcji kwadratowej:\r\n";
                    bufor+="y="+a+"x*x+"+b+"x+"+c+"\r\n\r\n";
                    if(a>0) bufor+="a>0\r\nRamiona paraboli skierowane do góry\r\n\r\n";
                    else if(a<0) bufor+="a<0\r\nRamiona paraboli skierowane w dół\r\n\r\n";
                    d=b*b-4*a*c;
                    if(d>0){
                        x1=(-b-Math.sqrt(d))/(2*a);
                        x2=(-b+Math.sqrt(d))/(2*a);
                        bufor+="Miejsca zerowe:\r\n"+"x1="+x1+"\r\nx2="+x2+"\r\n";
                        p=(-b)/(2*a);
                        q=(-d)/(4*a);
                        bufor+="\r\n\r\nWierzchołek paraboli W:\r\np="+p+"\r\nq="+q;
                    }else if(d==0){
                        p=(-b)/(2*a);
                        q=(-d)/(4*a);
                        bufor+="Miejsce zerowe (wierzchołek paraboli W:\r\np="+p+"\r\nq="+q;
                    }else if(d<0){
                        p=(-b)/(2*a);
                        q=(-d)/(4*a);
                        bufor+="Brak miejsc zerowych\r\n\r\nWierzchołek paraboli W:\r\np="+p+"\r\nq="+q;
                    }
                }catch(Exception blad){
                    Toast.makeText(MainActivity.this,blad.getMessage(),Toast.LENGTH_LONG).show();
                }finally {
                    ea.setText("");
                    eb.setText("");
                    ec.setText("");
                    tv.setText(bufor);
                }
            }
        });
    }
}