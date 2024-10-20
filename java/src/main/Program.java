import java.util.Set;

import domain.DFA;

public class Program {
    public static void main(String[] args) {
        Set<String> finalStates = Set.of("q3");
        DFA dfa = new DFA("q0", finalStates);

        dfa.addTransition("q0", 'a', "q1");
        dfa.addTransition("q0", 'b', "q5");
        dfa.addTransition("q1", 'a', "q5");
        dfa.addTransition("q1", 'b', "q2");
        dfa.addTransition("q2", 'a', "q3");
        dfa.addTransition("q2", 'b', "q4");
        dfa.addTransition("q3", 'a', "q6");
        dfa.addTransition("q3", 'b', "q4");
        dfa.addTransition("q4", 'a', "q3");
        dfa.addTransition("q4", 'b', "q4");
        dfa.addTransition("q5", 'a', "q5");
        dfa.addTransition("q5", 'b', "q5");
        dfa.addTransition("q6", 'a', "q6");
        dfa.addTransition("q6", 'b', "q4");
    

    String word = "ababa";

    if(dfa.acceptWord(word)){
        System.out.println("Accepted");
    }else{
        System.out.println("Not accepted");
    }
    }
}