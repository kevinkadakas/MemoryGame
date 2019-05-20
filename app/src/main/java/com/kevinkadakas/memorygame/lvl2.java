package com.kevinkadakas.memorygame;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class lvl2 extends AppCompatActivity {

    TextView Min,Sec, points;
    Handler update;
    Runnable updateTimer;
    ToggleButton btn1,btn2,btn3,btn4,btn5,btn6, btn7, btn8, btn9, btn10;
    Integer[] img = {R.mipmap.memorygame01, R.mipmap.memorygame02, R.mipmap.memorygame03, R.mipmap.memorygame04, R.mipmap.memorygame05};
    List<Integer> randimg = new ArrayList<>();
    List<Integer> randbtn = new ArrayList<>();
    List<ToggleButton> pair = new ArrayList<>();
    Dialog NextDiag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl2);
        btn1 = findViewById(R.id.button10);
        btn2 = findViewById(R.id.button11);
        btn3 = findViewById(R.id.button12);
        btn4 = findViewById(R.id.button13);
        btn5 = findViewById(R.id.button14);
        btn6 = findViewById(R.id.button15);
        btn7 = findViewById(R.id.button16);
        btn8 = findViewById(R.id.button17);
        btn9 = findViewById(R.id.button18);
        btn10 = findViewById(R.id.button19);
        Min = findViewById(R.id.minutelvl2);
        Sec = findViewById(R.id.secoundlvl2);
        points = findViewById(R.id.textView15);

        NextDiag = new Dialog(this);

        randimg.add(0,0);
        randimg.add(1,1);
        randimg.add(2,2);
        randimg.add(3,3);
        randimg.add(4,4);
        randimg.add(5,0);
        randimg.add(6,1);
        randimg.add(7,2);
        randimg.add(8,3);
        randimg.add(9,4);

        randbtn.add(0,0);
        randbtn.add(1,1);
        randbtn.add(2,2);
        randbtn.add(3,3);
        randbtn.add(4,4);
        randbtn.add(5,5);
        randbtn.add(6,6);
        randbtn.add(7,7);
        randbtn.add(8,8);
        randbtn.add(9,9);

        Intent intent = getIntent();

        Min.setText(intent.getStringExtra("minut"));
        Sec.setText(intent.getStringExtra("sekund"));
        points.setText(intent.getStringExtra("punktid"));

        final ToggleButton[] btn = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10};

        Collections.shuffle(randimg);
        Collections.shuffle(randbtn);
        for (int i = 0 ; i < 10;) {
            btn[randbtn.get(i)].setPaintFlags(randimg.get(i));
            i++;
        }

        update = new Handler();
        updateTimer = new Runnable() {
            @Override
            public void run() {
                if ((Integer.parseInt(Sec.getText().toString())) <= 58) {
                    int time = Integer.parseInt(Sec.getText().toString()) + 1;
                    Sec.setText(String.valueOf(time));
                } else if ((Integer.parseInt(Sec.getText().toString())) == 59) {
                    int mTime = Integer.parseInt(Min.getText().toString()) + 1;
                    int sTime = 0;
                    Min.setText(String.valueOf(mTime));
                    Sec.setText(String.valueOf(sTime));
                }
                update.postDelayed(updateTimer, 1000);
            }
        };


        btn1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn1.setBackgroundResource(img[btn1.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn1.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
        btn2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn2.setBackgroundResource(img[btn2.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn2.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
        btn3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn3.setBackgroundResource(img[btn3.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn3.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
        btn4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn4.setBackgroundResource(img[btn4.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn4.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
        btn5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn5.setBackgroundResource(img[btn5.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn5.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
        btn6.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn6.setBackgroundResource(img[btn6.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn6.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
        btn7.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn7.setBackgroundResource(img[btn7.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn7.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
        btn8.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn8.setBackgroundResource(img[btn8.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn8.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
        btn9.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn9.setBackgroundResource(img[btn9.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn9.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
        btn10.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn10.setBackgroundResource(img[btn10.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn10.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
    }

    public void ShowPopup(final String min, final String sec, final String points) {
        NextDiag.setContentView(R.layout.popup_next);
        TextView minut, sekund, nimi, punktid;
        Button finishBtn;
        minut = NextDiag.findViewById(R.id.textView24);
        sekund = NextDiag.findViewById(R.id.textView26);
        nimi = NextDiag.findViewById(R.id.name);
        punktid = NextDiag.findViewById(R.id.punktid);
        finishBtn = NextDiag.findViewById(R.id.finishBtn);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");

        nimi.setText(name);

        minut.setText(min);
        sekund.setText(sec);
        punktid.setText(points);

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NextDiag.dismiss();
                Intent nextlvl = new Intent(lvl2.this, lvl3.class);
                nextlvl.putExtra("name", name);
                nextlvl.putExtra("minut", min);
                nextlvl.putExtra("sekund", sec);
                nextlvl.putExtra("punktid", points);
                startActivity(nextlvl);
                finish();

            }
        });
        NextDiag.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        NextDiag.show();
    }

    public void Next(ToggleButton[] btn) {
        for (int k = 0; k < btn.length;) {
            if (btn[k].isChecked() && !(pair.contains(btn[k]))) {
                btn[k].setEnabled(false);
                for (int p = 0; p < btn.length;) {
                    if (!(p == k) && btn[p].isChecked() && !(pair.contains(btn[p]))) {
                        if (btn[p].getPaintFlags() == btn[k].getPaintFlags()) {
                            pair.add(btn[k]);
                            btn[k].setChecked(true);
                            btn[p].setChecked(true);
                            btn[k].setEnabled(false);
                            btn[p].setEnabled(false);
                            points.setText(String.valueOf(Integer.parseInt(points.getText().toString())+10));
                            pair.add(btn[p]);
                            if (btn1.isChecked() && btn2.isChecked() && btn3.isChecked() && btn4.isChecked() && btn5.isChecked() && btn6.isChecked()) {
                                update.removeCallbacks(updateTimer);
                                ShowPopup(Min.getText().toString(), Sec.getText().toString(), points.getText().toString());
                            }
                        } else if (btn[p].getPaintFlags() != btn[k].getPaintFlags()) {
                            try {
                                Thread.sleep(500);
                                points.setText(String.valueOf(Integer.parseInt(points.getText().toString())-10));
                                btn[k].setBackgroundResource(R.mipmap.memorygame07);
                                btn[p].setBackgroundResource(R.mipmap.memorygame07);
                                btn[p].setChecked(false);
                                btn[k].setChecked(false);
                                btn[p].setEnabled(true);
                                btn[k].setEnabled(true);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    p++;
                }
            }
            k++;
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        updateTimer.run();
    }
    @Override
    protected void onStop() {
        super.onStop();
        update.removeCallbacks(updateTimer);
    }
}
