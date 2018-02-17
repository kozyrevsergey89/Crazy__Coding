package com.kozyrev.study;

/**
 * Created by skozyrev on 2/17/18.
 */
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by Matskiv on 2/13/2018.
 */
public class Deck {
      ArrayList<Card> DeckCards = new ArrayList<>();
      ArrayList<Card> MyCards = new ArrayList<>();
      ArrayList<Card> CPUCards = new ArrayList<>();
      Scanner scanner = new Scanner(System.in);
    //      String commandInformation = scanner.nextLine();
      Random random = new Random();
      Card bybnu2 = new Card("bybnu", 2, "2");
      Card cresta7 = new Card("cersta", 7, "7");
      Card pika9 = new Card("pika", 9, "9");
      Card cerva10 = new Card("cerva", 10, "10");
      Card bybnuDama = new Card("bybnu", 3, "Dama");
      Card crestaValet = new Card("cresta", 2, "Valet");
      Card pikaKorol = new Card("pika", 4, "Korol");
      Card cervaTyz = new Card("cerva", 11, "Tyz");


    public   void CreateDeck() {
        DeckCards.add(bybnu2);
        DeckCards.add(cresta7);
        DeckCards.add(pika9);
        DeckCards.add(cerva10);
        DeckCards.add(bybnuDama);
        DeckCards.add(crestaValet);
        DeckCards.add(pikaKorol);
        DeckCards.add(cervaTyz);
        System.out.println(DeckCards.size());
    }

    public   boolean isTrueCommandStartGame(String command) {
        if (command.equals("Start a game")) {
            return true;
        } else {
            return false;
        }
    }

    public   boolean isTrueCommandGetOneCardPlayer(String command) {
        if (command.equals("Get one card for player")) {
            return true;
        } else {
            return false;
        }
    }

    public   boolean isTrueCommandGetOneCardCPU(String command) {
        if (command.equals("Get one card for CPU")) {
            return true;
        } else {
            return false;
        }
    }

    public   void getTwoCard() {
        int choseCard;
        int choseCard2;
        Card card;
        Card card2;
        choseCard = random.nextInt(DeckCards.size());
        choseCard2 = random.nextInt(DeckCards.size());
        card = DeckCards.get(choseCard);
        card2 = DeckCards.get(choseCard2);
        DeckCards.remove(choseCard);
        DeckCards.remove(choseCard2);
        MyCards.add(card);
        CPUCards.add(card2);
    }

    public   void getOneCardForPlayer() {
        int choseCard;
        Card card;
        choseCard = random.nextInt(DeckCards.size());
        card = DeckCards.get(choseCard);
        DeckCards.remove(choseCard);
        MyCards.add(card);
    }

    public   void getOneCardForCPU() {
        int choseCard;
        Card card;
        choseCard = random.nextInt(DeckCards.size());
        card = DeckCards.get(choseCard);
        DeckCards.remove(choseCard);
        CPUCards.add(card);

    }

//    public   void TestMethod() {
//        if (isTrueCommandGetOneCardPlayer())
//            getOneCardForPlayer();
//            System.out.println(DeckCards.size());
//            System.out.println(MyCards.size());
//          if (isTrueCommandGetOneCardCPU())
//            getOneCardForCPU();
//            System.out.println(DeckCards.size());
//            System.out.println(CPUCards.size());




    public   void doingAll() {
        int choseCard;
        String command = scanner.nextLine();

        Card card;
        if (isTrueCommandStartGame(command)) {
            getTwoCard();
            getTwoCard();
            System.out.println(DeckCards.size());
            System.out.println(MyCards.size());
            System.out.println(CPUCards.size());
        } else if (isTrueCommandGetOneCardPlayer(command)) {
            choseCard = random.nextInt(DeckCards.size());
            card = DeckCards.get(choseCard);
            DeckCards.remove(choseCard);
            MyCards.add(card);
            getOneCardForPlayer();
            System.out.println(DeckCards.size());
            System.out.println(MyCards.size());
            System.out.println(CPUCards.size());
        } else if (isTrueCommandGetOneCardCPU(command)) {
            choseCard = random.nextInt(DeckCards.size());
            card = DeckCards.get(choseCard);
            DeckCards.remove(choseCard);
            CPUCards.add(card);
            getOneCardForCPU();
            System.out.println(DeckCards.size());
            System.out.println(MyCards.size());
            System.out.println(CPUCards.size());
        } else {
            System.out.println("You entered invalid information");
        }
    }
}



