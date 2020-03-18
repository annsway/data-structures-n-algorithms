import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackCardGame {

    public static void main(String[] args){

        Stack<Integer> cardStack = new Stack<>(); // the card stack on the table
        Queue<Integer> playerA = new LinkedList<>();
        Queue<Integer> playerB = new LinkedList<>();

        int mark[] = new int[10]; // a total of 10 cards will be played

        System.out.println("Please enter the cards on players' hands: ");
        Scanner input = new Scanner(System.in);

        // deal the cards
        for (int i=0; i<6; i++){
            playerA.add(input.nextInt());
        }

        for (int i=0; i<6; i++){
            playerB.add(input.nextInt());
        }

        for (int i=0; i<10; i++){
            mark[i]=0;
        }

        while(!playerA.isEmpty()&&!playerB.isEmpty()){

            //////////// Player A

            int a = playerA.peek(); // get the first element of playerA

            // when Player loses cards
            if(mark[a] == 0){ // if this card is not on the table
                playerA.remove(); // give out the card from playerA
                cardStack.push(a);
                mark[a] = 1; // mark 'a=1' to indicate it's already shown on the table
            }
            // when Player A wins cards
            else if (mark[a] == 1){
                playerA.remove(); // remove the first element 'a' from hand
                playerA.add(a); // add the first 'a' from the table to hand

                while(cardStack.lastElement()!=a){
                    mark[cardStack.lastElement()] = 0;
                    playerA.add(cardStack.lastElement());
                    cardStack.pop();
                }
            }

            //////////// Player B

            int b = playerB.peek();

            if(mark[b]==0){
                playerB.remove();
                cardStack.add(b);
                mark[b]=1;
            } else if(mark[b]==1){
                playerB.remove();
                playerB.add(b);

                while(cardStack.lastElement()!=b){
                    mark[cardStack.lastElement()]=0;
                    playerB.add(cardStack.lastElement());
                    cardStack.pop();
                }

            }


        }

        if (playerA.isEmpty()){
            System.out.println("B wins! \nThe cards on B's hands' are: ");
            while(!playerB.isEmpty()){
                System.out.print(playerB.peek()+" ");
                playerB.remove();
            }
        } else {
            System.out.println("A wins! \nThe cards on A's hands' are: ");
            while(!playerA.isEmpty()){
                System.out.print(playerA.peek()+" ");
                playerA.remove();
            }
        }


    }

}
