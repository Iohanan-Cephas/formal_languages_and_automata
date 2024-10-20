from dfa import *

def transitionFunction(state, symbol):
    return delta.get((state, symbol))

def extendedTransitionFunction(state, word):
    if word == "":
        return state
    else:
        
        firstSymbol = word[0]
        residue = word[1:]
        nextState = transitionFunction(state, firstSymbol)
        if nextState is None:
            return None 
        return extendedTransitionFunction(nextState, residue)

def acceptWord(dfa, initialState, finalStates, word):
    finalState = extendedTransitionFunction(initialState, word)
    return finalState in finalStates