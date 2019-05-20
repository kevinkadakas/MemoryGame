package com.kevinkadakas.memorygame;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lvl3 extends AppCompatActivity {

    TextView Min,Sec, points;
    Handler update;
    Runnable updateTimer;
    ToggleButton btn1,btn2,btn3,btn4,btn5,btn6, btn7, btn8, btn9, btn10, btn11, btn12;
    Integer[] img = {R.mipmap.memorygame01, R.mipmap.memorygame02, R.mipmap.memorygame03, R.mipmap.memorygame04, R.mipmap.memorygame05, R.mipmap.memorygame06};
    List<Integer> randimg = new ArrayList<>();
    List<Integer> randbtn = new ArrayList<>();
    List<ToggleButton> pair = new ArrayList<>();
    Dialog FinishDiag;
    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef;
    DatabaseReference count;
    int prefix = 0;
    String value;
    Boolean exists;
    Boolean written = false;
    Boolean comp = true;
    Map<String, String> userData = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lvl3);
        btn1 = findViewById(R.id.button20);
        btn2 = findViewById(R.id.button21);
        btn3 = findViewById(R.id.button22);
        btn4 = findViewById(R.id.button23);
        btn5 = findViewById(R.id.button24);
        btn6 = findViewById(R.id.button25);
        btn7 = findViewById(R.id.button26);
        btn8 = findViewById(R.id.button27);
        btn9 = findViewById(R.id.button28);
        btn10 = findViewById(R.id.button29);
        btn11 = findViewById(R.id.button30);
        btn12 = findViewById(R.id.button31);

        Min = findViewById(R.id.minutelvl3);
        Sec = findViewById(R.id.secoundlvl3);
        points = findViewById(R.id.textView16);

        randimg.add(0,0);
        randimg.add(1,1);
        randimg.add(2,2);
        randimg.add(3,3);
        randimg.add(4,4);
        randimg.add(5,5);
        randimg.add(6,0);
        randimg.add(7,1);
        randimg.add(8,2);
        randimg.add(9,3);
        randimg.add(10,4);
        randimg.add(11,5);

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
        randbtn.add(10,10);
        randbtn.add(11,11);

        Intent intent = getIntent();

        myRef = database.getReference("User");

        Min.setText(intent.getStringExtra("minut"));
        Sec.setText(intent.getStringExtra("sekund"));
        points.setText(intent.getStringExtra("punktid"));

        FinishDiag = new Dialog(this);

        final ToggleButton[] btn = {btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btn10, btn11, btn12};

        Collections.shuffle(randimg);
        Collections.shuffle(randbtn);
        for (int i = 0 ; i < 12;) {
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
        btn11.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn11.setBackgroundResource(img[btn11.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn11.setBackgroundResource(R.mipmap.memorygame07);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                }
            }
        });
        btn12.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    btn12.setBackgroundResource(img[btn12.getPaintFlags()]);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Next(btn);
                        }
                    }, 1);
                } else {
                    btn12.setBackgroundResource(R.mipmap.memorygame07);
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
        FinishDiag.setContentView(R.layout.popup_window);
        TextView minut, sekund, nimi, punktid;
        Button finishBtn;
        minut = FinishDiag.findViewById(R.id.textView24);
        sekund = FinishDiag.findViewById(R.id.textView26);
        nimi = FinishDiag.findViewById(R.id.name);
        punktid = FinishDiag.findViewById(R.id.punktid);
        finishBtn = FinishDiag.findViewById(R.id.finishBtn);
        Intent intent = getIntent();
        final String name = intent.getStringExtra("name");
        nimi.setText(name);
        minut.setText(min);
        sekund.setText(sec);
        punktid.setText(points);
        userData.put("Time", (min + ":" + sec));
        userData.put("Points", points);
        String s = min + "." + sec;
        int minu = Integer.parseInt(min) * 60;
        int secu = Integer.parseInt(sec);

        int val = Integer.parseInt(points) - secu;
        int mVal = Integer.parseInt(points) - minu - secu;

        if (minu == 0) {
            userData.put("arg", String.valueOf(val));
        } else {
            userData.put("arg", String.valueOf(mVal));
        }

        finishBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent aFinish = new Intent(lvl3.this, StartActivity.class);
                startActivity(aFinish);
                finish();
            }
        });

        if (!written) {
            myRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                    exists = dataSnapshot.hasChild(name + String.valueOf(prefix));
                    Log.d("DATA", String.valueOf(prefix));
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            if (exists && !written) {
                                prefix++;
                                Log.d("DATA", "EXIST");
                                ShowPopup(min, sec, points);
                            } else if (!exists && !written) {
                                if (prefix == 0) {
                                    written = true;
                                    userData.put("Name", name);
                                    myRef.child(name + String.valueOf(prefix)).setValue(userData);
                                } else {
                                    written = true;
                                    userData.put("Name", name + "(" + String.valueOf(prefix) + ")");
                                    myRef.child(name + String.valueOf(prefix)).setValue(userData);
                                }
                                Log.d("DATA", "ADD NEW");
                            }
                        }
                    }, 1);
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });
        }

        FinishDiag.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        FinishDiag.show();
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
                            points.setText(String.valueOf(Integer.parseInt(points.getText().toString())+15));
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
