package Kazuate;

import java.util.Scanner;

public class Kazuate {
    public static void main(String[] args) {
        // プログラマが設定する2桁の正の整数（10-99）
        int targetNumber = 42; // この値を自由に変更してください
        
        Scanner scanner = new Scanner(System.in);
        int maxAttempts = 5;
        boolean isCorrect = false;
        
        System.out.println("数当てゲームを始めます！");
        System.out.println("2桁の正の整数を当ててください。");
        System.out.println("チャンスは" + maxAttempts + "回です。");
        System.out.println();
        
        for (int attempt = 1; attempt <= maxAttempts; attempt++) {
            System.out.print(attempt + "回目の予想: ");
            
            // ユーザーの入力を受け取る
            int userGuess;
            try {
                userGuess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("有効な数字を入力してください。");
                scanner.nextLine(); // 不正な入力をクリア
                attempt--; // 試行回数をカウントしない
                continue;
            }
            
            // 2桁の正の整数かチェック
            if (userGuess < 10 || userGuess > 99) {
                System.out.println("2桁の正の整数（10-99）を入力してください。");
                attempt--; // 試行回数をカウントしない
                continue;
            }
            
            // 判定
            if (userGuess == targetNumber) {
                System.out.println("当たり！");
                System.out.println("正解は " + targetNumber + " でした。");
                System.out.println(attempt + "回で正解です！");
                isCorrect = true;
                break;
            } else {
                int difference = Math.abs(userGuess - targetNumber);
                
                if (difference >= 20) {
                    System.out.println("20以上離れています。");
                }
                
                if (userGuess > targetNumber) {
                    System.out.println("設定された数より大きいです。");
                } else {
                    System.out.println("設定された数より小さいです。");
                }
                
                if (attempt < maxAttempts) {
                    System.out.println("残り" + (maxAttempts - attempt) + "回です。");
                }
                System.out.println();
            }
        }
        
        if (!isCorrect) {
            System.out.println("残念！チャンスを使い切りました。");
            System.out.println("正解は " + targetNumber + " でした。");
        }
        
        scanner.close();
    }
}