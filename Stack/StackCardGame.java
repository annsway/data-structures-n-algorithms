import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class StackCardGame {

    public static void main(String[] args){

        // Card game rules:
        // 1. Player A plays a card, player B plays a card, till there's no card on hand
        // 2. If there a card with the same number already on the table,
        //      then the player will collect all the cards behind that card on the table
        //      including the card she just played, excluding that card on the table
        // 3. The game stops whenever a player has no cards on hand

        Stack<Integer> cardStack = new Stack<>(); // the card stack on the table
        Queue<Integer> playerA = new LinkedList<>();
        Queue<Integer> playerB = new LinkedList<>();

        int mark[] = new int[10]; // this is the key to mark whether or not a card is on the table

        System.out.println("Please enter the cards on players' hands (1-9): ");
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
                playerA.remove(); // give out the first element from queue A
                cardStack.push(a);
                mark[a] = 1; // mark 'a=1' to indicate it's already shown on the table
            }
            // when Player A wins cards
            else if (mark[a] == 1){
                playerA.remove(); // remove the first element 'a' from hand
                playerA.add(a); // add the 'a' to the queue immediately

                while(cardStack.lastElement()!=a){
                    mark[cardStack.lastElement()] = 0; // mark as 0 to indicate the card has been taken out from the table
                    playerA.add(cardStack.lastElement()); // add the card from table to the hands of player A
                    cardStack.pop(); // remove the card from the table
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
            System.out.print("A wins! \nThe cards on A's hands' are: ");
            while(!playerA.isEmpty()){
                System.out.print(playerA.peek()+" ");
                playerA.remove();
            }
        }

        System.out.print("\nThe cards on the table are: "+cardStack);

    }

}
