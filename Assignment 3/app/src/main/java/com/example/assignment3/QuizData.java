package com.example.assignment3;

import java.util.ArrayList;
import java.util.Collections;

public class QuizData {
    public static ArrayList<QuizQuestion> getQuizQuestions() {
        ArrayList<QuizQuestion> quizQuestions = new ArrayList<>();

        quizQuestions.add(new QuizQuestion("Napoleon Bonaparte was attacked by 3,000 bunnies. The bunnies charged toward Bonaparte and his men in a viscous and unstoppable onslaught.", true, R.drawable.image1));
        quizQuestions.add(new QuizQuestion("Captain Morgan from the famous rum, was a real person - Sir Capitan Henry Morgan.", true, R.drawable.image2));
        quizQuestions.add(new QuizQuestion("The 37th president of the United States, Richard Nixon, actually was an extremely talented musician. He played five instruments in total: piano, saxophone, clarinet, accordion, and violin.", true, R.drawable.image3));
        quizQuestions.add(new QuizQuestion("Businessman LaMarcus Thompson hated that Americans were tempted by places like saloons and brothels. So in Coney Island in New York, he built America’s first roller coaster to give New Yorkers some good, clean fun.", true, R.drawable.image4));
        quizQuestions.add(new QuizQuestion("Octopuses and Squids have three hearts. One pumps blood to their whole systems, and two are dedicated just to the gills.", true, R.drawable.image5));
        quizQuestions.add(new QuizQuestion("Before toilet paper was invented, Americans used to use corn cobs.", true, R.drawable.image6));
        quizQuestions.add(new QuizQuestion("Michelangelo wrote a poem about how much he hated painting the Sistine Chapel.", true, R.drawable.image7));
        quizQuestions.add(new QuizQuestion("British military tanks are equipped to make tea.", true, R.drawable.image8));
        quizQuestions.add(new QuizQuestion("During the 1952 Great Smog of London, blind people helped others get home because they could find their way without seeing.", true, R.drawable.image9));
        quizQuestions.add(new QuizQuestion("Alexander von Humbolt learned a language that had died 40 years earlier from a parrot who still spoke some words.", true, R.drawable.image10));
        quizQuestions.add(new QuizQuestion("In 2010, Iran banned mullet haircuts.", true, R.drawable.image11));
        quizQuestions.add(new QuizQuestion("Botanically speaking, bananas are technically berries, but strawberries are not.", true, R.drawable.image12));
        quizQuestions.add(new QuizQuestion("The Eiffel Tower was originally constructed as a giant lightning rod to attract storms away from Paris.", false, R.drawable.image13));
        quizQuestions.add(new QuizQuestion("If you stack all the elephants in the world on top of each other, they would reach the moon.", false, R.drawable.image14));
        quizQuestions.add(new QuizQuestion("In ancient Egypt, it was believed that cats could predict the future by observing the patterns of sand grains.", false, R.drawable.image15));
        quizQuestions.add(new QuizQuestion("The Great Wall of China was built to keep out invading armies, but it was also designed to keep out aggressive pandas.", false, R.drawable.image16));
        quizQuestions.add(new QuizQuestion("Mount Rushmore was originally intended to feature the faces of famous musicians, but funding ran out and the US government said they would fund the project if the four presidents were carved.", false, R.drawable.image17));
        quizQuestions.add(new QuizQuestion("There's a hidden underground city beneath New York City where people live like characters from the 1920s.", false, R.drawable.image18));
        quizQuestions.add(new QuizQuestion("Bees have been known to communicate with each other through a form of interpretive dance routines.", false, R.drawable.image19));
        quizQuestions.add(new QuizQuestion("In a remote corner of the Amazon rainforest, there's a tree that produces a form of an electronic current instead of fruit.", false, R.drawable.image20));
        quizQuestions.add(new QuizQuestion("Dolphins organize their own underwater bubble-blowing contests.", false, R.drawable.image21));
        quizQuestions.add(new QuizQuestion("The world's largest pillow fight, involving over a million participants.", false, R.drawable.image22));
        quizQuestions.add(new QuizQuestion("The Bermuda Triangle is actually a vacation resort for time-traveling pirates who enjoy sunbathing on the decks of their ghost ships.", false, R.drawable.image23));
        quizQuestions.add(new QuizQuestion("There's a remote island where penguins moonwalk instead of waddle, and they host dance-offs to determine their leaders.", false, R.drawable.image24));
        quizQuestions.add(new QuizQuestion("There is a remote city in the US where the official language is emoji, and political debates consist of candidates sending each other funny GIFs.", false, R.drawable.image25));
        quizQuestions.add(new QuizQuestion("The International Space Station holds an annual 'Zero Gravity Dance-Off' competition among astronauts from different countries.", false, R.drawable.image26));

        // Shuffle the list to randomize the order
        Collections.shuffle(quizQuestions);

        return quizQuestions;
    }
}