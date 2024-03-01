package com.example.assign05_6406021631019;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import android.os.Handler;
import android.widget.Toast;

public class MatchingGameActivity extends AppCompatActivity implements View.OnClickListener{
    public ConstraintLayout constraintLayout;
    //กำหนดชนิดของตัวแปล
    private CountDownTimer countDownTimer;
    private Button playBtn,stopBtn;
    private TextView timerTextview;
    private TextView scoreTextview;

    private ImageButton imageButton1,imageButton2,imageButton3,imageButton4,
            imageButton5,imageButton6,imageButton7,imageButton8,
            imageButton9,imageButton10,imageButton11,imageButton12,
            imageButton13,imageButton14,imageButton15,imageButton16;

    private String[] imageNames ={"a1","a2","a3","a4","a5","a6","a7","a8","a9","a10"};


    private int imageNum1, imageNum2, imageNum3, imageNum4, imageNum5, imageNum6, imageNum7, imageNum8,
            imageNum9, imageNum10, imageNum11, imageNum12, imageNum13, imageNum14, imageNum15, imageNum16
            , imageNum17, imageNum18, imageNum19,imageNum20;

    private Map<String, Integer> imageCounter = new HashMap<>();
    public int additionalScore;
    private int[] clickCount = new int[17]; // ตัวแปรเก็บจำนวนครั้งที่คลิกที่แต่ละปุ่ม
    private int[] imageNum = new int[21]; // ตัวแปรเก็บรหัสรูปภาพที่จะตั้งค่าให้กับปุ่มที่คลิก
    private int[] checkImageNum = new int[3];
    private ImageButton[] imageButtons = new ImageButton[17];

    private MediaPlayer mPlayer;
    private Button btn[] = new Button[3];

    private Button playMusicBtn,stopMusicBtn;
    private boolean loop = false;

    private int mySong = R.raw.music;

    private int[] checkIndex = new int[3];

    private boolean playCheck = false;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matching_game);

        constraintLayout = (ConstraintLayout) findViewById(R.id.constraintLayout); //ดึงค่าตัวแปล

        playBtn = (Button) findViewById(R.id.playBtn); //set ค่า ปุ่ม playBtn
        playBtn.setOnClickListener(this);

        stopBtn = (Button) findViewById(R.id.stopBtn); //set ค่า ปุ่ม stopBtn
        stopBtn.setOnClickListener(this);

        timerTextview = (TextView) findViewById(R.id.timerTextview); //set ค่า ปุ่ม timerTextview ไว้แสดงเวลา
        scoreTextview = (TextView) findViewById(R.id.scoreTextview); //set ค่า ปุ่ม scoreTextview ไว้แสดงคะแนน

        imageButton1  = (ImageButton) findViewById(R.id.imageButton1); //set ค่า ปุ่มทั้ง 16 ปุ่ม
        imageButton2  = (ImageButton) findViewById(R.id.imageButton2);
        imageButton3  = (ImageButton) findViewById(R.id.imageButton3);
        imageButton4  = (ImageButton) findViewById(R.id.imageButton4);
        imageButton5  = (ImageButton) findViewById(R.id.imageButton5);
        imageButton6  = (ImageButton) findViewById(R.id.imageButton6);
        imageButton7  = (ImageButton) findViewById(R.id.imageButton7);
        imageButton8  = (ImageButton) findViewById(R.id.imageButton8);
        imageButton9  = (ImageButton) findViewById(R.id.imageButton9);
        imageButton10 = (ImageButton) findViewById(R.id.imageButton10);
        imageButton11 = (ImageButton) findViewById(R.id.imageButton11);
        imageButton12 = (ImageButton) findViewById(R.id.imageButton12);
        imageButton13 = (ImageButton) findViewById(R.id.imageButton13);
        imageButton14 = (ImageButton) findViewById(R.id.imageButton14);
        imageButton15 = (ImageButton) findViewById(R.id.imageButton15);
        imageButton16 = (ImageButton) findViewById(R.id.imageButton16);

        imageButton1.setOnClickListener(this); //set ค่า ปุ่มทั้ง 16 ปุ่ม
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
        imageButton7.setOnClickListener(this);
        imageButton8.setOnClickListener(this);
        imageButton9.setOnClickListener(this);
        imageButton10.setOnClickListener(this);
        imageButton11.setOnClickListener(this);
        imageButton12.setOnClickListener(this);
        imageButton13.setOnClickListener(this);
        imageButton14.setOnClickListener(this);
        imageButton15.setOnClickListener(this);
        imageButton16.setOnClickListener(this);

        imageCounter.clear(); //ให้เคลียค่าเมื่อเริ่มเปิดใหม่

        imageNum1 = randomizeImageResource(); //สุ่มค่ารูป ใส่ตัวแปล เตรีนมนำแสดง
        imageNum2 = randomizeImageResource();
        imageNum3 = randomizeImageResource();
        imageNum4 = randomizeImageResource();
        imageNum5 = randomizeImageResource();
        imageNum6 = randomizeImageResource();
        imageNum7 = randomizeImageResource();
        imageNum8 = randomizeImageResource();
        imageNum9 = randomizeImageResource();
        imageNum10 = randomizeImageResource();
        imageNum11 = randomizeImageResource();
        imageNum12 = randomizeImageResource();
        imageNum13 = randomizeImageResource();
        imageNum14 = randomizeImageResource();
        imageNum15 = randomizeImageResource();
        imageNum16 = randomizeImageResource();
        imageNum17 = randomizeImageResource();
        imageNum18 = randomizeImageResource();
        imageNum19 = randomizeImageResource();
        imageNum20 = randomizeImageResource();

        imageNum[1] = imageNum1; //นำรูปที่สุ่มมาทำเป็น Array
        imageNum[2] = imageNum2;
        imageNum[3] = imageNum3;
        imageNum[4] = imageNum4;
        imageNum[5] = imageNum5;
        imageNum[6] = imageNum6;
        imageNum[7] = imageNum7;
        imageNum[8] = imageNum8;
        imageNum[9] = imageNum9;
        imageNum[10] = imageNum10;
        imageNum[11] = imageNum11;
        imageNum[12] = imageNum12;
        imageNum[13] = imageNum13;
        imageNum[14] = imageNum14;
        imageNum[15] = imageNum15;
        imageNum[16] = imageNum16;
        imageNum[17] = imageNum17;
        imageNum[18] = imageNum18;
        imageNum[19] = imageNum19;
        imageNum[20] = imageNum20;

        additionalScore = 0;
        checkImageNum[1] = 0;
        checkImageNum[2] = 0;

        imageButtons[1] = imageButton1;
        imageButtons[2] = imageButton2;
        imageButtons[3] = imageButton3;
        imageButtons[4] = imageButton4;  //นำปุ่มมาทำเป็น Array
        imageButtons[5] = imageButton5;
        imageButtons[6] = imageButton6;
        imageButtons[7] = imageButton7;
        imageButtons[8] = imageButton8;
        imageButtons[9] = imageButton9;
        imageButtons[10] = imageButton10;
        imageButtons[11] = imageButton11;
        imageButtons[12] = imageButton12;
        imageButtons[13] = imageButton13;
        imageButtons[14] = imageButton14;
        imageButtons[15] = imageButton15;
        imageButtons[16] = imageButton16;

        System.out.println("ฟังชั่น onCreate!"); //ไว้เช็คตอนโปรแกรมทำงานว่าตอนนี้ทำงานอยู่ส่วนไหน

        playMusicBtn = (Button) findViewById(R.id.playMusicBtn); // set ค่าปุ่มกดเล่นเพลง
        playMusicBtn.setOnClickListener( this);
        stopMusicBtn = (Button) findViewById(R.id.stopMusicBtn);
        stopMusicBtn.setOnClickListener( this);

        mPlayer = MediaPlayer.create( this, mySong); // สร้างตัวแปลมาใส่ค่าเพลง
        mPlayer.setLooping(loop);


        checkIndex[1] = 0;
        checkIndex[2] = 0;


    }
    @Override
    public void onClick(View view) {
        System.out.println("ฟังชั่น onClick!"); //ไว้เช็คตอนโปรแกรมทำงานว่าตอนนี้ทำงานอยู่ส่วนไหน

        int viewId = view.getId();
        if (viewId == R.id.playBtn) {// ถ้ากดปุ่ม "เริ่มเกม"
            System.out.println("PLAY BTN");
            additionalScore = 0; //set Score ให้เป็น 0
            stopGame();

            System.out.println("PlayBtn"); //ไว้เช็คตอนโปรแกรมทำงานว่าตอนนี้ทำงานอยู่ส่วนไหน
            // เริ่มเกม
            countDownTimer = new CountDownTimer(60000, 1000) {
                // 60 วินาที (60,000 มิลลิวินาที) และแสดงเวลาทุกๆ 1 วินาที
                @Override
                public void onTick(long millisUntilFinished) {
                    // แสดงเวลาที่เหลือใน TextView
                    timerTextview.setText("Time: " + millisUntilFinished / 1000);

                    startGame(viewId);
                }//1000
                @Override
                public void onFinish() {
                    timerTextview.setText("Time: 0"); // เมื่อนับถึง 0 แสดงข้อความ "Time's up!"
                    checkScore();
                    Handler handler = new Handler();     //สร้างตัวหน่ยงเวลาให่้แสดงคะแนนก่อนปิด
                    handler.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            // เรียกใช้ฟังก์ชันที่จะทำงานเมื่อเกมจบ
                            stopGame();
                        }
                    }, 5000);
                    System.out.println("Time's up!"); //ไว้เช็คตอนโปรแกรมทำงานว่าตอนนี้ทำงานอยู่ส่วนไหน


                }
            }.start(); //เริ่มเกมโดยเรียกเมธอด startGame() เพื่อเตรียมเกม
            playCheck = true;//ไว้เช็คการทำงานของปุ่มplay
        }
        else if (viewId == R.id.stopBtn) {
            countDownTimer.cancel();
            timerTextview.setText("Time: 0");
            System.out.println("StopBtn"); //ไว้เช็คตอนโปรแกรมทำงานว่าตอนนี้ทำงานอยู่ส่วนไหน
            // หยุดการนับถอยหลังเมื่อกดปุ่ม "หยุดเกม"
            if (countDownTimer != null) {
                countDownTimer.cancel();// หยุดนับถอยหลัง
                stopGame();
            }

            playCheck = false; //ไว้เช็คการทำงานของปุ่มplay
        }
        else if (playCheck == true){//ไว้เช็คการทำงานของปุ่มplay

            startGame(viewId);// เริ่มเกม
        }

        if (viewId == R.id.playMusicBtn) {// ถ้ากดปุ่ม "เริ่มเกม"
            mPlayer.start();

        } else if (viewId == R.id.stopMusicBtn) {
            mPlayer.pause();
        }

    }

    protected void startGame(int viewId) {
        System.out.println("ฟังชั่น startGame!");

        System.out.println("เปรียบเทียบค่า imageNum1 = " +imageNum1+" imageNum[1] = "+imageNum[1]);

        if (viewId == R.id.imageButton1) {
            imageButton1.setImageResource(imageNum1);
            clickCount[1]++; // เพิ่มค่า clickCount ของปุ่มที่ถูกคลิก
            checkIfTwoButtonsClicked(); // เรียกใช้ฟังก์ชันเช็คการคลิกสองปุ่ม
            mPlayer.start();

        } else if (viewId == R.id.imageButton2) {
            imageButton2.setImageResource(imageNum2);
            clickCount[2]++; // เพิ่มค่า clickCount ของปุ่มที่ถูกคลิก
            checkIfTwoButtonsClicked(); // เรียกใช้ฟังก์ชันเช็คการคลิกสองปุ่ม

        } else if (viewId == R.id.imageButton3) {
            imageButton3.setImageResource(imageNum3);
            clickCount[3]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton4) {
            imageButton4.setImageResource(imageNum4);
            clickCount[4]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton5) {
            imageButton5.setImageResource(imageNum5);
            clickCount[5]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton6) {
            imageButton6.setImageResource(imageNum6);
            clickCount[6]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton7) {
            imageButton7.setImageResource(imageNum7);
            clickCount[7]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton8) {
            imageButton8.setImageResource(imageNum8);
            clickCount[8]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton9) {
            imageButton9.setImageResource(imageNum9);
            clickCount[9]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton10) {
            imageButton10.setImageResource(imageNum10);
            clickCount[10]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton11) {
            imageButton11.setImageResource(imageNum11);
            clickCount[11]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton12) {
            imageButton12.setImageResource(imageNum12);
            clickCount[12]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton13) {
            imageButton13.setImageResource(imageNum13);
            clickCount[13]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton14) {
            imageButton14.setImageResource(imageNum14);
            clickCount[14]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton15) {
            imageButton15.setImageResource(imageNum15);
            clickCount[15]++;
            checkIfTwoButtonsClicked();

        } else if (viewId == R.id.imageButton16) {
            imageButton16.setImageResource(imageNum16);
            clickCount[16]++;
            checkIfTwoButtonsClicked();
        }
    }
    private void checkIfTwoButtonsClicked() {
        System.out.println("ฟังชั่น checkIfTwoButtonsClicked!");
        // ตรวจสอบว่ามีการคลิกปุ่มครบสองครั้งหรือไม่
        int clickedButtonsCount = 0;
        int lastClickedButtonIndex = 0;

        for (int i = 0; i < clickCount.length; i++) {
            if (clickCount[i] >= 1) {
                System.out.println("ค่า clickCount[i] = " +clickCount[i]);
                System.out.println("ค่า I = " +i);
                System.out.println("===========");
                clickedButtonsCount++;

                //เก็บค่าปุ่มที่กดวในครั้งที่่ 1 ว่าปุ่มไหน
                if (clickedButtonsCount == 1 || checkIndex[1] == 0){
                    if (i == 1) {
                        checkIndex[1] = 1;
                    } else if (i == 2) {
                        checkIndex[1] = 2;
                    } else if (i == 3) {
                        checkIndex[1] = 3;
                    } else if (i == 4) {
                        checkIndex[1] = 4;
                    } else if (i == 5) {
                        checkIndex[1] = 5;
                    } else if (i == 6) {
                        checkIndex[1] = 6;
                    } else if (i == 7) {
                        checkIndex[1] = 7;
                    } else if (i == 8) {
                        checkIndex[1] = 8;
                    } else if (i == 9) {
                        checkIndex[1] = 9;
                    } else if (i == 10) {
                        checkIndex[1] = 10;
                    } else if (i == 11) {
                        checkIndex[1] = 11;
                    } else if (i == 12) {
                        checkIndex[1] = 12;
                    } else if (i == 13) {
                        checkIndex[1] = 13;
                    } else if (i == 14) {
                        checkIndex[1] = 14;
                    } else if (i == 15) {
                        checkIndex[1] = 15;
                    } else if (i == 16) {
                        checkIndex[1] = 16;
                    }

                }//เก็บค่าปุ่มที่กดวในครั้งที่่ 2 ว่าปุ่มไหน
                else if(clickedButtonsCount == 2 || checkIndex[2] == 0){
                    if (i == 1) {
                        checkIndex[2] = 1;
                    } else if (i == 2) {
                        checkIndex[2] = 2;
                    } else if (i == 3) {
                        checkIndex[2] = 3;
                    } else if (i == 4) {
                        checkIndex[2] = 4;
                    } else if (i == 5) {
                        checkIndex[2] = 5;
                    } else if (i == 6) {
                        checkIndex[2] = 6;
                    } else if (i == 7) {
                        checkIndex[2] = 7;
                    } else if (i == 8) {
                        checkIndex[2] = 8;
                    } else if (i == 9) {
                        checkIndex[2] = 9;
                    } else if (i == 10) {
                        checkIndex[2] = 10;
                    } else if (i == 11) {
                        checkIndex[2] = 11;
                    } else if (i == 12) {
                        checkIndex[2] = 12;
                    } else if (i == 13) {
                        checkIndex[2] = 13;
                    } else if (i == 14) {
                        checkIndex[2] = 14;
                    } else if (i == 15) {
                        checkIndex[2] = 15;
                    } else if (i == 16) {
                        checkIndex[2] = 16;
                    }

                }


            }

        }

        System.out.println("ค่าการคริก == "+ clickedButtonsCount );
        //int num1 = checkImageNum[1];
        //int num2 = lastClickedButtonIndex;

        int num1 = checkIndex[1]; //เก็บค่าปุ่มที่กดวในครั้งที่่ 1 ว่าปุ่มไหน
        int num2 = checkIndex[2]; //เก็บค่าปุ่มที่กดวในครั้งที่่ 2 ว่าปุ่มไหน
        System.out.println("ค่า รูป1 = " +num1);
        System.out.println("ค่า รูป2 = " +num2);
        // ถ้ามีการคลิกปุ่มครบสองครั้ง
        if (clickedButtonsCount == 2) {
            //int imageNum1 = imageNum[clickCount[1]];
            //int imageNum2 = imageNum[clickCount[2]];
            int imageNum1 = imageNum[num1]; //นำตัวแปลรูปที่แสดงไปเก็บ
            int imageNum2 = imageNum[num2];

            // เรียกใช้ฟังก์ชันที่จะทำการเช็ครูปภาพที่ตั้งค่าให้กับปุ่มที่คลิก
            checkMatch(imageNum1, imageNum2,num1,num2);

            // รีเซ็ตค่า clickCount เพื่อเตรียมรับคลิกใหม่
            Arrays.fill(clickCount, 0);
            checkImageNum[1] = 0;
            checkImageNum[2] = 0;
            checkIndex[1] = 0;
            checkIndex[2] = 0;
        }
    }


    // ฟังก์ชันที่ใช้ในการเปรียบเทียบรูปภาพ
    private void checkMatch(int imageNum1, int imageNum2,int num1, int num2) {
        int closenum1 = num1;
        int closenum2 = num2;
        System.out.println("ฟังชั่น checkMatch!");
        //System.out.println("ค่า imageNum1 = "+imageNum1);
        //System.out.println("ค่า imageNum2 = "+imageNum2);
        // เช็คว่ารูปภาพทั้งสองตรงกันหรือไม่
        if (imageNum1 == imageNum2) {// และเปรียบเทียบรูปภาพว่าตรงกันหรือไม่
            System.out.println("รูปภาพตรงกัน!");
            increaseScore();
            checkImageNum[1] = 0;
            checkImageNum[2] = 0;
            System.out.println("*************************************************************");

        } else {
            System.out.println("รูปภาพไม่ตรงกัน!");
            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    // เรียกใช้ฟังก์ชันที่จะทำการปิดรูป
                    closeImages(closenum1, closenum2);
                    //stopGame();
                    System.out.println("*************************************************************");
                }
            }, 1000);
        }
    }
    private void closeImages(int num1,int num2) {
        // ปิดรูปที่เปิดอยู่
        int imageResource = getResources().getIdentifier("a11", "drawable", getPackageName());
        imageButtons[num1].setImageResource(imageResource);
        imageButtons[num2].setImageResource(imageResource);
    }




    private int randomizeImageResource() {
        System.out.println("ฟังชั่น randomizeImageResource!");
        int randomIndex;
        String imageName;
        int imageResource;
        // สุ่ม index ของรูปภาพจาก imageNames และตรวจสอบว่ารูปนั้นถูกสุ่มไปแล้วกี่ครั้ง
        do {
            randomIndex = randomInRange(0, imageNames.length - 1);
            imageName = imageNames[randomIndex];

        } while (imageCounter.getOrDefault(imageName, 0) >= 2); // ถ้ารูปนี้ถูกสุ่มไปแล้วสองครั้งขึ้นไป ให้สุ่มใหม่

        imageResource = getResources().getIdentifier(imageName, "drawable", getPackageName());
        // เพิ่มจำนวนครั้งที่รูปถูกสุ่ม
        imageCounter.put(imageName, imageCounter.getOrDefault(imageName, 0) + 1);
        return imageResource;

    }
    private int randomInRange(int min, int max) { //กำหนดตำแหน่งการสุ่ม
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }



    private void increaseScore() { //ฟังชั่นเพิ่มคะแนน ทีละ1
        System.out.println("ฟังชั่น increaseScore!");
        additionalScore ++;
        String newText = "Score : " + additionalScore;
        scoreTextview.setText(newText);
    }

    private void checkScore() {
        if (additionalScore >= 8) {
            // แสดงข้อความชนะบนโทรศัพท์
            Toast.makeText(this, "คุณชนะ YOU WIN", Toast.LENGTH_SHORT).show();
        } else {
            // แสดงข้อความแพ้บนโทรศัพท์
            Toast.makeText(this, "คุณแพ้", Toast.LENGTH_SHORT).show();
        }
    }

    private void stopGame() {  // กำหนดรูปภาพเป็น a11 สำหรับทุกปุ่ม
        int imageResource = getResources().getIdentifier("a11", "drawable", getPackageName());
        imageButton1.setImageResource(imageResource);
        imageButton2.setImageResource(imageResource);
        imageButton3.setImageResource(imageResource);
        imageButton4.setImageResource(imageResource);
        imageButton5.setImageResource(imageResource);
        imageButton6.setImageResource(imageResource);
        imageButton7.setImageResource(imageResource);
        imageButton8.setImageResource(imageResource);
        imageButton9.setImageResource(imageResource);
        imageButton10.setImageResource(imageResource);
        imageButton11.setImageResource(imageResource);
        imageButton12.setImageResource(imageResource);
        imageButton13.setImageResource(imageResource);
        imageButton14.setImageResource(imageResource);
        imageButton15.setImageResource(imageResource);
        imageButton16.setImageResource(imageResource);
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (countDownTimer != null) {
            countDownTimer.cancel(); // ยกเลิกการนับถอยหลังเมื่อหน้าจอหยุดทำงาน
            checkScore();
        }
    }

    //สร้าง OptionsMenu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.option_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    // เรียกใช้ OptionsMenu
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if(item.getItemId() == R.id.Calculator){ //ถ้าคริกปุ่มนี้ .Calculator จะไป CalculatorActivity
            Toast.makeText( this, "AutoComplete", Toast.LENGTH_SHORT).show();
            Intent launchAdapterViewFipper = new Intent(this,CalculatorActivity.class);
            startActivity(launchAdapterViewFipper);
            return true;
        }
        else if(item.getItemId() == R.id.MatchingGame){ //ถ้าคริกปุ่มนี้ MatchingGame จะไป MatchingGameActivity
            Toast.makeText( this, "MatchingGameActivity", Toast.LENGTH_SHORT).show();
            Intent launchAdapterViewFipper = new Intent(this,MatchingGameActivity.class);
            startActivity(launchAdapterViewFipper);
            return true;
        }
        else if(item.getItemId() == R.id.exit){ //ถ้าคริกปุ่มนี้ exit จะไปกลับไปหน้า main menu
            Toast.makeText( this, "Exit", Toast.LENGTH_SHORT).show();
            finish();
            return true;
        }
        else
        {return super.onOptionsItemSelected(item);}

    }

}