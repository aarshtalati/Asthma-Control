package edu.gatech.epidemics.api;

import edu.gatech.epidemics.viewmodel.Answers;
import edu.gatech.epidemics.viewmodel.Question;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author atalati
 * /api/user
 */
@RestController
public class QuestionnaireApiController {
    @GetMapping(value = "/api/questionnaire/{id}")
    public List<Question> get(@PathVariable int id) {
        /**
         * This method takes an integer as an input. This intger represents an id for an age-group.
         * This end-point would retrun questionnaire with appropriate answer choices, depending on the age group.
         *
         * -------------------
         * |Id |	Age Group|
         * -------------------
         * 	1		Infant
         * 	2		Young
         * 	3		Older
         */

        // infant
        Question infantQ1 = new Question(
                1,
                "Asthma symptoms in previous 2 – 4 weeks",
                Arrays.asList("<= days/week", ">2 days/week", "Throughout the day"));
        Question infantQ2 = new Question(
                2,
                "Night time awakenings in previous 2- 4 weeks",
                Arrays.asList("<= 1x/month", "> 1x/month", ">= 1x/week"));
        Question infantQ3 = new Question(
                3,
                "Interference with normal activity in previous 2-4 weeks",
                Arrays.asList("None", "Some Limitation", "Extremely Limited"));
        Question infantQ4 = new Question(
                4,
                "Short-acting \n" +
                        "beta2-agonist use for symptom control in previous 2-4 weeks " +
                        "(not prevention of exercise-induced bronchospasm)\n",
                Arrays.asList("<= 2 days /week", ">2 days/week", "Several times per day"));
        Question infantQ5 = new Question(
                4,
                "Exacerbations requiring oral systemic corticosteroids",
                Arrays.asList("0-1/year", "2-3/year", "> 3/year"));

        Question youngQ1 = new Question(5, "First question for young", Arrays.asList("q1 a1", "q1 a2"));
        Question youngQ2 = new Question(6, "Second question for young", Arrays.asList("q2 a1", "q2 a2", "q2 a3"));
        Question youngQ3 = new Question(7, "Third question for young", Arrays.asList("q4 a1", "q4 a2", "q4 a3", "q4 a4"));

        Question olderQ1 = new Question(8, "First question for older", Arrays.asList("q1 a1", "q1 a2"));
        Question olderQ2 = new Question(9, "Second question for older", Arrays.asList("q2 a1", "q2 a2", "q2 a3"));
        Question olderQ3 = new Question(10, "Third question for older", Arrays.asList("q3 a1", "q3 a2"));
        Question olderQ4 = new Question(11, "Fourth question for older", Arrays.asList("q4 a1", "q4 a2", "q4 a3"));

        List<Question> questions = new ArrayList<Question>();

        if (id == 1) {
            questions.add(infantQ1);
            questions.add(infantQ2);
            questions.add(infantQ3);
            questions.add(infantQ4);
            questions.add(infantQ5);
        } else if (id == 2) {
            questions.add(youngQ1);
            questions.add(youngQ2);
            questions.add(youngQ3);
        } else if (id == 3) {
            questions.add(olderQ1);
            questions.add(olderQ2);
            questions.add(olderQ3);
            questions.add(olderQ4);
        } else {
            questions = null;
        }
        return questions;
    }

    @PostMapping(value = "/api/questionnaire/")
    public int post(@RequestBody Answers answers) {
        System.out.println("HTTP POST: \"/api/questionnaire/\" : " + answers.toString());
        return 0;
    }
}