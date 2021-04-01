package hr.ferit.drazetic.idealhouse;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;



public class QuizActivity extends AppCompatActivity {

        private TextView textViewQuestion;
        private TextView textViewQuestionCount;
        private RadioGroup rbGroup;
        private RadioButton rb1;
        private RadioButton rb2;
        private Button buttonConfirmNext;
       // private TextView numberic_answers;

        private ColorStateList textColorDefaultRb;

        private List<Question> questionList;

        private int questionCounter;
        private int questionCountTotal;
        private Question currentQuestion;
        String listB=new String();

       public static final String EXTRA_TEXT= "hr.ferit.drazetic.idealhouse.EXTRA_TEXT";


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_quiz);

            textViewQuestion=findViewById(R.id.text_view_question);
            textViewQuestionCount=findViewById(R.id.text_view_question_count);
            rbGroup = findViewById(R.id.radio_group);
            rb1 = findViewById(R.id.radio_button1);
            rb2 = findViewById(R.id.radio_button2);
            buttonConfirmNext = findViewById(R.id.button_confirm_next);

           // numberic_answers=findViewById(R.id.brojac_odgovora);

            textColorDefaultRb=rb1.getTextColors();



            QuizDbHelper dbHelper = new QuizDbHelper(this);
            questionList = dbHelper.getAllQuestions();

            questionCountTotal=questionList.size();


            showNextQuestion();

            buttonConfirmNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (buttonConfirmNext.getText()=="Show house")
                    { showHouse();}

                    else if (rb1.isChecked() || rb2.isChecked() ) {
                        showNextQuestion();
                    } else {
                        Toast.makeText(QuizActivity.this, "Please select an answer", Toast.LENGTH_SHORT).show();
                    }

                }
            });


        }

    public void showHouse () {

        Intent intent =new Intent(QuizActivity.this, ShowHouseActivity.class);
            intent.putExtra(EXTRA_TEXT,  listB);
        startActivity(intent);
    }



        private void showNextQuestion(){
            RadioButton rbSelected = findViewById(rbGroup.getCheckedRadioButtonId());
            int answerNr = rbGroup.indexOfChild(rbSelected) + 1;
            listB = listB + answerNr;
            //numberic_answers.setText(listB);


            if (questionCounter == questionCountTotal) {
                buttonConfirmNext.setText("Show house");
                buttonConfirmNext.setBackgroundColor(Color.GRAY);


            }
            else {

                rb1.setTextColor(textColorDefaultRb);
                rb2.setTextColor(textColorDefaultRb);
                rbGroup.clearCheck();

                if (questionCounter < questionCountTotal) {
                    currentQuestion = questionList.get(questionCounter);

                    textViewQuestion.setText(currentQuestion.getQuestion());
                    rb1.setText(currentQuestion.getOption1());
                    rb2.setText(currentQuestion.getOption2());

                    questionCounter++;
                    textViewQuestionCount.setText("Question: " + questionCounter + "/" + questionCountTotal);


                } else {
                    finishQuiz();
                }
            }
        }




        private void finishQuiz() {
            finish();
        }

}


