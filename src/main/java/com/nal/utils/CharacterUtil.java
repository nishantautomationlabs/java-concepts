package com.nal.utils;

/**
 * Created by nishant on 03/05/20.
 */
public class CharacterUtil {

    public static void main(String[] args) {
        System.out.println("isLetterOrDigit !:" + Character.isLetterOrDigit('!'));
        System.out.println("isLetterOrDigit a:" + Character.isLetterOrDigit('a'));
        System.out.println("isLetterOrDigit A:" + Character.isLetterOrDigit('A'));
        System.out.println("isLetterOrDigit 1:" + Character.isLetterOrDigit('1'));
        System.out.println("isLetter 3:" + Character.isLetter('3'));
        System.out.println("isDigit a:" + Character.isDigit('a'));

        Character.isDigit('1');
        Character.isLetter('a');
        Character.isLetterOrDigit('a');
        Character.toLowerCase('A');
    }
}
