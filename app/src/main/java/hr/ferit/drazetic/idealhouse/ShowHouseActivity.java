package hr.ferit.drazetic.idealhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ShowHouseActivity extends AppCompatActivity {
    private ImageView imageView1;
    private Button button_show_house1;
    private TextView textview1;
    private String text;
    private String text1="01111";
    private String text2="01112";
    private String text3="01121";
    private String text4="01122";
    private String text5="01211";
    private String text6="01212";
    private String text7="01221";
    private String text8="01222";
    private String text9="02111";
    private String text10="02112";
    private String text11="02121";
    private String text12="02122";
    private String text13="02211";
    private String text14="02212";
    private String text15="02221";
    private String text16="02222";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_house);
        button_show_house1= (Button) findViewById(R.id.button_show_house) ;
        imageView1 = (ImageView) findViewById(R.id.picture_house_show);


       Intent intent=getIntent();
       text =intent.getStringExtra(QuizActivity.EXTRA_TEXT);
       textview1=(TextView) findViewById(R.id.text_house_show1);

       showHouse();

       button_show_house1.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {
               repeateQuiz();
           }
       });



    }
    private void showHouse()
    {
        if (text.equals(text1)) {
            imageView1.setImageResource(R.drawable.house1111);
            textview1.setText("Yellow single story house with black complex roof.");
        }
        else if (text.equals(text2)) {
            imageView1.setImageResource(R.drawable.house1112);
            textview1.setText("Yellow single story house with red complex roof.");
        }
        else if (text.equals(text3)) {
            imageView1.setImageResource(R.drawable.house1121);
            textview1.setText("Yellow single story house with black simple roof.");
        }
        else if (text.equals(text4)) {
            imageView1.setImageResource(R.drawable.house1122);
            textview1.setText("Yellow single story house with red simple roof.");
        }
        else if (text.equals(text5)) {
            imageView1.setImageResource(R.drawable.house1211);
            textview1.setText("Gray single story house with black complex roof.");
        }
        else if (text.equals(text6)) {
            imageView1.setImageResource(R.drawable.house1212);
            textview1.setText("Gray single story house with red complex roof.");
        }
        else if (text.equals(text7)) {
            imageView1.setImageResource(R.drawable.house1221);
            textview1.setText("Gray single story house with black simple roof.");
        }
        else if (text.equals(text8)) {
            imageView1.setImageResource(R.drawable.house1222);
            textview1.setText("Gray single story house with red simple roof.");
        }
        else if (text.equals(text9)) {
            imageView1.setImageResource(R.drawable.house2111);
            textview1.setText("Yellow double story house with black complex roof.");
        }
        else if (text.equals(text10)) {
            imageView1.setImageResource(R.drawable.house2112);
            textview1.setText("Yellow double story house with red complex roof.");
        }
        else if (text.equals(text11)) {
            imageView1.setImageResource(R.drawable.house2121);
            textview1.setText("Yellow double story house with black simple roof.");
        }
        else if (text.equals(text12)) {
            imageView1.setImageResource(R.drawable.house2122);
            textview1.setText("Yellow double story house with red simple roof.");
        }
        else if (text.equals(text13)) {
            imageView1.setImageResource(R.drawable.house2211);
            textview1.setText("Gray double story house with black complex roof.");
        }
        else if (text.equals(text14)) {
            imageView1.setImageResource(R.drawable.house2212);
            textview1.setText("Gray double story house with red complex roof.");
        }
        else if (text.equals(text15)) {
            imageView1.setImageResource(R.drawable.house2221);
            textview1.setText("Gray double story house with black simple roof.");
        }
        else if (text.equals(text16)) {
            imageView1.setImageResource(R.drawable.house2222);
            textview1.setText("Gray double story house with red simple roof.");
        }

    }

    private void repeateQuiz () {
        Intent intent =new Intent(ShowHouseActivity.this, MainActivity.class);
        startActivity(intent);
    }
}
