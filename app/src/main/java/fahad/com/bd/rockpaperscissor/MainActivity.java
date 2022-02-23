package fahad.com.bd.rockpaperscissor;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button rock_btn,scissor_btn,paper_btn;
    TextView tv_score;
    ImageView iv_HumanChoice,iv_computerchoice;
    int HumanScore,ComputerScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        rock_btn=(Button) findViewById(R.id.rock_btn);
        scissor_btn=(Button) findViewById(R.id.scissor_btn);
        paper_btn=(Button) findViewById(R.id.paper_btn);
        iv_computerchoice=(ImageView) findViewById(R.id.iv_computerchoice);
        iv_HumanChoice=(ImageView) findViewById(R.id.iv_HumanChoice);
        tv_score=(TextView) findViewById(R.id.tv_score);

        rock_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.rock);
                String message=play_turn("rock");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: "+Integer.toString(HumanScore)+" Computer: "+Integer.toString(ComputerScore));


            }
        });

        paper_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.paper);
                String message=play_turn("paper");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: "+Integer.toString(HumanScore)+" Computer: "+Integer.toString(ComputerScore));

            }
        });

        scissor_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iv_HumanChoice.setImageResource(R.drawable.seccior);
                String message =play_turn("scissor");
                Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
                tv_score.setText("Score Human: "+Integer.toString(HumanScore)+" Computer: "+Integer.toString(ComputerScore));

            }
        });
    }
    public String play_turn(String player_choice){
        String computer_choice="";
        Random r=new Random();
//        chose 1,2 or 3
        int computer_choice_number=r.nextInt(3)+1;
        if(computer_choice_number==1){
            computer_choice="rock";
        }else
        if(computer_choice_number==2){
            computer_choice="scissor";
        }else
        if(computer_choice_number==3){
            computer_choice="paper";
        }
//        set the computer image based of his choice
        if(computer_choice=="rock"){
            iv_computerchoice.setImageResource(R.drawable.rock);
        }else
        if(computer_choice=="scissor"){
            iv_computerchoice.setImageResource(R.drawable.seccior);
        }else
        if(computer_choice=="rock"){
            iv_computerchoice.setImageResource(R.drawable.paper);
        }

//        computer  human and computer choice to determine who win
        if (computer_choice==player_choice) {
            return "Draw.Nobody Won.";
        }
        else if(player_choice=="rock"&&computer_choice=="scissor"){
            HumanScore++;
            return "Rock curshes scissors.You win!";
        }
        else if(player_choice=="rock"&&computer_choice=="paper"){
            ComputerScore++;
            return "Paper Covers Rock.Computer win!";
        }
        else if(player_choice=="scissor"&&computer_choice=="rock"){
            ComputerScore++;
            return "Rock curshes scissors.You win!.Computer win!";
        }
        else if(player_choice=="scissor"&&computer_choice=="paper"){
            HumanScore++;
            return "scissor cut paper.You win!";
        }
        else if(player_choice=="paper"&&computer_choice=="rock"){
            HumanScore++;
            return "Paper Covers Rock.You win!";
        }
        else if(player_choice=="paper"&&computer_choice=="scissor"){
            ComputerScore++;
            return "scissor cut paper.You win!.Computer win!";
        }
        else return "Thank You";
    }
}