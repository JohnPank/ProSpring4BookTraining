package com.johnpank.chapter9;

import org.springframework.stereotype.Service;

@Service("eloCalc")
public class ELOCalculator {

    public double calcRating(double selfRating, double opponentRating, boolean isWin){

        double k = 15;
        double rating;
        double sa;

        if (isWin){
            sa=1;
        }else {
            sa=0;
        }

        double exponent = (double)(opponentRating - selfRating)/400;
        double e = (1/(1+(Math.pow(10, exponent))));
        System.out.println(e        );

        rating = (int)Math.round(selfRating + k*(sa - e));

        return rating;
    }
}
