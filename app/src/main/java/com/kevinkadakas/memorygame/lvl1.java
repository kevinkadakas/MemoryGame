package com.kevinkadakas.memorygame;

import android.app.Dialog;
import android.content.Context;
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
import java.util.concurrent.ExecutionException;

public class lvl1 extends AppCompatActivity {

    TextView Min,Sec, points;
    Handler update;
    Runnable updateTimer;
    ToggleButton btn1,btn2,btn3,btn4,btn5,btn6;
    Integer[] img = {R.mipmap.memorygame01, R.mipmap.memorygame02, R.mipmap.memorygame03};
    List<Integer> randimg = new ArrayList<>();
    List<Integer> randbtn = new ArrayList<>();
    List<ToggleButton> pair = new ArrayList<>();
    Dialog NextDiag;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl1);
        Min = findViewById(R.id.minutelvl1);
        Sec = findViewById(R.id.secoundlvl1);
        btn1 = findViewById(R.id.button4);
        btn2 = findViewById(R.id.button5);
        btn3 = findViewById(R.id.button6);
        btn4 = findViewById(R.id.button7);
        btn5 = findViewById(R.id.button8);
        btn6 = findViewById(R.id.button9);
        points = findViewById(R.id.textView14);

        NextDiag = new Dialog(this);

        points.setText("100");
        randimg.add(0,0);
        randimg.add(1,1);
        randimg.add(2,2);
        randimg.add(3,0);
        randimg.add(4,1);
        randimg.add(5,2);
        randbtn.add(0,0);
        randbtn.add(1,1);
        randbtn.add(2,2);
        randbtn.add(3,3);
        randbtn.add(4,4);
        randbtn.add(5,5);
        final ToggleButton[] btn = {btn1, btn2, btn3, btn4, btn5, btn6};
        Collections.shuffle(randimg);
        Collections.shuffle(randbtn);
        for (int i = 0 ; i < 6;) {
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
                            Next(btn, NextDiag);
                        }
                    }, 1);
                } else {
                    btn1.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn, NextDiag);
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
                            Next(btn, NextDiag);
                        }
                    }, 1);
                } else {
                    btn2.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn, NextDiag);
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
                            Next(btn, NextDiag);
                        }
                    }, 1);
                } else {
                    btn3.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn, NextDiag);
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
                            Next(btn, NextDiag);
                        }
                    }, 1);
                } else {
                    btn4.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn, NextDiag);
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
                            Next(btn, NextDiag);
                        }
                    }, 1);
                } else {
                    btn5.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn, NextDiag);
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
                            Next(btn, NextDiag);
                        }
                    }, 1);
                } else {
                    btn6.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn, NextDiag);
                        }
                    }, 1);
                }
            }
        });
    }
    
    public void Next(ToggleButton[] btn, Dialog diag) {
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
                            points.setText(String.valueOf(Integer.parseInt(points.getText().toString())+5));
                            pair.add(btn[p]);
                            if (btn1.isChecked() && btn2.isChecked() && btn3.isChecked() && btn4.isChecked() && btn5.isChecked() && btn6.isChecked()) {
                                update.removeCallbacks(updateTimer);
                                ShowPopup(Min.getText().toString(), Sec.getText().toString(), points.getText().toString(), diag);
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

    public void ShowPopup(final String min, final String sec, final String points, final Dialog diag) {
        diag.setContentView(R.layout.popup_next);
        TextView minut, sekund, nimi, punktid;
        Button finishBtn;
        minut = diag.findViewById(R.id.textView24);
        sekund = diag.findViewById(R.id.textView26);
        nimi = diag.findViewById(R.id.name);
        punktid = diag.findViewById(R.id.punktid);
        finishBtn = diag.findViewById(R.id.finishBtn);

        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");

        nimi.setText(name);

        minut.setText(min);
        sekund.setText(sec);
        punktid.setText(points);

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                diag.dismiss();
                Intent nextlvl = new Intent(lvl1.this, lvl2.class);
                nextlvl.putExtra("name", name);
                nextlvl.putExtra("minut", min);
                nextlvl.putExtra("sekund", sec);
                nextlvl.putExtra("punktid", points);
                startActivity(nextlvl);
                finish();

            }
        });
        diag.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        diag.show();
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
