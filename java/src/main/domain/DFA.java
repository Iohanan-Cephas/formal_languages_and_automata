package domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DFA {
    private Map<String, Map<Character, String>> delta;
    private String initialState;
    private Set<String> finalStates;

    public DFA(){
    }

    public DFA(String initialState, Set<String> finalStates){
        this.delta = new HashMap<>();
        this.initialState = initialState;
        this.finalStates = finalStates;
    }

    public void addTransition(String atualState, char simbol, String nextState){
        delta.putIfAbsent(atualState, new HashMap<>());
        delta.get(atualState).put(simbol, nextState);
    }

    public String transitionFunction(String state, char simbol){
        Map<Character, String> transitions = delta.get(state);
        if(transitions != null) return transitions.get(simbol);
        return null;
    }

    public String extendedTransitionFunction(String state, String word){
        if(word.isEmpty()) return state;

        char firstSymbol = word.charAt(0);
        String residue = word.substring(1);
        String nextState = transitionFunction(state, firstSymbol);

        if(nextState == null) return null;

        return extendedTransitionFunction(nextState, residue);
    }

    public boolean acceptWord(String word){
        String finalState = extendedTransitionFunction(this.initialState, word);
        return this.finalStates.contains(finalState);
    }
}
