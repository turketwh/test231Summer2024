import java.util.ArrayList;

public class DFSMTabular {

    int numberOfStates;
    int numberOfAlphabetSymbols;
    ArrayList<Boolean> acceptingStates;
    int[][] table;

    // This function converts a symbol (character) to an integer
    // --
    // This function will turn A, C, G, and T into the integers 0, 1, 2, 3 respectively
    // Any other symbol as input will be turned into -1
    private int symbolToInt(char symbolArg) {
        switch (symbolArg) {
            case 'a' -> { return 0; }
            case 'b' -> { return 1; }
            case 'c' -> { return 2; }
            case '+' -> { return 3; }
            case '(' -> { return 4; }
            case ')' -> { return 5; }
            default ->  { return -1; }
        }
    }

    // This function, given the current state the machine is in and the next input symbol,
    // returns the next state the machine should be in
    private int nextState(int currentStateArg, char symbolArg) {
        int intSymbol = symbolToInt(symbolArg);

        // The "if" part of this if/else handles symbols not in the alphabet
        if ((intSymbol < 0) || (intSymbol >= numberOfAlphabetSymbols)) {
            return -1;
        }
        // The "else" does the table lookup based on the current state and input symbol
        else {
            return table[currentStateArg][intSymbol];
        }
    }

    // This function returns true if the word passed in to the function is accepted
    // by the machine and returns false if the word uses inappropriate symbols not
    // in the alphabet or if the word is rejected by the machine
    // It also generates and prints the trace of states visited by the machine.
    public boolean checkWord(String wordArg) {

        // This variable keeps track of which symbol in the word is being read
        int index;

        // This variable is the length of the word (used to determine the end of the word)
        int lengthOfWord = wordArg.length();

        // This string variable is the trace (the record of which states are visited)
        // The trace is initially empty and will have items added to it when
        // states are visited.
        String trace = "";

        // This variable represents the state the machine is in.
        // The initial state is 0
        int state = 0;

        // This loop determines each state the machine is to enter
        // by looping, updating the state and the symbol from the word
        // being read
        index = 0;
        while ((index < lengthOfWord) && (state != -1)) {
            trace = trace + " s" + state;
            state = nextState(state, wordArg.charAt(index));
            index = index + 1;
        }

        // The last state is added to the trace and the trace is printed
        trace = trace + " s" + state;
        trace = trace.trim();
        //System.out.println("Trace: " + trace);

        // Return false (the word is rejected) if -1 is the state
        // Otherwise, return whether or not the state is listed as
        // accepting or rejecting
        if (state == -1) {
            return false;
        } else {
            return acceptingStates.get(state);
        }
    }

    // This function is the constructor for the machine.  It defines
    // the number of states, the alphabet, the rules, and the accepting states.
    public DFSMTabular() {

        // This variable is used for loops
        int index;

        // TODO: UPDATE THIS VARIABLE TO REPRESENT THE NUMBER OF STATES IN YOUR MACHINE
        // This variable represents how many states are in the machine
        numberOfStates = ??????????;
        // This variable represents the size of the alphabet
        numberOfAlphabetSymbols = 6;

        // This array list contains for each state whether or not it is accepting (true/false)
        acceptingStates = new ArrayList<Boolean>();
        // Initially mark all states as not accepting
        for (index = 0; index < numberOfStates; index++) {
            acceptingStates.add(false);
        }

        // TODO: UPDATE THIS ARRAYLIST TO INDICATE THE ACCEPTING STATES
        // USING acceptingStates.set(???, true); REPLACING ??? WITH THE INTEGER ID OF ANY ACCEPTING STATE
        // Then record which states are accepting

        // This 2-d array encodes the transitions/rules of the finite state machine
        table = new int[numberOfStates][numberOfAlphabetSymbols];

        // TODO: UPDATE THIS SECTION, WRITING CODE SIMILAR TO WHAT IS COMMENTED TO REPRESENT THE
        // ASSOCIATING OF AN INTEGER RESULT STATE FOR THE MOVE FROM THE CURRENT STATE
        // ON THE CURRENT INPUT
        // table[0][0] = ?;

    }
}
