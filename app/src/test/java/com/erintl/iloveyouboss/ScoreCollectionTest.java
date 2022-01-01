package com.erintl.iloveyouboss;

import static org.junit.jupiter.api.Assertions.fail;
import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.CoreMatchers.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ScoreCollectionTest {

    @Test
    @DisplayName("Answers arithmetic mean of two numbers")
    public void answersArithmeticMeanOfTwoNumbers() {
        
        ScoreCollection collection = new ScoreCollection();
        collection.add(() -> 5);
        collection.add(() -> 7);

        int actualResult = collection.arithemticMean();

        assertThat(actualResult, equalTo(6));
    }
}