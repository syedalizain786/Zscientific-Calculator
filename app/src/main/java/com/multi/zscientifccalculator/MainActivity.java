package com.multi.zscientifccalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import org.mariuszgromada.math.mxparser.*;

public class MainActivity extends AppCompatActivity {

    private TextView previousCalculations;
    private EditText displayText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayText =findViewById(R.id.displaytext);
        previousCalculations =findViewById(R.id.previousCalculations);
        displayText.setShowSoftInputOnFocus(false);
    }
    private void updateText(String strToAdd) {
        String oldStr=displayText.getText().toString();
        int cursorPosi=displayText.getSelectionStart();
        String leftStr=oldStr.substring(0,cursorPosi);
        String rightStr=oldStr.substring(cursorPosi);

        displayText.setText(String.format("%s%s%s",leftStr,strToAdd,rightStr));
        displayText.setSelection(cursorPosi+strToAdd.length());
    }
    public void oneBTNPush(View view){
        updateText(getResources().getString(R.string.oneText));
    }
    public void twoBTNPush(View view){
            updateText(getResources().getString(R.string.twoText));
        }
    public void threeBTNPush(View view){
            updateText(getResources().getString(R.string.threeText));
        }
    public void fourBTNPush(View view){
            updateText(getResources().getString(R.string.fourText));
        }
    public void fiveBTNPush(View view){
            updateText(getResources().getString(R.string.fiveText));
        }
    public void sixBTNPush(View view){
            updateText(getResources().getString(R.string.sixText));
        }
    public void sevenBTNPush(View view){
            updateText(getResources().getString(R.string.sevenText));
        }
    public void eightBTNPush(View view){
            updateText(getResources().getString(R.string.eightText)) ;
        }
    public void nineBTNPush(View view){
            updateText(getResources().getString(R.string.nineText));
        }
    public void zeroBTNPush(View view){
            updateText(getResources().getString(R.string.zeroText));
        }
    public void plusBTNPush(View view){
            updateText(getResources().getString(R.string.addText));
        }
    public void minusBTNPush(View view){
            updateText(getResources().getString(R.string.subtractText));
        }
    public void multiplyBTNPush(View view){
            updateText(getResources().getString(R.string.multiplyText));
        }
    public void divideBTNPush(View view){
            updateText(getResources().getString(R.string.divideText));
        }
    public void decimalBTNPush(View view){
            updateText(getResources().getString(R.string.decimalText));
        }
    public void clearBTNPush(View view){
        displayText.setText("");
        previousCalculations.setText("");
        }
    public void parenthopenBTNPush(View view){
            updateText(getResources().getString(R.string.parenthesesOpenText));
        }

    public void parenthcloseBTNPush(View view){
            updateText(getResources().getString(R.string.parenthesesCloseText));
        }
    public void equalBTNPush(View view){
            String userExp=displayText.getText().toString();

            previousCalculations.setText(userExp);
            userExp =userExp.replaceAll(getResources().getString(R.string.divideText),"/");

            userExp =userExp.replaceAll(getResources().getString(R.string.multiplyText),"*");

            Expression exp=new Expression(userExp);
            String result=String.valueOf(exp.calculate());

            displayText.setText(result);
            displayText.setSelection(result.length());

        }
    public void backspaceBTNPush(View view){
            int cursorPosition=displayText.getSelectionStart();
            int textLen=displayText.getText().length();

            if(cursorPosition !=0 && textLen !=0){
                SpannableStringBuilder selection=(SpannableStringBuilder) displayText.getText();
                selection.replace(cursorPosition-1,cursorPosition,"");
                displayText.setText(selection);
                displayText.setSelection(cursorPosition-1);
            }

        }

    public void SinBTNPush(View view){
        updateText("sin(");
    }
    public void cosBTNPush(View view){
        updateText("cos(");

    }
    public void tanBTNPush(View view){
        updateText("tan(");
    }
    public void arcSinBTNPush(View view){
        updateText("arcsin(");
    }
    public void arcCosBTNPush(View view){
        updateText("arccos(");
    }
    public void arcTanBTNPush(View view){
        updateText("arctan(");

    }
    public void nLogBTNPush(View view){
        updateText("ln(");
    }
    public void logBTNPush(View view){
        updateText("log(");
    }
    public void absoluteValueBTNPush(View view){
        updateText("abs(");
    }
    public void piBTNPush(View view){
        updateText("pi");
    }
    public void underRootBTNPush(View view){
        updateText("sqrt(");
    }
    public void etextBTNPush(View view){
        updateText("e");

    }
    public void xPowYBTNPush(View view){
        updateText("^(");
    }

    public void isPrimeTextBTNPush(View view){
        updateText("ispr(");

    }
    public void xSquaredBTNPush(View view){
        updateText("^(2)");
	//Sample checking local for github
    }
}