package com.erintl.iloveyouboss;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ProfileTest {
    private Profile profile;
    private BooleanQuestion question;
    private Criteria criteria;
    
    @BeforeEach
    public void create() {
        profile = new Profile("Bull Hockey, Inc");
        question = new BooleanQuestion(1, "Got Bonuses?");
        criteria = new Criteria();
    }

    @Test
    @DisplayName("Matches answer false when must match criteria not met")
    public void matchesAnswersFalseWhenMustMatchCriteriaNotMet() {
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.MustMatch));

        boolean matches = profile.matches(criteria);

        assertThat(matches, equalTo(false));
    }

    @Test
    @DisplayName("Matches answer true for any don't care criteria")
    public void matchesAnswerTrueForAnyDontCareCriteria() {
        profile.add(new Answer(question, Bool.FALSE));
        criteria.add(new Criterion(new Answer(question, Bool.TRUE), Weight.DontCare));

        boolean matches = profile.matches(criteria);

        assertThat(matches, equalTo(true));
    }
}
