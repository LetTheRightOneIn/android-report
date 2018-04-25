package com.example.a12481.calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import java.util.*;
import java.lang.*;


public class MainActivity extends AppCompatActivity {
    Button btn_0,btn_1,btn_2,btn_3,btn_4,btn_5,btn_6,btn_7,btn_8,btn_9,btn_pai
            ,btn_add,btn_sub,btn_mul,btn_div,btn_equ,btn_sin,btn_cos,btn_tan,btn_dd,
            btn_pf,btn_nf,btn_left,btn_right,btn_jiec,btn_log,btn_clean,btn_del;
    EditText resultEdit;
    String[] ss = new String[20] ;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_0=(Button)findViewById(R.id.button3 );
        btn_1=(Button)findViewById(R.id.button5 );
        btn_2=(Button)findViewById(R.id.button6 );
        btn_3=(Button)findViewById(R.id.button7);
        btn_4=(Button)findViewById(R.id.button8 );
        btn_5=(Button)findViewById(R.id.button9);
        btn_6=(Button)findViewById(R.id.button10 );
        btn_7=(Button)findViewById(R.id.button15 );
        btn_8=(Button)findViewById(R.id.button16 );
        btn_9=(Button)findViewById(R.id.button17 );
        btn_pai=(Button)findViewById(R.id.button2 );
        btn_add=(Button)findViewById(R.id.button12 );
        btn_sub=(Button)findViewById(R.id.button13 );
        btn_mul=(Button)findViewById(R.id.button14 );
        btn_div=(Button)findViewById(R.id.button18 );
        btn_equ=(Button)findViewById(R.id.button11 );
        btn_sin=(Button)findViewById(R.id.button21 );
        btn_cos=(Button)findViewById(R.id.button19 );
        btn_tan=(Button)findViewById(R.id.button20 );
        btn_dd=(Button)findViewById(R.id.button4 );
        btn_pf=(Button)findViewById(R.id.button22 );
        btn_nf=(Button)findViewById(R.id.button23 );
        btn_left=(Button)findViewById(R.id.button26 );
        btn_right=(Button)findViewById(R.id.button27 );
        btn_jiec=(Button)findViewById(R.id.button28 );
        btn_log=(Button)findViewById(R.id.button24 );
        btn_clean=(Button)findViewById(R.id.button25 );
        btn_del=(Button)findViewById(R.id.button29 );
        resultEdit=(EditText)findViewById(R.id.result);

        btn_del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index=resultEdit.getSelectionStart();
                String s1=(resultEdit.getText()).toString();
                if (!s1.equals("")) {//判断输入框不为空，执行删除
                    resultEdit.getText().delete(index-1,index);
                }
            }
        });
        btn_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_0.getText());
            }
        });
        btn_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_1.getText());
            }
        });
        btn_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_2.getText());
            }
        });
        btn_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_3.getText());
            }
        });
        btn_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_4.getText());
            }
        });
        btn_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_5.getText());
            }
        });
        btn_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_6.getText());
            }
        });
        btn_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_7.getText());
            }
        });
        btn_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_8.getText());
            }
        });
        btn_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_9.getText());
            }
        });
        btn_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_left.getText());
            }
        });
        btn_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_right.getText());
            }
        });
        btn_clean.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.setText("");
            }
        });
        btn_pai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(String.valueOf(Math.PI));
            }
        });
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_add.getText());
            }
        });
        btn_sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_sub.getText());
            }
        });
        btn_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_mul.getText());
            }
        });
        btn_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_div.getText());
            }
        });

       btn_equ.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1,s2;
                s1 = (resultEdit.getText()).toString();
                s1+="=";
                StringBuffer temp = new StringBuffer();
                Stack <Character>opstack = new Stack<Character>();
                Stack <Double>numstack = new Stack<Double>();
                for(int k =0;k<s1.length();k++)
                {
                    char ch = s1.charAt(k);
                    if(isNumber(ch)== true)
                    {
                        temp.append(ch);
                    }
                    else
                    {
                        s2 = temp.toString();
                        if (!s2.isEmpty())
                        {
                            double num = Double.parseDouble(s2);
                            numstack.push(num);
                            temp = new StringBuffer();
                        }

                        while (!comparePri(ch, opstack) && !opstack.empty())
                        {
                            double b = numstack.pop();
                            double a = numstack.pop();
                            switch ((char)opstack.pop())
                            {
                                case '+':
                                    numstack.push(a + b);
                                    break;
                                case '-':
                                    numstack.push(a - b);
                                    break;
                                case '*':
                                    numstack.push(a * b);
                                    break;
                                case'/':
                                    numstack.push(a / b);
                                    break;
                                case'^':
                                    numstack.push(Math.pow(a, b));
                                    break;
                                default:
                                    break;
                            }
                        }

                        if(ch == '+'||ch == '-'||ch == '*'||ch == '/'||ch == '('||ch == ')'||ch == '^')
                        {
                            opstack.push(ch);
                            if(ch == ')')
                            {
                                opstack.pop();
                                opstack.pop();
                            }
                        }
                    }
                }
                    resultEdit.setText(numstack.pop().toString());
            }
            public boolean comparePri(char symbol,Stack symbolStack)
            {
                if(symbolStack.empty())
                {
                    return true;
                }
                char top = (char)symbolStack.peek();
                if(top =='(')
                {
                    return true;
                }
                switch (symbol) {
                    case '(':
                        return true;
                    case '*':
                    {
                        if(top=='+'||top == '-')
                        return true;
                        else
                            return false;
                    }
                    case '^':
                    {
                        if(top=='+'||top == '-'||top=='*'||top == '/')
                            return true;
                        else
                            return false;
                    }
                    case '/':
                    {
                        if(top=='+'||top == '-')
                            return true;
                        else
                            return false;
                    }
                    case '+':
                        return false;
                    case '-':
                        return false;
                    case ')':
                        return false;
                    case '=':
                        return false;
                    default:
                        break;

                }
                return true;
            }


       });

        btn_sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.valueOf(resultEdit.getText().toString());
                double b =Math.toRadians(a);//把数字90 转换成 90;
                resultEdit.setText(String.valueOf(Math.sin(b)));
            }
        });
        btn_cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.valueOf(resultEdit.getText().toString());
                double b =Math.toRadians(a);//把数字90 转换成 90;
                resultEdit.setText(String.valueOf(Math.cos(b)));
            }
        });
        btn_tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int a = Integer.valueOf(resultEdit.getText().toString());
                double b =Math.toRadians(a);//把数字90 转换成 90;
                resultEdit.setText(String.valueOf(Math.tan(b)));
            }
        });
        btn_dd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append(btn_dd.getText());
            }
        });
        btn_nf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append("^");
            }
        });
        btn_pf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultEdit.append("^2");
            }
        });
        btn_log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1 = (resultEdit.getText()).toString();
                resultEdit.setText(String.valueOf(Log(s1)));
            }
        });
        btn_jiec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s1;
                StringBuffer temp = new StringBuffer();
                s1 = (resultEdit.getText()).toString();
                for(int i=0;i<s1.length();i++)
                {
                    if(isNumber(s1.charAt(i))==false) {
                        temp.append(s1.charAt(i));
                    }
                }
                double num = Double.parseDouble(s1);
                double sum=1;
                for(double k =num;k>=1;k--)
                {
                    sum=sum*k;
                }
                resultEdit.setText(String.valueOf(sum));
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch(item.getItemId())
        {

        }
        return  true;
    }

    public boolean isNumber(char num) {
        if (num >= '0' && num <= '9'||num =='.') {
            return true;
        } else {
            return false;
        }
    }
    public double Log(String s1) {
        String s2;
        StringBuffer temp = new StringBuffer();
        Stack <Double>numstack = new Stack<Double>();
        for(int k =0;k<s1.length();k++) {
            char ch = s1.charAt(k);
            if (isNumber(ch) == true) {
                temp.append(ch);
            } else {
                s2 = temp.toString();
                if (!s2.isEmpty()) {
                    double num = Double.parseDouble(s2);
                    numstack.push(num);
                    temp = new StringBuffer();
                }
            }
        }
        double a = numstack.pop();
        double b = numstack.pop();
        double sum = Math.log(b) / Math.log(a);
        return  sum;
    }
}
