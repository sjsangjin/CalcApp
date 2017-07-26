package com.example.pc.calcapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private TextView txtDisp;
    private ArrayList<String> values = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDisp = (TextView)findViewById(R.id.txtDisp);

        //첫번째 키그룹
        LinearLayout layKey1 = (LinearLayout)findViewById(R.id.layKey1);
        int childCount = layKey1.getChildCount();

        for(int i=0; i<childCount; i++) {
            View v = layKey1.getChildAt(i);

            if(v instanceof LinearLayout) {
                int btnCount = ((LinearLayout) v).getChildCount();  //v를 LinearLayout으로 캐스팅 why?view는 getChildCount()를 갖고있지않으므로 LinearLayout으로 캐스팅 후 사용
                for(int k=0; k<btnCount; k++){
                    View btnChild = ((LinearLayout) v).getChildAt(k);
                    if(btnChild instanceof Button) {    //layout 안에 다른 layout들이 있으므로 버튼에만 반응하게끔
                        btnChild.setOnClickListener(keyPadClick);
                    }
                }
            }//end if

        }//end for

        //두번째 키그룹
        LinearLayout layKey2 = (LinearLayout)findViewById(R.id.layKey2);
        childCount = layKey1.getChildCount();

        for(int i=0; i<childCount; i++) {
            View v = layKey2.getChildAt(i);
            if(v instanceof LinearLayout) {
                int btnCount = ((LinearLayout) v).getChildCount();
                for(int k=0; k<btnCount; k++){
                    View btnChild = ((LinearLayout) v).getChildAt(k);
                    if(btnChild instanceof Button) {       //layout안에 다른 layout들이 있으므로
                        btnChild.setOnClickListener(keyPadClick);
                    }
                }
            }//end if
        }

    }// end OnCreate()


    private View.OnClickListener keyPadClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if(v instanceof Button) {
                Button btn = (Button)v;
                String btnText = btn.getText().toString();

                switch (btnText){
                    case "+":
                        values.add( txtDisp.getText().toString() );
                        values.add("+");
                        txtDisp.setText("");
                        break;
                    case "-":
                        values.add( txtDisp.getText().toString() );
                        values.add("-");
                        txtDisp.setText("");
                        break;
                    case "/":
                        values.add( txtDisp.getText().toString() );
                        values.add("/");
                        txtDisp.setText("");
                        break;
                    case "*":
                        values.add( txtDisp.getText().toString() );
                        values.add("*");
                        txtDisp.setText("");
                        break;
                    case "=":
                        values.add( txtDisp.getText().toString() );
                        break;
                    default:
                        txtDisp.setText(  txtDisp.getText() + btnText  );
                }

                if(btnText.equals("=")) {
                    double result = 0;

                    for(int i=0; i<values.size(); i++) {
                        String val = values.get(i);
                        result = Double.parseDouble(values.get(i));

                        switch (val) {
                            case "+":
                                double p1 = Double.parseDouble( values.get(i+1) );
                                result += p1;
                                break;
                            case "*":
                                break;
                            case "-":
                                break;
                            case "/":
                                break;
                            default:
                                result = Double.parseDouble(val);
                        }//end switch
                    }//end for

                    values.clear();
                    txtDisp.setText( result + "" );

                }//end if

            }

        }//end onClick
    };//end OnClickListener
}
