package tictactoe.qvalue.com.tictactoe;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    // 0=yellow 1 =red

    int activPlayer= 0 ;


    boolean gameIsAvtive = true;

    //2 = unplayed

    int [] gameState  = {2,2,2,2,2,2,2,2,2};

    int [] [] winningPositions = { {0,1,2} , {3,4,5} ,{6,7,8} ,{0,3,6} ,{1,4,7} ,{2,5,8} ,{0,4,8} ,{2,4,6} };

    public  void dropIn(View view){

        ImageView counter = (ImageView)  view;


        int tappedCounter =Integer.parseInt( counter.getTag().toString());


        if(gameState[tappedCounter] ==2  && gameIsAvtive) {

            gameState[tappedCounter] =activPlayer;

            counter.setTranslationY(-1000f);

            if (activPlayer == 0) {
                counter.setImageResource(R.drawable.yellow);
                activPlayer = 1;

            } else {
                counter.setImageResource(R.drawable.red);
                activPlayer = 0;
            }

            counter.animate().translationYBy(1000f).rotation(3600).setDuration(300);

            for (int []  winpos : winningPositions){


                if(gameState[winpos[0]]==gameState[winpos[1]]  &&
                        gameState[winpos[1]] == gameState[winpos[2]] && gameState[winpos[0]] !=2 )
                {

                    //Some one win
                    gameIsAvtive=false;
                    String winner ="Red";

                       if(gameState[winpos[0] ] ==0){


                          winner="Yellow";

                       }

                    TextView wimnnerMessage = (TextView)findViewById(R.id.winnerMessage);

                    wimnnerMessage.setText( winner+ " has  Won!!!! ");


                    LinearLayout linearLayout = (LinearLayout) findViewById(R.id.playAgainLayout);

                    linearLayout.setVisibility(view.VISIBLE);
                }
                else
                {

                    boolean gameIsOver = true;
                    for(int countetStae  : gameState)
                    {
                        if(countetStae == 2){

                            gameIsOver=false;
                        }
                    }

                    if(gameIsOver){


                        TextView wimnnerMessage = (TextView)findViewById(R.id.winnerMessage);

                        wimnnerMessage.setText( "It's a draw");


                        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.playAgainLayout);

                        linearLayout.setVisibility(view.VISIBLE);
                    }
                }



            }




        }
    }


    public  void  playAgain(View view){

        gameIsAvtive=true;
        LinearLayout linearLayout = (LinearLayout)findViewById(R.id.playAgainLayout);
        linearLayout.setVisibility(view.INVISIBLE);

        activPlayer =0;

        for (int  i=0 ;  i < gameState.length; i++){
            gameState[i]=2;
        }

        GridLayout gridLayout = (GridLayout)findViewById(R.id.gridLayout  );

        for(int  i = 0 ;  i < gridLayout.getChildCount(); i++){


            ( (ImageView) gridLayout.getChildAt(i)).setImageResource(0);
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
