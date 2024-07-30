package org.roly.domain;

public record Cell(
    State state
) {

    public enum State {
        X("X"),
        O("O"),
        EMPTY(" ");

        State(String value) {
            this.value = value;
        }

        private String value;
    }

    @Override
    public String toString() {
        return state.value.toString();
    }
}
